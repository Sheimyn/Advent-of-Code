import java.util.ArrayList;

class Bot {

	private int num;
	private int chip1;
	private int chip2;
	private ArrayList<Instruction> queue;

	public Bot(int botNum) {
		this.num = botNum;
		this.chip1 = -1;
		this.chip2 = -1;
		this.queue = new ArrayList<Instruction>();
	}


	public void giveChip(int value) {
		if (chip1 == value)
			chip1 = -1;
		else if (chip2 == value)
			chip2 = -1;
		else {
			System.out.println("Error: Bot nr. " + num + " does not have a chip with value " + value + ".");
			System.exit(1);
		}
	}

	public void takeChip(int value) {
		if (chip1 != -1 && chip2 != -1) {
			System.out.println("Error: Bot nr. " + num + " already has 2 chips.");
			System.exit(1);
		}
		if (chip1 == -1)
			chip1 = value;
		else
			chip2 = value;
	}

	public void addInstruction(int lowBot, int highBot) {
		Instruction inst = new Instruction(lowBot, highBot);
		queue.add(inst);
	}

	public Instruction getInstruction() {
		if (this.hasInstruction())
			return queue.remove(0);
		return null;
	}

	public boolean hasInstruction() {
		if (queue.isEmpty())
			return false;
		return true;
	}

	public int getLowestChip() {
		if (chip1 == -1 || chip2 == -1) {
			System.out.println("Error: Bot nr. " + num + " does not have 2 chips.");
			System.exit(1);
		}
		if (chip1 == chip2) {
			System.out.println("Error: Both chips are of equal value.");
			System.exit(1);
		}
		int chip = chip2;
		if (chip1 < chip2)
			chip = chip1;
		return chip;
	}

	public int getHighestChip() {
		if (chip1 == -1 || chip2 == -1) {
			System.out.println("Error: Bot nr. " + num + " does not have 2 chips.");
			System.exit(1);
		}
		if (chip1 == chip2) {
			System.out.println("Error: Both chips are of equal value.");
			System.exit(1);
		}
		int chip = chip2;
		if (chip1 > chip2)
			chip = chip1;
		return chip;
	}

	public boolean hasTwoChips() {
		if (chip1 != -1 && chip2 != -1)
			return true;
		return false;
	}

	public int getNum() {
		return num;
	}

}

