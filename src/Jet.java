import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Jet extends GameObject{
boolean right, left, up, down;
public static BufferedImage imageup;
public static BufferedImage imageright;
public static BufferedImage imagedown;
public static BufferedImage imageleft;
public static BufferedImage image2up;
public static BufferedImage image2right;
public static BufferedImage image2down;
public static BufferedImage image2left;
public static boolean needImage = true;
public static boolean gotImage = false;	
String direction;
	public Jet(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 1;
		if (needImage) {
		    loadImage ("jetphoto.png", imageup);
		    loadImage ("jetphotoright.png", imageright);
		    loadImage ("jetphotleft.png", imageleft);
		    loadImage ("jetphotodown.png", imagedown);
		    loadImage ("jet2up.png", image2up);
		    loadImage ("jet2right.png", image2right);
		    loadImage ("jet2left.png", image2left);
		    loadImage ("jet2down.png", image2down);
		}
	}
	void loadImage(String imageFile, BufferedImage image) {
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
	
public void jetUpdate() {
	x+=speed;
    super.update();
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
		loadImage ("jetphotoright.png");
		right();
	}
	if (left) {
		loadImage ("jetphotoleft.png");
		left();
	}
	if (up) {
		loadImage ("jetphoto.png");
		up();
	}
	if (down) {
		loadImage ("jetphotodown.png");
		down();
	}
	super.update();
}
public void update2() {
	if (right) {
		loadImage ("jet2right.png");
		right();
	}
	if (left) {
		loadImage ("jet2left.png");
		left();
	}
	if (up) {
		loadImage ("jet2up.png");
		up();
	}
	if (down) {
		loadImage ("jet2down.png");
		down();
	}
	super.update();
}
public void setIsActive(boolean b) {
	// TODO Auto-generated method stub
	this.isActive = b;
}
}
