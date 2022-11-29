package backjoon.fastcampus.ch05.TP_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No13144 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashSet<Integer> hs = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		long count = 0;
		
		for(int s = 0, e = -1; s<N; s++) {
			while(e+1 < N && !hs.contains(arr[e+1])) {
				e++;
				hs.add(arr[e]);
			}
			count += e - s + 1;
			
			hs.remove(arr[s]);
		}
		System.out.println(count);
		br.close();
	}
}