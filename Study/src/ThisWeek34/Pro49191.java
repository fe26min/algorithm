package ThisWeek34;

public class Pro49191 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
	}
}


class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] mat = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++) {
        	int win = results[i][0];
        	int lose = results[i][1];
        	
        	mat[win][lose] = 1;
        	mat[lose][win] = -1;
        }

        for(int k=1; k<=n; k++) {
        	for(int i=1; i<=n; i++) {
        		for(int j=1; j<=n; j++) {
        			if(mat[i][k]==1 && mat[k][j] == 1) {
        				mat[i][j] = 1;
        				mat[j][i] = -1;
        			}
        			if(mat[i][k]==-1 && mat[k][j]==-1) {
        				mat[i][j] = -1;
        				mat[j][i] = 1;
        			}
        		}
        	}
        }

        for(int i=1; i<=n; i++) {
        	int count = 0;
        	for(int j=1; j<=n; j++) {
        		if(mat[i][j]==0)
        			count++;
        	}
        	if(count==1)
        		answer++;
        }
        
        return answer;
    }
}