package Challange1.Entity;
public interface Vehicle{
    Vehicletype gettype();
}

enum Vehicletype{
    CAR,BIKE,TRUCK
}

class Car implements Vehicle{
    public Vehicletype gettype(){
        return Vehicletype.CAR;
    }
}
class Bike implements Vehicle{
    public Vehicletype gettype(){
        return Vehicletype.BIKE;
    }
}
class Truck implements Vehicle{
    public Vehicletype gettype(){
        return Vehicletype.TRUCK;
    }
}
