import java.util.Arrays;

public class PresortElementUniqueness {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 7, 6, 10, 3, 4, 8, 5 };
		Arrays.sort(arr);
		PEU(arr);
	}

	public static void PEU(int[] arr) {
		int i = 0;
		for (i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.println("有重复,不唯一");
				return;
			}
		}
		System.out.println("无重复，唯一");
	}

}
