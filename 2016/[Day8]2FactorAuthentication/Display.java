class Display {
	
	char[][] display;

	public Display(int width, int height) {
		display = new char[width][height];
		reset();
	}

	/*
	* Turns on all of the pixels in a rectangle at the top-left of the screen.
	*/
	public void fillRect(int width, int height) {
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				display[i][j] = '#';
			}
		}
	}

	/*
	* Shifts all of the pixels in a row to the right a certain amount of times.
	* Pixels that would fall off the right end appear at the left end of the row.
	*/
	public void rotateRow(int row, int shift) {
		char[] r = new char[display.length];
		int width = display.length;
		for (int j=0; j<width; j++) {
			r[j] = display[j][row];
		}
		char[] res = r.clone();
		for (int i=0; i<width; i++) {
			res[(i+shift)%width] = r[i];
		}
		for (int j=0; j<width; j++) {
			display[j][row] = res[j];
		}
	}

	/*
	* Shifts all of the pixels in a column down a certain amount of times.
	* Pixels that would fall off the bottom end appear at the top of the column.
	*/
	public void rotateColumn(int column, int shift) {
		char[] col = display[column];
		char[] res = col.clone();
		int height = col.length;
		for (int i=0; i<height; i++) {
			res[(i+shift)%height] = col[i];
		}
		display[column] = res;
	}

	public int getLitPixels() {
		int lit = 0;
		for (char[] column : display) {
			for (char c : column) {
				if (c != ' ')
					lit++;
			}
		}
		return lit;
	}

	public void reset() {
		for (int i=0; i<display.length; i++) {
			for (int j=0; j<display[i].length; j++) {
				display[i][j] = ' ';
			}
		}
	}

	public void print() {
		for (int i=0; i<display[i].length; i++) {
			for (int j=0; j<display.length; j++) {
				System.out.print(display[j][i]);
			}
			System.out.println();
		}
	}
}