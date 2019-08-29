package algorithm.sort;

import algorithm.Sortable;

public class BubbleSort implements Sortable {

	@Override
	public void sort(int[] messyArray) {
		for (int i = 0; i < messyArray.length; i++) {

			for (int j = 0; j < messyArray.length - 1 - i; j++) {
				int front = messyArray[messyArray.length -2 - j];
				int back = messyArray[messyArray.length -1 - j];

				if (front > back) {
					messyArray[messyArray.length -2 - j] = back;
					messyArray[messyArray.length -1 - j] = front;
				}
			}
		}
	}

}
