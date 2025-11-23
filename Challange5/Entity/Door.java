package Challange5.Entity;

public class Door {
    private DoorState state;
    private static int DOOR_OPERATION_TIME=2;
    public Door(){
        this.state=DoorState.CLOSED;
    }
    public DoorState getState() {
        return state;
    }
    public void open(){
        if(state==DoorState.CLOSED){
            state=DoorState.OPENING;
            simulateMovement("opening");
            state=DoorState.OPEN;
            System.out.println("Door is Opened.");
        }
    }
    public void close(){
        if(state==DoorState.OPEN){
            state=DoorState.CLOSING;
            simulateMovement("closing");
            state=DoorState.CLOSED;
            System.out.println("Door is Closed.");
        }
    }
    public boolean isClosed(){
        return state==DoorState.CLOSED;
    }
    public boolean isOpen(){
        return state==DoorState.OPEN;
    }

    public void simulateMovement(String operation){
        System.out.println("Door is "+operation+"...");
        try {
            Thread.sleep(DOOR_OPERATION_TIME * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
