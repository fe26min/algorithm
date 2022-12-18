package backjoon.answer_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No13144 {
	public static void main(String[] args) throws IOException {
		// 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		HashSet<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// 입력 끝
		
		// 현재 나온 숫자가 몇개 나왔는지를 세주는 배열
		int[] count = new int[100001];
		
		// 경우의 수
		// 1부터 100,000까지의 피보나치가 들어갈 수도 있다.
		// 100_001 * 100_000 / 2 = 5000050000
		long sum = 0;

		// 시작 포인터 : s
		// 끝 포인터 : e
		for(int s=0, e=0; e<N; e++) {
			// e번째의 숫자를 올려줍니다.
			count[arr[e]]++;
			
			// 새로온 수가 이미 있는 애라 갯수가 2가 되었다면 앞에를 이동해줘야 합니다.
			if(count[arr[e]]==2) {
				// count[arr[e]]의 카운트가 1일 될 때까지
				while(count[arr[e]] == 2) {
					// 앞어 것들을 하나하나 빼줍니다.
					count[arr[s]]--;
					s++;
				}
			}
			// 수열의 길이를 sum에 더해줍니다.
			sum += (e - s + 1);
		}
		// sum을 표현
		System.out.println(sum);
	}
}