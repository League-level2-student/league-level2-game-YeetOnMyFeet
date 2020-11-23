import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	 	final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
	    Font titleFont;
	    Font titleFont2;
	    Timer frameDraw;
	    Jet jet1 = new Jet(250, 250, 50, 50);
	    Jet jet2 = new Jet(100, 100, 50, 50);
	    ObjectManager manager = new ObjectManager(jet1, jet2);
	    public static BufferedImage image;
	    public static boolean needImage = true;
	    public static boolean gotImage = false;	
public GamePanel() {
	titleFont = new Font("Arial", Font.PLAIN, 48);
	titleFont2 = new Font("Times New Roman", Font.PLAIN, 32);
	frameDraw = new Timer(1000/60, this);
	frameDraw.start();
	
	    }
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        needImage = false;
	    }
	}
public void startGame() {
	 
	 
}
public void	 updateMenuState() { 
	
}
public void	 updateGameState() {  
	//jet1.jetUpdate();
	//jet2.jetUpdate();
	manager.update();
}
public void	 updateEndState()  {  
	
}
public void drawMenuState(Graphics g) {  
	g.setColor(Color.gray);
	g.fillRect(0, 0, JetFighter.WIDTH, JetFighter.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.black);
	g.drawString("Jet Fighter", 120, 100);
	g.setFont(titleFont2);
	g.drawString("Press ENTER to start", 100, 350);
	g.setFont(titleFont2);
	g.drawString("Press SPACE for instructions", 60, 550);
}
public void drawGameState(Graphics g) { 
	if (needImage) {
	    loadImage ("jetphoto.png");
	}
	g.setColor(Color.gray);
	g.drawImage(image,0, 0, null);
	g.fillRect(0, 0, JetFighter.WIDTH, JetFighter.HEIGHT);
	manager.draw(g);
	//manager.getScore();
	g.setColor(Color.YELLOW);
	g.setFont(titleFont);
	//g.drawString("" + manager.getScore(), 50, 80);
}
public void drawEndState(Graphics g)  { 
	g.setColor(Color.RED);
	g.fillRect(0, 0, JetFighter.WIDTH, JetFighter.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.BLACK);
	g.drawString("Game Over", 110, 100);
	g.setFont(titleFont2);
	//g.drawString("You killed " + ""+ + manager.getScore() + " enemies", 100, 350);
	g.setFont(titleFont2);
	g.drawString("Press ENTER to start", 100, 550);
	
}
	

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(currentState == MENU){
	    updateMenuState();
	}else if(currentState == GAME){
	    updateGameState();
	}else if(currentState == END){
	    updateEndState();
	}
	this.repaint();
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_SPACE) {
		System.out.println("Space");
	
	}
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		System.out.println("ENTER");
		startGame();
	    if (currentState == END) {
	        currentState = MENU;
	        
	        
	    } else {
	        currentState++;
	    }
	}
	if (e.getKeyCode()==KeyEvent.VK_SPACE) {
		manager.addProjectile(jet1.getProjectile());
	}
	if (e.getKeyCode()==KeyEvent.VK_UP) {
	    jet1.up = true;
	    jet1.down = false;
	    jet1.right= false;
	    jet1.left = false;
	}
	if (e.getKeyCode()==KeyEvent.VK_LEFT) {
	    jet1.left = true;
	    jet1.up = false;
	    jet1.down = false;
	    jet1.right= false;
	}
	if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		jet1.right= true;
		jet1.up = false;
	    jet1.down = false;
	    jet1.left = false;
	}
	if (e.getKeyCode()==KeyEvent.VK_DOWN) {
	    jet1.down = true;
	    jet1.right= false;
	    jet1.left = false;
	    jet1.up = false;
	}
	
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
