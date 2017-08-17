package main.java.datastruct.chapter10;

public class Node {

    private static final int ORDER = 4;
    private int numItems;
    private Node parent;

    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER-1];
    //connect child to this node
    public void connectChild(int childNum,Node child){
        childArray[childNum] = child;
        if (child != null){
            child.parent = this;
        }
    }
    //disconnect child from this node,return it
    public Node disconnectChild(int childNum){
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum){
        return childArray[childNum];
    }

    public Node getParent(){
        return parent;
    }

    public boolean isLeaf(){
        return (childArray[0]==null)?true:false;
    }

    public int getNumItems(){
        return numItems;
    }

    public DataItem getItem(int index){
        return itemArray[index];
    }

    public boolean isFull(){
        return (numItems== ORDER-1)?true:false;
    }

    public int findItem(long key){//return index of item within node
        for (int i = 0; i <ORDER-1; i++) {
            if (itemArray[i] == null){
                break;
            }else if (itemArray[i].dData == key){
                return i;
            }
        }
            return -1;

    }

    public int insertItem(DataItem newItem){
        //assume node is not full
        numItems++;//will add new Item
        long newKey = newItem.dData;//key of new item
        for (int j = ORDER-2;j>=0;j--){//start on right,examine items
            if (itemArray[j]== null){//if item null
                continue;//go left one cell
            }else {//not null
                long itsKey = itemArray[j].dData;//get its key
                if (newKey < itsKey){
                    itemArray[j+1] = itemArray[j];//if it's bigger,shift it right
                }else {
                    itemArray[j+1] = newItem;// insert new item
                    return j+1;//return index to new item
                }
            }//end else(not null)
        }//end for shifted all items
        itemArray[0] = newItem;
        return 0;
    }// end insertItem()


    public DataItem removeItem(){// remove largest item
        //assumes node not empty
        DataItem temp = itemArray[numItems-1];//save item
        itemArray[numItems-1] = null;//disconnect it
        numItems--;// one less item
        return temp;
    }

    public void displayNode(){
        for (int j=0;j<numItems;j++){
            itemArray[j].displayItem();
        }
        System.out.println("/");
    }
}
