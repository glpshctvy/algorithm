package algorithm;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import algorithm.sort.Sortable;

public class Application {

	public static void main(String[] args) throws IOException {

		int[] messyArray = ArrayFactory.createArray(ArrayType.RANDOM, 10);

		System.out.println("ソート前の配列：" + Arrays.toString(messyArray));
//		File file = new File("ソート実施結果.txt");
//		FileWriter writer = new FileWriter(file);
////		writer.write("ソート前の配列：" + Arrays.toString(messyArray) +"\r\n");

		List<Sortable> algorithms = Arrays.asList(SortFactory.createSortOfAll());

		for (Sortable algorithm : algorithms) {
			int[] array = messyArray.clone();
			
			long start = System.currentTimeMillis();
			algorithm.sort(array);
			long end = System.currentTimeMillis();

			System.out.println(algorithm.getClass().getSimpleName() + " ,処理結果：" + Duration.ofMillis(end - start) + ",\t\t\t ソート結果：" + Arrays.toString(array));
//			writer.write(algorithm.getClass().getSimpleName() + " ,処理結果：" + Duration.ofMillis(end - start) + ",\t\t ソート結果：" + Arrays.toString(array) +"\r\n");
//			writer.write(algorithm.getClass().getSimpleName() + " ,処理結果：" + Duration.ofMillis(end - start) + "\r\n");
		}
//		writer.close();
	}
}
