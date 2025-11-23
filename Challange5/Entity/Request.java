package Challange5.Entity;

public abstract class Request {
    private int floor;
    public Request(int floor){
        this.floor=floor;
    }
    public int getFloor() {
        return floor;
    }
    public abstract RequestType getType();
}
