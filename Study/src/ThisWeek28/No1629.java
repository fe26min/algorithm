package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1629 {
	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(power(A, B));
		br.close();
	}

	private static long power(long x, long p) {
		if(p == 0) return 1;
		long res = power(x, p/2) % C;
		res = (res * res) % C;
		if((p&1) == 1) res = (res * x) % C;
		return res;
	}
}
