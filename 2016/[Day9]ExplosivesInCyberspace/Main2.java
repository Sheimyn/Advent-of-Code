import java.util.Scanner;
import java.io.File;
import java.lang.Exception;

class Main2 {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();

		int decompLength = 0;
		ArrayList<>
		while (scan.hasNext()) {
			char c = scan.findInLine(".").charAt(0);
			if (c != '(') {
				decompLength++;
				continue;
			}
			int length = 0;
			int times = 1;
			while (c == '(') {
				length = Integer.parseInt(scan.findInLine("\\d+"));
				times *= Integer.parseInt(scan.findInLine("\\d+"));
				scan.findInLine(".");
				c = scan.findInLine(".").charAt(0);
			}
			for (int i=0; i<length-1; i++) {
				scan.findInLine(".");
			}
			decompLength += (times*length);
		}
		System.out.println("Decompressed length: " + decompLength);
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}