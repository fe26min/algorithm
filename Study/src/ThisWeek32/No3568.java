package ThisWeek32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().replace(",","").replace(";", "");
		String[] inputs = input.split(" ");
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<inputs.length; i++) {
			String[] variable = reverseType(inputs[i]).split("#");
			sb.append(inputs[0] + variable[0] + " " + variable[1] + ";\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static String reverseType(String str) {
		char[] origin = str.toCharArray();
		String result = "";
		
		for(int i=str.length()-1; i>= 0; i--) {
			if(origin[i] != ']') {
				if(origin[i]=='*' || origin[i]=='&') {
					result += origin[i];
				}else {
					result += "#";
					for(int j=0; j<=i; j++) {
						result += origin[j];
					}
					break;
				}
			}
			else {
				result += "[]";
				i--;
			}
		}
		return result;
	}
}
