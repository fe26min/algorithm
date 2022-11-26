package backjoon.fastcampus.ch03.Sort_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No11652 {
	
	static long max;
	static int maxC;
	static HashMap<Long, Integer> hm;
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(max);
	}

	private static void input() throws IOException {
		hm = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			
			hm.put(num, hm.getOrDefault(num, 0) + 1);
			if((hm.get(num) > maxC) || (hm.get(num) == maxC && num < max)) {
				maxC = hm.get(num);
				max = num;
			}
		}
		br.close();
	}
}