import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JetFighter {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	JFrame gameFrame = new JFrame();
	GamePanel gamePanel = new GamePanel();
	public void setup() {
	gameFrame.setSize(WIDTH,HEIGHT);
	gameFrame.setVisible(true);
	gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gameFrame.add(gamePanel);
	gameFrame.addKeyListener(gamePanel);
}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JetFighter JetFighter = new JetFighter();
				JetFighter.setup();
				
			}
		});
			
			
		}
		{
	}
}
