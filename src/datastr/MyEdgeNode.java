package datastr;

public class MyEdgeNode {
    private int indexOfVertice;
    private float weight; //piemeram, kilometri
    private MyEdgeNode next = null;
    //GETTERS & SETTERS
    public int getIndexOfVertice() {
        return indexOfVertice;
    }
    public void setIndexOfVertice(int inputIndexOfVertice) {
        if(inputIndexOfVertice >= 0){
            indexOfVertice = inputIndexOfVertice;
        } else {
            indexOfVertice = -1;
        }
    }

    public float getWeight() {
        return weight;
    }
    public void setWeight(float inputWeight) {
        if(inputWeight > 0 && inputWeight < 43000){
            weight = inputWeight;
        } else {
            weight = 0;
        }
    }

    public MyEdgeNode getNext() {
        return next;
    }
    public void setNext(MyEdgeNode next) {
        this.next = next;
    }
    //CONSTRUCTOR + TOSTRING
    public MyEdgeNode(int inputIndexOfVertice, float inputWeight){
        setIndexOfVertice(inputIndexOfVertice);
        setWeight(inputWeight);
    }
    @Override
    public String toString() {
        return "" + weight;
    }
}
