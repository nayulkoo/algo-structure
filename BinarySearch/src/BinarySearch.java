/**
 * 이진 탐색 (BinarySearch)
 *
 * 조건 : 데이터는 오름차순으로 정렬돼있다고 가정
 * 시간 복잡도 T(N) = log₂N + 1
 * 빅-오 표기법 = O(logN)
 */
public class BinarySearch {

	private static int times = 0;

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

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 7, 9, 12, 21, 23, 27, 30, 35, 38 };
		int foundIndex = binarySearch(arr, 38);
		System.out.println("size : " + arr.length); // size
		System.out.println("found : " + foundIndex);
		System.out.println("times : " + times); // operations
	}

}