package com.darkpocketscloudfull.cloud.level.tile;

import com.darkpocketscloudfull.cloud.graphics.Screen;
import com.darkpocketscloudfull.cloud.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public Tile ( Sprite sprite ) {
		this.sprite = sprite;
	}
    
	public void render ( int x, int y, Screen screen ) {
		
	}
}
