package resizer.image.batch.bams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * BamsBatchImageResizerApplicationTests --------------------- Unit tests for
 * BatchImageResizer. Demonstrates: - Generating dummy images for input -
 * Running the batch resizer - Validating output - Rough performance
 * benchmarking
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BamsBatchImageResizerApplicationTests {

	private static final String INPUT_DIR = "input-images";
	private static final String OUTPUT_DIR = "output-images";

	@BeforeAll
	static void setup() throws IOException {
		// Ensure Directories exist
		new File(INPUT_DIR).mkdirs();
		new File(OUTPUT_DIR).mkdirs();

		// Create dummy images if not present
		for (int i = 0; i < 5; i++) {
			File f = new File(INPUT_DIR + "/test" + i + ".png");
			if (!f.exists()) {
				BufferedImage img = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
				Graphics2D g2d = img.createGraphics();
				g2d.setColor(Color.BLUE);
				g2d.fillRect(0, 0, 400, 400);
				g2d.setColor(Color.WHITE);
				g2d.drawString("Test " + i, 150, 200);
				g2d.dispose();
				ImageIO.write(img, "png", f);
			}
		}
	}

	@Test
	@Order(1)
	void testBatchResizeCreatesOutput() throws Exception {
		// Run the main app
		BamsBatchImageResizerApplication.main(new String[] {});

		// Check if resized files exist
		File outFolder = new File(OUTPUT_DIR);
		File[] resized = outFolder.listFiles((dir, name) -> name.endsWith(".png"));
		assertNotNull(resized, "No output images created!");
		assertTrue(resized.length >= 5, "Not all files were processed!");
	}

	@Test
	@Order(2)
	void testResizedDimensions() throws IOException {
		File outFolder = new File(OUTPUT_DIR);
		File[] resized = outFolder.listFiles((dir, name) -> name.endsWith(".png"));
		assertNotNull(resized);

		for (File file : resized) {
			BufferedImage img = ImageIO.read(file);
			assertEquals(200, img.getWidth(), "Width should match target size");
			assertEquals(200, img.getHeight(), "Height should match target size");
		}
	}

	@Test
	@Order(3)
	void testPerformanceWithinThreshold() {
		long start = System.nanoTime();
		try {
			BamsBatchImageResizerApplication.main(new String[] {});
		} catch (Exception e) {
			fail("Exception during resize run: " + e.getMessage());
		}
		long end = System.nanoTime();

		long durationMs = TimeUnit.NANOSECONDS.toMillis(end - start);
		System.out.println("Batch resize completed in " + durationMs + " ms");

		// Arbitrary threshold (tune depending on your machine & number of images)
		assertTrue(durationMs < 3000, "Batch resize took too long!");
	}

}
