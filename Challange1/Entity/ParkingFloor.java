package Challange1.Entity;

import java.util.List;

public class ParkingFloor {
    private String id;
    private List<ParkingSpot> parkingSpots;
    public ParkingFloor(String id,List<ParkingSpot> parkingSpots){
        this.id=id;
        this.parkingSpots=parkingSpots;
    } 
    public ParkingSpot getAvailableParkingSpot(Vehicle v){
        return 
          parkingSpots.stream()
          .filter(spot->spot.isFree()&&spot.canFitVehicle(v))
          .findFirst()
          .orElse(null);
    }
}
