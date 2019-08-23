package algorithm.sort;

import algorithm.Sortable;

public class MergeSort implements Sortable {

	@Override
	public void sort(int[] messyArray) {
//		System.out.println(Arrays.toString(messyArray));

		if (messyArray.length <= 1) {
			return;
		}

		int[] array1 = new int[messyArray.length / 2];
		int[] array2 = new int[messyArray.length - array1.length];

		for (int i = 0; i < messyArray.length / 2; i++) {
			array1[i] = messyArray[i];
			array2[i] = messyArray[messyArray.length / 2 + i];
		}
		if (messyArray.length % 2 == 1) {
			array2[array2.length - 1] = messyArray[messyArray.length - 1];
		}

		sort(array1);
		sort(array2);

		int array1Counter = 0;
		int array2Counter = 0;
		for (int i = 0; i < array1.length + array2.length; i++) {
			if (array1.length == array1Counter) {
				messyArray[i] = array2[array2Counter];
				array2Counter++;
				continue;
			}

			if (array2.length == array2Counter) {
				messyArray[i] = array1[array1Counter];
				array1Counter++;
				continue;
			}

			if (array1[array1Counter] < array2[array2Counter]) {
				messyArray[i] = array1[array1Counter];
				array1Counter++;
			} else {
				messyArray[i] = array2[array2Counter];
				array2Counter++;
			}
		}
	}

}
