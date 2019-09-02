package algorithm.factory;

import java.util.Random;

public class RandowArrayProvider {

	private static int DEFAULT_BOUND = 1024;
	private int size;
	private int bound = DEFAULT_BOUND;

	public RandowArrayProvider(int size) {
		this.size = size;
	}

	public RandowArrayProvider setBound(int bound) {
		this.bound = bound;
		return this;
	}

	public int[] create() {
		Random random = new Random();

		int[] messyArray = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			messyArray[i] = random.nextInt(this.bound);
		}

		return messyArray;
	}

}
