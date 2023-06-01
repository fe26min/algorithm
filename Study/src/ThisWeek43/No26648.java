package ThisWeek43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No26648 {
	static int N;
	static int mat[][];
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
        int current = -1;
        for(int i=0; i<N; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=0; j<3; j++){
                min = Math.min(min, mat[j][i]);
                max = Math.max(max, mat[j][i]);
            }
            if(current+1>max){
            	System.out.println("NO");
            	return;
            }
            else{
                if(current+1<min){
                    current = min;
                }
                else{
                    current++;
                }
            }
        }
        System.out.println("YES");
	}
	

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		mat=new int[3][N];
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();		
	}
}
