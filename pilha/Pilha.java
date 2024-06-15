package edJava.pilha;

public class Pilha {
    private Node top;

    public Pilha() {
        this.top = null;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return top.value;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        Node removedNode = top;
        top = top.next;
        return removedNode.value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}