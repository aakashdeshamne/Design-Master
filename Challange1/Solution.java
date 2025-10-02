package Challange1;

import java.util.Arrays;
import java.util.List;

import Challange1.Entity.ParkingFloor;
import Challange1.Entity.ParkingLot;
import Challange1.Entity.ParkingSpot;
import Challange1.Entity.Ticket;
import Challange1.Entity.Vehicle;

public class Solution {

    public static void main(String[] args) {
        List<ParkingSpot>spots=Arrays.asList(new BikeSpot("B1"),new CarSpot("C1"),new TruckSpot("T1"));
        ParkingFloor floor1=new ParkingFloor("F1",spots);
        ParkingLot lot=new ParkingLot(Arrays.asList(floor1));
        Vehicle bike=new Bike();
        ParkingSpot spot=lot.findSpot(bike);
        if(spot!=null){
            spot.park(bike);
            System.out.println("Parked at spot");
            Ticket ticket=new Ticket("T1",bike,spot);
            //consider time is passed and you are departing
            ticket.departure();
            System.out.println("Parking fee: "+ticket.getParkingFee());
        }
    }
}
