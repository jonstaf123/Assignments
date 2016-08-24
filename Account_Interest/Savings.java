package ssa;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Savings extends Account {

	private double interestRate;
	private int months;
	private double earnedInterest;
	private double minBalance;

	public String print() {
		if (earnedInterest <= 0) {
			return super.print() + " no interest earned "; 
		} else {
			DecimalFormat df = new DecimalFormat("#.##");

		    df.setRoundingMode(RoundingMode.FLOOR);

		    double resultInterest = new Double(df.format(this.getEarnedInterest()));
			return super.print() + " and earned interest amount is $" + resultInterest;
		}
		
	}

	public double getEarnedInterest() {
		return earnedInterest;
	}

	public void setEarnedInterest(double earnedInterest) {
		this.earnedInterest = earnedInterest;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public double earnedInterest() {

		double interestAmount = this.getInterestRate() / 12 * months * this.getBalance();
		this.setEarnedInterest(interestAmount);
		// returns dollar amount of interest added to balance
		return earnedInterest;
	}

	public double calcDepositInterest(int months) {
		if (this.getBalance() < minBalance) {
			System.out.println("Below minimum Balance");
		} else if (this.interestRate <= 0) {
			System.out.println("Invalid Interest rate");
		} else {
			setMonths(months);
			earnedInterest();
			double newRate = this.getInterestRate() / 12 * this.months;
			deposit(newRate * this.getBalance());
		}
		return this.getBalance();
	}

	public Savings() {
		interestRate = .015;
		months = 12;
		earnedInterest = 0;
		minBalance = 1;
	}
}
