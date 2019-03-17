import java.io.*;
import java.util.*;

public class main {

	private static String codename = "April";



	/* Main Program*/
	public static void main(String[] args) {
		print(String.format("<%s>: Hello!", codename));
		while(true) {
		
			String user = input("<YOU>");	
			String response = getResponse(user);
			print(String.format("<%s>: %s",codename, response));
		}	
	}



	/* Creates a print statement simmilar to pythons*/
	private static void print(Object statement) {
		System.out.println(statement);
	}



	/* Creates an input grabber simmilar to pythons raw_input and input*/
	private static String input(Object label) {
		System.out.printf(String.format("%s: ",label));
    Scanner s = new Scanner(System.in);
    return s.nextLine();
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
	


	/* A simple get Response using a few keywords*/
	private static String getResponse(String statement) {
		return ( findKey(statement,"dog") || findKey(statement,"dogs") ) ? "Tell me more about the dog." :
			( findKey(statement,"cat") || findKey(statement,"cats") ) ? "Tell me more about the cat." :
			( findKey(statement,"weather") ) ? "The weather is nice.":
			( findKey(statement,"leandro") ) ? "I like Leandro, he created me.":
			( findKey(statement,"how are you") ) ? "I'm doing well.":
			RandomResponse();
	}



	/* Gets a random string from a list of responses*/
	private static String randomResponse() {
		String[] responses = {
			"idk.",
			"ok.",
			"tell me more.",
			"elaborate.",
			"let's talk about something else",
			"that's cool.",
			"cool.",
			"I'm bored."
		};

		Random rand = new Random();
		int randInt = rand.nextInt(responses.length);

		return responses[randInt];
	}


}
