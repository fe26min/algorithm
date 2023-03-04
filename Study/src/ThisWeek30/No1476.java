package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1476 {
	static int E, S, M;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int ans = S;
		
		while(E != ans%15 || M != ans % 19 )
			ans += 28;
		System.out.println(ans + 1);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		E = Integer.parseInt(st.nextToken()) - 1;
		S = Integer.parseInt(st.nextToken()) - 1;
		M = Integer.parseInt(st.nextToken()) - 1;
		
		br.close();
	}
}
