package backjoon.answer_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1637 {
	
	static int N;
	static int[] A, B, C;
	
	static long min = Long.MAX_VALUE;
	static long max = Long.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		B = new int[N];
		C = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			
			min = Math.min(min, A[i]);
			max = Math.max(max, C[i]);
		}
		max++;
		bs();
		br.close();
	}

	private static void bs() {
		long l = min;
		long r = max;
		
		while(l < r) {
			long mid = (l + r) / 2;
			
			long sum = getSum(mid);
			
			if(sum % 2 ==0) {
				l = mid+1;
			}
			else {
				r = mid;
			}
		}
		
		if(l == max) 
			System.out.println("NOTHING");
		else {
			long num = getSum(l) - getSum(l-1);
			System.out.println(l + " " + num);
		}
	}
	
	static long getSum(long mid) {
		long sum = 0;
		for(int i=0; i<N; i++) {
			if(mid >= A[i])
				sum += (Math.min(mid, C[i]) - A[i]) / B[i] + 1;
		}
		return sum;
	}
}
