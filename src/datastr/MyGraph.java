package datastr;

public class MyGraph <T> {
    private MyVerticeNode[] graphElements;
    private final int DEFAULT_ARRAY_SIZE = 10;
    private int arraySize = DEFAULT_ARRAY_SIZE;
    private int elementCounter = 0;

    //no args constructor
    public MyGraph()
    {
        graphElements = new MyVerticeNode[arraySize];
    }
    //args constructor
    public MyGraph(int inputArraySize) {
        if(inputArraySize > 0) {
            arraySize = inputArraySize;
        }
        graphElements = new MyVerticeNode[arraySize];
    }

    /*
    public boolean isFull(){}
    public boolean isEmpty(){}
    public boolean addVertice(T newItem){}
    public boolean addEdge(T fromV, T toV, int weight){}
    public int indexIs(T item){}
    public int weightIs(T fromV, T toV){}
    public void printNeighbourVertices(T fromV){}
    public String toString(){}
    public void makeEmpty(){}
    //nevis izprintē, bet ievieto virsotni rindā un atgriež rindu
    public MyQueue saveNeighbourVertices(T fromV){}
    // atzīmē virsotni kā apmeklētu
    public void markVertex(T vertex){}
    // pārbauda, vai virsotne jau ir apmeklēta
    public boolean isMarked(T vertex){}
    public void clearMarks(){}
    // grafa apiešana ejot dziļumā, pēc nepieciešamības var izmantot savas iepriekš izveidotās MyStack un MyQueue klases
    public void printDepthFirst(T fromV, T toV){}
    // grafa apiešana ejot platumā, pēc nepieciešamības var izmantot savas iepriekš izveidotās MyStack un MyQueue klases
    public void printBreadthFirst(T fromV, T toV){}
    //īsākā ceļa atrašana no virsotnes fromV uz virsotni toV
    public void printShortestPath( T fromV, T toV){}
*/

}
