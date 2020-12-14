import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Jet jet1;
	Jet jet2;
	 ArrayList<Projectile>  projectiles;
	 ArrayList<Projectile>  projectiles2;
	 Random random = new Random();
	 int score = 0;
	 int score2 = 0;
	 
public ObjectManager(Jet jet, Jet jet2) {
		// TODO Auto-generated constructor stub
		this.jet1 = jet;
		 projectiles = new  ArrayList<Projectile>();
		 this.jet2 = jet2;
		 projectiles2 = new ArrayList<Projectile>();
	}

public void addProjectile(Projectile projectile) {
	  projectiles.add(projectile);
	  
	  
}
public void addProjectile2(Projectile projectile) {
	  projectiles2.add(projectile);
	  
	  
}

public void update() {
	jet1.update();
	jet2.update();

	for (int i = 0; i < projectiles.size(); i++) {
		 Projectile currentProjectile = projectiles.get(i);
		 currentProjectile.update();
		 if (currentProjectile.y > 800 ) {
			currentProjectile.setIsActive(false);
		}}
	
	for (int i = 0; i < projectiles2.size(); i++) {
		 Projectile currentProjectile2 = projectiles2.get(i);
		 currentProjectile2.update();
		 if (currentProjectile2.y > 800 ) {
			currentProjectile2.setIsActive(false);
		}}
	checkCollision();
	purgeObjects();
	
}
public void draw(Graphics g) {
	
	jet1.draw(g);
	jet2.draw(g);

	for (int i = 0; i < projectiles.size(); i++) {
		Projectile currentProjectile = projectiles.get(i);
		 currentProjectile.draw(g);
}
	for (int i = 0; i < projectiles2.size(); i++) {
		Projectile currentProjectile2 = projectiles2.get(i);
		 currentProjectile2.draw(g);
}
}
public void purgeObjects() {
	
	
	for (int i = 0; i < projectiles.size(); i++) {
		Projectile currentProjectile = projectiles.get(i);
		if (currentProjectile.isActive == false) {
			projectiles.remove(i);
		}
	}
	for (int i = 0; i < projectiles2.size(); i++) {
		Projectile currentProjectile2 = projectiles2.get(i);
		if (currentProjectile2.isActive == false) {
			projectiles2.remove(i);
		}
	}

}
public void checkCollision() {
	
		for (int j = 0; j < projectiles2.size(); j++) {
			if (jet1.collisionBox.intersects(projectiles2.get(j).collisionBox)) {
				projectiles2.get(j).setIsActive(false);
				score += 1;
				System.out.println(score);
				System.out.println("Projectile collision");
			}
			
			}
		for (int j = 0; j < projectiles.size(); j++) {
			if (jet2.collisionBox.intersects(projectiles.get(j).collisionBox)) {
				projectiles.get(j).setIsActive(false);
				score2 += 1;
				System.out.println(score2);
				System.out.println("Projectile2 collision");
			}
			
			}
		}
		

		

public int getScore() {
	return score;
}
public int getScore2() {
	return score2;
	
}


}
