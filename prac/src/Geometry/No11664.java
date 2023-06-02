package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11664 {
	static double Ax, Ay, Az, Bx, By, Bz, Cx, Cy, Cz;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		
		double ans = Double.MAX_VALUE;
		while(true) {
			double Mx = (Ax + Bx)/2;
			double My = (Ay + By)/2;
			double Mz = (Az + Bz)/2;
			
			double AtoC = Math.sqrt(((Ax - Cx) * (Ax - Cx)) 
							+ ((Ay - Cy) * (Ay - Cy))
							+ ((Az - Cz) * (Az - Cz)));
			double MtoC = Math.sqrt(((Mx - Cx) * (Mx - Cx)) 
							+ ((My - Cy) * (My - Cy))
							+ ((Mz - Cz) * (Mz - Cz)));
			double BtoC = Math.sqrt(((Bx - Cx) * (Bx - Cx)) 
							+ ((By - Cy) * (By - Cy))
							+ ((Bz - Cz) * (Bz - Cz)));
			
			if(Math.abs(ans - MtoC) <= 1e-7) {
				System.out.printf("%.10f", ans);
				return;
			}
			
			if(MtoC < ans)
				ans = MtoC;
			if(AtoC > BtoC) {
				Ax = Mx;
				Ay = My;
				Az = Mz;
			}
			else {
				Bx = Mx;
				By = My;
				Bz = Mz;
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Ax = Double.parseDouble(st.nextToken());
		Ay = Double.parseDouble(st.nextToken());
		Az = Double.parseDouble(st.nextToken());
		Bx = Double.parseDouble(st.nextToken());
		By = Double.parseDouble(st.nextToken());
		Bz = Double.parseDouble(st.nextToken());
		Cx = Double.parseDouble(st.nextToken());
		Cy = Double.parseDouble(st.nextToken());
		Cz = Double.parseDouble(st.nextToken());
		br.close();		
	}
}
