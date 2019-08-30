package algorithm.sort;

import algorithm.Sortable;

public class BubbleSort implements Sortable {

	@Override
	public void sort(int[] messyArray) {
		for (int i = 0; i < messyArray.length; i++) {

			for (int j = messyArray.length; j > i + 1; j--) {
				if(messyArray[j - 2]  >  messyArray[j - 1]) {
					int temp = messyArray[j - 2];
					messyArray[j - 2] = messyArray[j - 1];
					messyArray[j - 1] = temp;
				}
			}
		}
	}

}
