import java.io.*;
import java.util.*;

public class main {
	public static void main(String[] args) {
	}

	/* Creates a print statement simmilar to pythons*/
	private static void print(Object statement) {
		System.out.println(statement);
	}

	/* Creates an input grabber simmilar to pythons raw_input and input*/
	private static String input(Object label) {
		System.out.printf(String.format("%s: ",label));
		Scanner raw_input = new Scanner(System.in);
		return raw_input.nextLine();
	}

	
	/* Finds if a word is in a string*/
	private static boolean findKey(String statement, String key) { // the key can be a word or multiple words
		String[] words = statement.split(" ");
		String[] keys = key.split(" ");

		for(int i = 0; i < words.length; i++) {
			int count = 0;
			for(int j = 0; j < keys.length; j++) {
				try {
				
					if(words[i+j].toLowerCase().equals(keys[j].toLowerCase())) {
						count ++;
					}
				} catch(ArrayIndexOutOfBoundsException e) {return false;}
			}
			if(count == keys.length) {
				return true;	
			}
		}
		return false;

	}	

}
