import java.util.Arrays;

public class PresortMode {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 3, 4, 5, 6, 8, 7, 7, 9, 2, 2, 9, 5, 5, 3, 2, 2 };
		Arrays.sort(arr);
		System.out.println(PM(arr));
	}

	public static int PM(int[] arr) {
		int i = 0;
		int modefrequency = 0;
		int modevalue = 0;
		while (i < arr.length) {
			int runlength = 1;
			int runvalue = arr[i];
			while (((i + runlength) < (arr.length - 1)) && arr[i + runlength] == runvalue) {
				runlength++;
			}
			if (runlength > modefrequency) {
				modefrequency = runlength;
				modevalue = runvalue;
			}
			i = i + runlength;
		}
		return modevalue;
	}
}
