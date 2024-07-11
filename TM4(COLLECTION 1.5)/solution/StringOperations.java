import java.util.ArrayList;
import java.util.List;

public class StringOperations {

    public static List<String> performOperations(String S1, String S2) {
        List<String> result = new ArrayList<>();

        // 1. Character in each alternate index of S1 should be replaced with S2
        StringBuilder sb1 = new StringBuilder(S1);
        for (int i = 0; i < sb1.length(); i += 2) {
            sb1.replace(i, i + 1, S2);
        }
        result.add(sb1.toString());

        // 2. Replace the last occurrence of S2 in S1 with the reverse of S2, else return S1 + S2
        if (S1.lastIndexOf(S2) != S1.indexOf(S2)) {
            int lastIndex = S1.lastIndexOf(S2);
            StringBuilder sb2 = new StringBuilder(S1);
            sb2.replace(lastIndex, lastIndex + S2.length(), new StringBuilder(S2).reverse().toString());
            result.add(sb2.toString());
        } else {
            result.add(S1 + S2);
        }

        // 3. Delete the first occurrence of S2 in S1, else return S1
        if (S1.contains(S2) && S1.indexOf(S2) != S1.lastIndexOf(S2)) {
            int firstIndex = S1.indexOf(S2);
            StringBuilder sb3 = new StringBuilder(S1);
            sb3.delete(firstIndex, firstIndex + S2.length());
            result.add(sb3.toString());
        } else {
            result.add(S1);
        }

        // 4. Divide S2 into two halves and add to the beginning and end of S1
        int n = S2.length();
        String firstHalf = S2.substring(0, (n + 1) / 2);
        String secondHalf = S2.substring((n + 1) / 2);
        result.add(firstHalf + S1 + secondHalf);

        // 5. Change all characters in S1 that are in S2 to *
        StringBuilder sb5 = new StringBuilder(S1);
        for (int i = 0; i < sb5.length(); i++) {
            if (S2.indexOf(sb5.charAt(i)) != -1) {
                sb5.setCharAt(i, '*');
            }
        }
        result.add(sb5.toString());

        return result;
    }

    public static void main(String[] args) {
        String S1 = "JAVAJAVA";
        String S2 = "VA";

        List<String> results = performOperations(S1, S2);

        System.out.println(results);
    }
}
