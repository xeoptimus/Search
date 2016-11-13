
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 6, 8, 22, 100, 555 };
		System.out.println(binarysearch(arr, 100));
	}

	public static int binarysearch(int[] arr, int aim) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == aim) {
				return mid;
			} else if (arr[mid] > aim) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

}
