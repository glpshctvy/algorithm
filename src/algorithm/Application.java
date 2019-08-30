package algorithm;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import algorithm.sort.BubbleSort;
import algorithm.sort.HeapSort;
import algorithm.sort.InsertionSort;
import algorithm.sort.MergeSort;
import algorithm.sort.QuickSort;
import algorithm.sort.SelectionSort;

public class Application {

	public static void main(String[] args) {
		int arraySize = 9;
		Random random = new Random();

		int[] messyArray = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			messyArray[i] = random.nextInt(20);
		}
		System.out.println(Arrays.toString(messyArray));
		List<Sortable> algorithms = Arrays.asList(new BubbleSort()
																			, new SelectionSort()
																			, new InsertionSort()
																			, new MergeSort()
																			, new QuickSort()
																			, new HeapSort()
																			);

		for (Sortable algorithm : algorithms) {
			int[] array = messyArray.clone();
			
			long start = System.currentTimeMillis();
			algorithm.sort(array);
			long end = System.currentTimeMillis();

			System.out.println(algorithm.getClass().getSimpleName() + " , 処理時間：" + Duration.ofMillis(end - start));
		}
	}
}
