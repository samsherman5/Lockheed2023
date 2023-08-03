import java.util.Scanner;

public class Nimo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			String[] lineSplit = scan.nextLine().split(" ");
			for (int j = 0; j < lineSplit.length; j++) {
				if(lineSplit[j].equals("Nimo")){
					System.out.println(j+1);
				}
			}
		}
	}
}
