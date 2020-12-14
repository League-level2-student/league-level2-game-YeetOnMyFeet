import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Jet extends GameObject {
	boolean right, left, up, down;
	public  BufferedImage imageup;
	public  BufferedImage imageright;
	public  BufferedImage imagedown;
	public  BufferedImage imageleft;
	
	String player ="";
	
	
	public Jet(int x, int y, int width, int height, String player) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 2;
		 up = true;
		 this.player = player;
		 loadImages();
		
	}

	void loadImages() {
		
			try {
				if (player.equals("1")) {
					
				
				
				imageup = ImageIO.read(this.getClass().getResourceAsStream("jetphoto.png"));
				imageright = ImageIO.read(this.getClass().getResourceAsStream("jetphotoright.png"));
				imageleft = ImageIO.read(this.getClass().getResourceAsStream("jetphotoleft.png"));
				imagedown = ImageIO.read(this.getClass().getResourceAsStream("jetphotodown.png"));
				
				}
				else if (player.equals("2")) {
					imageup = ImageIO.read(this.getClass().getResourceAsStream("jet2up.png"));
					imageright = ImageIO.read(this.getClass().getResourceAsStream("jet2right.png"));
					imageleft = ImageIO.read(this.getClass().getResourceAsStream("jet2left.png"));
					imagedown = ImageIO.read(this.getClass().getResourceAsStream("jet2down.png"));
				}
			} catch (Exception e) {

			}
			
		}
	

	public Projectile getProjectile(String direction) {
		return new Projectile(x + width / 2, y, 10, 10, direction);
	}

	public void draw(Graphics g) {

			
			if (up == true) {
				g.drawImage(imageup, x, y, width, height, null);
			}
			else if (down == true) {
				g.drawImage(imagedown, x, y, width, height, null);
			}
			else if (right == true) {
				g.drawImage(imageright, x, y, width, height, null);
			}
			else if (left == true) {
				g.drawImage(imageleft, x, y, width, height, null);
			}
			 
			
			else {
				g.setColor(Color.BLUE);
				g.fillRect(x, y, width, height);
				//g.drawImage(imageup, x, y, width, height, null);
			}}

		
	

	public void jetUpdate() {
		x += speed;
		super.update();
	}

	public void right() {
		if (checkMove(x + speed, y)) {
			x += speed;
		}
	}

	public void left() {
		if (checkMove(x - speed, y)) {
			x -= speed;
		}
	}

	public void up() {
		if (checkMove(x, y - speed)) {
			y -= speed;
		}
	}

	public void down() {
		if (checkMove(x, y + speed)) {
			y += speed;
		}
	}

	public boolean checkMove(int x, int y) {
		if (x >= JetFighter.WIDTH - width || y >= JetFighter.HEIGHT - height || x <= 0 || y <= 0) {
			return false;
		} else {
			return true;
		}
	}

	public void update() {
		if (right) {

			right();
		}
		if (left) {

			left();
		}
		if (up) {

			up();
		}
		if (down) {

			down();
		}
		super.update();
	}

	public void setIsActive(boolean b) {
		// TODO Auto-generated method stub
		this.isActive = b;
	}
}
