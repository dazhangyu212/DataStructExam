package main.java.datastruct.chapter11.hashChain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashChainApp {

    public static void main(String[] args) throws IOException{
        int aKey;
        Link aDataItem;
        int size,n,keysPerCell = 100;

        System.out.printf("Enter size of hash table");
        size = getInt();
        System.out.printf("Enter initial number of items: ");
        n = getInt();

        HashTable theHashTable = new HashTable(size);
        for (int i = 0; i < n; i++) {
            aKey = (int) (Math.random()*keysPerCell*size);
            aDataItem = new Link(aKey);
            theHashTable.insert(aDataItem);
        }
        while (true){
            System.out.printf("Enter first letter of ");
            System.out.printf("show,insert,delete,or find : ");
            char choice = getChar();
            switch (choice){
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.printf("Enter key value to insert:  ");
                    aKey = getInt();
                    aDataItem = new Link(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.printf("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.printf("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null){
                        System.out.println("Found "+ aKey);
                    }else {
                        System.out.println("Could not find "+aKey);
                    }
                    break;
                default:
                    System.out.printf("Invalid entry\n");
                    break;
            }
        }

    }

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
}
