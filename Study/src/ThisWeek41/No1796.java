package ThisWeek41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1796 {
	// https://devbelly.tistory.com/31
	
	static String S;
	static int s;
	static int[][] cache;
	static int[] lo, hi;
	static boolean[] exist;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		System.out.println(solve(0, 0) + s);
	}

	private static int solve(int alpha, int pos) {
		if(alpha==26) 
			return 0;
		
		int ret = cache[alpha][pos];
		
		if(ret != -1) 
			return ret;
		
		ret = Integer.MAX_VALUE/2;
		int posl = lo[alpha];
		int posr = hi[alpha];
		
		if(exist[alpha]) {
			for(int i=0; i<s; i++) 
				 ret = Math.min(ret, solve(alpha + 1, i) + Math.min(dist(pos, i, posl, posr), dist(pos, i, posr, posl)));
		}
		else
			ret = solve(alpha + 1, pos);
		cache[alpha][pos] = ret;
		return ret;
	}

	private static int dist(int a, int b, int c, int d) {
	    if (c == -1 || d == -1) return 0;
	    
	    int A = Math.abs(a - c);
	    int B = Math.abs(c - d);
	    int C = Math.abs(d - b);
	    return A + B + C;	
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		s = S.length();
		exist = new boolean[26];
		cache = new int[26][1001];
		lo = new int[26];
		hi = new int[26];
		
		for(int i=0; i<26; i++) 
			Arrays.fill(cache[i], -1);
		Arrays.fill(hi, -1);
		Arrays.fill(lo, s);
		
		for(int i=0; i<s; i++) {
			int c = S.charAt(i)-'a';
			exist[c] = true;
			lo[c] = Math.min(lo[c], i);
			hi[c] = Math.max(hi[c], i);
		}
		br.close();
	}
}
