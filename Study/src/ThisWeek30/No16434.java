package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16434 {
	
	static int N;
	static long Hatk;
	static int[][] mat;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		long left = 0;
		long right = N * 1_000_000L * 1_000_000L + 1;
		long ans = 0;
		while(left <= right) {
			long mid = (left + right) / 2;
			if(game(mid)) {
				ans = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}
	
	private static boolean game(long maxHp) {
		long curHp = maxHp;
		long curAtk = Hatk;
		for(int i=0; i<N; i++) {
			switch(mat[i][0]) {
			case 1 :
				long a = mat[i][1];
				long h = mat[i][2];
				long cnt = h/curAtk;
				if(h % curAtk == 0) cnt--;
				
				curHp -= cnt * a; 
				if(curHp <= 0)
					return false;
				break;
			case 2 : 
				curAtk += mat[i][1];
				curHp = curHp + mat[i][2] > maxHp 
						? maxHp : curHp + mat[i][2];
				break;
			}
		}
		return true;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Hatk = Long.parseLong(st.nextToken());
		
		mat = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
}
