public class CustomLinkedList<T> {
    Node<T> header;

    CustomLinkedList() {
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

    // runner 기법 활용 (시간 O(n^2), 공간 O(1))
    <T> void removeDup() {
        Node node = header;
        while (node != null && node.next != null) {
            Node runner = node;
            while (runner.next != null) {
                if (node.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            node = node.next;
        }
    }

    static <T> CustomLinkedList<T> of(T... datas) {
        if (datas.length == 0) {
            return new CustomLinkedList();
        }

        CustomLinkedList customLinkedList = new CustomLinkedList();
        for (T data : datas) {
            customLinkedList.add(data);
        }
        return customLinkedList;
    }
}

class Node<T> {
    T data;
    Node<T> next = null;
}