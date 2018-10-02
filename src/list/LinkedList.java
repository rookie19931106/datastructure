package list;

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

    /**
     * 为链表添加一个虚拟节点
     */
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead= new Node(null,null);
        size=0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }



    //在链表的index位置添加一个新的元素e
    //不是一个常用的操作习惯
    public void add(int index,E e){
        if(index<0||index > size){
            throw new IllegalArgumentException("add failed,illegal index");
        }

            Node prev = dummyHead;
            for (int i=0;i<index;i++){
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next=prev.next;
            prev.next=node;
            //简写
            //prev.next= new Node(e,prev.next);
            size++;
    }

    //在链表头添加新的元素e
    public void addFirst(E e){
        add(0,e);
    }

    //在链表末尾添加新的元素e
    public void addLast(E e){

        add(size,e);
    }

    //获得链表的第index个元素，在链表中不是一个常用的操作，练习用
    public E get(int index){
        if(index<0||index >= size){
            throw new IllegalArgumentException("get failed,illegal index");
        }
        Node cur = dummyHead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    public E getLast(){
        return get(size-1);
    }

    //修改链表的第index位置的元素
    public void set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("set failed,illegal index");
        }

        Node cur=dummyHead.next;
        for (int i=0;i<size;i++){
            cur=cur.next;
        }
        cur.e=e;
    }

    //在链表中查找指定元素
    public boolean contains(E e){

        Node cur =dummyHead.next;
        while (cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    //从链表中删除元素，练习用
    public E remove(int index){
        if(index < 0 ||index >= size){
            throw new IllegalArgumentException("remove failed,illegal index");
        }
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node retNode = prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;
    }

    public E removeFirst(){
      return remove(0);
    }

}
