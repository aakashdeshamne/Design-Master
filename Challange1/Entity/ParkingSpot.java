package Challange1.Entity;

public abstract class ParkingSpot {
    private String id;
    private boolean isFree;
    private Vehicle currentVehicle;
    public ParkingSpot(String id){
        this.id=id;
    }
    public boolean isFree(){
        return isFree;
    }
    public void park(Vehicle v){
        this.currentVehicle=v;
        this.isFree=false;
    }
    public void unpark(){
        this.currentVehicle=null;
        this.isFree=true;
    }
    public abstract boolean canFitVehicle(Vehicle v);    
}
class BikeSpot extends ParkingSpot{
    public BikeSpot(String id){
        super(id);
    }
    @Override
    public boolean canFitVehicle(Vehicle v) {
        return v.gettype()==Vehicletype.BIKE;
    } 
}
class CarSpot extends ParkingSpot{
    public CarSpot(String id){
        super(id);
    }
    @Override
    public boolean canFitVehicle(Vehicle v) {
        return v.gettype()==Vehicletype.CAR||v.gettype()==Vehicletype.BIKE;
    } 
}
class TruckSpot extends ParkingSpot{
    public TruckSpot(String id){
        super(id);
    }
    @Override
    public boolean canFitVehicle(Vehicle v) {
        return v.gettype()==Vehicletype.TRUCK||v.gettype()==Vehicletype.CAR||v.gettype()==Vehicletype.BIKE;
    } 
}


