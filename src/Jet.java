import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Jet extends GameObject{
boolean right, left, up, down;
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;	
	public Jet(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 10;
		if (needImage) {
		    loadImage ("rocket.png");
		}
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
}
public void draw(Graphics g) {
	 
     if (gotImage) {
    		g.drawImage(image, x, y, width, height, null);
    	} else {
    		g.setColor(Color.BLUE);
    		g.fillRect(x, y, width, height);
    	}
}
	
public void right() {
	if (checkMove(x+speed, y)) {
		x+=speed;
	}
}
public void left() {
	if (checkMove(x-speed, y)) {
		x-=speed;
	}
}
public void up() {
	if (checkMove(x, y-speed)) {
		y-=speed;
	}
}
public void down() {
	if (checkMove(x, y+speed)) {
		y+=speed;
	}
}

public boolean checkMove(int x, int y) {
	if (x >= JetFighter.WIDTH - width || y >= JetFighter.HEIGHT - height|| x<= 0 || y<= 0 ) {
		return false;
	}
	else {
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
