import java.util.*;
import java.io.*;
public class nlp {
	public static void main(String[] arguments) {
		String text = "this is the text that im going to use in the list";
		List<String> stext = tokenize(text);
		for(String test: stopwords(stext)) {
		}
	}



	/* Tokenize a string */
	private static List<String> tokenize(String text) {
		String[] split = text.split(" ");
		return Arrays.asList(split);
	}

	/* Remove stop words */
	private static List<String> stopwords(List<String> text) {
		/*
		 * TODO: this needs to be done
		 *
		 * remove words that are common in the text like (the, is, etc)
		 *
		 *
		 *
		 *
		 *
		 * */
	}


	
	/* group inflected forms of a word to a single item */
	private static String lemmatize(String word) {
		List<String> lema = FileManager.openFile("data/lemmatization-en.txt");	

		for(String line: lema) {
			String[] items = line.split("\t");

			String root = items[0];
			String branch = items[1];


			// if word is a branch return root, if word is root return root
			if(branch.toLowerCase().equals(word.toLowerCase())) {
				return root;	
			}	
			else if(root.toLowerCase().equals(word.toLowerCase())) {
				return root;	
			}
		}
		
		return null;
	}





}
