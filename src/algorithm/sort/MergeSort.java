package algorithm.sort;

import algorithm.Sortable;

public class MergeSort implements Sortable {

	@Override
	public void sort(int[] messyArray) {
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

		int frontCount = 0;
		int backCount = 0;

		while (frontCount < frontArray.length || backCount < backArray.length) {
			int targetIndex = frontCount + backCount;

			if (frontCount == frontArray.length) {
				messyArray[targetIndex] = backArray[backCount];
				backCount++;
				continue;
			}

			if (backCount == backArray.length) {
				messyArray[targetIndex] = frontArray[frontCount];
				frontCount++;
				continue;
			}

			if (frontArray[frontCount] < backArray[backCount]) {
				messyArray[targetIndex] = frontArray[frontCount];
				frontCount++;
			} else {
				messyArray[targetIndex] = backArray[backCount];
				backCount++;
			}
		}

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
