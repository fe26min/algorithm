package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1079 {
	static int N, enjin, max;
	static int[] guilty;
	static int[][] R;
	static boolean[] isDead;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		max = 0;
		isDead = new boolean[N];
		dfs(0, N);
		System.out.println(max);
	}

	private static void dfs(int depth, int num) {
		if(isDead[enjin] || num == 1) {
			max= Math.max(max, depth);
			return;
		}
		
		// 밤
		if(num %2 == 0) {
			for(int i=0; i<N; i++) {
				if(isDead[i] || i == enjin)
					continue;
				isDead[i] = true;
				for(int j=0; j<N; j++) {
					guilty[j] += R[i][j];
				}
				dfs(depth + 1, num-1);
				isDead[i] = false;
				for(int j=0; j<N; j++) {
					guilty[j] -= R[i][j];
				}
			}
		}
		// 낮
		else {
			int susIdx = -1;
			int susScore = -1;
			for(int i=0; i<N; i++) {
				if(!isDead[i] && guilty[i] > susScore) {
					susIdx = i;
					susScore = guilty[i];
				}
			}
			isDead[susIdx] = true;
			dfs(depth, num-1);
			isDead[susIdx] = false;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		guilty = new int[N];
		R = new int[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			guilty[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		enjin = Integer.parseInt(br.readLine());
		br.close();
	}
}