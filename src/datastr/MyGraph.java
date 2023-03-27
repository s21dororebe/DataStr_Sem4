package datastr;

public class MyGraph <T> {
    private MyVerticeNode[] graphElements;
    private final int DEFAULT_ARRAY_SIZE = 10;
    private int arraySize = DEFAULT_ARRAY_SIZE;
    private int elementCounter = 0;

    public MyGraph()
    {
        graphElements = new MyVerticeNode[arraySize];
    }
    public MyGraph(int inputArraySize) {
        if(inputArraySize > 0) {
            arraySize = inputArraySize;
        }
        graphElements = new MyVerticeNode[arraySize];
    }

    public boolean isFull()
    {
        return (elementCounter == arraySize);
    }
    public boolean isEmpty()
    {
        return (elementCounter == 0);
    }
    public int howManyElements() {
        return elementCounter;
    }
    private void increaseArray() {
        int newArraySize = (arraySize > 100)? (int)(arraySize*1.5) : arraySize*2;
        MyVerticeNode[] newElements = new MyVerticeNode[arraySize];
        System.arraycopy(graphElements, 0, newElements, 0, arraySize);
        graphElements = newElements;
        arraySize = newArraySize;
    }

    public void addVertice(T inputElement) throws Exception {
        if(inputElement == null){
            throw (new Exception("Vertice is null"));
        }
        //verify if vertice is not already in graph
        for(int i = 0; i < elementCounter; i++){
            if(graphElements[i].getElement().equals(inputElement)){
                throw (new Exception("Vertice is already in graph"));
            }
        }
        //verify if graph is not full
        if(isFull())
            increaseArray();
        graphElements[elementCounter++] = new MyVerticeNode<T>(inputElement);
    }
    public boolean addEdge(T fromV, T toV, int weight){

    }
    public void printNeighbourVertices(T fromV){}
    public void makeEmpty(){}

    //TODO remove vertice
    //TODO remove edge
    //TODO changeEdge


}
