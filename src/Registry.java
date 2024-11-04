import java.util.ArrayList;

public class Registry {
	ArrayList<Suspect> suspects = new ArrayList<Suspect>();	
	ArrayList<Suspect> possible = new ArrayList<Suspect>();
	ArrayList<Communication> comms = new ArrayList<Communication>();
	ArrayList<SMS> getMess = new ArrayList<SMS>();
	ArrayList<Suspect> Country = new ArrayList<>();
	public Registry() {
	
	}
	public void addSuspect(Suspect aSuspect) {
		suspects.add(aSuspect);
	}
	

	public void addCommunication(Communication aCommunication) {
		comms.add(aCommunication);
		for(int i=0; i<suspects.size(); i++) {
			for(int j=0; j<suspects.get(i).getnumbers().size(); j++) {
				if(suspects.get(i).getnumbers().get(j) == aCommunication.get1stnr()) {
						for(int k=0; k<suspects.size(); k++) {
							for(int y=0; y<suspects.get(k).getnumbers().size(); y++) {
								if(suspects.get(k).getnumbers().get(y) == aCommunication.get2ndnr()) {
									suspects.get(i).addpossible(suspects.get(k), aCommunication);
					
				}
			}

										
	}}}}}

	
	
	public Suspect getSuspectWithMostPartners() {
		int max=suspects.get(0).synergoisize();
		Suspect most=suspects.get(0);
		for(int i=0;i<suspects.size();i++) {
			if(suspects.get(i).synergoisize()>=max) {
				max=suspects.get(i).synergoisize();
				most=suspects.get(i);
			}
		}
	return most;
	}
	
	
	
	public PhoneCall  getLongestPhoneCallBetween(String number1, String number2) {
		PhoneCall longest=(PhoneCall)comms.get(0);
		int maxtime=longest.getDuration();
		for(int i=0;i<comms.size();i++) {
			if(comms.get(i) instanceof PhoneCall) {
			PhoneCall phonec=(PhoneCall)comms.get(i);
			if(comms.get(i).get1stnr()==number1 && comms.get(i).get2ndnr()==number2 ) {
			if(phonec.getDuration()>=maxtime) {
				maxtime=phonec.getDuration();
				longest =(PhoneCall)comms.get(i);
			}	}
			}
		}
		return longest;
	}
	
	
	
	public ArrayList<SMS> getMessagesBetween(String number1, String number2) {
		
    	for(int i=0;i<comms.size();i++) {
			if(comms.get(i) instanceof SMS) {
					if(comms.get(i).get1stnr().equals(number1) && comms.get(i).get2ndnr().equals(number2) || comms.get(i).get1stnr().equals(number2) && comms.get(i).get2ndnr().equals(number1)) {
						if(((SMS)(comms.get(i))).gettext().contains("Bomb") || ((SMS)(comms.get(i))).gettext().contains("Attack") 
								|| ((SMS)(comms.get(i))).gettext().contains("Explosives") || ((SMS)(comms.get(i))).gettext().contains("Gun"))
						{
							getMess.add((SMS)comms.get(i));
						}
				
					}
			
			}
		}
		return getMess;
	}	
			

	
	public void printSuspectsFromCountry(String country){
		System.out.println("Suspects from: "+country);
		for(int i=0;i<suspects.size();i++) {
			if(suspects.get(i).getCountry() == country) {
				System.out.println(suspects.get(i).getName()+"  ("+suspects.get(i).getCodeName()+")");
				
			}
		}
		
	}
	public ArrayList<Suspect> returnSuspects(){
		return suspects;
	}
	
public String getmess(ArrayList<SMS> messages) {
	String mess="";
	for(int i=0;i<messages.size();i++) {
		mess+=messages.get(i).gettext()+"\n";
		
}
	return mess;
}

public ArrayList<Suspect> getsuspectsfromCountry(String country){
	for(Suspect item: suspects) {
		if(item.getCountry() == country) {
			Country.add(item);
		}
	
	}
	return Country;
}

}

