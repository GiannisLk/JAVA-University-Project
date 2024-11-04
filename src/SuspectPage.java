import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;






public class SuspectPage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField NameField;
	private JTextField CodeNameField;
	private Suspect suspect;
	private JTextArea phonenumberField;
	private String numbers;
	private JPanel panel1;
	private JTextField thlefwno;
	private JTextArea messages;
	private JButton SMS;
	private Registry regist;
	private JTextArea partners;	
	private ArrayList<Suspect> synergoi;
	private JLabel syn;
	private int i;
	private String poss = "";
	private JLabel suggested;
	private JTextArea sugg;
	private String proteinomenoi = "";
	private ArrayList<Suspect> prot;
	private JTextArea country;
	private String xwra="";
	private ArrayList<Suspect> Xwra;
	private JButton back;
	private JPanel mainpanel;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	
	
	public SuspectPage(Suspect aSuspect,Registry registry) {
		suspect= aSuspect;
		numbers=String.join("\n",suspect.getnumbers());
		regist = registry;
		
		mainpanel=new JPanel();
		panel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		panel.setVisible(true);
		panel1.setVisible(true);
		panel2.setVisible(true);
		panel3.setVisible(true);
		panel4.setVisible(true);
		
		mainpanel.add(panel);
		mainpanel.add(panel1);
		mainpanel.add(panel2);
		mainpanel.add(panel3);
		mainpanel.add(panel4);
		panel.setBorder(BorderFactory.createEtchedBorder());
		panel1.setBorder(BorderFactory.createEtchedBorder());
		panel2.setBorder(BorderFactory.createEtchedBorder());
		panel3.setBorder(BorderFactory.createEtchedBorder());
		panel4.setBorder(BorderFactory.createEtchedBorder());
		
		NameField = new JTextField(suspect.getName());
		CodeNameField = new JTextField(suspect.getCodeName());
		phonenumberField = new JTextArea(numbers);
		
		panel.add(NameField);
		panel.add(CodeNameField);
		panel.add(phonenumberField);
		
		this.setContentPane(mainpanel);
		
		phonenumberField.setEditable(false);
		NameField.setEditable(false);
		CodeNameField.setEditable(false);
		
		
		
		thlefwno = new JTextField("Enter phone number");
		messages = new JTextArea(7,13);
		SMS = new JButton("Find SMS");
		
		
		panel1.add(thlefwno);
		panel1.add(messages);
		panel1.add(SMS);
		
		
		
		suspagelistener listener = new suspagelistener();
		SMS.addActionListener(listener);
		
		
		messages.setEditable(false);
		
	
		synergoi = suspect.getSynergoi();
		syn = new JLabel("Partners");
		partners = new JTextArea(7,16);
		
		panel2.add(syn);
		panel2.add(partners);
		
		syn.setVisible(true);
		partners.setVisible(true);
		
		partners.setEditable(false);
		
		
		for(i=0;i<synergoi.size();i++) {
		poss+=synergoi.get(i).getName()+", "+synergoi.get(i).getCodeName()+"\n";}
		partners.append(poss);
		
		suggested = new JLabel("Suggested Partners ---->");
		sugg = new JTextArea(4,18);
		
		panel3.add(suggested);
		panel3.add(sugg);
		
		suggested.setVisible(true);
		sugg.setVisible(true);
		
		suspect.proteinomenoi();
		prot = suspect.getSuggested();
		
		for(i=0;i<prot.size();i++) {
			proteinomenoi+=prot.get(i).getName()+"\n";
		}
		sugg.append(proteinomenoi);
		proteinomenoi="";
		prot=null;
		sugg.setEditable(false);
		
		country = new JTextArea(3,29);
		panel4.add(country);
		country.setVisible(true);
		country.setEditable(false);
		Xwra = regist.getsuspectsfromCountry(suspect.getCountry());
		xwra = "Suspects coming from "+suspect.getCountry()+"\n";
		for(i=0;i<Xwra.size();i++) {
		xwra+=Xwra.get(i).getName()+"\n";
		}
		country.append(xwra);
		xwra="";
		Xwra.clear();
		back = new JButton("Return to Search Screen");
		mainpanel.add(back);
		back.addActionListener(listener);
		back.setVisible(true);
		
		this.setTitle("Suspect Page");
		this.setSize(450, 650);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	
	
	class suspagelistener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(SMS)) {
			String noymero = thlefwno.getText();
			ArrayList<SMS> mhnymata = new ArrayList<>();
 			for(String number: suspect.getnumbers()) {
				mhnymata = regist.getMessagesBetween(number,noymero);
 			}
 		
		messages.setText(regist.getmess(mhnymata));
		mhnymata.clear();
			}	
		

			else if(e.getSource().equals(back)) {
				dispose();
				new FindSuspectFrame(regist);
			}
		}
	}	
	
	
						
}
