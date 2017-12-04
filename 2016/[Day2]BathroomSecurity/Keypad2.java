class Keypad2 {
	
	private char[][] keypad;

	public Keypad2() {
		initPad();
	}

	private void initPad() {
		this.keypad = new char[7][7];
		keypad[1][3] = '5';
		keypad[2][2] = '2';
		keypad[2][3] = '6';
		keypad[2][4] = 'A';
		keypad[3][1] = '1';
		keypad[3][2] = '3';
		keypad[3][3] = '7';
		keypad[3][4] = 'B';
		keypad[3][5] = 'D';
		keypad[4][2] = '4';
		keypad[4][3] = '8';
		keypad[4][4] = 'C';
		keypad[5][3] = '9';
	}

	public char getKeyAtPos(int c, int r) {
		return keypad[c][r];
	}
}