package backjoon.fastcampus.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int max = 0;
		int sum = 0;
		int count = 0;
		int a = 8_000 * 250_000;
		for(int i=0; i<X; i++) {
			sum += arr[i];
		}
		if(max < sum) {
			count = 1;
			max = sum;
		}
		
		for(int i=0; i<N-X; i++) {
			sum -= arr[i];
			sum += arr[X+i];
			if(max < sum) {
				count = 1;
				max = sum;
			}
			else if(max == sum) {
				count++;
			}
		}
		if(max == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(max);
			System.out.println(count);
		}
		br.close();
	}
}
