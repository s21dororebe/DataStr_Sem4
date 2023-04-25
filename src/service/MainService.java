package service;

import datastr.MyEdgeNode;
import datastr.MyGraph;
import datastr.MyVerticeNode;

import java.util.ArrayList;

public class MainService {
    public static void main(String[] args) throws Exception {
        MyGraph<String> map = new MyGraph<>();
        try {
            map.addVertice("Dallas"); //0
            map.addVertice("Washington"); //1
            map.addVertice("Austin"); //2
            map.addVertice("Denver"); //3
            map.addVertice("Atlanta"); //4
            map.addVertice("Houston"); //5
            map.addVertice("Chicago"); //6

            map.addEdge("Austin", "Dallas", 200);
            map.addEdge("Dallas", "Austin", 200);
            map.addEdge("Dallas", "Denver", 780);
            map.addEdge("Dallas", "Chicago", 900);
            map.addEdge("Chicago", "Denver", 1000);
            map.addEdge("Denver", "Chicago", 1000);
            map.addEdge("Austin", "Houston", 160);
            map.addEdge("Houston", "Atlanta", 800);
            map.addEdge("Atlanta", "Houston", 800);
            map.addEdge("Denver", "Atlanta", 1400);
            map.addEdge("Atlanta", "Washington", 600);
            map.addEdge("Washington", "Atlanta", 600);
            map.addEdge("Washington", "Dallas", 1300);

            map.print();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
