package algorithm.sort;

public class InsertionSort implements Sortable {

	@Override
	public void sort(int[] messyArray) {
		// messyArrayの0番目は操作済みとする。
		for (int i = 1; i < messyArray.length; i++) {

			// 操作済み要素でループを回す。
			for (int j = i; j > 0; j--) {
				if (messyArray[j - 1] <= messyArray[j]) {
					break;
				}
				int temp = messyArray[j - 1];
				messyArray[j - 1] = messyArray[j];
				messyArray[j] = temp;
			}
		}
	}
}
