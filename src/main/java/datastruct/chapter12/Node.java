package main.java.datastruct.chapter12;

public class Node {
    private int iData;

    public Node(int key) {
        this.iData = key;
    }

    public int getKey(){
        return iData;
    }

    public void setKey(int id){
        iData = id;
    }
}
