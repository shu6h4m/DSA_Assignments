package Assignment_6;

/* Node class is created to store key , value pair for dictonary

variable :
key : will conatain key
value : will conatin associated with key. you can also store dict, arraay as value
next : will conatin address of nest node if given(like in linkedlist) otherwise hold null

getter and setter function also use to get and set the value of above function
*/

public class Node {
    //declare varaible
    protected String key;
    protected Object value;
    protected Node next;

    //constructors
    public Node()
    {
        key = null;
        value = null;
        next=null;
    }
    
    public Node(String key,Object data,Node nextPointer)
    {
        this.key = key;
        value = data;
        next = nextPointer;
    }

    //setter
    public void setValue(Object data) {
        value = data;     
    }

    public void setkey(String key) {
        this.key = key;     
    }

    public void setNext(Node pointer) {
        next = pointer;       
    }

    //getter
    public Object getValue() {
        return value;       
    }

    public String getKey()
    {
        return key;
    }
    

    public Node getNext() {
        return next;
    }

    // Override the toString function
    @Override
    public String toString() {
        String result ="";
        result+=key+" : "+ value+"\n"; 
        return result;
    }
}