package Challange1.Entity;
import java.util.List;
public class ParkingLot {
    private List<ParkingFloor>parkingFloors;
    public ParkingLot(List<ParkingFloor> parkingFloors){
        this.parkingFloors=parkingFloors;
    }

    public ParkingSpot findSpot(Vehicle c){
        return 
            parkingFloors.stream()
            .map(floor->floor.getAvailableParkingSpot(c))
            .filter(spot->spot!=null)
            .findFirst()
            .orElse(null);
    }
    
}
