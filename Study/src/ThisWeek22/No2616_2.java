package ThisWeek22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2616_2 {

	// 각 배열마다 소형 수송차가 얼마나 많은 인원들을 찾을 수 있는지 본다.
	static int N, max, size;
	static int[] arr, sum;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		// dfs로 완탐을 해준다.
		dfs(0, 0, 0, 0, true);
		dfs(0, 0, 0, 0, false);
		System.out.println(max);
	}

	// depth = 골라진 소형 기관차의 갯수
	// index = 시작하는 곳
	// total = 합계 
	private static void dfs(int depth, int index, int coachCnt, int total, boolean check) {
		
		// 다음에 선택할게 만약 범위를 나가면
		if(index >= N)
			return;
		
		// 선택을 했다.
		if(check) {
			if(coachCnt >= size) coachCnt = 0;
			if(coachCnt == 0) depth++;
			if(depth >= 4) return;
			coachCnt++;
			total += arr[index];
			max = Math.max(max, total);
		}
		else coachCnt = 0;
		
		dfs(depth, index + 1, coachCnt, total, true);
		dfs(depth, index + 1, coachCnt, total, false);
	}
	
	// 입력
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		sum = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		size = Integer.parseInt(br.readLine());
		
		br.close();
	}
}
