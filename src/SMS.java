
public class SMS extends Communication{
	
private	String periexomeno;
	
	public SMS(String text1,String text2,int day,int month,int year,String message) {
		super(text1,text2,day,month,year);
		this.periexomeno=message;
	}

	public String gettext() {
	return this.periexomeno;	
	}

	public void printInfo() {
		System.out.println("This SMS has the following info:");
		super.printInfo();
		System.out.println("Text: "+periexomeno);
	
	}
}

