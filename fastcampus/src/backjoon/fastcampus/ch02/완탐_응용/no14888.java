package backjoon.fastcampus.ch02.완탐_응용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14888 {
	
	// 조합 순열
	// 조합 순열에 따라 최댓값, 최솟값 계산하기
	static int min = Integer.MAX_VALUE
			 , max = Integer.MIN_VALUE;
	
	static int N;
	static int nums[];
	// 부호들의 최대 갯수
	static int arr[] = new int[4];
	static int used[] = new int[4];
	
	static int cmd[];
	
	public static void main(String[] args) throws IOException {
		// 입력
		input();
		// 순열 조합
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		cmd = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}

	private static void dfs(int depth) {
		// 부호의 갯수는 N보다 1개가 적다
		if(depth == N-1) {
			// 계산하기
			check();
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(used[i]==arr[i]) continue;
			used[i]= used[i]+1;
			cmd[depth] = i;
			dfs(depth + 1);
			used[i]= used[i]-1;
		}
	}

	private static void check() {
		
		int num = nums[0];
		
		for(int i=1; i<N; i++) {
			switch(cmd[i-1]) {
			case 0:
				num += nums[i];
				break;
			case 1:
				num -= nums[i];
				break;
			case 2:
				num *= nums[i];
				break;
			case 3:
				num /= nums[i];
				break;
			}
		}
		if(num > max) max=num;
		if(num < min) min=num;
	}
}
