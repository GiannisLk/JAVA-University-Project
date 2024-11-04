public class Communication {
private	String number1;
private	String number2;
private	int mera;
private	int mhnas;
private	int xronia;
	
	public Communication(String text1,String text2,int day,int month,int year){
		this.number1=text1;
		this.number2=text2;
		this.mera=day;
		this.mhnas=month;
		this.xronia=year;
		
	}
	public String get1stnr(){
		return this.number1;
	}

	public String get2ndnr() {
		return this.number2;
	}
	public void printInfo() {
		
		System.out.println("Between "+number1+" --- "+number2);
		System.out.println("on "+mera+"/" +mhnas+"/"+xronia);
	
	}
}
