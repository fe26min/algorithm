package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1644 {
	static int N;
	static boolean[] isPrime;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		list = new ArrayList<>();
		era();
		int cnt = 0;
		int sum = list.get(0);
		int s = 0;
		int e = 0;
		
		while(true) {
			if(sum < N) {
				e++;
				if(e==list.size()) break;
				sum += list.get(e);
			}
			else if(sum >= N) {
				if(sum == N)
					cnt++;
				sum -= list.get(s);
				s++;
			}
		}
		
		System.out.println(cnt);
	}
	private static void era() {
		isPrime = new boolean[4_000_001];
		
		boolean[] visit = new boolean[4_000_001];
		for(int i=2; i<=4_000_000; i++) {
			if(visit[i])
				continue;
			if(!isPrime[i]) {
				isPrime[i] = true;
				list.add(i);
				for(int j=i; j<=N; j+=i) {
					visit[j] = true;
				}
			}
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
	}
}
