/**
 * 이진 탐색 (BinarySearch)
 *
 * 조건 : 데이터는 오름차순으로 정렬돼있다고 가정
 * 시간 복잡도 T(N) = log₂N + 1
 * 빅-오 표기법 = O(logN)
 */
public class BinarySearch {

	private static int times = 0;
	private static int rTimes = 0;

	private static int binarySearch(int[] arr, int target) {
		int size = arr.length;
		if (size == 0) {
			return -1;
		} else {
			int start = 0;
			int end = size - 1;
			int mid;
			while (start <= end) {
				times++;
				mid = (start + end) / 2;
				System.out.printf("[%d] start : %d, end : %d, mid : %d\n", times, start, end, mid);
				if (arr[mid] == target) {
					System.out.printf(" - arr[%d](%d) == %d\n", mid, arr[mid], target);
					return mid;
				} else if (arr[mid] < target) {
					System.out.printf(" - arr[%d](%d) < %d\n", mid, arr[mid], target);
					start = mid + 1;
				} else {
					System.out.printf(" - arr[%d](%d) > %d\n", mid, arr[mid], target);
					end = mid - 1;
				}
			}
			return -1;
		}
	}
	private static int binarySearchR(int[] arr, int start, int end, int target) {
		int size = arr.length;
		if (size == 0) {
			return -1;
		} else {
			if (start > end) {
				return -1;
			}
			rTimes++;
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				return binarySearchR(arr, mid + 1, end, target);
			} else {
				return binarySearchR(arr, start, mid - 1, target);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 7, 9, 12, 21, 23, 27, 30, 35, 38 };
		int target = 27;
		
		System.out.println("size : " + arr.length); // size
		int foundIndex = binarySearch(arr, target);
		System.out.println("found : " + foundIndex);
		System.out.println("loop times : " + times); // loop operations
		
		int foundRIndex = binarySearchR(arr, 0, arr.length - 1, target);
		System.out.println("foundR : " + foundRIndex);
		System.out.println("recursion times : " + rTimes); // recursion operations
	}

}