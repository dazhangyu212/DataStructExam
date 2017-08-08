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

    /**
     * delete node with given key
     * @param key
     * @return
     */
    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key){//search for node
            parent = current;
            if (key < current.iData){//go left
                isLeftChild = true;
                current = current.leftChild;
            }else {//or go right
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){ //end of the line
                return false;//didn't find it
            }
        }//end while
        //if no children ,simply delete it
        if (current.leftChild == null && current.rightChild == null){
            if (current == root){
                root = null;// if root ,tree is empty
            }else if (isLeftChild){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
        }else if(current.rightChild == null){
//            if no right child, replace with left subtree
            if (current == root){
                root = current.leftChild;
            }else if (isLeftChild){
                parent.leftChild = current.leftChild;
                //left child of parent
            }else {
                parent.rightChild = current.leftChild;
                //right child of parent
            }
        }else if(current.leftChild == null){
            if (current == root){
                root = current.rightChild;
            }else if (isLeftChild){
                parent.leftChild = current.rightChild;
                //left child of parent
            }else{
                parent.rightChild = current.rightChild;
                //right child of parent
            }
        }
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
