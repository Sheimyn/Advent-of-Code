import java.util.Scanner;
import java.io.File;
import java.lang.Exception;

class Main2 {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();

		String[] in = null;
		boolean first = true;
		while (scan.hasNextLine()) {
			String s = scan.nextLine();
			if (first) {
				first = false;
				in = new String[s.length()];
			}
			for (int i=0; i<in.length; i++) {
				if (in[i] != null)
					in[i] = new String(in[i]+s.charAt(i));
				else
					in[i] = new String(""+s.charAt(i));
			}
		}

		char[] msg = new char[in.length];

		for (int i=0; i<in.length; i++) {
			msg[i] = leastCommonLetter(in[i]);
		}
		
		System.out.println(msg);
	}


	private static char leastCommonLetter(String s) {
		int min = Integer.MAX_VALUE;
		String best = "";
		for (int i=97; i<=122; i++) {
			String letter = Character.toString((char) i);
			int matches = s.split(letter, -1).length - 1;
			if (matches < min) {
				best = letter;
				min = matches;
			}
			//System.out.println(letter + ": " + matches);
		}
		return best.charAt(0);
	}

	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}