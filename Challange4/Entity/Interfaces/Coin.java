package Challange4.Entity.Interfaces;
public enum Coin{
    ONE(1),TWO(2),FIVE(5),TEN(10),TWENTY(20),FIFTY(50),HUNDRED(100);
    private int value;
    private Coin(int value){
        this.value=value;
    }
    public int getValue(){
        return value;
    }
    public static boolean isValid(int value){
        for(Coin coin:Coin.values()){
            if(coin.getValue()==value) return true;
        }
        return false;
    }
}