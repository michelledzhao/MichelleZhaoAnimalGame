package AnimalGame;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class IceCreams extends IceCream{
	private IceCream [][] CreamMatrix;
	
	public IceCreams(){
		CreamMatrix = new IceCream [0][0];
	}
	
	public IceCreams(int row, int col){
		CreamMatrix = new IceCream [row][col];
	}
	
}