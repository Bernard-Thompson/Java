package resizer.image.batch.bams;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.imageio.ImageIO;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * BatchImageResizer ----------------- Demonstrates a multithreaded application
 * that processes files (images here) concurrently using an ExecutorService
 * thread pool.
 *
 * Key Skills Practiced: - Thread pooling with ExecutorService - Callable/Future
 * for concurrent tasks - Handling I/O-bound and CPU-bound workloads
 */

@SpringBootApplication
public class BamsBatchImageResizerApplication {

	// Change these paths for your local setup
	private static final String INPUT_DIR = "input-images";
	private static final String OUTPUT_DIR = "output-images";

	// Desired resized dimensions
	private static final int TARGET_WIDTH = 200;
	private static final int TARGET_HEIGHT = 200;

	public static void main(String[] args) throws InterruptedException {

		File inputFolder = new File(INPUT_DIR);
		File[] files = inputFolder.listFiles((dir, name) -> name.endsWith(".jpg") || name.endsWith(".png"));

		if (files == null || files.length == 0) {
			System.out.println("No image files found in " + INPUT_DIR);
			return;
		}

		// Thread pool: use # of available processors
		int numThreads = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);

		// Store futures to wait on tasks
		List<Future<Boolean>> results = new CopyOnWriteArrayList<>();

		long startTime = System.currentTimeMillis();

		// Submit tasks for each image
		for (File file : files) {
			Callable<Boolean> task = () -> resizeImage(file);
			results.add(executor.submit(task));
		}

		// Wait for all tasks to complete
		for (Future<Boolean> result : results) {
			try {
				result.get(); // blocks until task is done
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("Batch processing completed in " + (endTime - startTime) + " ms");

		executor.shutdown();

		// SpringApplication.run(BamsBatchImageResizerApplication.class, args);
	}

	/**
	 * Resizes a single image and saves it to OUTPUT_DIR
	 *
	 * @param inputFile the source image file
	 * @return true if successful, false otherwise
	 */

	private static boolean resizeImage(File inputFile) {
		try {
			BufferedImage originalImage = ImageIO.read(inputFile);

			// Create a scaled instance of the image
			Image scaled = originalImage.getScaledInstance(TARGET_WIDTH, TARGET_HEIGHT, Image.SCALE_SMOOTH);

			// Draw scaled image into a new BufferedImage
			BufferedImage resized = new BufferedImage(TARGET_WIDTH, TARGET_HEIGHT, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = resized.createGraphics();
			g2d.drawImage(scaled, 0, 0, null);
			g2d.dispose();

			// Save to output folder
			File outputFolder = new File(OUTPUT_DIR);
			if (!outputFolder.exists()) {
				outputFolder.mkdirs();
			}

			String outputName = OUTPUT_DIR + "/" + inputFile.getName();
			ImageIO.write(resized, "png", new File(outputName));

			System.out.println("Resized: " + inputFile.getName());
			return true;
		} catch (IOException e) {
			System.err.println("Failed to process: " + inputFile.getName());
			e.printStackTrace();
			return false;
		}

	}
}
