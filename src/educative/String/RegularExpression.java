package educative.String;

import java.util.LinkedList;
import java.util.List;

public class RegularExpression {
    static boolean regxMatch(String text, String pattern) {
        if(text.length()==0 ||  pattern.length()==0) return false;
        if(text.equals(pattern)) return true;
        List<Character> s = new LinkedList<>();
        for(int i=0; i<text.length(); i++){
            s.add(text.charAt(i));
        }
        char prev=s.get(0);
        int count = 0;
        while(!s.isEmpty()){
            char t = s.remove(0);
            char p = pattern.charAt(count);
            if( p == '*'){
                if(prev == t){
                    while(prev==s.get(0)){
                        s.remove(0);
                    }
                    count+=1;
                }
                else return false;
            }
            else if(p == '.'){
                prev=t;
                count+=1;
            }
            else{
                if(p!=t) return false;
                prev=t;
                count+=1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(regxMatch("aabbbbbcdda",".*b*c*d*a*"));
    }
}
