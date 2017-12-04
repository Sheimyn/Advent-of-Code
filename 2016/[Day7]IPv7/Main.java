import java.util.Scanner;
import java.io.File;
import java.lang.Exception;

class Main {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();

		int validIPs = 0;
		while (scan.hasNextLine()) {
			String ip = scan.nextLine();
			String[] splitIP = ip.replaceAll("\\[", "]").split("]");
			boolean valid = false;
			for (int i=0; i<splitIP.length; i++) {
				if (isAbba(splitIP[i])) {
					if (i%2 == 0)
						valid = true;
					else {
						valid = false;
						break;
					}
				}
			}
			if (valid)
				validIPs++;
		}
		System.out.println("Valid IPs: " + validIPs);
	}


	private static boolean isAbba(String s) {
		if (s.length() < 4)
			return false;
		char c1 = s.charAt(0);
		char c2 = s.charAt(1);
		for (int i=2; i<s.length(); i++) {
			if (c1 != c2 && i+1 < s.length() && s.charAt(i) == c2 && s.charAt(i+1) == c1)
				return true;
			else {
				c1 = c2;
				c2 = s.charAt(i);
			}
		}
		return false;
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}