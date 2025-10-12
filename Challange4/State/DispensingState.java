package Challange4.State;

import Challange4.VendingMachine;
import Challange4.Entity.Interfaces.Coin;
import Challange4.Entity.Interfaces.Item;

public class DispensingState implements VendingMachineState{
    private VendingMachine vendingMachine;
    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(String itemName) {
        System.out.println("Item selection is not allowed while dispensing.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Coin insertion is not allowed while dispensing.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Cancellation is not allowed while dispensing.");
    }

    @Override
    public void despenseItem() {
        Item selectedItem = vendingMachine.getSelectedItem();
        double insertedAmount = vendingMachine.getInsertedAmount();
        double itemPrice = selectedItem.getPrice();
        double changeAmount = insertedAmount - itemPrice;
        // Dispense the item
        System.out.println("Despensing: "+selectedItem.getName());
        selectedItem.setQuantity(selectedItem.getQuantity() - 1);
        // Handle change
        if(changeAmount>0){
            if(vendingMachine.canMakeChange(changeAmount)){
                System.out.println("Returning change: $"+String.format("%.2f",changeAmount));
            }
            else{
                System.out.println("Sorry, exact change required!");
                // In this case, you might want to return the item and refund
                selectedItem.setQuantity(selectedItem.getQuantity() + 1);
                System.out.println("Refunding: $"+String.format("%.2f",insertedAmount));
                vendingMachine.resetInsertedAmount();
                vendingMachine.setSelectedItem(null);
                vendingMachine.setState(new IdealState(vendingMachine));
            }
        }
        // Reset for next transaction
        vendingMachine.resetInsertedAmount();
        vendingMachine.setSelectedItem(null);
        vendingMachine.setState(new IdealState(vendingMachine));
    }

    @Override
    public String getStateName() {
        return "DispensingState";
    }
    
}
