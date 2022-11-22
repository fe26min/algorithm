package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1759 {
	
	// 한개의 모음(a,e,i,o,u);
	// 26개중에 L을 뽑고 그것을 사용해 
	static int L, C;
	static int arr[];
	static int checked[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		
		input();
		
		dfs(0,0);
		System.out.println(sb);
	}

	private static void dfs(int depth, int start) {
		
		if(depth == L) {
			check();
			return;
		}
		for(int i=start; i<C; i++) {
			checked[depth] = i;
			dfs(depth+1, i+1);
		}
	}

	private static void check() {
		int count = 0;
		for(int i : checked) {
			if(arr[i]=='a'-'a'||arr[i]=='e'-'a'||arr[i]=='i'-'a'||arr[i]=='o'-'a'||arr[i]=='u'-'a')
				count++;
		}
		if(count==0) return;
		if(count> L-2) return;
		
		for(int i=0; i<L; i++) {
			sb.append((char)('a' +arr[checked[i]]));
		}sb.append("\n");
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[C];
		checked = new int[L];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0)-'a';
		}
		Arrays.sort(arr);
		br.close();
	}
}
