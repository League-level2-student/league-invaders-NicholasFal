import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship rocket;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();
Random random = new Random();
ObjectManager(Rocketship rocket) {
	this.rocket = rocket;
}
void addProjectile(Projectile projectile) {
	projectiles.add(projectile);
}
void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}

	void update() {
	for(Alien alien : aliens) {
		alien.update();
		if(alien.y >= LeagueInvaders.HEIGHT) {
			alien.isActive = false;
		}
	}
	for(Projectile projectile : projectiles) {
		projectile.update();
		if(projectile.y <= LeagueInvaders.HEIGHT) {
			projectile.isActive = false;
		}
	}
}
	void draw(Graphics g) {
		rocket.draw(g);
		for(Alien alien : aliens) {
			alien.draw(g);
		}
		for(Projectile projectile : projectiles) {
			projectile.draw(g);
		}
	}
	void purgeObjects() {
		
	}
}
