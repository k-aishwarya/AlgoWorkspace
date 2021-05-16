package educative.LinkedList;

public class Challenge5 {

    public static <T> void reverse(SinglyLinkedList<T> list){
        SinglyLinkedList<T>.Node previous = null; //To keep track of the previous element, will be used in swapping links
        SinglyLinkedList<T>.Node current = list.headNode; //firstElement
        SinglyLinkedList<T>.Node next = null;

        //While Traversing the list, swap links
        while (current != null) {
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }
        //Linking Head Node with the new First Element
        list.headNode = previous;

    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertAtHead(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        list.printList();

        reverse(list);

        list.printList();

    }
}
