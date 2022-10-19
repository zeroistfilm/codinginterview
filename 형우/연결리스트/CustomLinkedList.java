public class CustomLinkedList<T> {
    Node<T> header;

    CustomLinkedList() {
        header = new Node();
    }

    CustomLinkedList(Node<T> header) {
        this.header = header;
    }

    void add(T data) {
        Node<T> end = new Node();
        end.data = data;
        Node node = header;
        while (node.next != null) {
            node = node.next;
        }
        node.next = end;
    }

    void remove(T data) {
        Node node = header;
        while (node.next != null) {
            if (node.next.data == data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    void print() {
        Node node = header.next;
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    // runner 기법 활용 (시간 O(n^2), 공간 O(1))
    void removeDup() {
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

    // 임시 버퍼 쓰지않고 구현해보기
    CustomLinkedList<T> separateByPivot(T pivot) {
        Node start = header.next, end = header.next;
        Node node = header.next;
        while (node != null) {
            Node next = node.next;
            if ((int) node.data < (int) pivot) { // todo : integer verify
                node.next = start;
                start = node;
            } else {
                end.next = node;
                end = node;
            }
            node = next;
        }
        end.next = null;

        Node newHeader = new Node();
        newHeader.next = start;
        this.header = newHeader;
        return (CustomLinkedList<T>) this;
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

    class Node<T> {
        T data;
        Node<T> next = null;
    }
}
