import java.util.Scanner;
import java.io.File;
import java.lang.Exception;

class Main {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();

		StringBuilder decomp = new StringBuilder();
		while (scan.hasNext()) {
			char c = scan.findInLine(".").charAt(0);
			if (c == '(') {
				int length = Integer.parseInt(scan.findInLine("\\d+"));
				int times = Integer.parseInt(scan.findInLine("\\d+"));
				scan.findInLine(".");
				StringBuilder partToRepeat = new StringBuilder();
				for (int i=0; i<length; i++) {
					partToRepeat.append(scan.findInLine("."));
				}
				for (int i=0; i<times; i++) {
					decomp.append(partToRepeat);
				}
			}
			else {
				decomp.append(c);
			}
		}
		System.out.println("Decompressed length: " + decomp.length());
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}