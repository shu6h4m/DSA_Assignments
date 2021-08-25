package Assignment_6;

public class doubleHashing2 {
    //variable
    protected Node[] hashArray;
    protected int hashTableSize;
    protected Node deleteNode;
    protected int size=0;
    protected int lookup=0;

    // return look up value
    public int getLookup()
    {
        return lookup;
    }

    //Constructor
    doubleHashing2(int tableSize)
    {
        hashTableSize=tableSize;
        hashArray = new Node[tableSize];
        deleteNode = new Node();
    }

    //to hashing function to get hash value of give key
    // this include getKey() and hasFunction1()
    protected long getKey(String key)
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


    protected int hashFunction1(long key)
    {
        double constA=0.7;
        return (int)(hashTableSize * ( (key* constA ) % 1 ) );
    }

    //offset function used when collision occur
    protected int hashFunction2(long key) {
        int realtivePrime = 6;
        double constA=0.7;
        return (int)( realtivePrime - ( (int)(realtivePrime * ( (key* constA ) % 1 ) ) ) );
    }

    // insert the element in hash table
    public boolean insert(String key , Object value) {
        int operationLookup=0;
        if(size==hashTableSize)
        {
            System.out.println("Look up in operation : "+operationLookup);
            return false;
        }
        long Key=getKey(key);
        int probe = hashFunction1(Key);
        int offset= hashFunction2(Key);
        int temp = probe;
        while(hashArray[temp]!=null && hashArray[temp]!=deleteNode )
        {
            if( hashArray[temp].getKey().equals(key) )
            {
                lookup+=operationLookup;
                System.out.println("Look up in operation : "+operationLookup);
                return false;
            }
            operationLookup+=1;
            temp=(temp+ offset )%hashTableSize;
        }
        Node n = new Node(key,value,null);
        hashArray[temp]=n;
        size++;
        lookup+=operationLookup;
        System.out.println("Look up in operation : "+operationLookup);
        return true;
    }

    // search given key
    public boolean search(String key) {
        int operationLookup=0;
        long Key=getKey(key);
        int probe = hashFunction1(Key);
        int offset= hashFunction2(Key);
        int temp = probe;
        while(hashArray[temp]!=null)
        {
            if(hashArray[temp]==deleteNode)
            {
              temp=(temp+offset)% hashTableSize;
              operationLookup+=1;
              continue;
            }

            if( hashArray[temp].getKey().equals(key) )
            {
                lookup+=operationLookup;
                System.out.println(hashArray[temp].getValue().toString());
                System.out.println("Look up in operation : "+operationLookup);
                return true;
            }
            temp=(temp+ offset )%hashTableSize;
            if(temp== probe)
            {
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

    //delete element of given key
    public boolean delete(String key) {
        int operationLookup=0;
        long Key=getKey(key);
        int probe = hashFunction1(Key);
        int offset= hashFunction2(Key);
        int temp = probe;
        while(hashArray[temp]!=null)
        {
            if(hashArray[temp]==deleteNode)
            {
              temp=(temp+offset)% hashTableSize;
              operationLookup+=1;
              continue;
            }

            if( hashArray[temp].getKey().equals(key) )
            {
                hashArray[temp]=deleteNode;
                size--;
                lookup+=operationLookup;
                System.out.println("Look up in operation : "+operationLookup);
                return true;
            }
            temp=(temp+ offset )%hashTableSize;
            if(temp== probe)
            {
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

}
