import java.util.Scanner;
import java.io.File;
import java.lang.Exception;

class Main2 {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}

		int[] triangle1 = new int[3];
		int[] triangle2 = new int[3];
		int[] triangle3 = new int[3];
		int numOfValid = 0;
		while (scan.hasNextLine()) {
			triangle1[0] = scan.nextInt();
			triangle2[0] = scan.nextInt();
			triangle3[0] = scan.nextInt();
			triangle1[1] = scan.nextInt();
			triangle2[1] = scan.nextInt();
			triangle3[1] = scan.nextInt();
			triangle1[2] = scan.nextInt();
			triangle2[2] = scan.nextInt();
			triangle3[2] = scan.nextInt();

			if (validTriangle(triangle1)) {
				numOfValid++;
			}
			if (validTriangle(triangle2)) {
				numOfValid++;
			}
			if (validTriangle(triangle3)) {
				numOfValid++;
			}
		}
		scan.close();
		System.out.println(numOfValid);
	}

	private static boolean validTriangle(int[] t) {
		if (t[0]+t[1] > t[2] && t[0]+t[2] > t[1] && t[1]+t[2] > t[0]) {
			return true;
		}
		return false;
	}
}