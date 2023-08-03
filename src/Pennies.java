import java.util.Scanner;

public class Pennies {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			String[] line = scan.nextLine().split(" ");
			int AValue = Integer.parseInt(line[0]);
			int words = Integer.parseInt(line[1]);
			for (int j = 0; j < words; j++) {
				int total = 0;
				String word = scan.nextLine();
				for (int k = 0; k < word.length(); k++) {
					int partialTotal = (word.charAt(k) - 'A') + AValue;
					while(partialTotal > 26){
						partialTotal -= 26;
					}
					total += partialTotal;
				}
				if(total == 100){
					System.out.println("WINNER " + AValue + ": " + word);
				}
			}
		}
	}
}
