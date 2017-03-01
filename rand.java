/**
 * @author Miriam Schnoll
 * This project reads a file and counts how many time each first digit appear 
 * of digits 0 to 9
 */
package random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class rand {
	/**
	 * this method find the first digit of a number
	 * 
	 * @param x
	 * @return
	 */
	public static int firstdigit(int x) {
		// keeps divide by 10 until less than 10
		while (x > 10) {
			x /= 10;
		}
		return x;
	}

	public static void main(String args[]) throws FileNotFoundException {
		// create array to store data
		int myarray[] = new int[14000];
		// array indexes to keep track of digits number
		int array[] = new int[10];
		// intialize array with 0 as the count
		for (int i = 0; i < 10; i++) {
			array[i] = 0;
		}
		int i = 0;
		try {
			// reads in file
			File inputFile = new File("rand.txt");
			Scanner in = new Scanner(inputFile);
			while (in.hasNextLine()) {
				String line = in.nextLine();
				// each line in file to parse to a number
				int num = Integer.parseInt(line);
				try {
					// try statement prevents array from going out of bounds
					// number goes into array
					myarray[i] = num;
					i++;
				} catch (ArrayIndexOutOfBoundsException aioob) {
					System.out.println(aioob);

				}
			}
			//closes scanner
			in.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		}

		for (int t = 0; t < 14000; t++) {
			try {
				// counts each first digit increases value of array of that
				// index
				array[firstdigit(myarray[t])]++;
			} catch (ArrayIndexOutOfBoundsException aioob) {
			}

		}
		//prints out digits and number of times that it occurs
		for (int j = 1; j < 10; j++) {
			System.out.println("The digit " + j + " " + "occurs " + array[j] + " times.");
		}
	}
}
