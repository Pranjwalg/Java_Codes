import java.util.*;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentInt = romanToIntMap.get(s.charAt(i));
            int nextInt = (i < s.length() - 1) ? romanToIntMap.get(s.charAt(i + 1)) : 0;

            if (currentInt < nextInt) {
                result -= currentInt;
            } else {
                result += currentInt;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine().toUpperCase();

        int result = romanToInt(romanNumeral);

        System.out.println("The equivalent integer is: " + result);
        scanner.close();
    }
}
