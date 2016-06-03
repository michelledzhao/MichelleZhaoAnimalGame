package AnimalGame;

import javax.swing.JFrame;
import java.awt.Component;

public class Pignic extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Pignic()
	{
		super("HUNGRY HIPPO");
		setSize(WIDTH,HEIGHT);

		Picnic theGame = new Picnic();
		
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		Pignic run = new Pignic();
	}
}