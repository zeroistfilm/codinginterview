package chapter2;

public class DivideList {

    public boolean checkValid(Node node, int divideInt) {

        while (node != null && node.data < divideInt) {
            node = node.next;
        }

        while (node!= null && node.data >= divideInt) {
            node = node.next;
        }

        if (node != null) {
            return false;
        }

        return true;
    }

    public Node divideList(Node node, int divideInt){

        Node leftHead = new Node(0);
        Node rightHead = new Node(0);

        while(node != null) {
            if (node.data < divideInt) {
                leftHead.appendToTail(node.data);
            } else {
                rightHead.appendToTail(node.data);
            }
            node = node.next;
        }
        Node leftTail = leftHead.getTail();
        leftTail.next = rightHead.next;
        Node answer = leftHead.next;
        leftHead.next = null;
        rightHead.next = null;
        return answer;
    }
}
