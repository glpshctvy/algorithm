package algorithm.sort;

public class SelectionSort implements Sortable {

	@Override
	public void sort(int[] messyArray) {

		// 線形探索で最小値を取得
		for (int i = 0; i < messyArray.length; i++) {
			if (i == messyArray.length - 1) {
				break;
			}

			int min = messyArray[i];
			int index = i;
			for (int j = i + 1; j < messyArray.length; j++) {
				if (messyArray[j] < min) {
					min = messyArray[j];
					index = j;
				}
			}

			if (index == i) {
				continue;
			}

			int temp = messyArray[i];
			messyArray[i] = messyArray[index];
			messyArray[index] = temp;
		}
	}
}
