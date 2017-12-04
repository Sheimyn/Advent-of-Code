class Player {
	private char facing;
	private int[] pos;
	private int[][] map;

	public Player() {
		this.facing = 'n';
		this.pos = new int[]{0, 0};
		this.map = new int[1000][1000];
		map[500][500] = 1;
	}


	public int distance() {
		return Math.abs(pos[0]) + Math.abs(pos[1]);
	}

	public void move(String s) {
		char dir = s.toUpperCase().charAt(0);
		int steps = Integer.parseInt(s.substring(1, s.length()));
		if (dir == 'L') 
			turnLeft();
		else 
			turnRight();

		for (int i=0; i<steps; i++) {
			boolean done = step();
			if (done) {
				System.out.println("Easter Bunny HQ is " + distance() + " blocks away.");
				System.exit(0);
			}
		}
	}

	private boolean step() {
		if (facing == 'n')
			pos[1]++;
		else if (facing == 'e')
			pos[0]++;
		else if (facing == 's')
			pos[1]--;
		else
			pos[0]--;

		int x = pos[0];
		int y = pos[1];
		if (map[x+500][y+500] == 1)
			return true;
		else {
			map[x+500][y+500] = 1;
			return false;
		}
	}

	private void turnLeft() {
		if (facing == 'n')
			facing = 'w';
		else if (facing == 'e')
			facing = 'n';
		else if (facing == 's')
			facing = 'e';
		else
			facing = 's';
	}

	private void turnRight() {
		if (facing == 'n')
			facing = 'e';
		else if (facing == 'e')
			facing = 's';
		else if (facing == 's')
			facing = 'w';
		else
			facing = 'n';
	}


	public String getPos() {
		return "{" + pos[0] + ", " + pos[1] + "} facing " + getDirection();
	}

	private String getDirection() {
		if (facing == 'n')
			return "North";
		else if (facing == 'e')
			return "East";
		else if (facing == 's')
			return "South";
		else
			return "West";
	}
}