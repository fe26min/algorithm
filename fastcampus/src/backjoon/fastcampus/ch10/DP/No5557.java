package backjoon.fastcampus.ch10.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No5557 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		long[] cnt = new long[21];
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		br.close();
		
		cnt[arr[0]] = 1;
		
		for(int i=1; i<N-1; i++) {
			int num = arr[i];
			long[] nextCnt = new long[21];
			
			for(int j=0; j<=20; j++) {
				if(cnt[j]==0) continue;
				int next = j - num;
				if(next >= 0) {
					nextCnt[next] += cnt[j];
				}
				next = j + num;
				if(next <= 20) {
					nextCnt[next] += cnt[j];
				}
			}
			cnt = nextCnt.clone();
//			for(long k : cnt){
//				System.out.print(k + " ");
//			}System.out.println();
		}
		System.out.println(cnt[arr[N-1]]);
	}
}
