package algorithm.sort;

public class QuickSort implements Sortable {

	@Override
	public void sort(int[] messyArray) {
		int start = 0;
		int end = messyArray.length - 1;

		sort(messyArray, start, end);
	}

	private void sort(int[] messyArray, int start, int end) {
		if (end - start == 0) {
			return;
		}

		int leftCounter = start;
		int rightCounter = end - 1;
		int pivot = messyArray[end];
		while (leftCounter != rightCounter) {
			if (messyArray[leftCounter] <= pivot) {
				leftCounter++;
				continue;
			}
			if (messyArray[rightCounter] > pivot) {
				rightCounter--;
				continue;
			}
			swap(messyArray, leftCounter, rightCounter);
		}

		// カウンタがまじりあった箇所とpivotを入れ替える
		if (messyArray[leftCounter] > pivot) {
			swap(messyArray, leftCounter, end);
		}
		sort(messyArray, start, leftCounter);
		sort(messyArray, leftCounter + 1, end);
	}

	private void swap(int[] messyArray, int target1, int target2) {
		int temp = messyArray[target1];
		messyArray[target1] = messyArray[target2];
		messyArray[target2] = temp;
	}

}
