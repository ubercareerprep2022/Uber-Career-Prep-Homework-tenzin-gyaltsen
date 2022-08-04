package LeetCode;

public class Sum {

    public int sumRange(int a, int b){
        if(a == b){
            return b;
        }
        return a + sumRange(a + 1, b);
    }

    public static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println(sum.sumRange(1, 5));
        System.out.println((5 * 6)/2);
    }
    
}
