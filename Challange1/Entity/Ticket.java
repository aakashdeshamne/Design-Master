package Challange1.Entity;

public class Ticket {
    private String id;
    private long issueTime;
    private long DepartureTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    public Ticket(String id,Vehicle vehicle,ParkingSpot parkingSpot){
        this.id=id;
        this.issueTime=System.currentTimeMillis();
        this.vehicle=vehicle;
        this.parkingSpot=parkingSpot;
    }
    public void departure(){
        this.DepartureTime=System.currentTimeMillis();
        this.parkingSpot.unpark();
    }
    public int getParkingFee(){
        //rate per hour
        long duration=(DepartureTime-issueTime)/(1000*60*60);
        int rate=0;
        switch(vehicle.gettype()){
            case BIKE:
                rate=10;
                break;
            case CAR:
                rate=20;
                break;  
            case TRUCK:
                rate=30;
                break;
            default:
                rate=0;
                break;
         }
        return (int)duration*rate;
    }
}
