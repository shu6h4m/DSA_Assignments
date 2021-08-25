package Assignment_6;

import java.util.Random;

// Double hashing technique is used for avoiding collisions. and rehashing also used
public class universalHashing {
    //variable
    protected Node[] hashArray;
    protected int hashTableSize;
    protected Node deleteNode;
    protected int size=0;
    protected int randomFunction;

    //constuctor
    universalHashing(int tableSize)
    {
        hashTableSize=tableSize;
        hashArray = new Node[tableSize];
        deleteNode = new Node();
        Random random = new Random();
        randomFunction= random.nextInt(3);
    }

    //getKey() function convert string to long vlaue which  value used in hashfunction
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

    // hash functions used in universial hashing
    protected int hashFunction1(long key)
    {
        return (int)key%hashTableSize;
    }

    protected int hashFunction2(long key)
    {
        double constA=0.7;
        return (int)(hashTableSize * ( (key* constA ) % 1 ) );
    }

    protected int hashFunction3(long key)
    {
        int constA=3;
        if(constA%hashTableSize==0)
            constA+=1;
        int constB=5;
        return  (int)((constA*key + constB)% hashTableSize);
    }

    //offset function which will used when collision occur
    protected int offsetFunction1(long key) {
        int realtivePrime = 6;
        return (int) ( realtivePrime - ( key % realtivePrime ) );
    }

    protected int offsetFunction2(long key) {
        int realtivePrime = 6;
        double constA=0.7;
        return (int)( realtivePrime - ( (int)(realtivePrime * ( (key* constA ) % 1 ) ) ) );
    }
    protected int offsetFunction3(long key) {
        int realtivePrime = 6;
        int constA=3;
        int constB=5;
        return (int)(realtivePrime - ( (constA*key + constB)% realtivePrime ));
    }

    // function to chose which hash function is used
    protected int choseHashFunction(long Key)
    {
        if(randomFunction == 1) return hashFunction1(Key);
        
        if(randomFunction == 2) return hashFunction2(Key);
        
        else return hashFunction3(Key);
    }

    //function to chose which offset function is used in case of collision
    protected int choseOffset(long Key) {
        if ( randomFunction == 1) return offsetFunction1(Key);

        if ( randomFunction == 2) return  offsetFunction2(Key);

        else    return offsetFunction3(Key);
    }

    //insert the element in hash table
    public boolean insert(String key , Object value) {
        if(size==hashTableSize)
            return false;
        long Key=getKey(key);
        int probe = choseHashFunction(Key);
        int offset= choseOffset(Key);
        int temp = probe;
        while(hashArray[temp]!=null && hashArray[temp]!=deleteNode )
        {
            if( hashArray[temp].getKey().equals(key) )
                return false;
            temp=(temp+ offset )%hashTableSize;
        }
        Node n = new Node(key,value,null);
        hashArray[temp]=n;
        size++;
        return true;
    }

    // search value of given key
    public boolean search(String key) {
        long Key=getKey(key);
        int probe = choseHashFunction(Key);
        int offset= choseOffset(Key);
        int temp = probe;
        while(hashArray[temp]!=null)
        {
            if(hashArray[temp]==deleteNode)
            {
              temp=(temp+offset)% hashTableSize;
              continue;
            }

            if( hashArray[temp].getKey().equals(key) )
            {
                System.out.println(hashArray[temp].getValue());
                return true;
            }
            temp=(temp+ offset )%hashTableSize;

            if(temp== probe)     return false;
        }
        return false;
    }

    //delete the given element with help of given key
    public boolean delete(String key) {
        long Key=getKey(key);
        int probe = choseHashFunction(Key);
        int offset= choseOffset(Key);
        int temp = probe;
        while(hashArray[temp]!=null)
        {
            if(hashArray[temp]==deleteNode)
            {
              temp=(temp+offset)% hashTableSize;
              continue;
            }

            if( hashArray[temp].getKey().equals(key) )
            {
                hashArray[temp]=deleteNode;
                size--;
                return true;
            }
            temp=(temp+ offset )%hashTableSize;
            if(temp== probe)
            {
                return false;
            }
        }
        return false;
    }

    //function to rehash the hash table
    protected void rehashing() {
        int tombStone =0;
        for(Node ele : hashArray)
        {
            if ( (tombStone*100)/hashArray.length <40 )  break;
            if(ele ==deleteNode)
                tombStone+=1;
        }
        if( (tombStone*100)/hashArray.length <40 )
            return;
        for ( Node ele : hashArray)
        {
            if(ele == null) continue;
            if (ele == deleteNode)
            {
                ele =null;
                continue;
            }
            else
            {
                Node temp = ele;
                ele=deleteNode;
                insert(temp.getKey(), temp.getValue());
            }            
        }
    }
}
