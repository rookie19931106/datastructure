package test.listTest;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x){
        val=x;
    }

    public ListNode(int[] x) {
        if(x==null||x.length==0){
            throw new IllegalArgumentException("arr cannot be null");
        }
        this.val=x[0];
        ListNode cur =this;
        for(int i=1;i<x.length;i++){
            cur.next=new ListNode(x[i]);
            cur=cur.next;
        }
    }
}
