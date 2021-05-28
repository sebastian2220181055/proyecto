package Container;

public class LinkedQueue<T>  {

    private Node<T> top = null;
    private Node<T> tail = null;
    private int index= 0;
    private int size = 0;




    public LinkedQueue(){
        top = null;
        tail = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public int size() {
        return size;
    }
    public T front() {
        if (isEmpty()){
            return null;
        } else {
            return top.getInfo();
        }
    }

    public void enqueue (T info){

        Node<T> temp = new Node<>(info, null, index);
        if (isEmpty()){
            top = temp;
        } else{
            tail.setNext(temp);
        }
        tail = temp;
        index++;
        size++;
    }


    public T dequeue(int index){

        Node<T> temp = top;
        T info = null;

        if (isEmpty()){
            return null;
        }
        for (int i = 0; i < size; i++){
            if (temp.getIndex() == index) {
                info = temp.getInfo();
                return info;
            }
            temp = temp.getNext();
            }
        return info;
        }

    public Node<T> getTop() {
        return top;
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
