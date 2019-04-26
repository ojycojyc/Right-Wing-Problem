import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author Jia-Ying Olivia Chan
 *
 * First solution to the RightWing problem. 
 * For any given array of positive integers, the solution uses multiple recursion to determine if there exist a path leading from the leftmost array position to the last.
 * An additional function to create random arrays of size n has been written to reduce cluttering in main.
 */
public class RightWing1 {
	/**
	 * Main method, where the reading and display of values occurs
	 * Programs reads an integer input from user to determine the number of random test cases they would like to view.
	 * It then generates those arrays using the randAr function and prints the results from the use of rightWing (a boolean).
	 * @param args
	 */
	public static void main(String[] args)  {
		try {
			File file = new File("rightWing1.txt"); //Define a storage file for every test case
			file.createNewFile();//Create said file if it doesn't already exist
			PrintWriter writer = new PrintWriter(file); //Write in file using PrintWrite (whose Println method is simpler than filewriter's, formatting wise)	
		
			Scanner read = new Scanner(System.in); //to read user input
			/**System.out.print("Input random array size greater than 0: "); //problem would not be interesting for empty arrays 
			int input = read.nextInt();
			**/
			
			System.out.print("How many test cases? : "); //Display a series of random cases
			int cases = read.nextInt();

			for (int input=3; input<26; input++){
				writer.println("Array size = " + input + " : ");
			for (int i = 0; i < cases; i++) { //for the number of cases desired, create a random integer array and determine if it is solvable
				long st = System.nanoTime();
				System.out.println("\nCase " + (i+1));
				writer.println("\nCase " + (i+1));
			
				int[] array = randAr(new int[input], writer);
				System.out.println("\n" + rightWing(array, array[0]) //if array is empty, then array[0] would throw an ArrayIndexOutOfBoundsException 
					+ " \n \n-------------------------------------------------------------------");
				long sp = System.nanoTime();
				writer.println();
				writer.println("\n" + rightWing(array, array[0]) + "\n");
				writer.println("Time of calculation: " + (sp-st) + " ns" );
				writer.println();

			}
				writer.println("*******************************************************************************************");
			}
		
			read.close();
			writer.close();
		} catch (IOException e) {
			System.out.println("File writing/creation error");
		} 
	}

	/**
	 * Method takes in an array and fills it with random values less or equal to the array length
	 * @param a (an array)
	 * @return an array filled with random values proportional to its size
	 */
	public static int[] randAr(int[] a, PrintWriter writer) {
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * (a.length+1)) ; //integer value 0 is possible
			System.out.print("" + a[i] + " | ");
			writer.print("" + a[i] + " | ");
		}
		return a;
	}

	/**
	 * RightWing method
	 * Uses try-catch to return false should the marker be a value outside of the array
	 * Uses multiple recursion to determine if the "marker" ever lands on the rightmost position
	 * Time complexity is O(n^2) and space complexity is constant
	 * Sadly not foolproof and will throw a StackOverFlowException for specific cases where the marker loops through 3 or more values (and not 2 immediate ones)
	 * @param a ( an array of positive integers)
	 * @param marker (an integer)
	 * @return a boolean value
	 */
	public static boolean rightWing(int[] a, int marker) {
		try {
			if (marker == (a.length - 1)) {
				// System.out.println("Reaching the end");
				return true;
			}

			int right = marker + a[marker];
			if (marker > (a.length - 1) || marker < 0 || marker == (right - a[right])) { // need only consider one direction, since the marker will travel in both
				// System.out.println("False of error 1");
				return false;
			}
			return rightWing(a, marker - a[marker]) || rightWing(a, marker + a[marker]); //if travelling to either of these were impossible, then the exception will be catched
			
		} catch (ArrayIndexOutOfBoundsException| StackOverflowError e) {
			// TODO: handle exception
			// System.out.println("False of error 2");
			return false;
		}
		

	}

}
