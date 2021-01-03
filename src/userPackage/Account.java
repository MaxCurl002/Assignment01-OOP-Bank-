package userPackage;

public class Account {
	private String userName;
	private char[] userAccountId = new char[4];//4 digit long ID
	private String userPhoneNo; 
	private int userPin; //8 digit pin code so int can hold it
	private int userBalance;
	
	/*public Account(String userName, String userPhoneNo, int userPin) {
		this.userName=userName;
		this.userPhoneNo=userPhoneNo;
		this.userPin=userPin;
	}
	
	public Account(String userName, char[]  userAccountId, int userPin) {
		this.userName=userName;
		this.userAccountId=userAccountId;
		this.userPin=userPin;
	}
	
	public Account(String userName, String userPhoneNo) {
		this.userName=userName;
		this.userPhoneNo=userPhoneNo;
	}*/
	
	//open a new Account
	public void openAccount(String userName, String userPhoneNo, int userPin) {
		this.userName=userName;
		this.userPhoneNo=userPhoneNo;
		this.userPin=userPin;
		
		//set the account id for the user
		this.userAccountId[0]=userName.charAt(0); 
		this.userAccountId[1]='2'; 
		this.userAccountId[2]='B'; 
		this.userAccountId[3]=userName.charAt(1); 
		//return this.userAccountId;
		System.out.println("Your account has been created.\nYour user id is: "+this.userAccountId);
	}
	
	//cashOut and addMoney
	public void cashOut(int amount, int userPin){
		if(isPinVerified(userPin)) {
			if(amount<=this.userBalance) this.userBalance-=amount;
			else if(amount>this.userBalance) {
				System.out.println("Request Denied. You don't have enough balace in your account.");
			}
		}
	}
	
	public void addMoney(int amount, int userPin){
		if(isPinVerified(userPin)) {
			this.userBalance+=amount;
		}
	}
	
	public void addMoney(int amount, String userPhoneNo){
		if(this.userPhoneNo==userPhoneNo) {
			this.userBalance+=amount;
		}
		else System.out.println("Wrong phone number, operation denied");
	}
	
	private boolean isPinVerified(int userPin) {
		if(this.userPin==userPin) return true;
		System.out.println("Wrong Pin code, operation denied!");
		return false;
	}
	
	//show Account information
	public String showBalance() { //add pin
		return "->"+this.userName+" Account Id:"+ this.userAccountId+ "	Balace:"+ this.userBalance;
	}
	
	//Update Account Info
	public void changeAccountPin(int oldPin, int newPin) {
		if(isPinVerified(oldPin)) {
			this.userPin=newPin;
			System.out.println("Pin has been updated.");
		}
	}
}
