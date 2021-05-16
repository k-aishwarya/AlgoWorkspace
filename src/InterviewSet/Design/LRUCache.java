package InterviewSet.Design;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {

    private Deque<Integer> queue;
    private Set<Integer> hash;
    private final Integer CAPACITY;

    public LRUCache(int capacity){
        queue = new LinkedList<>();
        hash = new HashSet<>();
        this.CAPACITY = capacity;
    }

    public void display(){
        queue.stream().forEach(System.out::print);
        System.out.println();
    }

    public void refer(int page){
        if(!hash.contains(page)){
            if(queue.size()==this.CAPACITY){
                hash.remove(queue.removeLast());
            }
        }
        else{
            queue.remove(page);
        }
        queue.push(page);
        hash.add(page);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.refer(1);
        cache.display();
        cache.refer(2);
        cache.display();
        cache.refer(3);
        cache.display();
        cache.refer(4);
        cache.display();
        cache.refer(2);
        cache.display();
        cache.refer(4);
        cache.display();
        cache.refer(3);
        cache.display();
        cache.refer(2);
        cache.display();
        cache.refer(3);
        cache.display();
        cache.refer(4);
        cache.display();
        cache.refer(5);
        cache.display();
    }


}
