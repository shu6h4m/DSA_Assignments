package Assignment_6;

import java.util.Arrays;

public class linearProbing3 {
    //variable
    protected Node[] hashArray;
    protected int hashTableSize;
    protected Node deleteNode;
    protected int size=0;
    protected int lookup;

    //return lookup
    public int getLookup() {
        return lookup;
    }

    //consturctor
    linearProbing3(int tableSize){
        hashTableSize=tableSize;
        hashArray = new Node[tableSize];
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
        int constA=3;
        if(constA%hashTableSize==0)
            constA+=1;
        int constB=5;
        return (int)(constA*key + constB)% hashTableSize;
    }

    // search given key
    protected boolean search(String Key)
    {
        int operationLookup=0;
        int hashKey = hashFunction(getKey(Key));
        int temp = hashKey;
        while(hashArray[temp]!=null)
        {
            if(hashArray[temp]==deleteNode)
            {
              temp=(temp+1)% hashTableSize;
              operationLookup+=1;
              continue;
            }
            if( hashArray[temp].getKey().equals(Key) ){
                lookup+=operationLookup;
                System.out.println(hashArray[temp].getValue());
                System.out.println("Look up in operation : "+operationLookup);
                return true;
            }
            temp=(temp+1)% hashTableSize;

            if(temp==hashKey){
                lookup+=operationLookup;
                System.out.println("Look up in operation : "+operationLookup);
                return false;
            }
            operationLookup+=1;
        }
        lookup+=operationLookup;
        System.out.println("Look up in operation : "+operationLookup);
        return false;
    }

    // insert the element in hash table
    protected boolean insert(String Key, Object value) {
        int operationLookup=0;
        if (size==hashTableSize)
        {
            System.out.println("Look up in operation : "+operationLookup);
            return false;
        }
        int hashKey = hashFunction(getKey(Key));
        int temp = hashKey;
        while(hashArray[temp]!=null && hashArray[temp]!=deleteNode)
        {
            if( hashArray[temp].getKey().equals(Key) ){
                lookup+=operationLookup;
                System.out.println("Look up in operation : "+operationLookup);
                return false;
            }
            operationLookup+=1;
            temp=(temp+1)% hashTableSize;
        }
        Node n = new Node(Key,value,null);
        hashArray[temp]=n;
        size++;
        lookup+=operationLookup;
        System.out.println("Look up in operation : "+operationLookup);
        return true;
    }

    //delete element of given key
    public boolean delete(String Key) {
        int operationLookup=0;
        int hashKey = hashFunction(getKey(Key));
        int temp = hashKey;
        while(hashArray[temp]!=null)
        {
            if(hashArray[temp]==deleteNode)
            {
              temp=(temp+1)% hashTableSize;
              operationLookup+=1;
              continue;
            }

            if( hashArray[temp].getKey().equals(Key) )
            {
                hashArray[temp]=deleteNode;
                size--;  
                lookup+=operationLookup;
            System.out.println("Look up in operation : "+operationLookup); 
                return true;
            }

            temp=(temp+1)% hashTableSize;

            if(temp==hashKey){
                lookup+=operationLookup;
                System.out.println("Look up in operation : "+operationLookup);
                return false;
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
