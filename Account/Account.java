package ssa;

public class Account {
	int accountId;
	String description;
	double balance, deposit1, deposit2, deposit3, withdraw1, withdraw2, withdraw3, totalBalance;
	
	
	
	
	double addDeposit (){
		double addDeposit = deposit1 + deposit2 + deposit3 + totalBalance;
		totalBalance = addDeposit;
		return totalBalance;
		
		
		
		
	}
	
	
	 double subtractWithdraw(){
		
		double subtractWithdraw =  totalBalance - withdraw1 - withdraw2 - withdraw3;
		totalBalance =subtractWithdraw;
		return totalBalance;
	
	}


	 double getBalance (){
		double totalBalance = 0;
		return totalBalance;
	 }
	 

}
