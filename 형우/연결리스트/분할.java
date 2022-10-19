public class 분할 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList = CustomLinkedList.of(3,5,8,5,10,2,1);
        CustomLinkedList separatedLinkedList = customLinkedList.separateByPivot(5);
        separatedLinkedList.print();
    }
}
