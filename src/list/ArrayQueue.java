package list;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array=new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    //时间复杂度O(1)
    @Override
    public void enqueue(E e)  {
         array.addLast(e);
    }

    //时间复杂度O(n)
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("list.Queue: ");
        res.append("front [");
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] last");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i=0;i<10;i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if(i%3==2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }

    }
}