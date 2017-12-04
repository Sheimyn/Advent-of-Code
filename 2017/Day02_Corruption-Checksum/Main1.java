import java.io.File;
import java.lang.Exception;
import java.util.*;

class Main1 {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();
		int checksum = 0;
		while (scan.hasNextLine()) {
			String[] nums = scan.nextLine().split("\\s");
			checksum += getMaxMinDiff(nums);
		}
		System.out.println("Checksum: " + checksum);
	}


	private static int getMaxMinDiff(String[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (String s_num : nums) {
			int num = Integer.parseInt(s_num);
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}
		return max-min;
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}