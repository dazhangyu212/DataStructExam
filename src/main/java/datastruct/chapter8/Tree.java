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
        }else {
            //get successor of node to delete(current)
            Node successor = getSuccessor(current);
            //后继节点肯定不会有左子节点的
            //connect parent of current to sucessor instead
            if (current == root){
                root = successor;
            }else if (isLeftChild){
                parent.leftChild = successor;

            }else {
                //吧current从它父节点的rightChild字段移除,把这个字段置为successor
                parent.rightChild = successor;
                //connect successor to current's left child
                //把current的左子节点从current移除,successor的leftChild字段置为current的左子节点
                successor.leftChild = current.leftChild;
            }//end else two children
            //(successor cannot have a left child)
        }
            return true;
    }

    /**
     * 寻找后继节点
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;//go to right child
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;//go to left child
//            if successor not rightChild
        }
            if (successor != delNode.rightChild){
            //把后继父节点的leftchild字段置为successor的右子节点
                successorParent.leftChild = successor.rightChild;//make connections
                //把successor的rightchild字段置为要删除节点的右子节点
                successor.rightChild = delNode.rightChild;
            }
            return successor;
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
