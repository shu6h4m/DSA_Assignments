package Assignment_6;
/*
dictionary is created to create dictionary which will hold record of student

function:
size() :  return number of element in dictionary
isEmpty() : check if dictionary is empty or not
elements() :  return/print all element of dictionary
findElem() : find the key in dictionary and return value assoicated with that key
insertItem() : to insert element in dictionary
updateItem() : update the value of given key
removeItem() : search the given key and remove that key and value associate with it from dictionary

*/
public class dictionary extends linkedList {

    //return size of dictionary
    public int size() {
        return size;
    }

    //return true when key is empty otherwise return full
    public boolean isEmpty() {
        if (size()==0) return true;
        return false;        
    }
    
    //print all element of key
    public void elements() {
        if(isEmpty())
        {
            System.out.println("No record");
            return;
        }
        Node temp = start;
        for (int i=1;i<=size;i++)
        {
           System.out.println("Roll No. : "+temp.getKey()+"\n"+temp.getValue());
            temp = temp.getNext();
        }        
    }

    /*
    function to find the key and return the value associated with it
    parameter:
    key : its the key which is stored in dictionary
    
    return:
        value associated with given key
    */
    public String findElem(String key) {
        if(isEmpty()) return null;
        Node temp;
        temp=start;
        for(int i=0;i<size()-1;i++)
        {
            if(temp.getKey().equals(key)) break;
            temp=temp.getNext();
            if(temp==null) return null;
        }
        return temp.getValue().toString();
    }

    /*
    Function to insert the element in dictionary
    parameter:
    key : key of item which we want to insert
    value : value of item associated with given key

    return:
        true when insertion Sucessfull
        false when insertion not sucessfull i.e key already present in dictionary
    */
    public boolean insertItem(String key,Object value) {
        Node temp;
        temp=start;
        for(int i=0;i<size();i++)
        {
            if(temp.getKey().equals(key)) return false;
            temp=temp.getNext();
        }
        insertAtEnd(key, value);
        return true;
    }
    /*
    Function to update the value of given key in dictionary
    parameter:
    key : key of item which we want to update
    value : new value of key which we want to update
    */
    public void updateItem(String key,Object value) {
        Node temp;
        temp=start;
        for(int i=0;i<size();i++)
        {
            if(temp.getKey().equals(key)) break;
            temp=temp.getNext();
        }
        temp.setValue(value);
    }
    /*
    Function to deletion the element in dictionary
    parameter:
    key : key of item which we want to delete

    return:
        true when deletion Sucessfull
        false when deletion not sucessfull i.e key not present in dictionary
    */
    public boolean removeItem(String key) {
        Node temp;
        temp=start;
        int count=0;
        for(int i=1;i<=size();i++)
        {
            count+=1;
            if(temp.getKey().equals(key)) break;
            temp=temp.getNext();
            if(temp==null) return false;
        }

        deletAtPosition(count);
        return true;
    }
}
