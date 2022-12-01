package backjoon.fastcampus.ch06.GS_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class No2251 {
	
	static int A, B, C;
	static HashSet<String> visit;
	static TreeSet<Integer> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visit = new HashSet<>();
		set = new TreeSet<>();
				 
		dfs(0,0,C);
		
		for(int i : set) {
			System.out.print(i + " ");
		}
		
		br.close();
	}

	private static void dfs(int a, int b, int c) {
		String exp = "" + a + "|" + b + "|" + c;
		
		if(visit.contains(exp))
			return;
		visit.add(exp);
		
		if(a==0)
			set.add(c);
		
		int na = a;
		int nb = b;
		int nc = c;
		
		// A <- B
		na = Math.min(a+b, A);
		nb = Math.min((a+b)-na, B);
		nc = c;
		dfs(na, nb, nc);
		
		// B <- A
		nb = Math.min(a+b, B);
		na = Math.min((a+b)-nb, A);
		nc = c;
		dfs(na, nb, nc);
		
		// A <- C
		na = Math.min(a+c, A);
		nc = Math.min((a+c)-na, C);
		nb = b;
		dfs(na, nb, nc);
		
		// C <- A
		nc = Math.min(a+c, C);
		na = Math.min((a+c)-nc, A);
		nb = b;
		dfs(na, nb, nc);
		
		// B <- C
		nb = Math.min(b+c, B);
		nc = Math.min((b+c)-nb, C);
		na = a;
		dfs(na, nb, nc);
		
		// C <- B
		nc = Math.min(b+c, C);
		nb = Math.min((b+c)-nc, B);
		na = a;
		dfs(na, nb, nc);
	}
}