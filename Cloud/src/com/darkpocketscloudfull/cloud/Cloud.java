package com.darkpocketscloudfull.cloud;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.darkpocketscloudfull.cloud.graphics.Screen;

public class Cloud extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	//game window and size
    public static int width = 300;
    public static int height = width  / 16 * 9;
    public static int scale = 3;
   
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int [ ] pixels = ((DataBufferInt)image.getRaster( ) .getDataBuffer ( )) .getData ( ) ;
    
    private Thread thread;
    private JFrame frame;
    private boolean running = false;
    
    private Screen screen;
    
    public Cloud () {
    	Dimension size = new Dimension (width * scale, height * scale);
    	setPreferredSize (size);
    	
    	screen = new Screen (width, height );
    	
    	frame = new JFrame ( );
    	
    }
    
    public synchronized void start () {
    	running = true;
    	thread = new Thread (this, "Display") ;
    	thread.start () ;
    }
    public synchronized void stop () {
    	running = false;
    	try {
    	thread.join ();
    } catch  (InterruptedException e) {
    	e.printStackTrace ();
    }
    }
    
    public void run () {
    	while (running) {
    		//System.out.println("Running......Like a boss!!");
    		update ();
    		render ();
    	}
    }
    public void update () {
    	
    }
     
    public void render () {
    	BufferStrategy bs = getBufferStrategy ( );
    	if (bs == null){
    		createBufferStrategy ( 3 ) ;
    		return;
    	}
    	
    	screen.clear ( );
    	screen.render ( );
    	
    	for (int i = 0 ; i < pixels.length; i++ ) {
    		pixels[ i ] = screen.pixels[ i ];
    	}
    	
    	Graphics g = bs.getDrawGraphics ( ) ; 
    	//This is where your graphics lay

    	g.drawImage(image,  0,  0,  getWidth( ), getHeight( ), null);
    	g.dispose ( ) ;  //removes current graphics to make room for new graphics
    	bs.show ( ) ;
    }
    
    public static void main (String[ ] args) {
    	Cloud cloud = new Cloud ();
    	cloud.frame.setResizable (false);
    	cloud.frame.setTitle("Cloud");
    	cloud.frame.add(cloud);
    	cloud.frame.pack( );
    	cloud.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	cloud.frame.setLocationRelativeTo(null);
    	cloud.frame.setVisible(true);
    	
    	cloud.start ( );
    }
}

