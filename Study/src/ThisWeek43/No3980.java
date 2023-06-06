package ThisWeek43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3980 {
	static int max;
	static int [][] mat = new int[11][11];
	static boolean[] used = new boolean[11];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int ci=0; ci<c; ci++) {
			for(int i=0; i<11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<11; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			dfs(0, 0);
			sb.append(max).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
	private static void dfs(int depth, int sum) {
		if(depth == 11) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<11; i++) {
			if(mat[depth][i]==0)
				continue;
			if(used[i])
				continue;
			used[i] = true;
			dfs(depth+1, sum + mat[depth][i]);
			used[i] = false;
		}
		
	}
}
