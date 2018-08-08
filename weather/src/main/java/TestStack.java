/**
 * 描述：利用栈完成进制转化
 * N = (N div d) * d + N mod d
 * N        N div d     N mod d
 * 1348       168          4
 * 168        21           0
 * 21         2            5
 * 2          0            2
 *
 * 1348 = 544(16) = 2504(8) = (10101000100)
 */
public class TestStack {
    public static void main(String[] args) {
//        char[] num = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
//        int N = 13485;
//        int result;
//        ArrayStack<Character> arrayStack = new ArrayStack<>(Character.class);
//        while (N != 0) {
//            result = N % 16;
//            arrayStack.push(num[result]);
//            N = N / 16;
//        }
//        int size = arrayStack.size();
//        for (int i = 0; i < size; i++) {
//            Character p = arrayStack.pop();
//            System.out.print(p);
//        }
        String s = new String("aa");
        change(s);
        System.out.println(s);
    }
    public static void change(String x) {
        x = "bb";
    }
}
