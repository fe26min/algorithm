package ThisWeek46;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1208 {
	static int N, S;
	static long cnt;
	static int[] mat;
	static HashMap<Integer, Integer> hm;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		cnt = 0;
		hm = new HashMap<>();
		makeSumLeft(0, 0);
		makeSumRight(N/2, 0);
		if(S == 0) {
			cnt--;
		}
		System.out.println(cnt);
	}
	private static void makeSumRight(int idx, int sum) {
		if(idx == N) {
			cnt += hm.getOrDefault(S - sum, 0);
			return;
		}
		makeSumRight(idx + 1, sum);
		makeSumRight(idx + 1, mat[idx] + sum);
	}
	private static void makeSumLeft(int idx, int sum) {
		if(idx == N/2) {
			hm.put(sum, hm.getOrDefault(sum, 0) + 1);
			return;
		}
		makeSumLeft(idx + 1, sum);
		makeSumLeft(idx + 1, mat[idx] + sum);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		mat = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) 
			mat[i] = Integer.parseInt(st.nextToken());
		
		br.close();		
	}
}
