package Ch001_CodingTestPrac.Basic.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		
		while(max % min != 0) {
			max -= min;
			if(max < min) {
				int tmp = min;
				min = max;
				max = tmp;
			}
		}
		System.out.println(min);
		System.out.println(a * b / min);
		
		br.close();
	}
}
