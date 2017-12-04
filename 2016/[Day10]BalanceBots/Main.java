import java.util.Scanner;
import java.io.File;
import java.lang.Exception;
import java.util.*;
import java.util.regex.*;

class Main {

	private static File input;
	private static Scanner scan;
	private static ArrayList<Bot> bots = new ArrayList<Bot>();

	public static void main(String[] args) {
		init();
		bots = new ArrayList<Bot>();

		while (scan.hasNextLine()) {
			String inst = scan.nextLine();
			if (inst.startsWith("value")) {
				Pattern p = Pattern.compile("(\\d+)\\D+(\\d+)");
				Matcher m = p.matcher(inst);
				m.find();
				int val = Integer.parseInt(m.group(1));
				int botNum = Integer.parseInt(m.group(2));
				Bot bot = getBot(botNum);
				bot.takeChip(val);
				if (bot.hasTwoChips() && bot.hasInstruction()) {
					Instruction botInst = bot.getInstruction();
					//perform instruction
				}
			}
			else {
				Pattern p = Pattern.compile("(\\d+).+(output|bot) (\\d+).+(output|bot) (\\d+)");
				Matcher m = p.matcher(inst);
				m.find();
				int giverBot = Integer.parseInt(m.group(1));
				String lowType = m.group(2);
				int lowNum = Integer.parseInt(m.group(3));
				String highType = m.group(4);
				int highNum = Integer.parseInt(m.group(5));
				
				//chipToBot(val, botNum);
			}
		}
	}

	public static Bot getBot(int botNum) {
		for (Bot bot : bots) {
			if (bot.getNum() == botNum) {
				return bot;
			}
		}
		Bot b = new Bot(botNum);
		bots.add(b);
		return b;
	}


	private static void init() {
		try {
			input = new File("./input");
			scan = new Scanner(input);
		}
		catch (Exception e) {System.out.println(e);}
	}
}