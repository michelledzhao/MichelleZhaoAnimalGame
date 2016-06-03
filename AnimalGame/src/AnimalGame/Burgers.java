package AnimalGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Burgers extends Burger{
	private Burger [][] BurgerMatrix;
	
	public Burgers(){
		BurgerMatrix = new Burger [0][0];
	}
	
	public Burgers(int row, int col){
		BurgerMatrix = new Burger [row][col];
	}
	
}