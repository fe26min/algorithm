package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21943 {
	static int N, P, Q, max;
	static int[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		visit = new boolean[N];
		max = 0;
		dfsAdd(0);
		System.out.println(max);
	}

	private static void dfsAdd(int depth) {
		if(depth == P) {
			int num = 1;
			for(int i=0; i<N; i++) {
				if(visit[i])
					continue;
				num *= arr[i];
			}
			max = Math.max(max, num);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visit[i])
				continue;
			for(int j=i+1; j<N; j++) {
				if(visit[j])
					continue;
				visit[j] = true;
				arr[i] += arr[j];
				dfsAdd(depth + 1);
				visit[j] = false;
				arr[i] -= arr[j];
			}
		}
	}


	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		br.close();
	}
}
