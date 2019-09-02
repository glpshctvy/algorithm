package algorithm.sort;

public class HeapSort implements Sortable {
	private static final int LEFT_CHILD = 1;
	private static final int RIGHT_CHILD = 2;

	@Override
	public void sort(int[] messyArray) {

		for (int i = messyArray.length - 1; i > -1; i--) {
			structuringButtomUp(messyArray, i, messyArray.length -1);
		}

		for (int i = messyArray.length - 1; i > -1; i--) {
			int temp = messyArray[i];
			messyArray[i] = messyArray[0];
			messyArray[0] = temp;
			structuringTopDown(messyArray, 0, i - 1);
		}
	}

	private void structuringTopDown(int[] heap, int start, int end) {
		int childrenNode = start * 2;
		// end を超えている == 子要素がない場合
		if (childrenNode >= end) {
			return;
		}
		// 一方の子しかいない場合
		if (childrenNode + RIGHT_CHILD > end) {
			if (heap[start] < heap[childrenNode + LEFT_CHILD]) {
				int temp = heap[childrenNode + LEFT_CHILD];
				heap[childrenNode + LEFT_CHILD] = heap[start];
				heap[start] = temp;
				structuringTopDown(heap, childrenNode + LEFT_CHILD, end);

			}
			return;
		}

		// 双方の子がいる場合
		if (heap[start] >= heap[childrenNode + LEFT_CHILD] && heap[start] >=  heap[childrenNode + RIGHT_CHILD]) {
			return;
		} 

		int targetChild = heap[childrenNode + LEFT_CHILD] < heap[childrenNode + RIGHT_CHILD] ? RIGHT_CHILD : LEFT_CHILD;
		int temp = heap[childrenNode + targetChild];
		heap[childrenNode + targetChild] = heap[start];
		heap[start] = temp;
		structuringTopDown(heap, childrenNode + targetChild, end);
		
	}

	private void structuringButtomUp(int[] heap, int target, int end) {

		// 子 ＞ 親の場合に並べ変える。
		int t = target;
		while (heap[(t)] > heap[(t - 1) / 2]) {
			if (target == 0) {
				return;
			}
			int temp = heap[(t - 1) / 2];
			heap[(t - 1) / 2] = heap[(t)];
			heap[(t)] = temp;
			structuringTopDown(heap, t, end);
			
			// 一つ上の階層にいく。
			t = (t - 1) / 2;

		}
	}
}
