import java.io.File;
import java.lang.Exception;
import java.util.*;

class Main2 {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();
		int checksum = 0;
		while (scan.hasNextLine()) {
			String[] nums = scan.nextLine().split("\\s");
			checksum += getEvenlyDiv(nums);
		}
		System.out.println("Checksum: " + checksum);
	}


	private static int getEvenlyDiv(String[] nums) {
		for (int i=0; i<nums.length; i++) {
			int num = Integer.parseInt(nums[i]);
			for (int j=0; j<nums.length; j++) {
				if (i==j) {
					continue;
				}
				int divisor = Integer.parseInt(nums[j]);
				if (num%divisor == 0) {
					return num/divisor;
				}
			}
		}
		return 0;
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}