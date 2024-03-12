import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	// variables
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
	private double totalBalance = 0; // total balance
	private double retireBalance = 0; // retire balance
	private double investBalance = 0; // invest balance

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	public Account() {
	}

	public Account(int customerNumber, int pinNumber) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
	}

	public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance, double retireBalance, double investBalance) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
		this.retireBalance = retireBalance;
		this.investBalance = investBalance;
	}

	public double totalBalance() { // SHOW ALL ACCOUNT BALANCE CODE
		totalBalance = getCheckingBalance() + getSavingBalance() + getRetireBalance() + getInvestBalance();
		return totalBalance;
	}

	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public double getRetireBalance() { // GET RETIRE BALANCE
		return retireBalance;
	}

	public double getInvestBalance() { // GET INVEST BALANCE
		return investBalance;
	}

	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}

	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	public double calcRetireWithdraw(double amount) { // CALC RETIRE WITHDRAWL
		retireBalance = (retireBalance - amount);
		return retireBalance;
	}

	public double calcInvestWithdraw(double amount) { // CALC INVEST WITHDRAWL
		investBalance = (investBalance - amount);
		return investBalance;
	}

	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}

	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}

	public double calcRetireDeposit(double amount) { // CALC RETIREMENT DEPOSIT
		retireBalance = (retireBalance + amount);
		return retireBalance;
	}

	public double calcInvestDeposit(double amount) { // CALC INVESTMENT DEPOSIT
		investBalance = (investBalance + amount);
		return investBalance;
	}

	public void calcCheckTransfer(double amount) {
		checkingBalance = checkingBalance - amount;
		savingBalance = savingBalance + amount;
	}

	public void calcSavingTransfer(double amount) {
		savingBalance = savingBalance - amount;
		checkingBalance = checkingBalance + amount;
	}

	public void calcRetireTransfer(double amount) { // CALC RETIRE TRANSFER
		retireBalance = retireBalance - amount;
		investBalance = investBalance + amount;
	}

	public void calcInvestTransfer(double amount) { // CALC INVEST TRANSFER
		investBalance = investBalance - amount;
		retireBalance = retireBalance + amount;
	}

	public void getCheckingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
				System.out.print("\nAmount you want to withdraw from Checking Account: ");
				double amount = input.nextDouble();
				if ((checkingBalance - amount) >= 0 && amount >= 0) {
					calcCheckingWithdraw(amount);
					System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getsavingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
				System.out.print("\nAmount you want to withdraw from Savings Account: ");
				double amount = input.nextDouble();
				if ((savingBalance - amount) >= 0 && amount >= 0) {
					calcSavingWithdraw(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getRetireWithdrawInput() { // GET RETIREMENT WITHDRAWAL INPUT
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Retirement Account Balance: " + moneyFormat.format(retireBalance));
				System.out.print("\nAmount you want to withdraw from Retirement Account: ");
				double amount = input.nextDouble();
				if ((retireBalance - amount) >= 0 && amount >= 0) {
					calcRetireWithdraw(amount);
					System.out.println("\nCurrent Retirement Account Balance: " + moneyFormat.format(retireBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getInvestWithdrawInput() { // GET INVESTMENT WITHDRAWAL INPUT
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investBalance));
				System.out.print("\nAmount you want to withdraw from Investment Account: ");
				double amount = input.nextDouble();
				if ((investBalance - amount) >= 0 && amount >= 0) {
					calcInvestWithdraw(amount);
					System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}


	public void getCheckingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
				System.out.print("\nAmount you want to deposit from Checking Account: ");
				double amount = input.nextDouble();
				if ((checkingBalance + amount) >= 0 && amount >= 0) {
					calcCheckingDeposit(amount);
					System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getSavingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
				System.out.print("\nAmount you want to deposit into your Savings Account: ");
				double amount = input.nextDouble();

				if ((savingBalance + amount) >= 0 && amount >= 0) {
					calcSavingDeposit(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getRetireDepositInput() { // GET RETIREMENT DEPOSIT INPUT
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Retirement Account Balance: " + moneyFormat.format(retireBalance));
				System.out.print("\nAmount you want to deposit into your Retirement Account: ");
				double amount = input.nextDouble();

				if ((retireBalance + amount) >= 0 && amount >= 0) {
					calcRetireDeposit(amount);
					System.out.println("\nCurrent Retirement Account Balance: " + moneyFormat.format(retireBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}


	public void getInvestDepositInput() { // GET INVESTMENT DEPOSIT INPUT
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investBalance));
				System.out.print("\nAmount you want to deposit into your Investment Account: ");
				double amount = input.nextDouble();

				if ((investBalance + amount) >= 0 && amount >= 0) {
					calcInvestDeposit(amount);
					System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}


	public void getTransferInput(String accType) {
		boolean end = false;
		while (!end) {
			try {
				if (accType.equals("Checking")) {
					System.out.println("\nSelect an account you wish to transfer funds to:");
					System.out.println("1. Savings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
						case 1:
							System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
							System.out.print("\nAmount you want to deposit into your Savings Account: ");
							double amount = input.nextDouble();
							if ((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) {
								calcCheckTransfer(amount);
								System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
								System.out.println(
										"\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
								end = true;
							} else {
								System.out.println("\nBalance Cannot Be Negative.");
							}
							break;
						case 2:
							return;
						default:
							System.out.println("\nInvalid Choice.");
							break;
					}
				} else if (accType.equals("Savings")) {
					System.out.println("\nSelect an account you wish to transfer funds to: ");
					System.out.println("1. Checking");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
						case 1:
							System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
							System.out.print("\nAmount you want to deposit into your savings account: ");
							double amount = input.nextDouble();
							if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
								calcSavingTransfer(amount);
								System.out.println("\nCurrent checking account balance: " + moneyFormat.format(checkingBalance));
								System.out.println("\nCurrent savings account balance: " + moneyFormat.format(savingBalance));
								end = true;
							} else {
								System.out.println("\nBalance Cannot Be Negative.");
							}
							break;
						case 2:
							return;
						default:
							System.out.println("\nInvalid Choice.");
							break;
					}
				} else if (accType.equals("Retirement")) { //RETIREMENT TRANSFER
					System.out.println("\nSelect an account you wish to transfer funds to: ");
					System.out.println("1. Investment");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
						case 1:
							System.out.println("\nCurrent Retirement Account Balance: " + moneyFormat.format(retireBalance));
							System.out.print("\nAmount you want to deposit into your savings account: ");
							double amount = input.nextDouble();
							if ((investBalance + amount) >= 0 && (retireBalance - amount) >= 0 && amount >= 0) {
								calcRetireTransfer(amount);
								System.out.println("\nCurrent investment account balance: " + moneyFormat.format(investBalance));
								System.out.println("\nCurrent retirement account balance: " + moneyFormat.format(retireBalance));
								end = true;
							} else {
								System.out.println("\nBalance Cannot Be Negative.");
							}
							break;
						case 2:
							return;
						default:
							System.out.println("\nInvalid Choice.");
							break;
					}
				} else if (accType.equals("Investment")) { //INVESTMENT TRANSFER
					System.out.println("\nSelect an account you wish to transfer funds to: ");
					System.out.println("1. Retirement");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
						case 1:
							System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investBalance));
							System.out.print("\nAmount you want to deposit into your savings account: ");
							double amount = input.nextDouble();
							if ((retireBalance + amount) >= 0 && (investBalance - amount) >= 0 && amount >= 0) {
								calcInvestTransfer(amount);
								System.out.println("\nCurrent retirement account balance: " + moneyFormat.format(retireBalance));
								System.out.println("\nCurrent investment account balance: " + moneyFormat.format(investBalance));
								end = true;
							} else {
								System.out.println("\nBalance Cannot Be Negative.");
							}
							break;
						case 2:
							return;
						default:
							System.out.println("\nInvalid Choice.");
							break;
					}
				}
				} catch(InputMismatchException e){
					System.out.println("\nInvalid Choice.");
					input.next();
				}
			}
		}
	}
