import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel panel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	LeagueInvaders() {
		this.frame = new JFrame();
		this.panel = new GamePanel();
	}
	public static void main(String[] args) {
		LeagueInvaders window = new LeagueInvaders();
		window.setup();
		
	}
	void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
