import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Rocketship rocketship = new Rocketship(250, 700, 50, 50);
	ObjectManager objectmanager = new ObjectManager(rocketship);
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font miniText = new Font("Arial", Font.PLAIN, 10);
	int currentState = MENU;
	Timer frameDraw;
	Timer alienSpawn;

	GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
			loadImage("space.png");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectmanager.update();
		if(!rocketship.isActive) {
			currentState = END;
		}
	}

	void updateEndState() {

	}

	void startGame() {
		alienSpawn = new Timer(1000, objectmanager);
		alienSpawn.start();
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 100);
		g.setFont(miniText);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 200, 300);
		g.drawString("Press SPACE for instructions", 180, 400);
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		objectmanager.draw(g);
		g.setFont(miniText);
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf(objectmanager.getScore()), 100, 100);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 100, 100);
		g.setFont(miniText);
		g.setColor(Color.YELLOW);
		g.drawString("You killed "  + objectmanager.getScore() + " enemies", 200, 300);
		g.drawString("Press ENTER to restart", 180, 400);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		// System.out.println("Action");
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState == END) {
				rocketship = new Rocketship(250, 700, 50, 50);
				objectmanager = new ObjectManager(rocketship);
			}
			if (currentState == END) {
				currentState = MENU;
			} else {
				if (currentState == MENU) {
					currentState = GAME;
					startGame();
				} else {
				if(currentState == GAME) {
					alienSpawn.stop();
					}
					currentState++;
				}
			}
			
		}
			if (currentState == GAME) {
				if (arg0.getKeyCode() == KeyEvent.VK_UP) {
					if (rocketship.y > 0)
						rocketship.up();
				}
				if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (rocketship.x < 445) {
						rocketship.right();
					}
				}
				if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
					if (rocketship.y < 745) {
						rocketship.down();
					}
				}
				if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
					if (rocketship.x > 0) {
						rocketship.left();
					}
				}
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					objectmanager.addProjectile(rocketship.getProjectile());
				}
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

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
