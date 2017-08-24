package main.java.datastruct.chapter11;

/**
 * 哈希化字符串
 */
public class HashMethod {
    private int arraySize;

    public static int hashFunc1(String key,int arraySize){
        int hashVal = 0;
        int pow27 = 1;

        for (int i = 0; i < key.length() - 1; i++) {
            int letter = key.charAt(i)-96;
            hashVal += pow27*letter;
            pow27 *= 27;
        }
        return hashVal%arraySize;
    }

    public static int hashFunc2(String key,int arraySize){
        int hashVal = key.charAt(0)-96;
        for (int i = 0; i < key.length(); i++) {
            int letter = key.charAt(i)-96;//get char code
            hashVal = hashVal*27+letter;//multiply and add
        }
        return hashVal%arraySize;
    }

    public static int hashFunc3(String key,int arraySize){
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            int letter = key.charAt(i) -96;//get char code
            hashVal = (hashVal*27+letter)%arraySize;//mod
        }
        return hashVal;
    }
}
