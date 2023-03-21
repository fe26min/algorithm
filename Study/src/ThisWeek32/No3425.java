package ThisWeek32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No3425 {
	static ArrayList<String> cmds;
	static long[] stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		stack = new long[1001];
		
		while(true) {
			cmds = new ArrayList<>();
			String line = br.readLine();
			if(line.equals("QUIT"))
				break;
			while(!line.equals("END")) {
				String[] split = line.split(" ");
				
				cmds.add(split[0]);
				if(split.length == 2) {
					cmds.add(split[1]);
				}
				line = br.readLine();
			}
			int N = Integer.parseInt(br.readLine());
			
			for(int i=0; i<N; i++) {
				int s = Integer.parseInt(br.readLine());
				if(func(s)) {
					sb.append(stack[0]).append("\n");
				}
				else
					sb.append("ERROR\n");
			}
			sb.append("\n");
			br.readLine();
		}
		System.out.println(sb);
		br.close();
	}

	private static boolean func(int num) {
		int size = cmds.size();
		
		int head = 0;
		stack[head++] = num;
		
		for(int i=0; i<size; i++) {
			if(cmds.get(i).equals("NUM")) {
				stack[head++] = Long.parseLong(cmds.get(i+1));
				i++;
			}
			else {
				if(head < 1) {
					return false;
				}
				if(cmds.get(i).equals("POP")) {
					head--;
				}
				else if(cmds.get(i).equals("INV")) {
					stack[head-1] *= -1;
				}
				else if(cmds.get(i).equals("DUP")) {
					stack[head] = stack[head-1];
					head++;
				}
				else {
					if(head < 2) {
						return false;
					}
					else if(cmds.get(i).equals("SWP")) {
						long temp = stack[head-1];
						stack[head-1] = stack[head-2];
						stack[head-2] = temp;
					}
					else {
						if(cmds.get(i).equals("ADD")) {
							stack[head-2] += stack[head-1];
						}
						else if(cmds.get(i).equals("SUB")) {
							stack[head-2] -= stack[head-1];
						}
						else if(cmds.get(i).equals("MUL")) {
							stack[head-2] *= stack[head-1];
						}
						else {
							if(stack[head-1] == 0) {
								return false;
							}
							else if(cmds.get(i).equals("DIV")) {
								stack[head-2] /= stack[head-1];
							}
							else if(cmds.get(i).equals("MOD")) {
								stack[head-2] %= stack[head-1];
							}
						}
						head--;
						if(Math.abs(stack[head-1]) > 1000000000) {
							return false;
						}
					}
				}
			}
		}
		if(head==1)
			return true;
		return false;
	}
}