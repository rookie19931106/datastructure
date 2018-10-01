package list;

public class Demo1<E> {

    private E[] data;

    private int size;

    /**
     * 初始化容量
     * @param capacity
     */
    public Demo1(int capacity){
        data = (E[]) new Object[capacity];
        size = 0 ;
    }

    /**
     * 默认无参为10
     */
    public Demo1(){
        this(10);
    }

    /**
     * 获取元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addLast(E e){
       add(size,e);
    }

    //添加
    public void add(int index,E e){
        

        if(index<0||index>size){
            throw new IllegalArgumentException("失敗");
        }

        if(size==data.length){
            resize(2*data.length);
        }

        for (int i=size-1;i>=index;i--){
            data[i+1] =data[i];
        }

        data[index]=e;
        size++;

    }

    /**
     * 數組滿了以後擴容,扩容两倍
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0;i<size;i++){
            newData[i] =data[i];
            data=newData;
        }
    }

    //查找數組是否包含元素e
  public boolean contains(E e){
        for(int i =0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
  }

  //在數組刪除index位置的元素
  public E remove(int index){
        if(index <0||index>=size){
            throw new IllegalArgumentException("錯了");
        }
        E ret =data[index];
        for(int i =index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size] =null;
        return ret;
  }

  int[] i ;

}
