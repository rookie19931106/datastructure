package list;

public class Test {

    public static void main(String[] args) {
        System.out.println(fib(30));
    }
    public static int fib(int n){
        if(n==1||n==2){
            return 1;
        }else {
            return fib(n-1)+fib(n-2);
        }

    }
}
