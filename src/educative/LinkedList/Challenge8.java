package educative.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Challenge8 {
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        if(list.isEmpty()) return;
        Set<Object> s = new HashSet<>();
        SinglyLinkedList.Node cur = list.headNode.nextNode;
        SinglyLinkedList.Node prev = list.headNode;
        s.add(prev.data);
        while(cur!=null){
            if(!s.contains(cur.data)){
                s.add(cur.data);
                cur=cur.nextNode;
                prev=prev.nextNode;
            }
            else{
                SinglyLinkedList.Node next = cur.nextNode;
                prev.nextNode=next;
                cur=next;
            }
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertAtHead(7);
        list.insertAtEnd(14);
        list.insertAtEnd(21);
        list.insertAtEnd(14);
        list.insertAtEnd(22);
        list.insertAtEnd(7);

        list.printList();

        removeDuplicates(list);

        list.printList();

    }

}
