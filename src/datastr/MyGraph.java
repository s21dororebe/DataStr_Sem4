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

    private int searchVertice(T inputVertice){
        for(int i = 0; i < elementCounter; i++){
            if(graphElements[i].getElement().equals(inputVertice)){
                //return index of element
                return i;
            }
        }
        //return -1 if element is not there
        return -1;
    }

    public void addVertice(T inputElement) throws Exception {
        if(inputElement == null){
            throw (new Exception("Vertice is null"));
        }
        //verify if vertice is not already in graph
        /*for(int i = 0; i < elementCounter; i++){
            if(graphElements[i].getElement().equals(inputElement)){
                    throw (new Exception("Vertice is already in graph"));
            }
        }*/
        if(searchVertice(inputElement) > -1) {
            throw (new Exception("Vertice is already in graph"));
        }
        //verify if graph is not full
        if(isFull())
            increaseArray();
        graphElements[elementCounter++] = new MyVerticeNode<T>(inputElement);
    }
    public void addEdge(T elementFrom, T elementTo, int edgeWeight) throws Exception{
        if(elementFrom == null && elementTo == null && edgeWeight <= 0){
            throw (new Exception("Incorrect arguments"));
        }
        //verify if elementFrom and elementTo are real
        int indexFrom = searchVertice(elementFrom);
        int indexTo = searchVertice(elementTo);
        //TODO add vertice if it is not found in graph
        if(indexTo < 0 || indexFrom < 0)
            throw (new Exception("One or both vertices are not in graph"));

        MyEdgeNode newNode = new MyEdgeNode(indexTo, edgeWeight);
        //if it is as first edge
        if(graphElements[indexFrom].getFirstEdge()==null){
            graphElements[indexFrom].setFirstEdge(newNode);
        } else {
            MyEdgeNode temp = graphElements[indexFrom].getFirstEdge();
            while(temp.getNext()!=null)
                temp = temp.getNext();
            temp.setNext(newNode);
        }
    }
    public void printNeighbourVertices(T fromV) throws Exception{
        if(isEmpty()){
            throw (new Exception("Graph is empty"));
        }
        for(int i = 0; i < elementCounter; i++){
            System.out.print(graphElements[i].getElement() + " --> ");
            MyEdgeNode tempEdgeNode = graphElements[i].getFirstEdge();
            while(tempEdgeNode.getNext() != null){
                System.out.print(tempEdgeNode + " ");
                tempEdgeNode = tempEdgeNode.getNext();
            }
        }
    }
    public void makeEmpty(){}

    //TODO remove vertice
    //TODO remove edge
    //TODO changeEdge


}
