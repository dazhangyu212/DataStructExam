package main.java.datastruct.chapter10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree234App {

    public static void main(String[] args) throws IOException{
        long value;
        Tree234 theTree = new Tree234();

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);
        while (true){
            System.out.print("Enter first letter of");
            System.out.print("show insert ,or find;");
            char choice = getChar();
            switch (choice){
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.printf("Enter value to insert:");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    System.out.printf("Enter value to find");
                    value = getInt();
                    int found = theTree.find(value);
                    if (found != -1){
                        System.out.printf("Found "+value);
                    }else {
                        System.out.printf("could not find "+value);
                    }
                    break;
                default:
                    System.out.printf("Invalid entry\n");
                    break;
            }//end switch
        }//end while
    }//end main()

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    private static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static long getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
