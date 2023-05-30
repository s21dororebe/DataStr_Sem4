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
        graphElements[elementCounter++] = new MyVerticeNode<>(inputElement);
    }

    public void addEdge(T elementFrom, T elementTo, int edgeWeight) throws Exception {
        // Verify if elementFrom and elementTo are real
        int indexFrom = searchVertice(elementFrom);
        int indexTo = searchVertice(elementTo);

        // If vertices do not exist, create them
        if (indexTo < 0) {
            addVertice(elementTo);
            indexTo = elementCounter - 1; // Get the newly added vertex index
        }
        if (indexFrom < 0) {
            addVertice(elementFrom);
            indexFrom = elementCounter - 1; // Get the newly added vertex index
        }

        // Check if this edge already exists
        MyEdgeNode pointer = graphElements[indexFrom].getFirstEdge();
        while (pointer != null) {
            if (pointer.getIndexOfVertice() == indexTo) {
                throw new Exception("This edge already exists");
            }
            pointer = pointer.getNext();
        }

        MyEdgeNode newNode = new MyEdgeNode(indexTo, edgeWeight);
        // If it is the first edge
        if (graphElements[indexFrom].getFirstEdge() == null) {
            graphElements[indexFrom].setFirstEdge(newNode);
        } else {
            MyEdgeNode temp = graphElements[indexFrom].getFirstEdge();
            while (temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(newNode);
        }
    }

    public void print() throws Exception{
        if(isEmpty()){
            throw (new Exception("Graph is empty"));
        }
        for(int i = 0; i < elementCounter; i++){
            System.out.print(graphElements[i].getElement() + " --> ");
            MyEdgeNode tempEdgeNode = graphElements[i].getFirstEdge();
            while(tempEdgeNode != null){
                T verticeTo = (T) graphElements[tempEdgeNode.getIndexOfVertice()].getElement();
                System.out.print(verticeTo + " (" + tempEdgeNode.getWeight()+ " km); ");
                tempEdgeNode = tempEdgeNode.getNext();
            }
            System.out.println();
        }
    }
    public void makeEmpty(){
        if(!isEmpty()){
            arraySize = DEFAULT_ARRAY_SIZE;
            graphElements = new MyVerticeNode[arraySize];
            elementCounter = 0;
        }
    }

    public void removeVertice(T vertice) throws Exception{
        //check if the vertice exists in the graph
        if(searchVertice(vertice) >= 0){
            //if exists
            int removeIndex = searchVertice(vertice);
            //creating new graph massive
            MyVerticeNode[] graphElementsNew = new MyVerticeNode[arraySize];
            int indexNewGraph = 0;
            //for loop to copy all of the element except the vertice we want to remove
            for(int i = 0; i < arraySize; i++){
                if(i != removeIndex){
                    graphElementsNew[indexNewGraph++] = graphElements[i];
                }
            }
            //linking new graph for the existing one
            graphElements = graphElementsNew;
            //minus one because we removed one vertice
            elementCounter--;
        } else throw (new Exception("The vertice you want to remove does not exist in the graph"));
    }

    //TODO test update vertice
    public void updateVertice(T vertice, T inputElement) throws Exception {
        //check if the vertice exists
        if(searchVertice(vertice) >= 0){
            //check the inputElement -> it is checked in the MyVerticeNode class
            graphElements[searchVertice(vertice)].setElement(inputElement);
        } else throw (new Exception("The vertice you want to remove does not exist in the graph"));
    }
    public boolean removeEdge(T elementFrom, T elementTo) throws Exception {
        if (elementFrom == null && elementTo == null) {
            throw new Exception("Incorrect arguments");
        }
        // Verify if elementFrom and elementTo are real
        int indexFrom = searchVertice(elementFrom);
        int indexTo = searchVertice(elementTo);

        // Check if both vertices exist in the graph
        if (indexFrom < 0 || indexTo < 0) {
            return false; // At least one vertex does not exist
        }

        MyEdgeNode pointer = graphElements[indexFrom].getFirstEdge();
        MyEdgeNode prevPointer = null;

        while (pointer != null) {
            if (pointer.getIndexOfVertice() == indexTo) {
                if (prevPointer == null) {
                    // If the edge to remove is the first edge
                    graphElements[indexFrom].setFirstEdge(pointer.getNext());
                } else {
                    // If the edge to remove is not the first edge
                    prevPointer.setNext(pointer.getNext());
                }
                return true;
            }
            prevPointer = pointer;
            pointer = pointer.getNext();
        }

        return false; // Edge not found
    }

    public boolean updateEdgeWeight(T elementFrom, T elementTo, int inputWeight) throws Exception {
        if (elementFrom == null && elementTo == null && inputWeight <= 0) {
            throw new Exception("Incorrect arguments");
        }
        // Verify if elementFrom and elementTo are real
        int indexFrom = searchVertice(elementFrom);
        int indexTo = searchVertice(elementTo);

        // Check if both vertices exist in the graph
        if (indexFrom < 0 || indexTo < 0) {
            return false; // At least one vertex does not exist
        }

        MyEdgeNode pointer = graphElements[indexFrom].getFirstEdge();

        while (pointer != null) {
            if (pointer.getIndexOfVertice() == indexTo) {
                pointer.setWeight(inputWeight);
                return true;
            }
            pointer = pointer.getNext();
        }

        return false; // Edge not found
    }


}
