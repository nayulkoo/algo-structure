/**
 * HanoiTower
 * 
 * 조건1 : 기둥은 3개라고 가정 (A,B,C)
 * 조건2 : 기둥에 꽂힌 원반의 크기는 맨 아래가 제일 크고, 맨 위가 제일 작은 순이며 큰 원반은 작은 원반 위에 놓일 수 없음
 * [Rule]
 * 1. A에 꽂힌 모든 원반을 C로 옮겨야 한다. (A->B->C)
 * 2. N개의 원반에서 최하단 N번째 원반을 제외한 1 ~ N-1 번째의 원반을 B로 옮긴다. (A->C->B)
 * 3. A에 남아있던 N번째 원반을 C로 옮긴다. (A->C)
 * 4. B에 있는 모든 원반을 C로 옮긴다. (B->C)
 */
public class HanoiTower {
	
	/**
	 * case 1 (N = 1)
	 * [1] A -> C
	 */
	
	/**
	 * case 2 (N = 2)
	 * [1] A -> B
	 * [2] A -> C
	 * [3] B -> C
	 */
	
	/**
	 * case 3 (N = 3)
	 * [1] A -> C
	 * [2] A -> B
	 * [3] C -> B
	 * [4] A -> C
	 * [5] B -> A
	 * [6] B -> C
	 * [7] A -> C
	 */
	
	/**
	 * 찾은 규칙1 : 원반의 수가 홀수 일때에는 C를 먼저 거쳐가고, 짝수 일때에는 B를 먼저 거쳐간다.
	 * 찾은 규칙2 : N개의 원반은 2 * hanoi(n-1) + 1번 이동하면 된다
	 */
	private static int hanoi(int n, char from, char by, char to) {
		int count = 0;
		if (n == 1) {
			System.out.printf("%c -> %c\n", from, to);
			return 1;
		} else {
			if (n <= 0) {
				return 0;
			}
			// 1 ~ N-1 번째 원반을 B로 옮긴다
			count += hanoi(n-1, from, to, by);
			count++;
			// A에 남아있던 N번째 원반을 C로 옮긴다
			System.out.printf("%c -> %c\n", from, to);
			// B에 있는 모든 원반(C로 옮긴 원반을 제외한)을 C로 옮긴다
			count += hanoi(n-1, by, from, to);
		}
		return count;
	}
	private static int hanoiTimes(int n) {
		if (n == 0) {
			return 0;
		} else {
			return 2 * hanoiTimes(n - 1) + 1;
		}
	}
	
	public static void main(String[] args) {
		int n = 10;
		int hanoiTimes = hanoiTimes(n);
		System.out.println("move count by rule : " + hanoiTimes + " time(s)");
		int count = hanoi(n, 'A', 'B', 'C');
		System.out.println("move count by hanoi : " + count + " time(s)");
	}
	
}
