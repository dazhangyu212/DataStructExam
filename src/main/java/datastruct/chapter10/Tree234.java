package main.java.datastruct.chapter10;

public class Tree234 {
    private Node root = new Node();

    public int find(long key){
        Node curNode = root;
        int childNumber;
        while(true){
            if ((childNumber =curNode.findItem(key)) != -1) {
                return childNumber;//found it
            }else if (curNode.isLeaf()){
                return -1;//can't find it
            }else {
                curNode = getNextChild(curNode,key);
            }
        }//end while
    }

    /**
     * insert a DataItem
     * @param dValue
     */
    public void insert(long dValue){
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);

        while (true){
            if (curNode.isFull()){//if node is full
                split(curNode);//split it
                curNode = curNode.getParent();//back up
                curNode = getNextChild(curNode,dValue);//search once
            }//end if(node is full)
            else if (curNode.isLeaf()){//if node is leaf
                break;//go insert
            }else {//node is not full,not a leaf,so go to lower level
                curNode = getNextChild(curNode,dValue);
            }
        }// end while
        curNode.insertItem(tempItem);
    }

    private void split(Node curNode) {//split the node
        //assume node is full
        DataItem itemB,itemC;
        Node parent,child2,child3;
        int itemIndex;
        itemC = curNode.removeItem();//remove items from
        itemB = curNode.removeItem();//this node
        child2 = curNode.disconnectChild(2);//remove children
        child3 = curNode.disconnectChild(3);//from this node
        Node newRight = new Node();//make new node

        if (curNode == root){//if this is the root
            root = new Node();//make new node
            parent = root;//root is our parent
            root.connectChild(0,curNode);//connect to parent
        }else {
            parent = curNode.getParent();//get parent

        }
        //deal with parent
            itemIndex = parent.insertItem(itemB);//itemB to parent
            int n = parent.getNumItems();//total items?
            for (int i = 0; i < itemIndex; i++) {//move parents
                Node temp = parent.disconnectChild(i);//one child
                parent.connectChild(i+1,temp);//on the right
            }
            //connect newRight
            parent.connectChild(itemIndex+1,newRight);
//            deal with newRight
        newRight.insertItem(itemC);//itemC to newRight
        newRight.connectChild(0,child2);//connect to 0 and 1
        newRight.connectChild(1,child3);//on newRight
    }//end split

    /**
     * get appropriate child of node during search for value
     * @param theNode
     * @param theValue
     * @return
     */
    private Node getNextChild(Node theNode, long theValue) {
        int j;
        // assume node is not empty,not full,not a leaf
        int numItems = theNode.getNumItems();
        for ( j = 0; j < numItems; j++) {// for each item in node
            //are we less?
            if (theValue<theNode.getItem(j).dData){
                return theNode.getChild(j);//return left child
            }//end for //we're greater ,so
        }
        return theNode.getChild(j);//return right child
    }

    public void displayTree(){
        recDisplayTree(root ,0,0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.print("level = "+level+" child= "+childNumber+" ");
        thisNode.displayNode();//display this node
        //call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for (int j=0;j<numItems;j++){
            Node nextNode = thisNode.getChild(j);
            if (nextNode!= null){
                recDisplayTree(nextNode,level+1,j);
            }else {
                return;
            }
        }
    }//return recDisplayTree

}
