package LeetCode.LinkedList;

import LeetCode.LinkedList.common.ListNode;

public class addTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;


        int sum = l1.val+l2.val;
        int value = sum%10;
        int carry = sum/10;
        ListNode head = new ListNode(value);
        ListNode temp = head;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null && l2!=null){
            sum = l1.val+l2.val+carry;
            value = sum%10;
            carry = sum/10;
            temp.next = new ListNode(value);
            temp = temp.next;

            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            sum = l1.val+carry;
            value = sum%10;
            carry = sum/10;
            temp.next = new ListNode(value);
            temp = temp.next;
            l1=l1.next;
        }

        while(l2!=null){
            sum = l2.val+carry;
            value = sum%10;
            carry = sum/10;
            temp.next = new ListNode(value);
            temp = temp.next;
            l2=l2.next;
        }

        if(carry>0){
            temp.next = new ListNode(carry);
        }

        return head;

    }

    public static void main(String[] args) {
        Integer[] arr1 = {9,9,9,9,9,9,9};
        Integer[] arr2 = {9,9,9,9};
        ListNode l1 = ListNode.createFromArray(arr1);
        ListNode l2 = ListNode.createFromArray(arr2);
        ListNode.display(l1);
        ListNode.display(l2);

        ListNode res = addTwoNumbers(l1,l2);
        ListNode.display(res);
    }
}
