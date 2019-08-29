package algorithm.sort;

import algorithm.Sortable;

public class MergeSort implements Sortable {

	@Override
	public void sort(int[] messyArray) {
//	System.out.println(Arrays.toString(messyArray));
	
		if (messyArray.length == 1) {
			return;
		}

		int roundDownPointOfHalf = messyArray.length / 2;

		int[] frontArray = new int[roundDownPointOfHalf];
		int[] backArray = new int[messyArray.length - roundDownPointOfHalf];

		for (int i = 0; i < roundDownPointOfHalf; i++) {
			frontArray[i] = messyArray[i];
		}
		for (int i = 0; i < messyArray.length - roundDownPointOfHalf; i++) {
			backArray[i] = messyArray[roundDownPointOfHalf + i];
		}

		sort(frontArray);
		sort(backArray);

		int frontArrayCount = 0;
		int backArrayCount = 0;
		for (int i = 0; i < frontArray.length + backArray.length; i++) {
			if (frontArrayCount == frontArray.length) {
				messyArray[i] = backArray[backArrayCount];
				backArrayCount++;
				continue;
			}

			if (backArrayCount == frontArray.length) {
				messyArray[i] = frontArray[frontArrayCount];
				frontArrayCount++;
				continue;
			}

			if (frontArray[frontArrayCount] < backArray[backArrayCount]) {
				messyArray[i] = frontArray[frontArrayCount];
				frontArrayCount++;
			} else {
				messyArray[i] = backArray[backArrayCount];
				backArrayCount++;
			}
		}
//		System.out.println(Arrays.toString(messyArray));
		
	}

	public void sort2(int[] messyArray) {
		if (messyArray.length == 1) {
			return;
		}

		int[] frontArray = splitInHalfOfFront(messyArray);
		int[] backArray = splitInHalfOfBack(messyArray);

		sort2(frontArray);
		sort2(backArray);

		int[] mergedArray = mergeArray(frontArray, backArray);

		rewriteTo(messyArray, mergedArray);
	}

	private void rewriteTo(int[] messyArray, int[] mergedArray) {
		for (int i = 0; i < mergedArray.length; i++) {
			mergedArray[i] = mergedArray[i];
		}
	}

	private int[] mergeArray(int[] frontArray, int[] backArray) {
		int summaryArraySize = frontArray.length + backArray.length;
		int[] mergedArray = new int[summaryArraySize];
		int frontArrayCounter = 0;
		int backArrayCounter = 0;
		for (int i = 0; i < summaryArraySize; i++) {
			if (frontArrayCounter == frontArray.length) {
				mergedArray[i] = backArray[backArrayCounter];
				backArrayCounter++;
				continue;
			}

			if (backArrayCounter == frontArray.length) {
				mergedArray[i] = frontArray[frontArrayCounter];
				frontArrayCounter++;
				continue;
			}

			if (frontArray[frontArrayCounter] < backArray[backArrayCounter]) {
				mergedArray[i] = frontArray[frontArrayCounter];
				frontArrayCounter++;
			} else {
				mergedArray[i] = backArray[backArrayCounter];
				backArrayCounter++;
			}
		}
		return mergedArray;

	}

	private int[] splitInHalfOfFront(int[] messyArray) {
		int roundDownPointOfHalf = messyArray.length / 2;
		int[] frontArray = new int[roundDownPointOfHalf];

		for (int i = 0; i < roundDownPointOfHalf; i++) {
			frontArray[i] = messyArray[i];
		}
		return frontArray;
	}

	private int[] splitInHalfOfBack(int[] messyArray) {
		int roundDownPointOfHalf = messyArray.length / 2;
		int[] backArray = new int[messyArray.length - roundDownPointOfHalf];

		for (int i = 0; i < messyArray.length - roundDownPointOfHalf; i++) {
			backArray[i] = messyArray[roundDownPointOfHalf + i];
		}
		return backArray;
	}

}
