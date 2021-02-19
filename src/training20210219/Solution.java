package training20210219;

/**
 * Created by Orion on 2021/2/19 17:41
 */
//2. 两数相加
//        给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//        请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//        你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
//        示例 1：
//
//
//        输入：l1 = [2,4,3], l2 = [5,6,4]
//        输出：[7,0,8]
//        解释：342 + 465 = 807.
//        示例 2：
//
//        输入：l1 = [0], l2 = [0]
//        输出：[0]
//        示例 3：
//
//        输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        输出：[8,9,9,9,0,0,0,1]
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode();
        ergodicList(result,l1,l2,0);
        return result.next;
    }
    public static void ergodicList(ListNode result,ListNode l1,ListNode l2,int extra){
        if (l1!=null&&l2!=null) {
            result.next=new ListNode();
            result.next.val=l1.val+l2.val+extra;
            if (result.next.val>=10){
                result.next.val=result.next.val%10;
                ergodicList(result.next, l1.next, l2.next, 1);
            }else {
                ergodicList(result.next, l1.next, l2.next, 0);
            }
        }
        else if(l1!=null){
            result.next=new ListNode();
            result.next.val=l1.val+extra;
            if (result.next.val>=10){
                result.next.val=result.next.val%10;
                ergodicList(result.next, l1.next, null, 1);
            }else {
                ergodicList(result.next, l1.next, null, 0);
            }
        }
        else if(l2!=null){
            result.next=new ListNode();
            result.next.val=l2.val+extra;
            if (result.next.val>=10){
                result.next.val=result.next.val%10;
                ergodicList(result.next, null, l2.next, 1);
            }else {
                ergodicList(result.next, null, l2.next, 0);
            }
        }
        else{
            if (extra==1)result.next=new ListNode(1);
        }

    }

    public static void creatLinkTable(ListNode head,int val){
        if (head.next==null){
            head.next=new ListNode(val);
        }else creatLinkTable(head.next,val);
    }
    public static void main(String[] args) {
        int [] array1={9,9,9,9,9,9,9};
        int [] array2={9,9,9,9};
        ListNode l1=new ListNode();
        ListNode l2=new ListNode();
        for (int i : array1) {
            creatLinkTable(l1,i);
        }
        for (int i : array2) {
            creatLinkTable(l2,i);
        }

        addTwoNumbers(l1.next,l2.next);

    }
}