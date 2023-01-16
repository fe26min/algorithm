import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class No15686 {
	// 조합 문제
	// 치킨 집 목록에서 M개를 고른다.
	// M개의 치킨집과 집들과 거리를 비교한다.
	static int N, M, min;
	static int[][] mat;
	static ArrayList<int[]> homes, chs;
	static boolean [] select;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		select = new boolean[chs.size()];
		min = Integer.MAX_VALUE;
		
		dfs(0, 0);
		System.out.println(min);
	}

	private static void dfs(int depth, int start) {
		if(depth == M) {
			check();
			return;
		}
			
		for(int i=start; i< chs.size(); i++) {
			if(select[i]) continue;
			select[i] = true;
			dfs(depth+1, i+1);
			select[i] = false;
		}
	}

	private static void check() {
		// 도시의 치킨 거리는 모든 집의 치킨 거리
		int cityDis = 0;
		
		for(int i=0; i<homes.size(); i++) {
			int[] ho = homes.get(i);
			
			int homeDis = Integer.MAX_VALUE;
			for(int j=0; j<chs.size(); j++) {
				if(!select[j]) continue;
				int[] ch = chs.get(j);
				homeDis = Math.min(homeDis, dist(ho, ch));
			}
			cityDis += homeDis;
		}
		
		min = Math.min(min, cityDis);
	}

	private static int dist(int[] ho, int[] ch) {
		return Math.abs(ho[0] - ch[0]) + Math.abs(ho[1] - ch[1]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][N];
		homes = new ArrayList<int[]>();
		chs = new ArrayList<int[]>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j]==0) continue;
				if(mat[i][j]==1)
					homes.add(new int[] {i, j});
				else if(mat[i][j]==2)
					chs.add(new int[] {i, j});
			}
		}
		br.close();
	}
}
