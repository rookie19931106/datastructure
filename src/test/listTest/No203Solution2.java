package test.listTest;

public class No203Solution2 {
    //定义一个节点
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head,int val){
        /**
         * 设置一个虚拟节点，值随便
         */
        ListNode dummyHead = new ListNode(1);
        dummyHead.next=head;
        ListNode prev = dummyHead;
        while (prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else {
                prev=prev.next;
            }
        }
       return dummyHead.next;

    }

}
