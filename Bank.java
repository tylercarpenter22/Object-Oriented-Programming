//Tyler Carpenter
//COP 3300
//Assignment 2: Objects


import java.util.Scanner;

public class Bank {

    //private static array of 5 accounts
    private static Account[] accounts = new Account[5];

    //initialize Scanner 
    public static Scanner scan = new Scanner(System.in);


    //displays a menu of bank options and returns the option the user selects
    public static int bankMenu(){

        //display options
        for(int i = 0; i < 5; i++){
            //display empty accounts
            if(accounts[i] == null){
                System.out.printf("%d. Empty\n", (i+1));
            }
            //display existing accounts
            else{
                System.out.printf("%d. %s\n", (i+1), accounts[i].getName());
            }
        }
        System.out.println("6. Exit Program");
        
        //get user input
        System.out.println("What would you like to do?");
        int in = scan.nextInt();
        scan.nextLine();
        return in;
    }


    //displays a menu of account options and returns the option the user selects
    public static int accountMenu(){

        //display options
        System.out.println("What would you like to do?");
        System.out.println("1. Deposit Funds");
        System.out.println("2. Withdraw Funds");
        System.out.println("3. Check Balance");
        System.out.println("4. Calculate Interest");
        System.out.println("5. Close Account");

        //get user input
        System.out.println("What would you like to do?");
        int in = scan.nextInt();
        scan.nextLine();
        return in;
    }


    public static void main(String[] args){

        //upon start
        System.out.println("Welcome to Knightro Banking:");
        //declare variables
        int in = 0, accOption;
        double funds = 0;

        //handle cases for banking menu
        while(in != 6){
            in = bankMenu();
            switch(in){
                //cases 1-5 the same
                case 1: case 2: case 3: case 4: case 5:
                    //create a new account if empty
                    if(accounts[in - 1] == null){
                        //get input for new account
                        System.out.println("Creating a new account.");
                        System.out.println("What is the name of the account:");
                        String inName = scan.nextLine();
                        System.out.println("What is the interest rate?");
                        double inInterest = scan.nextDouble();
                        accounts[in - 1] = new Account(inName, inInterest);
                        break;
                    }
                    //account not empty
                    else{
                        //display account menu 
                        accOption = accountMenu();
                        //handle cases for account menu
                        switch(accOption){
                            case 1:
                                //desposit
                                System.out.println("How much money would you like to deposit?");
                                funds = scan.nextDouble();
                                accounts[in -1].deposit(funds);
                                break;
                            case 2:
                                //withdrawal
                                System.out.println("How much would you like to withdraw?");
                                funds = scan.nextDouble();
                                accounts[in -1].withdraw(funds);
                                break;
                            case 3:
                                //check balance
                                System.out.printf("You have $%.2f.\n", accounts[in -1].getBalance());
                                break;
                            case 4:
                                //calc interest
                                System.out.println("How many months have past?");
                                int months = scan.nextInt();
                                accounts[in-1].calcInterest(months);
                                break;
                            case 5:
                                //close account
                                accounts[in-1] = null;
                                System.out.println("Account closed.");
                                break;
                        }
                    }
                case 6:
                    //exit program
                    if(in == 6){
                        //display goodbye message if exiting program
                        System.out.println("Goodbye.");
                    }
                    break;
            }
        }
    }
}
