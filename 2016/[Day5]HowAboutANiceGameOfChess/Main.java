import java.util.Scanner;
import java.io.File;
import java.lang.Exception;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

class Main {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();

		String doorID = scan.nextLine();
		StringBuilder pw = new StringBuilder();
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		}
		catch (Exception e) {System.out.println(e);}

		int count = 0;
		while (pw.length() < 8) {
			md5.update(new String(doorID+count).getBytes());
			byte[] digest = md5.digest();
			String hash = DatatypeConverter.printHexBinary(digest).toLowerCase();
			if (hash.substring(0,5).equals("00000"))
				pw.append(hash.charAt(5));
			count++;
		}
		
		scan.close();
		System.out.println(pw);
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}