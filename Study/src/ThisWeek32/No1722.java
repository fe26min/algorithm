package ThisWeek32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1722 {
	
	static boolean[] check = new boolean[21];
	static long[] fac = new long[21];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		fac[0] = 1;
		for(int i=1; i<21; i++) {
			fac[i] = fac[i-1] * i;
		}
		
		int num = Integer.parseInt(st.nextToken());
		
		switch(num) {
		case 1:
			long k = Long.parseLong(st.nextToken());
			int[] vec1 = new int[N];
			for(int i=0; i<N; i++) {
				for(int j=1; j <= N; j++) {
					if(check[j])
						continue;
					if(k > fac[N-i-1]) {
						k -= fac[N-i-1];
					}
					else {
						vec1[i] = j;
						check[j] = true;
						break;
					}
				}
			}
			for(int i : vec1) {
				System.out.print(i + " ");
			}
			break;
		case 2:
			int[] vec2 = new int[N];
			for(int i=0; i<N; i++) {
				vec2[i] = Integer.parseInt(st.nextToken());
			}
			long result = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=1; j<vec2[i]; j++) {
					if(check[j])
						continue;
					result += fac[N - 1 - i];
				}
				check[vec2[i]] = true;
			}
			System.out.println(result + 1);
			break;
		}
		
		br.close();
	}
}
