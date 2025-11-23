package Challange5.Controller;

import java.util.LinkedList;
import java.util.Queue;

import Challange5.Entity.Direction;
import Challange5.Entity.Elevator;
import Challange5.Entity.ExternalRequest;
import Challange5.Entity.InternalRequest;
import Challange5.Entity.Request;

public class ElevatorController {
    private Elevator elevator;
    private Queue<Request> requestQueue;
    public ElevatorController(Elevator elevator, Queue<Request> requestQueue) {
        this.elevator = elevator;
        this.requestQueue = new LinkedList<>();
    }
    public void callElevator(int floor,Direction direction){
        ExternalRequest request=new ExternalRequest(floor,direction);
        requestQueue.add(request);
        System.out.println("External request added for floor: "+floor+" direction: "+direction);
        processRequests();
    }
    public void selectFloor(int floor){
        InternalRequest request=new InternalRequest(floor);
        requestQueue.add(request);
        System.out.println("Internal request added for floor: "+floor);
        processRequests();
    }
    public void processRequests(){
        while(!requestQueue.isEmpty()){
            Request request=requestQueue.poll();
            int targetFloor=request.getFloor();
            System.out.println("Processing request for floor: "+targetFloor);
            elevator.addDestination(targetFloor);
            elevator.move(targetFloor);
        }
    }
    public void status(){
        elevator.displayStatus();
        System.out.println("Pending requests: "+requestQueue.size());
    }
}
