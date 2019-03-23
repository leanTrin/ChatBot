import java.util.*;
import java.io.*;
public class nlp {
	public static void main(String[] arguments) {
		String text = "My name is Leandro and i love to go running when it is warm outside.";
		String clean = cleanText(text);
		List<String> token = tokenize(clean);
		List<String> stopW = stopwords(token);
		List<String> lemm = lemmatize(stopW);
		for(String words: lemm) {
			System.out.println(words);
		}
	}



	/* Tokenize a string */
	private static List<String> tokenize(String text) {
		String[] split = text.split(" ");
		return Arrays.asList(split);
	}

	/* Remove stop words */
	private static List<String> stopwords(List<String> text) {
		List<String> result = new ArrayList<String>();
		List<String> stopwords = FileManager.openFile("data/stopwords-en.txt");
		for(String word: text) {
			if(!stopwords.contains(word.toLowerCase())) {
				result.add(word);
			}	
		}
		return result;
	}
	
	/* Clean the text of symbols or non letters*/
	private static String cleanText(String text) {
		return text.replaceAll("[^a-zA-Z ]", "").toLowerCase();	
	}


	
	/* group inflected forms of a word to a single item */
	private static List<String> lemmatize(List<String> text) {
		List<String> lema = FileManager.openFile("data/lemmatization-en.txt");	

		for(int i = 0; i < text.size(); i++) {	
			for(String line: lema) {
				String[] items = line.split("\t");
				String root = items[0];
				String branch = items[1];
				if(text.get(i).toLowerCase().equals(branch.toLowerCase())) {
					text.set(i, root.toLowerCase());
				}
			}
		}		
		return text;
	}





}
