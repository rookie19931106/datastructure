public interface Queue<E> {

    /**
     * 获得队列的大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 进队
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 获取第一个值
     * @return
     */
    E getFront();
}
