package test.listTest;

/**
 * 采用递归算法
 */
public class No203Solution3 {


    /**
     * 采用递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head,int val){
        //程序的出口
        if(head ==null){
            return null;
        }

        //动作
        ListNode listNode = removeElements(head.next, val);
        if(head.val==val){
            return listNode;
        }else {
            head.next=listNode;
            return head;
        }

        //超级简单的简化,4行代码
//        if(head ==null){
//            return null;
//        }
//        head.next = removeElements(head.next,val);
//        return head.val==val?head.next:head;

    }

    public static void main(String[] args) {
        int[] nums={1,2,6,3,4,5,6};
        ListNode head=new ListNode(nums);
        System.out.println(head);

        ListNode res=new No203Solution3().removeElements(head,6);
        System.out.println(res);
    }
}
