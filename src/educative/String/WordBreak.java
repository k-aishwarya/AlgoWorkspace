package educative.String;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {



    public static boolean canSegmentString(String s, Set<String> dictionary) {
        Set<String> memory = new HashSet<>();
        for(int i=1; i<s.length(); i++){
            String firstWord = s.substring(0,i);
            if(memory.contains(firstWord) || dictionary.contains(firstWord)){
                memory.add(firstWord);
                String secondWord = s.substring(i);
                if (secondWord == null || secondWord.length() == 0 || dictionary.contains(secondWord) || memory.contains(secondWord) || canSegmentString(secondWord, dictionary)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set < String > dictionary = new HashSet< String >();
        String s = new String();
        s = "hellonow";

        dictionary.add("hello");
        dictionary.add("hell");
        dictionary.add("on");
        dictionary.add("now");
        if (canSegmentString(s, dictionary)) {
            System.out.println("String Can be Segmented");
        } else {
            System.out.println("String Can NOT be Segmented");
        }
    }
}
