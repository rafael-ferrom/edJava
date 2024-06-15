package edJava.lista;

public class ListaCircular {
    private Node head; // Cabeça da lista

    public ListaCircular() {
        this.head = null;
    }

    public void insert(int value) {
        Node new_node = new Node(value);
        if (this.head == null) {
            this.head = new_node;
            this.head.next = this.head; // Faz o nó apontar para si mesmo
        } else {
            Node current = this.head;
            while (current.next != this.head) {
                current = current.next;
            }
            current.next = new_node;
            new_node.next = this.head; // Completa o círculo apontando para a cabeça da lista
        }
    }

    public boolean remove(int value) {
        if (this.head == null) {
            return false; // Lista vazia
        }

        Node current = this.head;
        Node prev = null;
        do {
            if (current.value == value) {
                if (prev != null) {
                    prev.next = current.next;
                    if (current == this.head) { // Se estiver removendo a cabeça
                        this.head = current.next;
                    }
                } else {
                    // Se a lista tiver apenas um nó
                    if (current.next == this.head) {
                        this.head = null;
                    } else {
                        this.head = current.next;
                        prev = this.head;
                        while (prev.next != current) {
                            prev = prev.next;
                        }
                        prev.next = this.head;
                    }
                }
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != this.head);
        
        return false; // Dado não encontrado
    }

    public void display() {
        if (this.head == null) {
            System.out.println("A lista está vazia");
            return;
        }
        Node current = this.head;
        do {
            System.out.print(current.value + " -> ");
            current = current.next;
        } while (current != this.head);
        System.out.println("(volta para o início)");
    }
}