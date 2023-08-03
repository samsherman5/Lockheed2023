public class Rounding {
	public static void main(String[] args) {
		double number = 3.14159;
		System.out.println(round(number));
	}
	public static double round(double number) {
		double powerOfTen = 10;//change this for precision (10: 1 place)
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
