package ThisWeek43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class No1495 {
	static int N, S, M;
	static int[] arr;
	static boolean[] volume;
	static TreeSet<Integer> V;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		for(int i=0; i<N; i++)
			check(arr[i]);
		
		if(V.size()==0)
			System.out.println(-1);
		else {
			System.out.println(V.pollLast());
		}
	}
	private static void check(int v) {
		boolean[] nextVolume = new boolean[M + 1];
		TreeSet<Integer> nextSet = new TreeSet<Integer>();
		
		for(int i : V) {
			if(i-v>= 0)
				nextSet.add(i-v);
			if(i+v<= M)
				nextSet.add(i+v);
		}
		V = nextSet;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		volume = new boolean[M+1];
		volume[S] = true;
		V = new TreeSet<>();
		V.add(S);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		br.close();		
	}
}
