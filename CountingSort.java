import java.util.Arrays;

public class CountingSort {
	public static void main(String args[]) {
		int[] arr = { 2, 5, 7, 6, 10, 3, 4, 8, 5 };
		Arrays.sort(arr);
		CS(arr);
	}

	public static void CS(int[] arr) {
		int i;
		int j;
		int[] count = new int[arr.length];
		int[] s = new int[arr.length];
		for (i = 0; i < arr.length; i++) {
			count[i] = 0;
		}
		for (i = 0; i < arr.length - 1; i++) {
			for (j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					count[j]++;
				} else {
					count[i]++;
				}
			}
		}
		for (i = 0; i < arr.length; i++) {
			s[count[i]] = arr[i];
		}
		for (i = 0; i < arr.length; i++) {
			System.out.println(s[i] + " ");
		}
	}

}
