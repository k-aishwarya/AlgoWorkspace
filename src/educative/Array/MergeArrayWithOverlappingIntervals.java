package educative.Array;

import java.util.ArrayList;

public class MergeArrayWithOverlappingIntervals {
    static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
        if (v == null) return null;
        if (v.size()==1) return v;
        ArrayList<Pair> result = new ArrayList<Pair>();
        result.add(v.get(0));
        for(int i=1; i<v.size(); i++){
            Pair cur = v.get(i);
            Pair last = result.get(result.size()-1);
            if(last.second >= cur.first){
                result.remove(result.size()-1);
                int newFirst = last.first;
                int newSecond = Math.max(last.second, cur.second);
                result.add(new Pair(newFirst, newSecond));
            }
            else{
                result.add(cur);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Pair> v = new ArrayList<Pair>();

        v.add(new Pair(1, 5));
        v.add(new Pair(3, 7));
        v.add(new Pair(4, 6));
        v.add(new Pair(6, 8));
        v.add(new Pair(10, 12));
        v.add(new Pair(11, 15));

        ArrayList<Pair> result = mergeIntervals(v);

        for(int i=0; i<result.size(); i++){
            System.out.print(String.format("[%d, %d] ", result.get(i).first, result.get(i).second));
        }
    }

}

class Pair{
    public int first;
    public int second;

    public Pair(int x, int y){
        this.first = x;
        this.second = y;
    }
}
