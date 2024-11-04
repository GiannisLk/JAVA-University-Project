import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class FindSuspectFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField NameField;
	private JButton FindButton;
	private ArrayList<Suspect> Suspects;
	private Registry regist;
	
	public FindSuspectFrame(Registry registry) {
		Suspects= registry.returnSuspects();
		regist = registry;
		
		panel = new JPanel();
		NameField = new JTextField("Please enter suspect's name");
		FindButton = new JButton("Find");
		
		panel.add(NameField);
		panel.add(FindButton);
		
		this.setContentPane(panel);
		
		findsuslistener listener = new findsuslistener();
		FindButton.addActionListener(listener);
		
		this.setTitle("Find Suspect");
		this.setSize(300, 160);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class findsuslistener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Registry registry=regist;
			String suspect = NameField.getText();
			Suspect selectedsuspect = null;			
			for(Suspect aSuspect : Suspects)
			{
				if (suspect.equals(aSuspect.getName()))
				{
					selectedsuspect = aSuspect;
					break;
				}}
				if (selectedsuspect!=null){
					if (e.getSource().equals(FindButton)) {

					dispose();
					new SuspectPage(selectedsuspect,registry);
					}
					
				}
				else new MessageBox(suspect);
			
			}			
		
				
	}
	}

