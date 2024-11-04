import java.util.ArrayList;

public class Suspect {
private	String Name;
private	String codename;
private	String katagwgh;
@SuppressWarnings("unused")
private	String drasthriopoihsh;
	int i;
	private ArrayList<Suspect> synergoi;
	private ArrayList<String> noumera;
	private ArrayList<Suspect> suggested;
	ArrayList<Suspect> common = new ArrayList<Suspect>()  ;
	
	public Suspect(String text1,String text2,String text3,String text4) {
		this.Name=text1;
		this.codename=text2;
		this.katagwgh=text3;
		this.drasthriopoihsh=text4;
		 synergoi = new ArrayList<Suspect>();
		 noumera = new ArrayList<String>();
		
	}
	
	public String getName() {
		return this.Name;
	}
	
	public String getCodeName() {
		return this.codename;
	}
	
	public void addNumber(String number) {
		noumera.add(number);
	}

	
	public ArrayList<Suspect> getCommonPartners(Suspect bsuspect){
		
		for(i=0; i<synergoi.size(); i++) {
			for(int j=0; j<bsuspect.synergoi.size(); j++) {
				if(synergoi.get(i) == bsuspect.synergoi.get(j)) {
					common.add(synergoi.get(i));
				}
			}
		}
		return common;
	}

	public ArrayList<Suspect> getSynergoi(){
		return synergoi;
	}
	
	public boolean isConnectedTo(Suspect csuspect) {
		boolean flag=false;
		for(i=0;i<synergoi.size();i++) {
			if(synergoi.get(i)==csuspect) {
				flag=true;
			}}
		return flag;
		}


public void printInfo() {
	System.out.print("Common partners: ");
	for(i=0;i<synergoi.size();i++) {
		System.out.print(synergoi.get(i).Name+"---"+synergoi.get(i).codename);
		if(synergoi.get(i).katagwgh==katagwgh) {
			System.out.println("*");
		}
	}
}


public void addpossible(Suspect aSuspect,Communication aCommunication){
	boolean flag=false;
	for(i=0;i<synergoi.size();i++) {
		if(aSuspect==synergoi.get(i)) {
			flag=true;
		}
		
	}
	if(flag==false) {
		synergoi.add(aSuspect);
		aSuspect.synergoi.add(this);
		
	}
}



public int synergoisize() {
	return synergoi.size();
}



public String getCountry(){
	return this.katagwgh;
}


public ArrayList<String> getnumbers() {
	return noumera;
}

public void proteinomenoi(){
	 suggested = new ArrayList<Suspect>();
	for(Suspect item: this.synergoi) {
		for(int i=0;i<item.synergoisize();i++) {
			if(!this.synergoi.contains(item.synergoi.get(i)) && this!=item.synergoi.get(i)){
				this.suggested.add(item.synergoi.get(i));
			}
		
		}
		
    }
}

public ArrayList<Suspect> getSuggested(){
		return this.suggested;
	}



}


