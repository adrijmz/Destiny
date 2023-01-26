package Metro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;

public class Metro {

    private final int R = 6378;
    private Graph graph;
    
    String path;
    
    public Metro(){
        this.graph = new Graph();
        this.path = new File("").getAbsolutePath();
        initNodes();
        initEdges();
    }
    
    public Graph getGraph() {
        return graph;
    }

    public void initNodes(){
        try {
            FileReader fileReader = new FileReader(path+"/src/Metro/Locations.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line;
            String[] arr;
    
            Station station;
            Node node;
            while((line=bufferedReader.readLine())!=null){
                arr = line.split(",");
                String lines = arr[0];
                List<Integer> myLines = new ArrayList<>();
                for(Character c : lines.toCharArray())
                    myLines.add(Character.getNumericValue(c));

                station = new Station(myLines,arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]));
                node = new Node(station, new ArrayList<>());
                graph.addNode(node);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initEdges(){
        try {
            FileReader fileReader = new FileReader(path+"/src/Metro/Locations.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line;
            String[] arr;
    
            List<Edge> list;
            Node node1, node2;
            Edge edge = null;
            
            while((line=bufferedReader.readLine())!=null){
                arr = line.split(",");
                if(arr.length>4){
                    list = new ArrayList<>();
                    node1 = graph.getNode(arr[1]);
                    for(int i=4; i<arr.length; i++){
                        node2 = graph.getNode(arr[i]);
                        edge = new Edge(node1, node2, calculaDistance(node1, node2));
                        list.add(edge);
                        node1.setEdges(list);
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print(){
        for(Node n : graph.getList()){
            for(Edge e : n.getEdges()){
                System.err.println("distance between n1:"
                +e.getN1().getStation().getName()+" and n2:"+e.getN2().getStation().getName()+" is "
                +e.getDistance()+"km");
            }
        }
    }

    public double calculaDistance(Node node1, Node node2){
        double lat1 = node1.getStation().getLatitude();
        double lat2 = node2.getStation().getLatitude();
        double len1 = node1.getStation().getLength();
        double len2 = node2.getStation().getLength();

        double difLat = (lat2 -  lat1)*(Math.PI/180);
        double difLen = (len2 - len1)*(Math.PI/180);
        double a = Math.pow(Math.sin(difLat/2),2) + Math.cos(lat1*(Math.PI/180)) * 
            Math.cos(lat2*(Math.PI/180)) * Math.pow(Math.sin(difLen/2),2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

    public void sortList(List<Node> list){
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Double.compare(n1.getG()+n1.getH(), n2.getG()+n2.getH());
            }
        });
    }
}
