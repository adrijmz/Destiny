package Metro;

import java.util.List;

public class Station{

    private String name;
    private double latitude,length;
    private List<Integer> line;

    public Station(List<Integer> line , String name, double latitude, double length){
        this.name = name;
        this.latitude = latitude;
        this.length = length;
        this.line = line;
    }
    public List<Integer> getLine() {
        return line;
    }
    public void setLine(List<Integer> line) {
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
}