import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14889 {
	
	// 백트래킹
	static int N, min;
	static int[][] mat;
	static boolean[] select;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	// 백트래킹 실시
	// 절반을 고른다.
	private static void pro() {
		select = new boolean[N];
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			dfs(i, 0);
		}
		System.out.println(min);
	}

	private static void dfs(int start, int depth) {
		if(depth == N/2) {
			check();
			return;
		}
		
		for(int i=start; i<N; i++) {
			select[i] = true;
			dfs(i+1, depth+1);
			select[i] = false;
		}
		
	}
	// 스타트팀과 링크팀의 점수를 계산한다.
	private static void check() {
		int start = 0;
		int link = 0;
		
		for(int i=0; i < N; i++) {
			for(int j=i+1; j<N; j++) {
				if(select[i]!=select[j])continue;
				if(select[i])
					start+= mat[i][j] + mat[j][i];
				else
					link += mat[i][j] + mat[j][i];
			}
		}
		min = Math.min(min, Math.abs(start - link));
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		mat = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
}
