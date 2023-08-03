import java.util.ArrayList;
import java.util.Scanner;

public class Bidget {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine());
		for (int k = 0; k < testcases; k++){
			Double items = Double.parseDouble(sc.nextLine());
			String [] predicted = sc.nextLine().split(" ");
			String [] actual = sc.nextLine().split(" ");
			double output = solve(items, predicted, actual);
			String outputString = String.format("%.2f", output);
			System.out.println("" + outputString);
		}
	}
	public static Double solve(double items, String [] predicted, String [] actual){
		ArrayList<Double> diff = new ArrayList<Double>();
		for(int i = 0; i < items; i++){
			diff.add((Double.parseDouble(actual[i])) - Double.parseDouble(predicted[i]));
		}
		Double total = 0.0;
		for(int i = 0; i < items; i++){
			total += diff.get(i);
		}
		Double avg = total/items;

		//Add trailing zeros to 2 decimal places
		return round(avg);

	}

	public static double round(double number) {
		double powerOfTen = 100;//change this for precision (10: 1 place)
		double exp = number * powerOfTen;
		double remainder = Math.abs(exp) - Math.floor(Math.abs(exp));
		if (remainder >= 0.5) {
			if (exp > 0.0) {
				exp += 1.0;
			} else {
				exp -= 1.0;
			}
		}
		return ((int)exp)/powerOfTen;
	}
}
