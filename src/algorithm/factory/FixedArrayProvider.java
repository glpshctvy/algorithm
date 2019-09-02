package algorithm.factory;

public class FixedArrayProvider {

	private int[] array = new int[] { 9, 13, 25, 17, 29, 5, 18, 9, 1, 27 };

	public FixedArrayProvider() {
	}

	public FixedArrayProvider setArray(int[] array) {
		this.array = array;
		return this;
	}
	public int[] create() {
		return this.array;
	}

}
