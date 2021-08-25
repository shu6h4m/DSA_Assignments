package Assignment_6;

/*
linkedList class is created to create linked list which will used for create dictionary

variable:
size : total number of item
start : Hold adress of first/Strating Node of linked list

function:
isEmpty() : to check if circular Linked list is empty or not
getSize() : to get size of circular Linked list
insertAtEnd() : to insert node at End
deleteAtStart() : to delete node at start
deleteAtEnd() : to delete node at End
deleteAtPosition(): to delete at particluar poistion
*/
public class linkedList {

    //delcare variable
    protected int size;
    protected Node start;

    //construtor
    public linkedList()
    {
        size=0;
        start=null;
    }

    //return true when linked list is empty otherwise return false
    public boolean isEmpty() {
        if (start==null) return true;
        return false;
        
    }

    //return size
    public int size() {
        return size;        
    }

    //to insert node at End --> return nothing
    public void insertAtEnd(String key, Object value) 
    {
        Node n = new Node(key,value,null);
        if (isEmpty())
            start=n;
        else
        {
            Node tempNext;
            tempNext=start;
            for(int i=0; i<size-1;i++)
                tempNext=tempNext.getNext();
            tempNext.setNext(n);
            n.setNext(null);
        }
        size++;        
    }

    //delete node at start of Linked list --> return nothing
    public void deletAtStart() {
        if (isEmpty())
        {
            System.out.println("Already Empty!! can't delete");
            return;
        }
        else if ( size == 1)
            start = null;
        else
        {
            Node temp;
            temp=start;
            start = temp.getNext();
            temp.setNext(null);
        }
        size--;
    }

    //delete node at start of Linked list --> return nothing
    public void deletAtEnd() {
        if (isEmpty())
        {
            System.out.println("Already Empty!! can't delete");
            return;
        }
        else if ( size == 1)
            start = null;
        else
        {
            Node temp;
            temp = start;
            for (int i=1;i<size-1;i++)
                temp = temp.getNext();
            temp.setNext(null);
        }
        size--;
    }

    //delete node at start of Linked list --> return nothing
    //parameter: pos -- position where node what to delete
    public void deletAtPosition(int pos) {
        if ( pos == 1 )
            deletAtStart();
        else if (pos == size)
            deletAtEnd();
        else if( pos >1 && pos <size)
        {
            Node temp;
            temp = start;
            for (int i=1;i<pos-1;i++)
                temp = temp.getNext();
            
            Node temp2;
            temp2=temp.getNext();
            temp.setNext(temp2.getNext());
            temp2.setNext(null);
            size--;
        }
        else
            System.out.println("Deletion not possible");
    }

    // override to string function
    @Override
    public String toString() {
        if ( isEmpty() )
            return "\nEmpty";
        String result="";
        Node temp = start;
        for (int i=1;i<=size;i++)
        {
            result=result+temp.getKey()+" : "+temp.getValue().toString()+"\n";
            temp = temp.getNext();
        }  
        return result;    
    }
}

