// Classe para a árvore binária de busca
public class BinaryTree {
    NodeTree root;

    public BinaryTree() {
        root = null;
    }

    // Método para inserir um novo valor na árvore
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Método recursivo para inserir um novo valor
    private NodeTree insertRec(NodeTree root, int key) {
        if (root == null) {
            root = new NodeTree(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Método para buscar um valor na árvore
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Método recursivo para buscar um valor
    private boolean searchRec(NodeTree root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.key) {
            return true;
        }
        if(key < root.key )
        {
            return searchRec(root.left, key);
        }
        else{
            return searchRec(root.right, key);
        }
    }

    // Método para percorrer a árvore em ordem
    public void inorder() {
        inorderRec(root);
    }

    // Método recursivo para percorrer a árvore em ordem
    private void inorderRec(NodeTree root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }



     public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Exemplo de inserção de valores na árvore
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);

        // Exibir todos os elementos da árvore em ordem crescente
        System.out.println("A raiz da árvore e: "+tree);
     
    }
}
