//Tyler Carpenter
//COP 3300
//Assignment 2: Objects


public class Account{

    //instance variables
    private String name;
    private double balance;
    private double interest;

    //constructor
    public Account(String name, double interest){
        this.name = name;
        this.interest = interest;
        this.balance = 0;
    }


    //instance methods
    
    //gets (returns) name value.
    public String getName(){

        return this.name;
    }


    //gets (returns) balance value.
    public double getBalance(){

        return this.balance;
    }


    //takes in double funds and adds to balance if funds greater than 0.
    public void deposit(double funds){

        //return false if funds is 0 or less
        if(funds <= 0){
            System.out.println("This is an invalid amount");
        }
        else{
            //add money to balance
            this.balance += funds;
            System.out.printf("You have added $%.2f.\n", funds);
        }
    }


    //takes in double funds and removes from balance if funds greater than 0 and balance has sufficent amount.
    public void withdraw(double funds){

        //return false if funds is 0 or less or balance - funds 
        if(funds <= 0 || (this.balance - funds) < 0){
            System.out.println("This is an invalid amount");
            return;
        }
        else{
            //remove money from balance
            this.balance -= funds;
            System.out.printf("You have withdrawn $%.2f.\n", funds);
        }
    }


    //takes in an int months (1-1000) representing months passed. calculates interest.
    public void calcInterest(int months){

        //calculate interest with interest rate
        double interestRate = this.interest * (months/12.0)/100.0;
        
        //calculate and update balance
        double newBalance = this.balance * (1 + interestRate);
        this.balance = newBalance;
        System.out.println("Done");
        System.out.printf("%f %d %f %f", this.interest, months, interestRate, newBalance);
    }

}
