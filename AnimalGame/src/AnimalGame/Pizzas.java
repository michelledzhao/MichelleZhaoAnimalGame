package AnimalGame;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Pizzas extends Pizza{
	private Pizza [][] PizzaMatrix;
	
	public Pizzas(){
		PizzaMatrix = new Pizza [0][0];
	}
	
	public Pizzas(int row, int col){
		PizzaMatrix = new Pizza [row][col];
	}
	
}