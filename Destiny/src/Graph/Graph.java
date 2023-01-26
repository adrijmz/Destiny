package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;

    public Graph(){
        this.nodes = new ArrayList<>();
    }

    public Node getNode(String name){
        for(Node node : nodes){
            if(node.getStation().getName().equals(name)) return node;
        }
        return null;
    }
    
    public void addNode(Node node){
        nodes.add(node);
    }

    public List<Node> getList(){
        return nodes;
    }

    public String[] getNames(){
        String[] toReturn = new String[nodes.size()];

        for(int i=0; i<nodes.size(); i++){
            toReturn[i] = nodes.get(i).getStation().getName();
        }

        return toReturn;
    }

    public void clearNodes(){
        for(Node n : nodes){
            n.setG(0);
            n.setH(0);
            n.setActual(null);
        }
    }

}
