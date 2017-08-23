package main.java.datastruct.chapter11.hashChain;

/**
 *
 */
public class SortedList {
   private Link first;//ref to first list item

    public SortedList() {
        first = null;
    }

    public void insert(Link theLink){
        int key  = theLink.getKey();
        Link previous = null;
        Link current = first;//start at first
        while (current != null && key >current.getKey())
        {//or current > key
            previous = current;
            current = current.next;//go to next item
        }
        if (previous == null){//if beginning of list
            first = theLink;// first --> new link
        }else {//not at beginning
            previous.next = theLink;//prev --> new link
            theLink.next = current;//new link --> current
        }//end insert
    }

    public void delete(int key){//delete link
        //assumes non-empty list
        Link previous = null;
        Link current = first;//start at first
        while (current != null && key != current.getKey()){
            //or key == current
            previous = current;
            current = current.next;//go to next link
        }
        //disconnect link
        if (previous == null){//if beginning of list
            first = first.next;//delete first link
        }else {//not at beginning
            previous.next = current.next;//delete current link
        }
    }//end delete

    public Link find(int key){
        Link current = first;//start at first
        while(current != null && current.getKey() <= key){
            //or key too small
            if (current.getKey() == key){// is this the link?
                return current;//found it,return link
            }
            current = current.next;//go to next item
        }
        return null;// didn't find it
    }// end find


    public void displayList(){
        System.out.printf("List(first-->last)");
        Link current = first;//start at beginning of list
        while (current != null){
            //until end of list
            current.displayLink();//print data
            current = current.next;
        }
        System.out.println("");

    }
}//end class
