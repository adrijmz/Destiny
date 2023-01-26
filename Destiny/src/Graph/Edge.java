package Graph;

public class Edge{

    private Node n1,n2;
    private double distance;

    public Edge(Node n1, Node n2, double distance){
        this.n1=n1;
        this.n2=n2;
        this.distance=distance;
    }

    public Node getN1() {
        return n1;
    }

    public void setN1(Node n1) {
        this.n1 = n1;
    }

    public Node getN2() {
        return n2;
    }

    public void setN2(Node n2) {
        this.n2 = n2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}