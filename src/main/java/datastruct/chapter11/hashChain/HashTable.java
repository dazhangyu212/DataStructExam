package main.java.datastruct.chapter11.hashChain;

public class HashTable {

    private SortedList[] hashArray;//array of lists
    private int arraySize;

    public HashTable(int size) {
        this.arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortedList();//with lists
        }
    }

    public void displayTable(){
        for (int i = 0; i < arraySize; i++) {
            System.out.printf(i+". ");//display cell number
            hashArray[i].displayList();//display list

        }
    }

    public int hashFunc(int key){
        return key%arraySize;
    }

    public void insert(Link theLink){
        int key = theLink.getKey();
        int hashVal = hashFunc(key);//hash the key
        hashArray[hashVal].insert(theLink);//insert at hashVal
    }//end insert()

    public void delete(int key){
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);//delete link
    }

    public Link find(int key){
        int hashVal = hashFunc(key);//hash the key
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }
}
