package Challange4;

import Challange4.Entity.Beverages;
import Challange4.Entity.Chocklet;
import Challange4.Entity.Cookies;
import Challange4.Entity.Popcorn;
import Challange4.Entity.Interfaces.Coin;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addItem("Chocolate", new Chocklet("Dark Chocolate", 1.50, 5));
        vendingMachine.addItem("Cookies", new Cookies("Oreo Cookies", 2.00, 3));
        vendingMachine.addItem("Popcorn", new Popcorn("Buttered Popcorn", 3.25, 4));
        vendingMachine.addItem("Soda", new Beverages("Coca Cola", 1.75, 6));
        vendingMachine.displayInventory();

        System.out.println("==== Successful Purchase ====");
        vendingMachine.selectItem("Chocolate");
        vendingMachine.insertCoin(Coin.HUNDRED); 
        vendingMachine.insertCoin(Coin.FIFTY);
        vendingMachine.dispenseItem();
        System.out.println("\n==== Cancelled Transaction ====");
        vendingMachine.selectItem("Popcorn");
        vendingMachine.insertCoin(Coin.HUNDRED);
        vendingMachine.cancelTransaction();
        System.out.println("\n==== Out of Stock ====");
        vendingMachine.selectItem("macha");
        System.out.println("\n==== Insufficient Money ====");
        vendingMachine.selectItem("Popcorn");
        vendingMachine.insertCoin(Coin.HUNDRED);
        vendingMachine.insertCoin(Coin.FIFTY);
        System.out.println("Adding more money...");
        vendingMachine.insertCoin(Coin.HUNDRED);
        vendingMachine.insertCoin(Coin.HUNDRED);
        vendingMachine.dispenseItem();
    }
    
}
