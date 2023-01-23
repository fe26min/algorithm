import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 사다리 조작
public class No15684 {
	
	static int N, M, H, min;
	static int mat[][];
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		min = 4;
		dfs(0, 1);
		if(min==4) {
			min = -1;
		}
		System.out.println(min);
	}

	private static void dfs(int depth, int sx) {
		// 이미 최솟값을 찾았기 때문에
		if(min <= depth)
			return;
		// i번 세로선의 결과가 i번이 나오는지 체크하기
		if(check()){
			min = depth;
			return;
		}
		
		for(int i=sx; i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(mat[i][j]!=0)
					continue;
				if(mat[i][j+1]!=0)
					continue;
				
				mat[i][j] = 1;
				mat[i][j+1] = 2;
				dfs(depth + 1, i);
				mat[i][j] = 0;
				mat[i][j+1] = 0;
			}
		}
	}

	private static boolean check() {
		for(int i=1; i<=N; i++) {
			int idx = i;
			for(int j=1; j<=H; j++) {
				if(mat[j][idx]==1)
					idx++;
				else if(mat[j][idx]==2)
					idx--;
			}
			if(idx != i)
				return false;
		}
		return true;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		mat = new int[H+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			mat[a][b] = 1;
			mat[a][b+1] = 2;
		}
		br.close();
	}
}