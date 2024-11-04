
public class PhoneCall extends Communication{
	
	private int diarkeia;
	
	public PhoneCall(String text1,String text2,int day,int month,int year,int duration) {
		super(text1,text2,day,month,year);
		this.diarkeia=duration;
	}
	
	public int getDuration() {
		return this.diarkeia;
	}
	
	public void printInfo() {
		System.out.println("This phonecall has the following info");
		super.printInfo();
		System.out.println("Duration: "+diarkeia);
	}
}
