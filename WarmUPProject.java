
/**
 * @author Miriam Schnoll
 * this project reads a file, encyrpts, and decrypts messages
 * I am not sure if what I did is considered the extra credit
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WarmUPProject {
	/**
	 * this method encrypt character by spilt up a message
	 * 
	 * @param letterstoencrypt
	 *            number to spilt up letters in encryption
	 * @param message
	 *            is the line from file being passed in
	 * @return message1 it returns the encrypted message as string
	 */

	public static String Encrypt(int letterstoencrypt, String message) {
		int length = message.length(); // actual length of message
		/*
		 * actual length of message because first two characters to encrypt and
		 * number to encrypt last character * is not included in array.
		 * 
		 */
		String message1 = "";

		int col = letterstoencrypt; // get col for array
		// from the number in file to encrypt
		// get row number by dividing length of message by number to encrypt
		int row = length / letterstoencrypt;
		// if length doesn't divide evenly by number to encrypt add another row
		if (length % letterstoencrypt != 0)
			row++;
		// create a char array to hold message
		char[][] myArray = new char[row][col];
		// letterat keeps track of index in message
		int letterat = 0;
		// fill character to array by columns
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < row; i++) {

				try {
					// might go out of bounds for the string index
					if (letterat >= length)
						myArray[i][j] = 'Z';// puts z at end of message
					else
						myArray[i][j] = message.charAt(letterat); // put
																	// characters
																	// in
																	// array
					letterat++;

				} catch (ArrayIndexOutOfBoundsException aioobe) {
					System.out.println(aioobe);
				} catch (StringIndexOutOfBoundsException siofbe) {
					// message index goes out of bounds
					System.out.println(siofbe);

				}

			}
		}
		// this puts the encrypted message in the string message1
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				message1 += myArray[i][j];
			}
		}
		return message1;
	}

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		File inputFile = new File("Cryptography Text File.txt");
		// create new file one for decrypt and encrypt
		File output = new File("decrypt.txt");
		File output1 = new File("encrypt.txt");
		try { //file not found error
			// write to file
			FileWriter writer = new FileWriter(output);
			FileWriter fWriter = new FileWriter(output1);
			PrintWriter pWriter = new PrintWriter(fWriter);
			PrintWriter writerprint = new PrintWriter(writer);
			String crypto = "";
			try {
				// create new scanner to read text file
				Scanner in = new Scanner(inputFile);
				while (in.hasNextLine()) {
					// line gets each line in file
					String line = in.nextLine();
					// gets first value to passed for first encrypt or decrypt
					// stores numbers for encrypt and decrypt in array
					int cryptography[] = new int[10];
					int i = 1;
					int index = 0;
					try {
						//string index could go out of bounds
						while ((Character.isDigit(line.charAt(i)))) {
							// stores number in array
							cryptography[index] = Character.getNumericValue(line.charAt(i));
							index++;
							i++;
						}
					} catch (StringIndexOutOfBoundsException siofbe) {
						System.out.println(siofbe);
					}
					// decides starting point of message
					int start = index + 1;
					// if line starts with E then begin encrypt
					if (line.charAt(0) == 'E') {
						// line now just has actual message

						line = line.substring(start, line.length() - 1);
						// run though array of numbers
						for (int k = 0; k < index; k++) {
							line = Encrypt(cryptography[k], line);
							// add the message to the file
							pWriter.println(line);
						}
						// code to decrypt encrypted
						/*
						 * for (int k = index - 1; k >= 0; k--) { line =
						 * Decrypt(cryptography[k], line); // add message to the
						 * file writerprint.println(line); }
						 */

					}
					// line starts with D so decrypt first
					else {
						// line has actual message
						line = line.substring(start, line.length() - 1);
						// run through array
						for (int k = 0; k < index; k++) {
							line = Decrypt(cryptography[k], line);
							// write to file
							writerprint.println(line);
						}
						// code to reencrypt decrypted code
						/*
						 * for (int k = index - 1; k >= 0; k--) { line =
						 * Encrypt(cryptography[k], line); // add message to the
						 * file pWriter.println(line); }
						 */
					}
				}

				in.close();
				writerprint.close();
				pWriter.close();
			} catch (IOException ioe) {
				System.out.println("file error" + ioe.getMessage());
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("file not found" + fnfe.getMessage());
		}

	}

	/**
	 * method to decrypt message
	 * 
	 * @param numbertodecrypt
	 *            will be the row in the array to decrypt
	 * @param message
	 *            is the string that is passed in the decrypt
	 * @return message2 returns the decrypted message
	 */
	public static String Decrypt(int numbertodecrypt, String message) {
		int length = message.length();
		int col = length / numbertodecrypt; // determine cols for array
		if (length % numbertodecrypt != 0)
			col++;
		char[][] myArray = new char[numbertodecrypt][col];
		int charat = 0; // run through character of the message
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < numbertodecrypt; i++) {
				try { // mightexceed string index
						// removes Z from end of message
					if (length == charat)
						break;
					myArray[i][j] = message.charAt(charat);
					charat++;

				} catch (StringIndexOutOfBoundsException soobie) {
					System.out.println("String index out of bounds");
				}
			}
		}
		String message2 = "";
		// run through array to put message in string
		for (int i = 0; i < numbertodecrypt; i++) {
			for (int j = 0; j < col; j++) {
				message2 += myArray[i][j];// puts decrypted message in a string
			}

		}
		return message2;
	}
}
