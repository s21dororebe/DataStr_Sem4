package datastr;

public class MyVerticeNode <T> {
    private T element;
    private MyEdgeNode firstEdge = null;

    //GETTERS & SETTERS
    public T getElement() {
        return element;
    }
    public void setElement(T inputElement) {
        if(inputElement != null){
            element = inputElement;
        } else {
            element = (T) new Object();
        }
    }

    public MyEdgeNode getFirstEdge() {
        return firstEdge;
    }
    public void setFirstEdge(MyEdgeNode firstEdge) {
        this.firstEdge = firstEdge;
    }

    //CONSTRUCTOR + TOSTRING
    public MyVerticeNode(T inputElement){
        setElement(inputElement);
    }
    @Override
    public String toString() {
        return "" + element;
    }
    //OTHER FUNCTIONS
}
