package algorithm.sort;

import java.util.Arrays;

import algorithm.Sortable;

public class HeapSort implements Sortable {
	private static final int LEFT_CHILD = 1;
	private static final int RIGHT_CHILD = 2;

	@Override
	public void sort(int[] messyArray) {

		for (int i = messyArray.length - 1; i > -1; i--) {
			structuringButtomUp(messyArray, i);
		}

//		System.out.println(Arrays.toString(messyArray));

		for (int i = messyArray.length - 1; i > -1; i--) {
//			System.out.println("前後入れ替え前" + Arrays.toString(messyArray));
			int temp = messyArray[i];
			messyArray[i] = messyArray[0];
			messyArray[0] = temp;
//			System.out.println("前後入れ替え後" + Arrays.toString(messyArray));
			structuringTopDown(messyArray, 0, i - 1);
//			System.out.println("ツリー構築後　　" + Arrays.toString(messyArray));

		}
		System.out.println(Arrays.toString(messyArray));

	}

	private void structuringTopDown(int[] heap, int start, int end) {
		int childrenNode = start * 2;
		if (childrenNode >= end) {
			return;
		}

		if (childrenNode + RIGHT_CHILD > end) {
			if (heap[start] < heap[childrenNode + LEFT_CHILD]) {
				int temp = heap[childrenNode + LEFT_CHILD];
				heap[childrenNode + LEFT_CHILD] = heap[start];
				heap[start] = temp;
//				System.out.println(Arrays.toString(heap));
				structuringTopDown(heap, childrenNode + LEFT_CHILD, end);

			}
			return;
		}
		int targetChild;
		targetChild = heap[childrenNode + LEFT_CHILD] < heap[childrenNode + RIGHT_CHILD] ? RIGHT_CHILD : LEFT_CHILD;

		int temp = heap[childrenNode + targetChild];
		heap[childrenNode + targetChild] = heap[start];
		heap[start] = temp;
//		System.out.println("途中経過　　" + Arrays.toString(heap));
		structuringTopDown(heap, childrenNode + targetChild, end);
	}

	private void structuringButtomUp(int[] heap, int target) {

		// 子 ＞ 親の場合に並べ変える。
		int t = target;
		while (heap[(t)] > heap[(t - 1) / 2]) {
			if (target == 0) {
				return;
			}
			int temp = heap[(t - 1) / 2];
			heap[(t - 1) / 2] = heap[(t)];
			heap[(t)] = temp;

			// 一つ上の階層にいく。
			t = (t - 1) / 2;

		}
	}
}
