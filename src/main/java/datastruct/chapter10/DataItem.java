package main.java.datastruct.chapter10;

public class DataItem {

    public long dData;

    public DataItem(long dData) {
        this.dData = dData;
    }

    public void displayItem(){//display item,format"/27"
        System.out.print("/"+dData);
    }
}// end class DataItem
