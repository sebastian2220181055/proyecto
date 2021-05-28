package Container;

public class Node<T>{

    private T info;
    private Node<T> next;
    private int index;


    public Node(T info, Node<T> next, int index) {
        setInfo(info);
        setNext(next);

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }


}
