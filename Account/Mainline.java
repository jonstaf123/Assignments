package ssa;

public class Mainline {

	public static void main(String[] args) {
		Account myCheckings = new Account();
		myCheckings.accountId = 100;
		myCheckings.description ="My personal checking account";
		myCheckings.balance = 500.00;
		myCheckings.deposit1 = 200;
		myCheckings.withdraw1 = 600.00;
		
		
		System.out.println("Account ID: " + myCheckings.accountId + " Account description: " + myCheckings.description
				+ "Account Balance: " + myCheckings.balance);
		myCheckings.totalBalance = myCheckings.balance; 
		myCheckings.addDeposit();
		System.out.println("Account ID: " + myCheckings.accountId + " Account description: " + myCheckings.description
				+ "Account Balance: " + myCheckings.totalBalance);
		myCheckings.subtractWithdraw();
		System.out.println("Account ID: " + myCheckings.accountId + " Account description: " + myCheckings.description
				+ "Account Balance: " + myCheckings.totalBalance);
		myCheckings.getBalance();
		myCheckings.deposit2 = 100;
		myCheckings.deposit1 = 0;
		myCheckings.addDeposit();
		System.out.println("Account ID: " + myCheckings.accountId + " Account description: " + myCheckings.description
				+ "Account Balance: " + myCheckings.totalBalance);
		
		myCheckings.getBalance();
		myCheckings.withdraw2 = 300;
		myCheckings.withdraw1 = 0;
		myCheckings.subtractWithdraw();	
		if (myCheckings.totalBalance > 0) {
			System.out.println("Account ID: " + myCheckings.accountId + " Account description: " + myCheckings.description
				+ "Account Balance: " + myCheckings.totalBalance);
		}else {
			System.out.println("Insufficient funds!");
		}
		
		myCheckings.getBalance();
		myCheckings.withdraw3 = 200;
		myCheckings.withdraw2 = 0;
		myCheckings.withdraw1 = 0;
		myCheckings.subtractWithdraw();
		if (myCheckings.totalBalance >= 0) {
			System.out.println("Account ID: " + myCheckings.accountId + " Account description: " + myCheckings.description
				+ "Account Balance: " + myCheckings.totalBalance);
		}else {
		System.out.println("Insufficient funds!");
		}
	
	
	
		Account mySavings = new Account();
		mySavings.accountId = 200;
		mySavings.description ="My personal savings account";
		mySavings.balance = 1000.00;
		mySavings.deposit1 = 200;
		mySavings.withdraw1 = 750.00;
		mySavings.totalBalance = mySavings.balance;
	
	
		mySavings.subtractWithdraw();
		System.out.println("Account ID: " + mySavings.accountId + " Account description: " + mySavings.description
				+ "Account Balance: " + mySavings.totalBalance);
		mySavings.withdraw2 = 250;
		mySavings.withdraw1 = 0;
		mySavings.subtractWithdraw();
		
		System.out.println("Account ID: " + mySavings.accountId + " Account description: " + mySavings.description
				+ "Account Balance: " + mySavings.totalBalance);
	mySavings.addDeposit();
	System.out.println("Account ID: " + mySavings.accountId + " Account description: " + mySavings.description
			+ "Account Balance: " + mySavings.totalBalance);
	
	
	
	
	
	
	
	
	}
}
		