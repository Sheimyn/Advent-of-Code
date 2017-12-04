class Marker {
	private int length;
	private int times;

	public Marker(int length, int times) {
		this.length = length;
		this.times = times;
	}

	public void tick() {
		this.length--;
	}

	public int getLength() {
		return this.length;
	}

	public int getTimes() {
		return this.times;
	}
}