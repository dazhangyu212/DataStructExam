package main.java.datastruct.chapter11.hashLine;

import main.java.datastruct.chapter11.DataItem;

public class HashTable {

    private DataItem[] hashArray;//array holds hash table

    private int arraySize;//for delete items

    private DataItem nonItem;//constructor

    public HashTable(int size) {
        this.arraySize = size;
        hashArray = new DataItem[size];
        nonItem = new DataItem(-1);//deleted item key is -1
    }

    public void displayTable(){
        System.out.print("Table: ");

        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null ){
                System.out.printf(hashArray[i].getKey()+" ");
            }else {
                System.out.printf("** ");
            }
        }
    }

    public int hashFunc(int key){
        return key % arraySize;//hash function
    }

    public void insert(DataItem item){//insert a DataItem(assume table not full)
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null
                && hashArray[hashVal].getKey() != -1){
            ++hashVal;//go to next cell
            hashVal %= arraySize;//wraparound if necessary
        }
        hashArray[hashVal] = item;//insert item
    }//ent insert()

    //delete a DataItem
    public DataItem delete(int key){
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null){
            if (hashArray[hashVal].getKey() == key){

                DataItem temp = hashArray[hashVal];//save item
                hashArray[hashVal] = nonItem;//delete item
                return temp;//return item
            }
            ++hashVal;//go to next cell
            hashVal %= arraySize;
        }
        return null;//can't find item
    }

    public DataItem find(int key) {// find item with key
        int hashVal = hashFunc(key);//hash the key
        while (hashArray[hashVal] != null){//until empty cell,
            //found the key
            if (hashArray[hashVal].getKey() == key){
                return hashArray[hashVal];//yes, return item
            }
            ++hashVal;//go to next cell
            hashVal %= arraySize;//wraparount if necessary
        }
        return null;//can't find item
    }

    private int getPrime(int min){
        for (int i = min+1;true; i++) {
            if (isPrime(i)){

            }
        }
    }

    private boolean isPrime(int n) {//is n prime
        for (int j = 0; j*j < n; j++) {//for all j
            if (n%j == 0){//devides evenly by j
                return false;//yes ,so not prime
            }
        }
        return true;// no,so prime
    }
}
