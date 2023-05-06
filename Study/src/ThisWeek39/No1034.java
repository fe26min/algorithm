package ThisWeek39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1034 {
	static int N, M, K;
	static HashMap<String, Integer> hm;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int max = 0;
		for(String key : hm.keySet()) {
			int zeroCnt = 0;
			
			for(int i = 0; i<M; i++) {
				if(key.charAt(i) =='0')
					zeroCnt++;
			}
			
			if(zeroCnt > K)
				continue;
			if(zeroCnt % 2 != K % 2)
				continue;
			max = Math.max(hm.get(key), max);
		}
		System.out.println(max);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		hm = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String num = br.readLine();
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		K = Integer.parseInt(br.readLine());
		br.close();		
	}
}