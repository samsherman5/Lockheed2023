import java.util.*;


public class StringPermutation {
	public static void main(String[] args) {
		permuteStrings("BRAT", "|");
		permuteStrings("ROOST", "|");
		//\System.out.println(move("abcde", 2));
		//loop("abc|de");
	}
	static void permutingArray(List<Integer> arrayList, int element) {
		for (int i = element; i < arrayList.size(); i++) {
			Collections.swap(arrayList, i, element);
			permutingArray(arrayList, element + 1);
			Collections.swap(arrayList, element, i);
		}
		if (element == arrayList.size() - 1) {
			System.out.println(arrayList);
		}
	}
	public static void permuteStrings(String s, String marker) {
		Stack<String> stack = new Stack<>();
		stack.push(s + marker);
		Set<String> set = new TreeSet<>();
		while(!stack.isEmpty()) {
			String item = stack.pop();
			if (item.startsWith(marker)) {
				set.add(item.substring(1));
			}
			else {
				int i = 0;
				while(i < item.length() && !item.substring(i, i + 1).equals(marker)) {
					stack.push(move(item, i));
					i++;
				}
			}
		}
		System.out.println(set.size() + " " + set);
	}
	public static String move(String s, int i) {
		return s.substring(0, i) + s.substring(i + 1) + s.substring(i, i + 1);
	}
	public static void loop(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!s.substring(i, i + 1).equals("|")) {
				System.out.println(s.substring(i, i + 1));
			}
		}
	}
}

