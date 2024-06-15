package edJava.lista;

public class ListaDuplamenteLigada {
    private Node head; // Cabeça da lista
    private Node tail; // Cauda da lista

    public ListaDuplamenteLigada() {
        this.head = null;
        this.tail = null;
    }

    public void append(int value) {
        Node new_node = new Node(value);
        if (this.tail == null) { // Se a lista está vazia
            this.head = this.tail = new_node;
        } else {
            this.tail.next = new_node;
            new_node.prev = this.tail;
            this.tail = new_node;
        }
    }

    public void prepend(int value) {
        Node new_node = new Node(value);
        if (this.head == null) { // Se a lista está vazia
            this.head = this.tail = new_node;
        } else {
            new_node.next = this.head;
            this.head.prev = new_node;
            this.head = new_node;
        }
    }

    public void display() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.value + (current.next != null ? " <-> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public boolean remove(int value) {
        Node current = this.head;
        while (current != null) {
            if (current.value == value) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    this.head = current.next; // Atualizar a cabeça da lista
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    this.tail = current.prev; // Atualizar a cauda da lista
                }
                return true; // Nó encontrado e removido
            }
            current = current.next;
        }
        return false; // Nó não encontrado
    }
}