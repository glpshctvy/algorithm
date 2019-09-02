package algorithm;

import algorithm.sort.BubbleSort;
import algorithm.sort.HeapSort;
import algorithm.sort.InsertionSort;
import algorithm.sort.MergeSort;
import algorithm.sort.QuickSort;
import algorithm.sort.SelectionSort;
import algorithm.sort.Sortable;

public class SortFactory {

	private SortFactory() {
	}

	public static Sortable createSort(SortType type) {
		switch (type) {
		case BUBBLE:
			return new BubbleSort();
		case INSERTION:
			return new InsertionSort();
		case SELECTION:
			return new SelectionSort();
		case MERGE:
			return new MergeSort();
		case QUICK:
			return new QuickSort();
		case HEAP:
			return new HeapSort();
		default:
			return null;
		}
	}

	public static Sortable[] createSortOfAll() {
		SortType[] types = SortType.values();
		Sortable[] sortables = new Sortable[types.length];

		for (int i = 0; i < types.length; i++) {
			sortables[i] = createSort(types[i]);
		}
		return sortables;
	}
}

enum SortType {
	MERGE, BUBBLE, HEAP, INSERTION, QUICK, SELECTION;
}
