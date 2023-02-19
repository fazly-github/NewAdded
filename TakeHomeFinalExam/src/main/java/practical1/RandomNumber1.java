package practical1;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RandomNumber1 {

	public static void main(String[] args) {

		Set<Integer> data = new TreeSet<Integer>();
		
		Random randomNumber = new Random();
		
		while (data.size() != 500)
		
		{ data.add(randomNumber.nextInt(500));
		}
		System.out.println("There are 500 random numbers: "+ data);
		Object[] newDataArr = data.toArray();

		System.out.println("Enter the n to get Nth smallest number (the range is from 1 to 500) : ");
		Scanner ui = new Scanner(System.in);
		int input = ui.nextInt();
		System.out.println("The "+input+"th smallest number is: "+ newDataArr[input - 1]);// print out element at n-1 since array index starts at 0

		ui.close();
	}
}