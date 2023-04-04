package Geo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		
		int ccw = CCW(x1, y1, x2, y2, x3, y3);
		
		if(ccw == 0) {
			System.out.println(0);
		}
		else if(ccw >0) {
			System.out.println(1);
		}
		else {
			System.out.println(-1);
		}
		
		br.close();
	}
	
	static int CCW(int x1, int y1, int x2, int y2, int x3, int y3) {
	    return (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);
	}
}
