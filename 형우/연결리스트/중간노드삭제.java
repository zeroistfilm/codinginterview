public class 중간노드삭제 {
    // 중간 노드 삭제
    public static void main(String[] args) {
        LinkedListCustom linkedList = new LinkedListCustom();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.remove("c");
        linkedList.print();
    }
}

class LinkedListCustom<T> {
    Node<T> header;

    LinkedListCustom() {
        header = new Node();
    }

    <T> void add(T data) {
        Node<T> end = new Node();
        end.data = data;
        Node node = header;
        while (node.next != null) {
            node = node.next;
        }
        node.next = end;
    }

    <T> void remove(T data) {
        Node node = header;
        while (node.next != null) {
            if (node.next.data == data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    <T> void print() {
        Node node = header.next;
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }
}

class Node<T> {
    T data;
    Node<T> next = null;
}