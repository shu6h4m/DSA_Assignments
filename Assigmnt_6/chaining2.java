package Assignment_6;

import java.util.Arrays;

public class chaining2 {
    //variable
    protected linkedList[] hashArray;
    protected int hashTableSize;
    protected int lookup=0;

    //constructor
    chaining2(int tableSize)
    {
        hashTableSize=tableSize;
        hashArray = new linkedList[tableSize];
        for(int i=0;i<hashTableSize;i++)
        {
            linkedList lst = new linkedList();
            hashArray[i]=lst;
        }
    }

    //to return lookup
    public int getLookup() {
        return lookup;
    }

    //to hashing function to get hash value of give key
    // this include getKey() and hasFunction()
    public long getKey(String key)
    {
        int constValue =33;
        long result = 0;
        for(int i=0;i<key.length();i++)
        {
            char ch = key.charAt(i);
            int ascii = ch;
            result= result + (ascii* (long)Math.pow(constValue, i));
        }
        return result;
    }

    protected int hashFunction(long key)
    {
        double constA=0.7;
        return (int)(hashTableSize * ( (key* constA ) % 1 ) );
    }

    // search given key
    public boolean search(String Key) {
        int opertationLookup=0;
        int hashKey = hashFunction(getKey(Key));
        linkedList temp = hashArray[hashKey];
        Node temp2= temp.start;
        for(int i=0;i<temp.size();i++)
        {
            if (temp2.getKey().equals(Key))
            {
                lookup+=opertationLookup;
                System.out.println("Look up in operation : "+opertationLookup);
                return true;
            }

            opertationLookup+=1;
        }
        lookup+=opertationLookup;
        System.out.println("Look up in operation : "+opertationLookup);
        return false;
    }

    // insert the element in hash table
    public boolean insert(String Key, Object value) {
        int opertationLookup=0;
        int hashKey = hashFunction(getKey(Key));
        linkedList temp = hashArray[hashKey];
        Node temp2= temp.start;
        for(int i=0;i<temp.size();i++)
        {
            if (temp2.getKey().equals(Key) )
            {
                lookup+=opertationLookup;
                System.out.println("Look up in operation : "+opertationLookup);
                return false;
            }
            opertationLookup+=1;
        }
        temp.insertAtEnd(Key, value);
        lookup+=opertationLookup;
        System.out.println("Look up in operation : "+opertationLookup);
        return true;
    }

    // delete the given key form hash Table
    public boolean delete(String Key) {
        int operationLookup=0;
        int hashKey = hashFunction(getKey(Key));
        linkedList temp = hashArray[hashKey];
        Node temp2= temp.start;
        int count=0;
        for(int i=0;i<temp.size();i++)
        {
            count+=1;
            if (temp2.getKey().equals(Key))
            {
                temp.deletAtPosition(count);
                lookup+=operationLookup;
                System.out.println(temp2.value.toString());
                System.out.println("Look up in operation : "+operationLookup);
                return true;
            }
            operationLookup+=1;
        }
        lookup+=operationLookup;
        System.out.println("Look up in operation : "+operationLookup);
        return false;
    }

    public void display() {
        System.out.println(Arrays.toString(hashArray));
        
    }
}
