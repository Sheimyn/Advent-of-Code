import java.util.Scanner;
import java.io.File;
import java.lang.Exception;

class Main {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}

		int numOfValid = 0;
		while (scan.hasNextLine()) {
			int side1 = scan.nextInt();
			int side2 = scan.nextInt();
			int side3 = scan.nextInt();

			if (side1+side2 > side3 && side1+side3 > side2 && side2+side3 > side1) {
				//System.out.println(side1 + " " + side2 + " " + side3);
				numOfValid++;
			}
		}
		scan.close();
		System.out.println(numOfValid);
	}
}