import java.io.File;
import java.lang.Exception;
import java.util.*;

class Main2 {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();
		int sum = 0;
		char[] digitSeq = scan.nextLine().toCharArray();
		int length = digitSeq.length;
		int distance = length/2;
		for (int i=0; i<length; i++) {
			int currentDigit = (int) digitSeq[i]-48;
			int nextDigit = (int) digitSeq[(i+distance)%length]-48;
			if (currentDigit == nextDigit) {
				sum += currentDigit;
			}
		}
		System.out.println("Solution to captcha: " + sum);
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}