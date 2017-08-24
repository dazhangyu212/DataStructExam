package main.java.datastruct.chapter12;


import java.io.IOException;

public class Heap {
    private Node heapArray[];
    /**
     * size of array
     */
    private int maxSize;
    /**
     * number of nodes in array
     */
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean insert(int key){
        if (currentSize == maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    private void trickleUp(int index) {
        int parent = (index-1)/2;
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()){
            heapArray[index] = heapArray[parent];//move it down
            index = parent;
            parent = (parent-1)/2;
        }
        heapArray[index] = bottom;
    }


    public Node remove(){
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];//save root
        while (index < currentSize){//while node has at least one child
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;//find larger child
            if (rightChild < currentSize
                    && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
            {
                largerChild = rightChild;
            }else {
                largerChild = leftChild;
            }
            if (largerChild > currentSize || top.getKey() >= heapArray[largerChild].getKey()){
                break;
            }
            heapArray[index] = heapArray[largerChild];//shift child up
            index = largerChild;//go down
        }//end while
        heapArray[index] = top;
    }//end

    public boolean change(int index,int newValue){
        if (index < 0 || index>=currentSize){
            return false;
        }
        int oldValue = heapArray[index].getKey();//remember old
        heapArray[index].setKey(newValue);//change to new
        if (oldValue < newValue){//if raised,
            trickleUp(index);// trickle it up
        }else {//if lowered
            trickleDown(index);//trickle it down
        }
        return true;
    }

    public void displayHeap(){
        System.out.printf("heapArray: ");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null){
                System.out.printf(heapArray[i].getKey()+" ");
            }else {
                System.out.printf("-- ");
            }
        }
            System.out.println("");
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;// current item
        String dots = "........................";
        System.out.println(dots+dots);//dotted top line;
        while (currentSize > 0){// for each heap item
            if (column == 0){
                for (int k = 0; k < nBlanks; k++) {
                    System.out.printf(" ");
                }
            }
            System.out.printf(heapArray[j].getKey()+"");//display item
            if (++j == currentSize){// done?
                break;
            }
            if (++column == itemsPerRow){//end of rows?
                nBlanks /=2;//half the blanks
                itemsPerRow *=2;// twice the items
                column = 0;// start over on
                System.out.println();//new row

            }else {
                for (int k = 0; k < nBlanks*2-2; k++) {
                    System.out.printf(" ");//interim blanks
                }
            }
        }//end while
        System.out.println("\n"+dots+dots);//dotted bottom line
    }
}
