package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No1976 {
	static int N, M;
	static int[] parent;
	static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int g = parent[list.get(0)];

		for (int i : list) {
			if (g != parent[i]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		return;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <=N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		br.close();
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			if(a  < b) {
				parent[b] = a;
			}
			else {
				parent[a] = b;
			}
		}
	}
	
	private static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
}
