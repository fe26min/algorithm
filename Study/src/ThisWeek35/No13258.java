package ThisWeek35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int sum = num;
		
		for(int i=1; i<N; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
		double J = Integer.parseInt(br.readLine());
		double C = Integer.parseInt(br.readLine());
		
		// 적어도 한 사람의 잔고는 0원보다 많기 때문에 sum이 0이 되는 경우는 없다.
		double ans = num + (num * J * C) / sum; 
		System.out.printf("%.10f", ans);
		br.close();
	}
}
