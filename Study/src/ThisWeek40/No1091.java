package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1091 {
	static int N;
	static int[] P, S, arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = i % 3;
		}
		int cnt = 0;
		
		while(true) {
			if(check())
				break;
			shuffle();
			cnt++;
			if(dormamu()) {
				cnt = -1;
				break;
			}
		}		
		System.out.println(cnt);
	}
	
	private static boolean dormamu() {
		for(int i=0; i<N; i++) {
			if(arr[i] != i%3)
				return  false;
		}
		return true;
	}

	private static boolean check() {
		for(int i=0; i<N; i++) {
			if(arr[i] != P[i])
				return false;
		}
		return true;
	}

	private static void shuffle() {
		int[] temp = new int[N];
		for(int i=0; i<N; i++) {
			temp[i] = arr[S[i]];
		}
		arr = temp;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		P = new int[N];
		S = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			P[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			S[i] = Integer.parseInt(st.nextToken());
		
		br.close();		
	}
}
