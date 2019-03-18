import java.util.List;
import java.util.ArrayList;
public class test {

	public static void main(String[] arguments) {
		FileManager FileManager = new FileManager();	
		List<String> test = FileManager.openFile("random.txt");
		String randString = FileManager.randChoice(testString);
		System.out.println(randString);

	}

}
