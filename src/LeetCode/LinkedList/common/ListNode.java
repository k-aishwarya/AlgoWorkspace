package LeetCode.LinkedList.common;

import java.awt.*;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static ListNode createFromArray(Integer[] arr){
        if(arr==null || arr.length<1) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i=1; i<arr.length; i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void display(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null)
                System.out.print("->");
            temp=temp.next;
        }
        System.out.println();
    }

}
