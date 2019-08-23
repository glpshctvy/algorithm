package algorithm;

import java.util.Arrays;

import algorithm.sort.MergeSort;

public class Application {

	public static void main(String[] args) {

		int[] messyArray = {4,7,1,3,8,2,6,2,9};

		Sortable algorithm = new MergeSort();

		System.out.println("ソート前：" + Arrays.toString(messyArray));

		algorithm.sort(messyArray);

		System.out.println("ソート後：" + Arrays.toString(messyArray));
	}
}
