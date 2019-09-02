package algorithm;

import algorithm.factory.FixedArrayProvider;
import algorithm.factory.RandowArrayProvider;

public class ArrayFactory {

	private ArrayFactory() {}

	public static int[] createArray(ArrayType type, int size) {
		switch (type) {
		case FIXED:
			return new FixedArrayProvider().setArray(new int[] {1,2,3,4,5,6,6,8}).create();
		case RANDOM:
			return new RandowArrayProvider(size).create();
		default: return null;
		}
	}
	
}
enum ArrayType {
	FIXED, RANDOM;
}

