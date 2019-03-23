import java.io.*;
import java.util.*;

public class main {

	private static String codename = "April";
    private static String version = "1.0";



	/* Main Program*/
	public static void main(String[] args) {
		FileManager FileManager = new FileManager();
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




}
