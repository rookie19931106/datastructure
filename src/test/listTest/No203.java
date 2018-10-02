package test.listTest;

/**
 * leetCode 203号问题
 * 删除链表的给定数字
 */
public class No203 {
    //定义一个节点
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head,int val){
        //假设头结点就是要删除的节点
        while (head != null&& head.val == val){
            ListNode delNode =head;
            head=head.next;
            delNode.next=null;
        }
        //如果是空链表
        if(head==null){
            return null;
        }

        //正常情况
        ListNode prev = head;
        while(prev.next!=null){
            if(prev.next.val==val){
                ListNode delNode = prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else {
                prev=prev.next;
            }
        }
        return head;
    }



}
