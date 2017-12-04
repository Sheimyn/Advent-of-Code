class Keypad {
	
	private int[][] keypad;

	public Keypad() {
		initPad();
	}

	private void initPad() {
		this.keypad = new int[3][3];
		keypad[0][0] = 1;
		keypad[0][1] = 4;
		keypad[0][2] = 7;
		keypad[1][0] = 2;
		keypad[1][1] = 5;
		keypad[1][2] = 8;
		keypad[2][0] = 3;
		keypad[2][1] = 6;
		keypad[2][2] = 9;
	}

	public int getKeyAtPos(int c, int r) {
		return keypad[c][r];
	}
}