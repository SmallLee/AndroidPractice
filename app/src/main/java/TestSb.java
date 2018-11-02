/**
 * 描述：
 *
 * @author Create by lxn on 2018/10/30
 * @see
 * @since
 * @deprecated
 */
public class TestSb {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("1,2,");
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb.toString());
    }
}
