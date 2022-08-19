import java.util.Arrays;

public class Set<T> {

    protected int quantidade;
    protected Node<T> inicio;

    public void add(T e) {
        if (!this.contains(e)) {
            Node<T> novo = new Node<T>(e);
            novo.setNext(inicio);
            inicio = novo;
            this.quantidade++;
        }
    }

    public boolean contains(T e) {
        boolean r = false;
        Node<T> aux = inicio;
        while (aux != null) {
            if (e instanceof int[]) {
                if (Arrays.equals((int []) aux.getInfo(), (int[]) e)) {
                    r = true;
                    break;
                }
            } else if (aux.getInfo().equals(e)) {
                r = true;
                break;
            }
            aux = aux.getNext();
        }
        return r;
    }

    public T get(int i) {
        T r = null;
        int contador = 0;
        Node<T> aux = inicio;
        while (aux != null && contador <= i) {
            if (contador == i) {
                r = aux.getInfo();
                break;
            }
            aux = aux.getNext();
            contador++;

        }
        return r;
    }

    public void print() {
        for (int i = 0; i < this.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < ((int []) this.get(i)).length; j++) {
                System.out.print(j == ((int []) this.get(i)).length - 1 ? ((int []) this.get(i))[j] : ((int []) this.get(i))[j] + ",");
            }
            System.out.println("]");
        }
    }

    public int size() {
        return this.quantidade;
    }

    public String toString() {
        String r = "";
        for (Node<T> aux = inicio; aux != null; aux = aux.getNext()) {
            r += aux.getInfo() + " -> ";
        }
        r += "null";
        return r;
    }
}