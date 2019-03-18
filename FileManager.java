import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class FileManager {

	/* returns how many lines are in a file*/
	public static int fileLength(String filename) {
		BufferedReader reader;
		int count = 0;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while(line != null) {
				count ++;
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		return count;
	}



	/* Opens a file and returns the lines as a list*/
	public static List<String> openFile(String filename) {	
		BufferedReader reader;
		List<String> result = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();

			while(line != null) {
				result.add(line);
				line = reader.readLine();
			}

			reader.close();

		} catch (IOException e) {e.printStackTrace();	}

		return result;
	}



	/* Gets random choice from a list or an array*/	
	public static String randChoice(Object lists) {
		Random rand = new Random();

		if( lists instanceof List<?> ) {
			List<String> listString = (List<String>) lists;
			return listString.get(rand.nextInt(listString.size()));

		} else if(lists instanceof String[]) {
			String[] listString = (String[]) lists;
			return listString[rand.nextInt(listString.length)];

		}

		return null;
	}
}
