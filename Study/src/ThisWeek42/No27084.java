package ThisWeek42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No27084 {
	static int N;
	static int per;
	static HashMap<Integer, Integer> hm;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		hm = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int j = Integer.parseInt(st.nextToken());
			hm.put(j, hm.getOrDefault(j, 0) + 1);
		}
		br.close();	
		
		long ans = 1;
		
		for(int cnt : hm.values()) {
			ans *= (cnt + 1) % 1000000007;
			ans %= 1000000007;
		}
		System.out.println(ans - 1);	
	}
}
