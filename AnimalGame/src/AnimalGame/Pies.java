package AnimalGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Pies extends Pie{
	private Pie [][] FoodMatrix;
	
	public Pies(){
		FoodMatrix = new Pie [0][0];
	}
	
	public Pies(int row, int col){
		FoodMatrix = new Pie [row][col];
	}
	
}