package main.java.datastruct.chapter8;

public class Tree {
    /**
     * the only data field in tree
     */
    private Node root;

    public Node find(int key){
        Node current = root;//start at root
        while(current.iData != key){//while no match
            if (key < current.iData){
                //go left
                current = current.leftChild;
            }else {
                //go right
                current = current.rightChild;
            }
            if (current == null){//if no child
                return null;//didn't find it
            }
        }
        return current;//found it
    }

    public void insert(int id,double dd)
    {
        Node newNode = new Node();//make new node
        newNode.iData = id;//insert data
        newNode.fData = dd;
        if (root == null){//no node in root
            root = newNode;
        }else {
            Node current = root;//start at root
            Node parent;
            while(true){//exits internally
                parent = current;
                if (id<current.iData){//go left
                    current = current.leftChild;
                    if (current == null){// if end of the line
                        parent.leftChild = newNode;//insert on left
                        return;
                    }
                }else {// or go right
                    current = current.rightChild;
                    if (current == null){//if end of the line
                        parent.rightChild = newNode;//insert on right
                        return;
                    }
                }//end else go right
            }//end while
        }//end else not root
    }//end insert

    public void delete(int id){

    }


    public void inOrder(Node localRoot){
        if (localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData+" ");
            System.out.println(localRoot.rightChild);
        }
    }

    public Node minimum(){
        Node current ,last = null;
        current = root;//start at root
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    /**
     * 最大值
     * @return
     */
    public Node maximum(){
        Node current,last = null;
        current = root;
        while(current != null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }
}
