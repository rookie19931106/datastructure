package list;

/**
 * @author jay
 */
public class ArraysTestDemo {
    public static void main(String[] args) {
        ArrayStack<Integer> stark = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stark.push(i);
            System.out.println(stark);
        }

        stark.pop();
        System.out.println(stark);
    }
}