package Metro;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Graph.Edge;
import Graph.Node;

public class Astar {

    private Metro metro;
    private Stack<Node> stack;

    public Astar(Metro metro){
        this.metro = metro;
    }
    
    public Stack<Node> getSortestPath(String s1, String s2){

        Node n1=null, n2=null, c=null, n=null;
        List<Node> openList = new ArrayList<>(), closedList = new ArrayList<>();

        for(Node node : metro.getGraph().getList()){
            if(node.getStation().getName().equals(s1)) n1 = node;
            else if(node.getStation().getName().equals(s2)) n2 = node;
        }

        c = n1;
        c.setG(0);
        c.setH(metro.calculaDistance(c, n2));
        
        closedList.add(c);

        while(!c.getStation().getName().equals(n2.getStation().getName())){
            for(Edge edge : c.getEdges()){
                Node aux = edge.getN2();

                if(closedList.contains(aux)) continue;
               
                if(openList.contains(aux) && c.getG() + edge.getDistance()<c.getG()){
                    aux.setActual(edge);
                    c.setG(c.getG() + edge.getDistance());
                }
                else{
                    aux.setActual(edge);
                    aux.setG(c.getG() + edge.getDistance());
                    aux.setH(metro.calculaDistance(c, n2)); 
                    openList.add(aux);
                }
            }

            metro.sortList(openList);
            c = openList.remove(0);
            closedList.add(c);
        }

        stack = new Stack<>();
        n = closedList.get(closedList.size()-1);

        while(n.getActual()!=null){
            stack.push(n);
            n = n.getActual().getN1();
        }
        stack.push(n);
        return stack;
    }
}
