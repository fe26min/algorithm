package ThisWeek44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1522 {
	static String s;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int min = Integer.MAX_VALUE;
		
		int aCnt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) =='a') {
				aCnt++;
			}
		}
		
		for(int i=0; i<s.length(); i++) {
			int bCnt = 0;
			for(int j=i; j<i+aCnt; j++) {
				int idx = j%s.length();
				if(s.charAt(idx) =='b') {
					bCnt++;
				}
			}
			min = Math.min(min, bCnt);
		}
		System.out.println(min);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		br.close();		
	}
}
