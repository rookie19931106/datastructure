package list;

public class LoopQueue<E> implements Queue<E>{

    private E[] data;

    private int front;

    private int tail;

    private int size;

    public LoopQueue(int capacity){
        //创建循环队列使容量加1防止front和tail相等
        data = (E[]) new Object[capacity+1];
        front=0;
        tail=0;
        size=0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length==front){
            resize(getCapacity()*2);
        }
        data[tail]=e;
        //循环队列要对队列进行取余
        tail=(tail+1)%data.length;
        size++;
    }

    //扩容
    private void resize(int i) {
        E[] newData =(E[]) new Object[i+1];
        for(int j=0;j<size;j++) {
            //对队列进行重新排列
            newData[j] = data[(j + front) % data.length];
        }
            data=newData;
            front=0;
            tail=size;

    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
            E ret =data[front];
            data[front]=null;
            front=(front+1)%data.length;
            size--;
            if(size==getCapacity()/4 &&getCapacity()/2!=0){
                resize(getCapacity()/2);
            }
            return ret;

    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("list.Queue is empty");
        }
        return data[front];
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("list.Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front:[");
        for(int i = front ; i !=tail ; i =(i+1)%data.length){
            res.append(data[i]);
            if( (i+1)!= tail){
                res.append(", ");
            }

        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
