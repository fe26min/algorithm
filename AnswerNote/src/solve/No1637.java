package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1637 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int arr[][] = new int[N][3];

		// l의 범위를 정하기 위한 A값의 최소를 저장할 곳
		int minA = Integer.MAX_VALUE;
		// r의 범위를 정하기 위한 C값의 최대를 저장할 곳
		int maxC = 0;

		// N줄에 걸쳐 A, C, B를 입력받는다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// A, B, C 저장
			arr[i][0] = A;
			arr[i][1] = B;
			arr[i][2] = C;

			// 최대 최소 기록하기
			minA = Math.min(minA, A);
			maxC = Math.max(maxC, C);

		}
		br.close();

		long l = minA;
		long r = maxC;

		// 이분 탐색 시작
		while (l < r) {
			long mid = (l + r) / 2;

			// A,B,C 목록들을 보면서 mid 보다 작은 숫자들의 갯수가 기록되는 곳
			long count = 0;

			// A,B,C 목록 돌기
			for (int i = 0; i < N; i++) {
				int A = arr[i][0];
				int B = arr[i][1];
				int C = arr[i][2];

				if (mid < A) continue;
				count += (Math.min(C, mid) - A) / B + 1;
			}
//			System.out.println(l + " " + mid + " " + count);
			// count가 짝수이면 갯수가 홀수인 수는 mid에서 r사이에 있다.
			if (count % 2 == 0) {
				l = mid + 1;
			}
			// count가 홀수이면 갯수가 홀수인 수는 l과 mid사이에 있다.
			else if (count % 2 == 1) {
				r = mid;
			}
		}

		// l의 갯수를 찾아줘야 한다.
		// A + i * B == l일 경우를 세준다.
		// 다만 l이 C보다 클 경우, A가 l보다 클 경우는 계산 X
		// (l - A) % B == 0일 경우를 세준다.
		long count = 0;
		// A,B,C 목록 돌기
		for (int i = 0; i < N; i++) {
			int A = arr[i][0];
			int B = arr[i][1];
			int C = arr[i][2];
			
			// 범위를 벗어난다면 
			if (C < l || l < A)
				continue;
			if ((l - A) % B == 0)
				count++;
		}
		// maxN까지 갔을 경우 만약 maxN이 짝수이면 NOTHING이다.
		if (l == maxC && count % 2 == 0) {
			System.out.println("NOTHING");
		} else {
			System.out.println(l + " " + count);
		}
	}
}
