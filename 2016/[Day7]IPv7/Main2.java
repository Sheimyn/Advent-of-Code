import java.util.Scanner;
import java.io.File;
import java.lang.Exception;
import java.util.ArrayList;

class Main2 {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();

		int validIPs = 0;
		while (scan.hasNextLine()) {
			String ip = scan.nextLine();
			String[] splitIP = ip.replaceAll("\\[", "]").split("]");
			ArrayList<String> abaOutside = new ArrayList<String>();
			ArrayList<String> abaInside = new ArrayList<String>();
			for (int i=0; i<splitIP.length; i++) {
				if (i%2 == 0)
					findAbas(splitIP[i], abaOutside);
				else
					findAbas(splitIP[i], abaInside);
			}
			for (String aba : abaOutside) {
				String bab = new String("" + aba.charAt(1) + aba.charAt(0) + aba.charAt(1));
				if (abaInside.contains(bab)) {
					validIPs++;
					break;
				}
			}
		}

		System.out.println("IPs supporting SSL: " + validIPs);
	}


	private static void findAbas(String s, ArrayList<String> abas) {
		if (s.length() < 3)
			return;
		char c1 = s.charAt(0);
		char c2 = s.charAt(1);
		for (int i=2; i<s.length(); i++) {
			if (c1 != c2 && s.charAt(i) == c1) {
				abas.add(new String("" + c1 + c2 + c1));
			}
			c1 = c2;
			c2 = s.charAt(i);
		}
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}