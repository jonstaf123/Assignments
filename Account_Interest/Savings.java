package ssa;

public class Savings extends Account {

	private double interestRate;
	private int months;
	private double earnedInterest;

	public String print() {
		return super.print() + " and earned interest amount is $" + earnedInterest;
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
		return earnedInterest;
	}

	public double calcDepositInterest(int months) {
		if (this.interestRate <= 0) {
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
	}
}
