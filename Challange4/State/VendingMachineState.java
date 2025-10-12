package Challange4.State;

import Challange4.Entity.Interfaces.Coin;

public interface VendingMachineState {
    void selectItem(String itemName);
    void insertCoin(Coin coin);
    void cancelTransaction();
    void despenseItem();
    String getStateName();
}
