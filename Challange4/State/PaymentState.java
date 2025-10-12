package Challange4.State;

import Challange4.VendingMachine;
import Challange4.Entity.Interfaces.Coin;

public class PaymentState implements VendingMachineState{
    public VendingMachine vendingMachine;

    public PaymentState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(String itemName) {
        System.out.println("Transaction in progress. Please insert coins or cancel.");
    }

    @Override
    public void insertCoin(Coin coin) {
        double coinValue=coin.getValue()/100.0;
        vendingMachine.addInsertedAmount(coinValue);
        vendingMachine.addCoinToBank(coin);
        System.out.printf("Inserted: $%.2f%n", coinValue);
        vendingMachine.displayInsertedAmount();
        if(vendingMachine.getInsertedAmount()>=vendingMachine.getSelectedItem().getPrice()){
            System.out.println("Sufficient amount inserted. Dispensing item...");
            vendingMachine.setState(new DispensingState(vendingMachine));
            vendingMachine.dispenseItem();
        }
        else{
            double needed=vendingMachine.getSelectedItem().getPrice()-vendingMachine.getInsertedAmount();
            System.out.printf("Please insert $%.2f more%n",needed); 
        }
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Transaction cancelled. Returning money...");
        double refundAmount=vendingMachine.getInsertedAmount();
        if(refundAmount>0){
            System.out.printf("Refunded: $%.2f%n",refundAmount);
        }
        vendingMachine.resetInsertedAmount();
        vendingMachine.setSelectedItem(null);
        vendingMachine.setState(new IdealState(vendingMachine));
    }

    @Override
    public void despenseItem() {
        System.out.println("Please insert sufficient money first!");
    }

    @Override
    public String getStateName() {
        return "PaymentState";
    }
    
}
