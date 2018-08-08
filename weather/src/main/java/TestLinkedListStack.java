/**
 * 描述：利用栈完成括号的匹配
 * 输入任意一组括号，判断括号是否匹配
 *  [{}] {[]} ([{}])([{}])
 *
 *  1.取出栈顶元素
 *  2.将当前元素与栈顶元素比较，如果匹配，栈顶元素出栈
 *  3.如果最后栈中没有元素，说明括号匹配
 */
public class TestLinkedListStack {
    public static void main(String[] args) {
        char[] chars = "([{}])]".toCharArray();
        LinkedListStack<Character> linkedListStack = new LinkedListStack<>();
        for (Character aChar : chars) {
            // 取出栈顶元素,可能为null
            Character top = linkedListStack.peek();
            if (matches(top,aChar)) {
                linkedListStack.pop();
            } else {
                linkedListStack.push(aChar);
            }
        }
        if (linkedListStack.isEmpty()) {
            System.out.println("括号匹配");
        } else {
            System.out.println("括号不匹配");
        }
    }

    // 判断当前元素和栈顶元素是否匹配
    private static boolean matches(Character c1,Character c2) {
        return c1 != null && c2 != null && (c1.equals('{') && c2.equals('}') || c1.equals('[') && c2.equals(']') || c1.equals('(') && c2.equals(')'));
    }
}
