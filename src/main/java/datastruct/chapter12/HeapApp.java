package main.java.datastruct.chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapApp {

    public static void main(String[] args) throws IOException{
        int value,value2;
        Heap theHeap = new Heap(31);//make a Heap;max size 31
        boolean success;
        theHeap.insert(70);
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);

        while (true){
            System.out.printf("Enter first letter of ");
            System.out.printf("show ,insert , remove, change: ");
            int choice = getChar();
            switch (choice){
                case 's':
                    theHeap.displayHeap();
                    break;
                case 'i':
                    System.out.printf("Enter value to insert: ");
                    value = getInt();
                    success = theHeap.insert(value);
                    if (!success){
                        System.out.println("Can't insert;heap full");
                    }
                    break;
                case 'r':
                    if (!theHeap.isEmpty()){
                        theHeap.remove();
                    }else {
                        System.out.println("Can't remove; heap empty");
                    }
                    break;
                case 'c':
                    System.out.printf("Enter current index of item: ");
                    value = getInt();
                    System.out.printf("Enter new key: ");
                    value2 = getInt();
                    success = theHeap.change(value,value2);
                    if (!success){
                        System.out.println("Invalid index");
                    }
                    break;
                default:
                    System.out.println("Invalid entry\n");
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
