package Graph;

import java.util.List;

import Metro.Station;

public class Node {
    
    private Station station;
    private List<Edge> edges;
    private double g,h;
    private Edge actual;
    
    public Node(Station station, List<Edge> edges){
        this.station=station;
        this.edges=edges;
        g = 0;
        h = 0;
    }
    
    public Edge getActual() {
        return actual;
    }
    
    public void setActual(Edge actual) {
        this.actual = actual;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

}
