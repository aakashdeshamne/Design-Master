package Challange5.Entity;

import java.util.HashSet;
import java.util.Set;

public class Elevator {
    private int currentFloor;
    private Direction direction;
    private ElevaterState state;
    private Door door;
    private static final int TOTAL_FLOORS = 10;
    private Set<Integer>destinationFloors;
    public Elevator(){
        this.currentFloor=0;
        this.direction=Direction.IDLE;
        this.state=ElevaterState.IDLE;
        this.door=new Door();
        this.destinationFloors=new HashSet<>();
    }
    public void addDestination(int floor){
        if(floor>=0 && floor<TOTAL_FLOORS && floor!=currentFloor){
            destinationFloors.add(floor);
            System.out.println("Added destination floor: "+floor);
        }
    }
    public void removeDestination(int floor){
        destinationFloors.remove(floor);
    }
    public void move(int targetFloor){
        if(!door.isClosed()){
            System.out.println("Cannot move. Door is not closed.");
            return;
        }
        if(targetFloor==currentFloor){
            arriveAtFloor();
            return;
        }
        direction=targetFloor>currentFloor?Direction.UP:Direction.DOWN;
        state=direction==Direction.UP?ElevaterState.MOVING_UP:ElevaterState.MOVING_DOWN;
        System.out.println("Elevator is moving "+direction);
        while(currentFloor!=targetFloor){
            if(direction==Direction.UP){
                currentFloor++;
            }
            else{
                currentFloor--;
            }
            System.out.println("Current floor: "+currentFloor);
            if(destinationFloors.contains(currentFloor)){
                arriveAtFloor();
                destinationFloors.remove(currentFloor);
                if(currentFloor==targetFloor){
                    break;
                }
            }
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        if(currentFloor==targetFloor){
            arriveAtFloor();
            destinationFloors.remove(currentFloor);
        }
    }
    private void arriveAtFloor() {
        state=ElevaterState.IDLE;
        System.out.println("Arrived at floor: "+currentFloor);
        door.open();
        try{
            Thread.sleep(3000);;
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        state=ElevaterState.DOOR_CLOSED;
        door.close();
        if(destinationFloors.isEmpty()){
            direction=Direction.IDLE;
            state=ElevaterState.IDLE;
        }
    }
    public boolean hasDestinations(){
        return !destinationFloors.isEmpty();
    }
    public void displayStatus(){
        System.out.println("Current Floor: "+currentFloor);
        System.out.println("Direction: "+direction);
        System.out.println("State: "+state);
        System.out.println("Door State: "+door.getState());
        System.out.println("Destination Floors: "+destinationFloors);
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public Direction getDirection() {
        return direction;
    }
    public ElevaterState getState() {
        return state;
    }
    public Door getDoor() {
        return door;
    }
    public Set<Integer> getDestinationFloors() {
        return destinationFloors;
    }
}
