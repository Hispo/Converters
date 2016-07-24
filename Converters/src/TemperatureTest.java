import javax.swing.JFrame;

public class TemperatureTest {

	public static void main(String[] args) {

		Temperature temperature = new Temperature();
		temperature.setSize(450, 120);
		temperature.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temperature.setVisible(true);

		temperature.setAutoRequestFocus(true); // Prevents using frame , when
											   // the secondary is open .
		
		temperature.setLocationRelativeTo(null); // It appears in the center of
												 // the screen.
	}
}