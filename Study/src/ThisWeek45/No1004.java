package ThisWeek45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1004 {
	static int x1, x2, y1, y2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int ti=0; ti<T; ti++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
		
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				if(contain(cx,cy,r))
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	private static boolean contain(int cx, int cy, int r) {
		int dist1 = dist(cx,cy,x1,y1);
		int dist2 = dist(cx,cy,x2,y2);
		
		if(dist1 <=r*r && dist2 <= r*r)
			return false;
		else if(dist1 >r*r && dist2 > r*r)
			return false;
		return true;
	}
	private static int dist(int x1, int y1, int x2, int y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
