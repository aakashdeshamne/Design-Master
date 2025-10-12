package Challange4.State;

import Challange4.Entity.Interfaces.Coin;
import Challange4.VendingMachine;

public class IdealState implements VendingMachineState{

    public VendingMachine vendingMachine;
    public IdealState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectItem(String itemName) {
        if(vendingMachine.isItemAvailable(itemName)){
            var item=vendingMachine.getItem(itemName);
            vendingMachine.setSelectedItem(item);
            System.out.println("Selected: "+item.getName()+" - $"+item.getPrice());
            vendingMachine.setState(new PaymentState(vendingMachine));
        }
        else{
            System.out.println("Item not available or out of stock!");
        }
    }
    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select an item first");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("No transaction to cancel.");
    }

    @Override
    public void despenseItem() {
       System.out.println("Please select an item first!");
    }

    @Override
    public String getStateName() {
        return "IdealState";
    } 
}
