import java.util.Arrays;

public class DistributionSort {
	public static void main(String args[]) {
		int[] arr = { 2, 5, 7, 6, 10, 3, 4, 8, 5 };
		Arrays.sort(arr);
		DS(arr, 2, 10);
	}

	public static void DS(int[] arr, int l, int u) {
		int i = 0;
		int j = 1;
		int[] res = new int[arr.length];
		int[] count = new int[u - l + 1];
		for (i = 0; i <= u - l; i++) {
			count[i] = 0;
		}
		for (i = 0; i < arr.length; i++) {
			count[arr[i] - l]++;
		}
		for (j = 1; j <= u - l; j++) {
			count[j] = count[j] + count[j - 1];
		}
		for (i = arr.length - 1; i >= 0; i--) {
			j = arr[i] - l;
			res[count[j] - 1] = arr[i];
			count[j]--;
		}
		for (i = 0; i < arr.length; i++) {
			System.out.println(res[i] + " ");
		}
	}

}
