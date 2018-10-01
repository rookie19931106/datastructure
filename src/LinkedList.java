/**
 * @author jay
 * 这是一个链表实现
 * @param <E>
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList(){
        head=null;
        size=0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //在链表头添加新的元素e
    public void addFirst(E e){
        Node node=new Node(e);
        //新的节点的下一个指向现在的头
        node.next=head;
        //然后头现在指向新的节点
        head = node;
        //简写
        //head = new Node(e,head);
        //变大
        size++;
    }
}
