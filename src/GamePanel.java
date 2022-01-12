import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.JPanel;
public class GamePanel extends JPanel implements ActionListener {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font miniText = new Font("Arial", Font.PLAIN, 10);
    int currentState = MENU;
    Timer frameDraw;
    GamePanel(){
    	frameDraw = new Timer(1000/60,this);
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
		}	
		}
	 void updateMenuState() {  
		 
	 }
	 void updateGameState() { 
		 
	 }
	 void updateEndState()  {  
		 
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
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	 }
	 void drawEndState(Graphics g)  {  
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Game Over", 100, 100);
		 g.setFont(miniText);
		 g.setColor(Color.YELLOW);
		 g.drawString("You killed _ enemies", 200, 300);
		 g.drawString("Press ENTER to restart", 180, 400);
	 }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}