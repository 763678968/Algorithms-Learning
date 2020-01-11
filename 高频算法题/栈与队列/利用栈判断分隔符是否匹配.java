class Solution {
    public static boolean isMatch(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (!stack.isEmpty()) {
                        char c = stack.pop();
                        if (ch == ')' && c != '('
                                || ch == ']' && c != '['
                                || ch == '}' && c != '{') {
                            return false;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "(1123<>)"; // true
        String str1 = "()[]{)"; // false
        String str2 = "([)]"; // false
        System.out.println(isMatch(str));
    }
}