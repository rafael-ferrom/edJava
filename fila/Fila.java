package edJava.fila;

public class Fila {
    private Node first;
    private Node last;

    public Fila() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public Integer peek() {
        if (!isEmpty()) {
            return this.first.value;
        }
        return null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (this.last == null) {
            this.first = this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        Node removedNode = this.first;
        this.first = this.first.next;
        if (this.first == null) {
            this.last = null;
        }
        return removedNode.value;
    }

    public int size() {
        Node current = this.first;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}