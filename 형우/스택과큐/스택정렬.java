public class 스택정렬 {
    public static void main(String[] args) {
        CustomStack<Integer> customStack = new CustomStack<>();
        customStack.push(4);
        customStack.push(1);
        customStack.push(5);
        customStack.push(6);
        customStack.push(3);
        customStack.push(2);
        customStack.sort();

        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}
