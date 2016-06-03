package AnimalGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Picnic extends Canvas implements KeyListener, Runnable, MouseListener
{
	private Pig pig;
	private Pie PieOne;
	private ArrayList<Pie> pies;
	private ArrayList<Burger> burgers;
	private ArrayList<Pizza> pizzas;
	private ArrayList<IceCream> icecreams;
	private boolean title;
	private int score=0;
	//private Pie PieTwo;
	private ArrayList<Spider> spiders;

	//uncomment once you are ready for this part
	 
	
	private boolean[] keys;
	private BufferedImage back;

	public Picnic()
	{
		setBackground(new Color(0,100,0));

		keys = new boolean[5];

		//instantiate other stuff
		pig = new Pig(300, 510, 5);
		PieOne = new Pie(500, 10, 1);
		pies = new ArrayList<Pie>();
		spiders = new ArrayList<Spider>();
		burgers = new ArrayList<Burger>();
		pizzas = new ArrayList<Pizza>();
		icecreams = new ArrayList<IceCream>();
		
		
		pies.add(new Pie(10, 100, 1));
		title = true;
		
		Timer timer = new Timer();
		timer.schedule(new NewPie(), 0, 2*1000);
		timer.schedule(new NewSpider(), 0, 4*1000);
		timer.schedule(new NewBurger(), 0, 5*1000);

		timer.schedule(new NewPizza(), 0, 3*1000);

		timer.schedule(new NewIceCream(), 0, 7*1000);


		//PieTwo = new Pie (300, 100, 1);	
		this.addKeyListener(this);
		this.addMouseListener(this);
		new Thread(this).start();

		setVisible(true);
	}
	
	class NewPie extends TimerTask {
		public void run(){
		pies.add(new Pie(((int)(Math.random()*800)), 10, 1));
		}
	}
	
	class NewSpider extends TimerTask {
		public void run(){
		spiders.add(new Spider(((int)(Math.random()*800)), 10, 1));
		}
	}
	
	class NewBurger extends TimerTask {
		public void run(){
		burgers.add(new Burger(((int)(Math.random()*800)), 10, 1));
		}
	}
	
	class NewPizza extends TimerTask {
		public void run(){
		pizzas.add(new Pizza(((int)(Math.random()*800)), 10, 1));
		}
	}
	
	class NewIceCream extends TimerTask {
		public void run(){
		icecreams.add(new IceCream(((int)(Math.random()*800)), 10, 1));
		}
	}
	
	
	
	
   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		if(title){
			window.setColor(Color.BLACK);
			window.fillRect(0, 0, 800, 600);
			
			window.setColor(Color.WHITE);
			window.setFont(new Font("Comic Sans", Font.BOLD, 96));
			window.drawString("HUNGRY HIPPO", 50, 100);

			window.setFont(new Font("Comic Sans", Font.BOLD, 36));
			window.drawString("Michelle Zhao, Period 2", 60, 250);
			
			
			window.setFont(new Font("Comic Sans", Font.BOLD, 36));
			window.drawString("Eat food. Avoid spiders. Click screen to continue.", 60, 300);

			window.setFont(new Font("Comic Sans", Font.PLAIN, 25));
			window.drawString("Use the left and right arrows to move the hippo.", 10, 350);
		}
		
		else if (title == false){
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		
		graphToBack.setColor(new Color(0,100,0));
		graphToBack.fillRect(0,0,800,600);
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("HUNGRY HIPPO", 25, 50 );
		graphToBack.drawString("SCORE: "+ score, 25, 100 );

		if(keys[0] == true)
		{
			if(pig.getX()>10){
			pig.move("LEFT");
			}
		}
		if(keys[1] == true)
		{
			if(pig.getX()<750){
			pig.move("RIGHT");
			}
		}
		/*if(keys[2] == true)
		{
			title = false;
		}*/
		/*if(keys[3] == true)
		{
			if(pig.getY()<500){
			pig.move("DOWN");
			}
		}*/
		
		


		
		
		
		for (int i=0; i<pies.size(); i++){
		pies.get(i).move("DOWN");
		if (pies.get(i).getY()>600){
			pies.remove(i);
		}
		}
		PieOne.move("DOWN");
		
		for (int i=0; i<spiders.size(); i++){
			spiders.get(i).move("DOWN");
			if (spiders.get(i).getY()>600){
				spiders.remove(i);
			}
			}
	
		for (int i=0; i<burgers.size(); i++){
			burgers.get(i).move("DOWN");
			if (burgers.get(i).getY()>600){
				burgers.remove(i);
			}
			}
		
		for (int i=0; i<pizzas.size(); i++){
			pizzas.get(i).move("DOWN");
			if (pizzas.get(i).getY()>600){
				pizzas.remove(i);
			}
			}
		
		for (int i=0; i<icecreams.size(); i++){
			icecreams.get(i).move("DOWN");
			if (icecreams.get(i).getY()>600){
				icecreams.remove(i);
			}
			}
		
		
		/*if (PieOne.getY()>700){
			PieOne.setSpeed(PieOne.getSpeed()*(-1));
		}
			if (PieOne.getX()<25){
				PieOne.setSpeed(PieOne.getSpeed()*(-1));
			}*/
		
	
		/*if(PieOne.getX()>10){
		PieOne.move("LEFT");
			}
		
			while(PieOne.getX()>10){
			PieOne.move("LEFT");
			}
			while(PieOne.getX()<750){
				PieOne.move("RIGHT");
				}
		*/

		//add in collision detection

		
		for (int j=0; j<pies.size(); j++){
			if (pies.get(j).getX() >= pig.getX() && pies.get(j).getX() <= pig.getX()+100 &&
					pies.get(j).getY() >= pig.getY() && pies.get(j).getY() <= pig.getY()+100){
				pies.remove(pies.get(j));
				score++;
			}
			}
		
		for (int j=0; j<spiders.size(); j++){
			if (spiders.get(j).getX() >= pig.getX() && spiders.get(j).getX() <= pig.getX()+100 &&
					spiders.get(j).getY() >= pig.getY() && spiders.get(j).getY() <= pig.getY()+100){
				spiders.remove(spiders.get(j));
				score=0;
				
				
			}
			}
		
		for (int j=0; j<burgers.size(); j++){
			if (burgers.get(j).getX() >= pig.getX() && burgers.get(j).getX() <= pig.getX()+100 &&
					burgers.get(j).getY() >= pig.getY() && burgers.get(j).getY() <= pig.getY()+100){
				burgers.remove(burgers.get(j));
				score+=2;
			}
			}
		
		for (int j=0; j<pizzas.size(); j++){
			if (pizzas.get(j).getX() >= pig.getX() && pizzas.get(j).getX() <= pig.getX()+100 &&
					pizzas.get(j).getY() >= pig.getY() && pizzas.get(j).getY() <= pig.getY()+100){
				pizzas.remove(pizzas.get(j));
				score+=3;
			}
			}
		
		for (int j=0; j<icecreams.size(); j++){
			if (icecreams.get(j).getX() >= pig.getX() && icecreams.get(j).getX() <= pig.getX()+100 &&
					icecreams.get(j).getY() >= pig.getY() && icecreams.get(j).getY() <= pig.getY()+100){
				icecreams.remove(icecreams.get(j));
				score+=4;
			}
			}
		
		//ship.draw(graphToBack);
		for (int i=0; i<pies.size(); i++){
			pies.get(i).draw(graphToBack);
		}
		
		for (int i=0; i<spiders.size(); i++){
			spiders.get(i).draw(graphToBack);
		}
		
		for (int i=0; i<burgers.size(); i++){
			burgers.get(i).draw(graphToBack);
		}
		
		for (int i=0; i<pizzas.size(); i++){
			pizzas.get(i).draw(graphToBack);
		}
		
		for (int i=0; i<icecreams.size(); i++){
			icecreams.get(i).draw(graphToBack);
		}
		
		/*for (int i=0; i<shots.size(); i++){
			shots.get(i).draw(graphToBack);
		}
		*/
		pig.draw(graphToBack);
		PieOne.draw(graphToBack);
		//alienTwo.draw(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
	}

	}
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		/*if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}*/
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
	/*	if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}*/
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	title = false;
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}

