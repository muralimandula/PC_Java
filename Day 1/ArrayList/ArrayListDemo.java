import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo{

	public static void main(String[] args) {

		int[] a = new int[10];

		System.out.println(Arrays.toString(a));


		// -- arrayList

		ArrayList<Integer> a2 = new ArrayList<>();
		System.out.println(a2);

		a2.add(1);
		a2.add(2);

		a2.add(1);
		a2.add(2);

		a2.add(1);
		a2.add(2);
		System.out.println(a2);

		ArrayList<Integer> a3 = new ArrayList<>();
		a3.addAll(a2);
		System.out.println(a3);
	}
}