package generateRandomNumbers;

import java.util.Scanner;

public class RandomNumber {   
    /** Main method */
    public static void main(String[] args) {
        int input;
        int[] arraylist = new int[500]; // Create array object.
 
        random(arraylist); // Create random numbers.
        arraySort(arraylist); // Sort random numbers.
 
        do{
            System.out.print("Please enter a number between 1 and 500: ");
            Scanner sc = new Scanner(System.in);
            input   = sc.nextInt();   
        }while(input < 1 || input > 500);
        
        String result ="";
            for (int j = 0; j < arraylist.length; j++) {
                result += " " + arraylist[j];
            }
 
        System.out.println("The Random Numbers are" + result);
        
        if(input == 1){
            System.out.println("The " + input + "st smallest number is " + findNthSmallestNumber(input,arraylist) + ".");
        }else if(input == 2){
            System.out.println("The " + input + "nd smallest number is " + findNthSmallestNumber(input,arraylist) + ".");
        }else if(input == 3){
            System.out.println("The " + input + "rd smallest number is " + findNthSmallestNumber(input,arraylist) + ".");
        }else{
            System.out.println("The " + input + "th smallest number is " + findNthSmallestNumber(input,arraylist) + ".");
        }   
    } 
    public static void random(int[] arraylist){
        for(int i=0; i < arraylist.length; i++){
            arraylist[i]    = (int) (Math.random() * 1000);  
            
        }
    } 
    public static void arraySort(int [] arraylist){
        int temp;   
        for (int i=1; i<arraylist.length; i++){
            for(int j=0; j < arraylist.length-i; j++){
                if (arraylist[j] > arraylist [j+1]){
                    temp = arraylist [j];
                    arraylist [j] = arraylist [j+1];
                    arraylist [j+1] = temp;
                }
            }
        }
    }
    public static int findNthSmallestNumber(int n, int[] numbers){
        return numbers[n-1];
    } 
 
} 
