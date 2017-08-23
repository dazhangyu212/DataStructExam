package main.java.datastruct.chapter11.hashChain;

public class Link {
    private int iData;//data item

    public Link next;//next link in list

    public Link(int iData) {
        this.iData = iData;
    }

    public int getKey(){
        return iData;
    }

    /**
     * display this link
     */
    public void displayLink(){
        System.out.printf(iData+" ");
    }
}
