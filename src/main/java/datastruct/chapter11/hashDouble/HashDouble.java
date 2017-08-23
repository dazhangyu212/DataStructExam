package main.java.datastruct.chapter11.hashDouble;

import main.java.datastruct.chapter11.DataItem;

/**
 * 再哈希法
 * demonstrates hash table with double hashing
 * to rn this program
 */
public class HashDouble {
    private DataItem[] hashArray;

    private int arraySize;

    private DataItem nonItem;

    public HashDouble(int size) {
        this.arraySize = size;
        hashArray = new DataItem[size];
        nonItem = new DataItem(-1);
    }

    public void displayTable(){
        System.out.printf("Table: ");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null){
                System.out.printf(hashArray[i].getKey()+" ");
            }else{
                System.out.printf("** ");
            }
            System.out.println("");
        }
    }

    public int hashFunc1(int key){
        return key%arraySize;
    }

    public int hashFunc2(int key){
        //non-zero ,less than array size,different from hF1
        //array size must be relatively prime to 5,4,3,2
        return 5-key%5;
    }

    public void insert (int key,DataItem item){
        //assume table not full
        int hashVal = hashFunc1(key);//hash the key
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal]!= null
                && hashArray[hashVal].getKey() != -1){
            hashVal += stepSize;//at the step
            hashVal%=arraySize;//for wraparound
        }
        hashArray[hashVal]= item;//insert item
    }//end insert()

    public DataItem delete(int key){
        int hashVal = hashFunc1(key);//hash the key
        int stepSize = hashFunc2(key);//get step size
        while (hashArray[hashVal] != null){//until empty cell.
            //is correct hashVal?
            if (hashArray[hashVal].getKey() == key){
                DataItem temp = hashArray[hashVal];//save item
                hashArray[hashVal] = nonItem;//delete item
                return temp;//return item
            }
            hashVal += stepSize;//add the step
            hashVal %= arraySize;//for wraparound
        }
        return null;//can't find item
    }//end delete()

    public DataItem find(int key){//find item with key
        // assume table not full
        int hashVal = hashFunc1(key);//hash the key
        int stepSize = hashFunc2(key);//get step size

        while (hashArray[hashVal] != null){//until empty cell
            //is correct hashVal?
            if (hashArray[hashVal].getKey() == key){
                return hashArray[hashVal];//yes return item
            }
            hashVal+= stepSize;//add the step
            hashVal%= arraySize;//for wraparound
        }
        return null;//can''t find item
    }
}
