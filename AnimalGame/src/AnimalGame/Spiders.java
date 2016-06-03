package AnimalGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Spiders extends Pie{
	private Spider [][] SpiderMatrix;
	
	public Spiders(){
		SpiderMatrix = new Spider [0][0];
	}
	
	public Spiders(int row, int col){
		SpiderMatrix = new Spider [row][col];
	}
	
}