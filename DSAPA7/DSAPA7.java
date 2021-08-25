
import java.util.Random;
import java.util.Scanner;

public class DSAPA7 {
    class Node{
    
        int value;
        Node parent;
        Node rightChild;
        Node leftChild;

        public Node(int value){
            this.value = value;
        } //constructor
    }

    protected Node root = null;
    //Function to check if BT is empty or not
    public boolean Is_Empty(){
        return root == null;
    }

    //Function to insert element into BT
    public void insertNode(int value){

        Node node_New = new Node(value);
        if(Is_Empty()){
            root = node_New;
            return;
        }
        
        Node prev = null;
        Node temp = root;
        while(temp != null && temp.value != value){
            prev = temp;
            if(temp.value < value){
                temp = temp.rightChild;
            }
            else if(temp.value > value){
                temp = temp.leftChild;
            }
        }

        if(prev.value > value){
            prev.leftChild = node_New;
        }
        else{
            prev.rightChild = node_New;
        }
        node_New.parent = prev;
    }

    //Fuction to search element in BT
    public Node search(int value){

        Node node = root;
        while(node != null && node.value != value){
            if(node.value < value){
                node = node.rightChild;
            }else if(node.value > value){
                node = node.leftChild;
            }
        }
        return node;
    }

    //Function to perform preorder traversal in BT
    public void preOT(Node tempNode){
        if(tempNode == null){
            return;
        }

        System.out.print(tempNode.value + " ");
        preOT(tempNode.leftChild);
        preOT(tempNode.rightChild);
    }

    //Function to perform inorder traversal in BT
    public void inOT(Node tempNode){

        if(tempNode == null){
            return;
        }

        inOT(tempNode.leftChild);
        System.out.print(tempNode.value + " ");
        inOT(tempNode.rightChild);
    }

    //Fuction to perform postorder traversal in BT
    public void postOT(Node tempNode){

        if(tempNode == null){
            return;
        }

        postOT(tempNode.leftChild);
        postOT(tempNode.rightChild);
        System.out.print(tempNode.value + " ");
    }

    //Function to find minimum of BT
    public Node min(Node node){

        while(node.leftChild != null){
            node = node.leftChild;
        }
        return node;
    }

    //Function to find maximum of BT
    public Node max(Node node){

        while(node.rightChild != null){
            node = node.rightChild;
        }
        return node;
    }

    //Fuction to find successor of a given node in BT
    public Node successor(int value){

        Node temp = search(value);
        if(temp != null && temp.value == value){
            if(temp.rightChild == null){
                Node par = temp.parent;
                while((par != null) && (par.leftChild != temp)){
                    temp = par;
                    par = par.parent;
                }
                return par;
            }
            return min(temp.rightChild);
        }
        return null;
    }

    //Function to find predecessor of a given number in BT
    public Node predecessor(int value){

        Node temp = search(value);
        if(temp != null && temp.value == value){
            if(temp.leftChild == null){
                Node par = temp.parent;
                while((par != null) && (par.rightChild != temp)){
                    temp = par;
                    par = par.parent;
                }
                return par;
            }
            return max(temp.leftChild);
        }
        return null;
    }
    

    public void delete(int value){
        delete(root,value);
        
    }
    //Function to delete element from BT
    private void delete(Node node,int value){

        //to search the node.
        while(node != null && node.value != value){
            if(node.value < value){
                node = node.rightChild;
            }else{
                node = node.leftChild;
            }
        }

        //if tree is empty or node not found.
        if(node == null){
            return;
        }

        //when no child is there.
        if(node.leftChild == null && node.rightChild == null){
            if(node == root){
                root = null;
            }
            if(node.parent.leftChild.value == value){
                node.parent.leftChild = null;
            }else{
                node.parent.rightChild = null;
            }

        //when both child are there.
        }else if(node.leftChild != null && node.rightChild != null){
            Node successor = min(node.rightChild);
            node.value = successor.value;
            Node next = node.rightChild;
            delete(next,successor.value);

        //when one child is there.
        }else {
            Node child = (node.leftChild != null)? node.leftChild : node.rightChild;
            if(node == root){
                root = child;
            }
            if(node == node.parent.leftChild){
                node.parent.leftChild = child;
            }else{
                node.parent.rightChild = child;
            }
        }
        
    }



    void preOT(){
        preOT(root); //wrapper method for preOT.
    }

    void inOT(){
        inOT(root); //wrapper method for inOT.
    }

    void postOT(){
        postOT(root);  //wrapper method for postOT.
    }

    public int min(){
        return min(root).value; //wrapper method for min.
    }

    public int max(){
        return max(root).value; //wrapper method for max.
    }

    public static void main(String[] args){
        //Driver code.
        Scanner sc = new Scanner(System.in);
        DSAPA7 bst = new DSAPA7();

        while(true){
            Random r = new Random();
            System.out.println("-----------------Binary Search Tree Menu-----------------");
            System.out.println("1. Insert in Tree \n2. Search \n3. Traversal of Tree \n4. Minimum \n5. Maximum \n6. Successor of given node \n7. Predecessor of given Node \n8. Delete a node\n0. Exit");
            System.out.println("---------------------------------------------------------");
            System.out.print("Enter the option : ");
            int option = sc.nextInt();

            if(option==0){
                //to exit from the loop.
                break;
            }

            int value;
            switch(option){

                case 1:
                    System.out.print("Enter the number of elements you want to insert : ");
                    int n = sc.nextInt();

                    for(int i=0; i<n; i++){
                        value = r.nextInt(100); 
                        System.out.println(" "+ value);
                        bst.insertNode(value);
                    }
                    break;
                
                case 2:
                    System.out.print("Enter the number you want to search : ");
                    value = sc.nextInt();
                    if(bst.search(value) == null){
                        System.out.println("No! number doesn't exists."); 
                    }else{
                        System.out.println("yes! "+ bst.search(value).value +" exists in the binary tree.");
                    }
                    break;

                case 3:
                    System.out.print("Pre-order traversal is : ");
                    bst.preOT();
                    System.out.println();
                    System.out.print("In-order Travesal is : ");
                    bst.inOT();
                    System.out.println();
                    System.out.print("Post-order Travesal is : ");
                    bst.postOT();
                    System.out.println();

                    break;

                case 4:
                    System.out.println("Minimum in the tree : " + bst.min());
                    break;

                case 5:
                    System.out.println("Maximum in the tree : " + bst.max());
                    break;

                case 6:
                    System.out.print("Enter the number : ");
                    value = sc.nextInt();
                    if(bst.successor(value) == null){
                        System.out.println("Can't find the successor !");
                    }else{
                        System.out.println("Successor of " + value + " is : " + bst.successor(value).value);
                    }
                    break;
                
                case 7:
                    System.out.print("Enter the number : ");
                    value = sc.nextInt();
                    if(bst.successor(value) == null){
                        System.out.println("Can't find the predecessor !");
                    }else{
                        System.out.println("Predecessor of " + value + " is : " + bst.predecessor(value).value);
                    }
                    break;
                case 8:
                    System.out.print("Enter the number : ");
                    value = sc.nextInt();
                    bst.delete(value);
                    break;

                default:
                    break;
            }
        }
        
    }

}
