import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Anagrams {
    public static void main(String[] args) {

        String s1 = "cde";
        String s2 = "abc";
        int result = makeAnagram(s1, s2);
        int expectedOutput = 4;
        System.out.println(result == expectedOutput);
    }
    
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        HashMap<Character, Integer> aStore = createLetterStore(a);
        HashMap<Character, Integer> bStore = createLetterStore(b);

        int numLettersToRemove = 0;

        Set<Character> keys = new HashSet<Character>();
        keys.addAll(aStore.keySet());
        keys.addAll(bStore.keySet());

        Iterator<Character> keysIter =  keys.iterator();

        while (keysIter.hasNext()) {
            Character key = keysIter.next();

            int aVal = aStore.getOrDefault(key, 0);
            int bVal = bStore.getOrDefault(key, 0);

            numLettersToRemove += Math.abs(aVal - bVal);
        }
        return numLettersToRemove;
    }

    static HashMap<Character, Integer> createLetterStore(String s) {
        HashMap<Character, Integer> store = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (store.containsKey(c)) {
                store.put(c, store.get(c) + 1);
            } else {
                store.put(c, 1);
            }
        }

        return store;
    }
}