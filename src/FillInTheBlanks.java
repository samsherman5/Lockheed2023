import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FillInTheBlanks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine());
		for (int k = 0; k < testcases; k++) {
			String [] lens = sc.nextLine().split(" ");
			int d = Integer.parseInt(lens[0]);
			int t = Integer.parseInt(lens[1]);
			Map<String, String> map = new HashMap<String, String>();
			for(int i = 0; i < d; i++){
				String [] line = sc.nextLine().split(": ");
				map.put(line[0], line[1]);
			}
			//print the whole map

			for (int i = 0; i < t; i++) {
				String outLine = "";
				String input = sc.nextLine();
				for (int j = 0; j < input.length(); j++) {
					if(input.charAt(j)=='['){
						String key = "";
						j++;
						while(input.charAt(j)!=']'){
							key += input.charAt(j);
							j++;
						}
						outLine += map.get(key);
					} else {
						outLine += input.charAt(j);
					}
				}
				System.out.println(outLine);
			}
		}
	}
}
