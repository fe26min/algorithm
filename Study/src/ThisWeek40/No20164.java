package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No20164 {
	static String num;
	static int min, max;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		min = Integer.MAX_VALUE;
		max = 0;
		func(num, cal(num));
		System.out.println(min + " " + max);
	}

	private static void func(String n, int sum) {
		if(n.length() >= 3) {
			for(int i=1; i<n.length(); i++) {
				for(int j=i+1; j<n.length(); j++) {
					int a = Integer.parseInt(n.substring(0, i));
					int b = Integer.parseInt(n.substring(i, j));
					int c = Integer.parseInt(n.substring(j));
//					System.out.println(a + " " + b + " " + c);
					String nn = "" + (a + b + c);
					func(nn, sum + cal(nn));
				}
			}
		}
		else if(n.length()==2) {
			String nn = "" + (n.charAt(0) + n.charAt(1) - 2 * '0');
			func(nn, sum + cal(nn));
		}
		else if(n.length()==1) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
		}
	}

	private static int cal(String n) {
		int cnt = 0;
		for(int i=0; i<n.length(); i++) {
			cnt += (n.charAt(i) - '0') % 2;
		}
		return cnt;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = br.readLine();
		br.close();		
	}
}