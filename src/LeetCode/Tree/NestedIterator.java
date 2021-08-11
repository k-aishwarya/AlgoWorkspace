package LeetCode.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {
 
  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return empty list if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}


public class NestedIterator  implements Iterator<Integer> {

    private List<Integer> flatList = new ArrayList<>();
    private int pointer=0;

    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList!=null){
            flatten(nestedList);
        }
    }

    private void flatten(List<NestedInteger> nestedList){
        if(nestedList==null) return;
        for(NestedInteger i: nestedList){
            if(i.isInteger()){
                flatList.add(i.getInteger());
            }
            else{
                flatten(i.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return flatList.get(pointer++);
    }

    @Override
    public boolean hasNext() {
        return flatList.size()>0 && pointer<flatList.size();
    }
}