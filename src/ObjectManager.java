import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Jet jet1;
	Jet jet2;
	 ArrayList<Projectile>  projectiles;
	 Random random = new Random();
	 int score = 0;
	 
public ObjectManager(Jet jet) {
		// TODO Auto-generated constructor stub
		this.jet1 = jet;
		 projectiles = new  ArrayList<Projectile>();
		 
	}

public void addProjectile(Projectile projectile) {
	  projectiles.add(projectile);
	  
}

public void update() {
	
	

	for (int i = 0; i < projectiles.size(); i++) {
		 Projectile currentProjectile = projectiles.get(i);
		 currentProjectile.update();
		 if (currentProjectile.y > 800 ) {
			currentProjectile.setIsActive(false);
		}}
	checkCollision();
	purgeObjects();
}
public void draw(Graphics g) {
	

	for (int i = 0; i < projectiles.size(); i++) {
		Projectile currentProjectile = projectiles.get(i);
		 currentProjectile.draw(g);
}
}
public void purgeObjects() {
	
	
	for (int i = 0; i < projectiles.size(); i++) {
		Projectile currentProjectile = projectiles.get(i);
		if (currentProjectile.isActive == false) {
			projectiles.remove(i);
		}
	}

}
public void checkCollision() {
	
		
		for (int j = 0; j < projectiles.size(); j++) {
			if (aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)) {
				projectiles.get(j).setIsActive(false);
				aliens.get(i).setIsActive(false);
				score += 1;
				System.out.println(score);
				System.out.println("Projectile collision");
			}
		}
	}

public int getScore() {
	return score;
}


}
