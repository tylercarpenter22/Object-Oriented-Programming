import java.util.Scanner;

public class Daytona{
    //static variables
    public static Scanner scan;
    
    //this function displays a menu of options and returns the option selected
    public static int menu(){
        //print list of options
        System.out.println("What would you like to do?");
        System.out.println("1. Drive on the Beach");
        System.out.println("2. Play Disc Golf");
        System.out.println("3. See the race.");
        System.out.println("4. Exit");
        //get user input for option
        int in = scan.nextInt();
        scan.nextLine();
        return in;
    }
    
    //this method displays output for beach option dependent on time entered
    public static void Beach(){
        //get user input for time
        System.out.println("What time did Knightro get to the beach?");
        int time = scan.nextInt();
        //check time
        if(time >= 9 && time <= 18){
            System.out.println("Enjoy your drive!\n");
        }
        else{
            System.out.println("Oh no! The beach is closed\n");
        }
    
    }
    
    //this function displays output for the park option, looping until the disk is in basket
    public static void Park(){
        int distance = 457; //default distance, prime number 300-500
        System.out.println("Welcome to the park!");
        while(distance != 0){
            int throwdist = 0;
            System.out.println("There is " + distance + " feet left until the basket.");
            //get user input for distance thrown
            System.out.println("How far did you throw?");
            throwdist = scan.nextInt();
            //handle case where disk is thrown past goal
            if(distance < throwdist){
                distance = throwdist - distance;
            }
            else{
                distance -= throwdist;
            }
            //disk is made into goal
            if(distance == 0){
                System.out.println("You made it in!\n");
                break;
            }
        }
    }
    
    //this functiont takes in the amount of laps and outputs a decrementation of these laps
    public static void Race(){
        //get user input for laps
        System.out.println("How many laps are left?");
        int laps = scan.nextInt();
        //print out laps decrementing in loop
        while(laps != 0){
            System.out.println("There are " + laps + " laps left.");
            laps--;
        }
        //print finish when no laps left
        if(laps == 0){
            System.out.println("Finished!\n");
        }
    
    }
    
    public static void main(String[] args) {
        
        //declare variables, print intro
        scan = new Scanner(System.in);
        int in = 0;
        System.out.println("Welcome to Daytona Beach!");
    
        //handle cases
        while(in != 4){
            in = menu();
            switch(in){
                case 1:
                    Beach();
                    break;
                case 2:
                    Park();
                    break;
                case 3:
                    Race();
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
            }
        }
    }
        
    
