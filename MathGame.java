import java.util.Scanner;
import java.util.Arrays;

public class MathGame {

    //static variables
    public static Scanner scan;

    //this method creates and returns an array of random numbers for a user inputed size
    public static int[] generateArray(){
    
        //get user input for num of random nums
        System.out.println("How many values would you like to use: ");
        int size = scan.nextInt(); //values 2-25
        int max = 20, min = 5;

        //create array of random nums (values 5-20)
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = (int)(Math.random() * (max - min + 1)) + min;
            //System.out.printf("%d ", arr[i]); //for seeing rand values created
        }
        System.out.println("Created!");
        return arr;
    }

    //this method displays a list of options and returns the option selected
    public static int menu(){
    
        //print out options
        System.out.println("Select your option:");
        System.out.println("1. Play Game");
        System.out.println("2. Swap Values");
        System.out.println("3. New Values");
        System.out.println("4. Sort");
        System.out.println("5. Exit");
        
        //get user input for option
        int in = scan.nextInt();
        scan.nextLine();
        return in;
    }

    //this method displays a list of number and asks the user to input the sum.
    public static void game(int[] arr){
        
        int sum = 0;
        System.out.println("Add these values: ");
        
        //display all numbers and get the sum
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%d ", arr[i]);
            sum += arr[i];
        }
        //get user answer
        System.out.printf("\n");
        int answer = scan.nextInt(); 
        
        //check if answer is correct
        if(answer == sum) System.out.println("That is correct!\n");
        else{
            System.out.println("That was incorrect. The value adds to be: " + sum);
            System.out.printf("\n");
        }
    }

    //this method randomly selects two different indexes and swaps them
    public static int[] swap(int[] arr){

        int max = arr.length - 1, min = 0;
        
        //print current array
        System.out.printf("Current: ");
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n");

        //get number of swaps
        System.out.println("How many swaps?");
        int numSwaps = scan.nextInt();

        //get and swap two indexes for each numSwap
        for(int i = 0; i < numSwaps; i++){
            //randomly generate two indexes to swap
            int swap1 = (int)(Math.random() * (max - min + 1)) + min;
            int swap2;
            //ensure swap2 is a different value than swap1
            do {
                swap2 = (int) (Math.random() * (max - min + 1)) + min;
            } while (swap1 == swap2);
            //System.out.printf("Swap1: %d Swap2: %d\n", swap1, swap2);

            //perform swap
            int temp = arr[swap1];
            arr[swap1] = arr[swap2];
            arr[swap2] = temp;
        }
        //print final array
        System.out.printf("Final: ");
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n\n");

        return arr;
    }

    //this method takes in an array and replaces the current values with random numbers
    public static int[] newValues(int[] arr){
        
        int max = 20, min = 5;

        //replace each value with a new random one
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * (max - min + 1)) + min;
        }
        //display new values
        System.out.printf("New Values: ");
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n");

        return arr;
    }

    //this method sorts the numbers into ascending order, displays before and after
    public static int[] arrSort(int[] arr){

        //display current array
        System.out.printf("Current: ");
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n");

        //sort array
        Arrays.sort(arr);

        //display sorted array
        System.out.printf("Final: ");
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n\n");
        return arr;
    }

    
    public static void main(){

        //declare variables
        scan = new Scanner(System.in);
        int in = 0;
        
        //starting statement
        System.out.println("Welcome to random number generator!");

        //generate array of random nums
        int[] randomArr = generateArray();

        //display menu and handle cases
        while(in != 5){
            in = menu();
            switch(in){
                case 1:
                    game(randomArr);
                    break;
                case 2:
                    randomArr = swap(randomArr);
                    break;
                case 3:
                    randomArr = newValues(randomArr);
                    break;
                case 4:
                    randomArr = arrSort(randomArr);               
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
            }
        }
    }
}
