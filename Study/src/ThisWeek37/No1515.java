package ThisWeek37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1515 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int idx = 0;
		int base = 0;
		
		while(base++ <= 30000) {
			String num = String.valueOf(base);
			for(int i=0; i < num.length(); i++) {
				if(num.charAt(i) == input.charAt(idx))
					idx++;
				if(idx == num.length()) {
					System.out.println(base);
					return;
				}
			}
		}
		
		br.close();
	}
}
