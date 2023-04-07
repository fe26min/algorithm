package ThisWeek35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2564 {
	static int N, M, x;
	static int[] mat;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int sum = 0;
		int len = 2 * (N + M);
		for(int i : mat) {
			int path = Math.abs(x - i);
			int num = Math.min(path, len - path);
			sum += num;
		}
		System.out.println(sum);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int num = Integer.parseInt(br.readLine());
		
		mat = new int[num];
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			idx = func(dir, idx);
			mat[i] = idx;
		}
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());
		int idx = Integer.parseInt(st.nextToken());
		x = func(dir, idx);
		br.close();
	}

	private static int func(int dir, int idx) {
		switch(dir) {
		// 북쪽
		case 1 :
			// 아무것도 하지 않는다.
			return idx;
		// 동쪽
		case 4 :
			// 가로 길이 만큼 더해준다.
			return N + idx;
		// 남쪽
		case 2 :
			// 가로 + 세로 + 가로 역방향
			return N + M + N - idx;
		case 3 :
			// 가로 + 세로 + 가로 + 세로 역방향
			return N + M + N + M - idx;
		}
		return 0;
	}
}
