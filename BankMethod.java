import java.util.Scanner;
class BankMethod{
	static double num;
	static float bal;
	static int OrgPin = 1234;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		for (; ; ) {
		System.out.println("\n.........WELCOME TO BANK..........\n");
		System.out.println("1.DEPOSIT \n2.WITHDRAW \n3.LOAN \n4.CHECK BALANCE \n5.EXIT");
		System.out.print("\nEnter Your Choice: ");
		int ch = sc.nextInt();
		switch(ch){
			case 1:
				System.out.println("\n.........DEPOSIT...........\n");
				System.out.print("Enter a amount : ");
				num = sc.nextDouble();
				if(num>0) deposit(num);
				else System.out.println("INVAILD AMOUNT");
				System.out.print("\n Do you want to check Balance (Y/N) : ");
				char op = sc.next().toUpperCase().charAt(0);
				if(op=='Y') checkBal();
				else exit();
				break;
			case 2:
				System.out.println("\n.........WITHDRAW...........\n");
				System.out.print("Enter a amount : ");
				num = sc.nextDouble();
				if(pinCheck()){
					if(num>0) withdraw(num);
					else System.out.println("INVAILD AMOUNT");
					System.out.print("\n Do you want to check Balance (Y/N) : ");
					char op1 = sc.next().toUpperCase().charAt(0);
					if(op1=='Y') checkBal();
					else exit();
					}
				else System.out.println("INVAILD PIN ");
				break;
			case 3:
				System.out.println("\n.................LOAN.................\n");
				System.out.print("1.EDUCATION LOAN \n2.BUSSINESS LOAN \n Enter Your Choice: ");
				int lonOP = sc.nextInt();
				switch(lonOP){
					case 1: 
						System.out.println("\n..........EDUCATION LOAN.............\n");
						String org = "College";
						Loan(org);
						break;
					case 2:
						System.out.println("\n..........BUSSINESS LOAN.............\n");
						org = "Company";
						Loan(org);
						break;
					default:
						System.out.println("INVAILD CHOICE");
					}
					break;

			case 4:
				System.out.println("\n.............CHECK BALANCE............\n");
				checkBal();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("INVAILD CHOICE");
		}
	}
	}
	public static void deposit(double num){
		// System.out.println("\n.............DEPOSIT..................\n");
		if(num>=1){
			bal+=num;
			System.out.println("Your Amount is Successfully deposited");
		}
		else{
			System.out.println("MINIMUM DEPOSIT 1.00 ");
		}
	}
	public static void withdraw(double num){
		//System.out.println("\n.............WITHDRAW..................\n");
		if(bal>=num){
			bal-=num;
			System.out.println("Your Amount is Successfully Withdraw");
		}
		else System.out.println("INSUFFICIENT BALANCE");
	}
	public static void checkBal(){
		if(pinCheck()){
			System.out.println("\n.........................\n");
			System.out.printf("YOUR BALANCE: %.2f",bal);
			System.out.println();
		}else System.out.println("INVAILD PIN");
	}
	public static void exit(){
		System.out.println("\n..............THANK YOU FOR USING THIS APP...............\n");
	}
	public static boolean pinCheck(){
		System.out.println();
		System.out.print("Enter a PIN: ");
		int pin = new Scanner(System.in).nextInt();
		if(OrgPin==pin) return true;
		else return false;
	}
	public static void Loan(String org){
		//Scanner sc = new Scanner(System.in);
		
		if(details(org)){
		System.out.print("Enter a Loan Amount: ");
		num = sc.nextDouble();
		deposit(num);
		System.out.print("\n Do you want to check Balance (Y/N) : ");
				char op = sc.next().toUpperCase().charAt(0);
				if(op=='Y') checkBal();
				else exit();
			}
			else exit();
	}
	public static boolean details(String org){
		System.out.println("\n FOR PROVIDING YOU A LOAN WE NEED SOME YOUR INFORMATION \n");
		System.out.print("Enter your Name : ");
		String nm = sc.next();
		System.out.print("Enter your Age : ");
		int age = sc.nextInt();
		if(age>=0 && age < 100){ 
		System.out.print("Enter your "+org+" Name: ");
		String org1 = sc.next();
		return true;
		}else System.out.println("INVAILD AGE ");
		return false;
		
	}

}