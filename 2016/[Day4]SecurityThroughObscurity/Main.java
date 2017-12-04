import java.util.Scanner;
import java.io.File;
import java.lang.Exception;
import java.util.*;

class Main {

	private static File input;
	private static Scanner scan;

	public static void main(String[] args) {
		init();

		int idSum = 0;
		while (scan.hasNextLine()) {
			String[] in = scan.nextLine().split("-");
			StringBuilder sb = new StringBuilder();
			int id = 0;
			String checksum = null;
			for (String s : in) {
				if (!Character.isDigit(s.charAt(0)))
					sb.append(s);
				else {
					String[] idAndChecksum = s.replace("]", "").split("\\[");
					id = Integer.parseInt(idAndChecksum[0]);
					checksum = idAndChecksum[1];
				}
			}
			String name = sb.toString();
			LinkedList<String> mostCommon = letterOccurrence(name);
			
			StringBuilder sb2 = new StringBuilder();
			for (String l : mostCommon) {
				sb2.append(l);
			}
			if (sb2.toString().equals(checksum))
				idSum += id;
		}

		scan.close();
		System.out.println(idSum);
	}

	private static LinkedList<String> letterOccurrence(String s) {
		HashMap<String, Integer> occurrences = new HashMap<String, Integer>();
		for (int i=97; i<=122; i++) {
			String letter = Character.toString((char) i);
			int matches = s.split(letter, -1).length - 1;
			occurrences.put(letter, matches);
		}
		LinkedList<String> mostCommon = new LinkedList<String>();
		for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
			//System.out.println("{" + entry.getKey() + ", " + entry.getValue() + "}");
			if (mostCommon.isEmpty()) {
				mostCommon.add(entry.getKey());
				continue;
			}
			int occ = entry.getValue();
			for (int i=0; i<mostCommon.size(); i++) {
				if (occ > occurrences.get(mostCommon.get(i))) {
					mostCommon.add(i, entry.getKey());
					if (mostCommon.size() > 5)
						mostCommon.removeLast();
					break;
				}
			}
			if (mostCommon.size() < 5 && !mostCommon.contains(entry.getKey()))
				mostCommon.add(entry.getKey());
		}
		return mostCommon;
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}