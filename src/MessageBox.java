
import javax.swing.*;



public class MessageBox extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;

	
	public MessageBox(String suspect) {
		JOptionPane.showMessageDialog(panel, "Suspect "+suspect+" not found");

		}
}
