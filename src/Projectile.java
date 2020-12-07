import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	String direction;
	public Projectile(int x, int y, int width, int height, String direction) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 10;
		this.direction = direction;
		if (needImage) {
		    loadImage ("bullet.png");
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
	public void update() {
		
        super.update();
        if (direction.equals("up")) {
        	y-=speed;
		}
        if (direction.equals("left")) {
        	x-=speed;
		}
        if (direction.equals("right")) {
        	x+=speed;
		}
        if (direction.equals("down")) {
        	y+=speed;
		}
        
	}
	public void updateleft() {
		x-= speed;
		super.update();
	}
	public void draw(Graphics g) {
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
	}
	
}
	public void setIsActive(boolean b) {
		// TODO Auto-generated method stub
		this.isActive = b;
	}
}