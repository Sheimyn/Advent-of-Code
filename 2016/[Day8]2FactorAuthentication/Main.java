import java.util.Scanner;
import java.io.File;
import java.lang.Exception;
import java.util.regex.*;

class Main {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();

		Display display = new Display(50, 6);

		while (scan.hasNextLine()) {
			String op = scan.nextLine();
			if (op.startsWith("rect")) {
				Pattern r = Pattern.compile("(\\d+)x(\\d+)");
				Matcher m = r.matcher(op);
				m.find();
				display.fillRect(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
			}
			else if (op.startsWith("rotate row")) {
				Pattern r = Pattern.compile("(\\d+) by (\\d+)");
				Matcher m = r.matcher(op);
				m.find();
				display.rotateRow(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
			}
			else if (op.startsWith("rotate column")) {
				Pattern r = Pattern.compile("(\\d+) by (\\d+)");
				Matcher m = r.matcher(op);
				m.find();
				display.rotateColumn(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
			}
		}
		display.print();
		System.out.println();
		System.out.println("Lit pixels: " + display.getLitPixels());
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}