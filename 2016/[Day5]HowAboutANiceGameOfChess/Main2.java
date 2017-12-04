import java.util.Scanner;
import java.io.File;
import java.lang.Exception;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

class Main2 {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();

		String doorID = scan.nextLine();
		char[] pw = new char[8];
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		}
		catch (Exception e) {System.out.println(e);}

		int count = 0;
		int found = 0;
		boolean[] filled = new boolean[8];
		while (found < 8) {
			md5.update(new String(doorID+count).getBytes());
			byte[] digest = md5.digest();
			String hash = DatatypeConverter.printHexBinary(digest).toLowerCase();
			int index = Character.getNumericValue(hash.charAt(5));
			if (hash.substring(0,5).equals("00000") && index < 8 && !filled[index]) {
				pw[index] = hash.charAt(6);
				filled[index] = true;
				found++;
			}
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