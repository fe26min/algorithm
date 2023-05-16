package ThisWeek41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1670 {
	static int N;
	static int[] arr;
	static final int MOD = 987654321;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		System.out.println(func(N));
	}
	private static long func(int num) {
		if(num == 0 || num == 2)
			return 1;
		if(arr[num] != 0)
			return arr[num];
		
		long ret = 0;
		
		for(int i=2; i<=num; i+=2) {
			ret += func(i - 2) * func(num -i);
			ret %= MOD;
		}
		arr[num] = (int) (ret % MOD);
		return ret % MOD;
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		br.close();		
	}
}
