package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int ti=0; ti<T; ti++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			sb.append(func(y-x)).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}

	private static Integer func(int num) {
		int a = (int) Math.sqrt(num);
		if(num <= a * a)
			return 2 * a - 1;
		if(num <= a * (a + 1))
			return 2 * a;
		return 2 * a + 1;
	}
}
