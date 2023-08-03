import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Budget {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			String[] line = scan.nextLine().split(" ");
			int categories = Integer.parseInt(line[0]);
			int trans = Integer.parseInt(line[1]);
			Map<String, Integer> budget = new HashMap<String, Integer>();
			for (int j = 0; j < categories; j++) {
				String[] linesplit = scan.nextLine().split(" ");
				budget.put(linesplit[0], Integer.parseInt(linesplit[1]));
			}
			for (int j = 0; j < trans; j++) {
				String[] linesplit = scan.nextLine().split(" ");
				int change = Integer.parseInt(linesplit[2]);
				if(linesplit[1].equals("+")){
					System.out.println("YES");
					budget.put(linesplit[0], budget.get(linesplit[0]) + change);
				} else if(linesplit[1].equals("-")){
					if(budget.get(linesplit[0]) - change < 0){
						System.out.println("NO");
					} else {
						System.out.println("YES");
						budget.put(linesplit[0], budget.get(linesplit[0]) - change);
					}
				}
			}
		}
	}
}
