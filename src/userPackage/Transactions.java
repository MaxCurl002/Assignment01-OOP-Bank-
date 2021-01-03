package userPackage;

public class Transactions {
	public void viewInterface(){
		
		//create account
		Account user1 = new Account();
		user1.openAccount("Abhijit Paul", "01968399154", 1201);
		System.out.println(user1.showBalance()); 
		
		//transaction
		user1.addMoney(1000, 1201);
		user1.cashOut(100, 1201);
		System.out.println(user1.showBalance()); 
		
		//change pin
		user1.changeAccountPin(1200, 1001);
		user1.changeAccountPin(1201, 1001);	
	}
}
