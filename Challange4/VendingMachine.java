package Challange4;

import java.util.HashMap;
import java.util.Map;

import Challange4.Entity.Interfaces.Coin;
import Challange4.Entity.Interfaces.Item;
import Challange4.State.IdealState;
import Challange4.State.VendingMachineState;

public class VendingMachine {
    private VendingMachineState currentState;
    Map<String, Item> inventory;
    Map<Coin, Integer> coinBank;
    double insertedAmount;
    Item selectedItem;
    public VendingMachine(){
        this.insertedAmount=0.0;
        this.currentState=new IdealState(this);
        this.inventory=new HashMap<>();
        this.coinBank=new HashMap<>();
        initializeCoinBank();
    }
    private void initializeCoinBank() {
        for(Coin coin:Coin.values()){
            coinBank.put(coin, 10);
        }
    }
    //state management
    public void setState(VendingMachineState state){
        this.currentState=state;
        System.out.println("State changed to: "+state.getStateName());
    }
    public VendingMachineState getState(){
        return currentState;
    }
    //operations to current state
    public void selectItem(String itemName){
        currentState.selectItem(itemName);
    }
    public void insertCoin(Coin coin){
        currentState.insertCoin(coin);
    }
    public void cancelTransaction(){
        currentState.cancelTransaction();
    }
    public void dispenseItem(){
        currentState.despenseItem();
    }
    //inventory management
    public void addItem(String name,Item item){
        inventory.put(name,item);
    }
    public boolean isItemAvailable(String itemName){
        return inventory.containsKey(itemName)&&inventory.get(itemName).getQuantity()>0;
    }
    public Item getItem(String itemName){
        return inventory.get(itemName);
    }
    public void setSelectedItem(Item item){
        this.selectedItem=item;
    }
    public Item getSelectedItem(){
        return this.selectedItem;
    }
    public double getInsertedAmount(){
        return this.insertedAmount;
    }
    public void addInsertedAmount(double amount){
        this.insertedAmount+=amount;
    }
    public void resetInsertedAmount(){
        this.insertedAmount=0.0;
    }
    public void addCoinToBank(Coin coin){
        coinBank.put(coin,coinBank.getOrDefault(coin,0)+1);
    }
    public double getTotalCoinBankValue(){
        double total=0.0;
        for(Map.Entry<Coin,Integer>entry:coinBank.entrySet()){
            total+=entry.getKey().getValue()/100.0*entry.getValue();
        }
        return total;
    }
    public boolean canMakeChange(double changeAmount){
        return getTotalCoinBankValue()>=changeAmount;
    }
    public void displayInsertedAmount(){
        System.out.printf("Total inserted amount: %.2f\n",insertedAmount);
    }
    public Map<Coin,Integer> getCoinBank(){
        return this.coinBank;
    }
    public Map<String,Item> getInventory(){
        return this.inventory;
    }
    public void displayInventory(){
        System.out.println("Current Inventory:");
        for(Map.Entry<String,Item>entry:inventory.entrySet()){
            Item item=entry.getValue();
            System.out.printf("%s - Price: $%.2f, Quantity: %d\n",item.getName(),item.getPrice(),item.getQuantity());
        }
    }
}
