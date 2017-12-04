import java.io.File;
import java.lang.Exception;
import java.util.*;

class Main1 {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();

		
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}