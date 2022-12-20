package backjoon.fastcampus.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21920 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int X = Integer.parseInt(br.readLine());
		
		double sum = 0;
		int count =0;
		for(int i : arr) {
			double check = isDis(i, X);
			sum += check;
			if(check != 0 )
				count++;
		}
		System.out.println(sum / count);
		
		br.close();
	}

	private static double isDis(int num, int x) {
		int max = Math.max(num, x);
		int min = Math.min(num, x);
		
		while(max % min != 0 ) {
			int temp = max - min;
			max = Math.max(temp, min);
			min = Math.min(temp, min);
		}
		
		if(min == 1) return num;
		return 0;
	}
}
