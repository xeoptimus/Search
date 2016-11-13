
public class InterpolationSearch {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 11, 20, 33, 50, 88, 92 };
		System.out.println(insearch(arr, 50));
	}

	public static int insearch(int[] arr, int aim) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (int) (low + (high - low) * (aim - arr[low]) / (arr[high] - arr[low]));
			if (arr[mid] == aim) {
				return mid;
			} else if (arr[mid] < aim) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
