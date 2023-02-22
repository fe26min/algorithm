package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No14658 {
	static int N, M, L, K;
	static ArrayList<Star> stars;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int answer = N * M;
		
		for(Star s1  : stars) {
			int res = 0;
			for(Star s2 : stars) {
				res = check(s1.x, s2.y);
				answer = Math.min(answer, res);
			}
		}
		
		System.out.println(answer);
	}
	
	private static int check(int i, int j) {
		int cnt = 0;
		for(Star s : stars) {
			if(s.x < i || i+L < s.x || s.y < j || j+L < s.y) {
				cnt++;
			}
		}
		return cnt;
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		stars = new ArrayList<>();
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			stars.add(new Star(x, y));
		}
		
		br.close();
	}
}

class Star {
	int x, y;
	
	public Star(int x, int y) {
		this.x = x;
		this.y = y;
	}
}