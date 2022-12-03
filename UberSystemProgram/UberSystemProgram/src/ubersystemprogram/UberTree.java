/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubersystemprogram;

import java.util.Stack;

/**
 *
 * @author Chetan
 */
public class UberTree {
    private CaptainNode root;
    public String data;
    UberTree(){
        root = null;
        data = "";
        data = data + "--------------- Welcome to Uber Booking System ---------------";
        System.out.println("--------------- Welcome to Uber Booking System ---------------");
        
    }
    
    public void addCaptain(int f_id,String f_name){
        
        //Cretaing node;
        CaptainNode node = new CaptainNode( f_id, f_name);
        
        if(root==null) {
            root = node;
            data = data + "\nCommand Add_Captain: Add a new captain record in the System"+"\n\n            ID: "+node.getCaptainID()+"\n            Name: "+node.getCaptainName()+"\n            Available: True\n            Rating star: "+node.getRating();
            data = data + "\n\n----------------------------------------------------------------";
        
            return;
        }
        
        CaptainNode prev = null;
        CaptainNode temp = root;
        
        while (temp!=null){
            if(temp.getCaptainID() > f_id){ //check if root id is less then root traverse to left 
                prev = temp;
                temp = temp.leftChild();
            }
            else if (temp.getCaptainID() < f_id){// check if root id is greater then traverse to right
                prev = temp;
                temp = temp.rightChild();
            }
        }
        
        if(prev.getCaptainID() > f_id)    //we got the leave node stored in prev so adding element to left or rigth based on id
            prev.setLeftChild(node);
        else 
            prev.setRightChild(node);
        
 
        System.out.println("Command Add_Captain: Add a new captain record in the System"+"\n\n            ID: "+node.getCaptainID()+"\n            Name: "+node.getCaptainName()+"\n            Available: True\n            Rating star: "+node.getRating());
        System.out.println("\n----------------------------------------------------------------");
        
        
        data = data + "\nCommand Add_Captain: Add a new captain record in the System"+"\n\n            ID: "+node.getCaptainID()+"\n            Name: "+node.getCaptainName()+"\n            Available: True\n            Rating star: "+node.getRating();
        data = data + "\n\n----------------------------------------------------------------";
        
    }
    
    public static CaptainNode searchNode(CaptainNode f_root,int f_id)
    {
        
        if (f_root == null || f_root.getCaptainID()== f_id) //root is null or id is present in root Node
            return f_root;
 
        // id is greater than roots id
        if (f_root.getCaptainID() < f_id)           // traversing right using recursive call
            return searchNode(f_root.rightChild(), f_id);
        else
            // id is smaller than roots id          //traversing left using recursive call
            return searchNode(f_root.leftChild(), f_id);
    }
    
    public void display_captain_info(int f_id){
        CaptainNode obj = searchNode(root,f_id);
        if(obj == null){
            System.out.println("Cammand DISPLAY CAPTAIN_INFO: Couldn’t find any " + "captain with ID number "+f_id);
            System.out.println("\n----------------------------------------------------------------");
            
            data = data + "\nCammand DISPLAY CAPTAIN_INFO: Couldn’t find any " + "captain with ID number "+f_id ; 
            data = data + "\n\n----------------------------------------------------------------";
            
            
        }
        else{
            
            System.out.println("Cammand DISPLAY CAPTAIN_INFO:\n            ID: "+obj.getCaptainID()+"\n            Name: "
                    +obj.getCaptainName()+"\n            Available: "+obj.isAvailable()+"\n            Rating star: "+obj.getRating());
            System.out.println("\n----------------------------------------------------------------");
            
            data = data + "\nCammand DISPLAY CAPTAIN_INFO:\n            ID: "+obj.getCaptainID()+"\n            Name: "
                    +obj.getCaptainName()+"\n            Available: "+obj.isAvailable()+"\n            Rating star: "+obj.getRating();
            data = data + "\n\n----------------------------------------------------------------";
        }
    
    }
    
    public void display_all_captains_info(){
        /*
        inorder traversal but using stack for getting previous node
        */
        System.out.println("Command DISPLAY_ALL_CAPTAINS:");
        data = data + "\nCommand DISPLAY_ALL_CAPTAINS:";
        CaptainNode temp = root;
        Stack<CaptainNode> stack=new Stack<>();     
        while (temp!=null||!stack.isEmpty()){            
            if(temp!=null){                     
                stack.add(temp);           // traverse to left child for greater number
                temp=temp.leftChild();
            }
            else {              //temp = null means we got leave node in stack as stack works as LIFO order
                temp=stack.pop();   // get previous element
                //System.out.print(temp.getCaptainID()+" ");
                System.out.println("\n            ID: "+temp.getCaptainID()+"\n            Name: "
                    +temp.getCaptainName()+"\n            Available: "+temp.isAvailable()+"\n            Rating star: "+temp.getRating());
                System.out.println("\n\n----------------------------------------------------------------");
                
                
                data = data + "\n\n            ID: "+temp.getCaptainID()+"\n            Name: "
                    +temp.getCaptainName()+"\n            Available: "+temp.isAvailable()+"\n            Rating star: "+temp.getRating();
                data = data +"\n\n----------------------------------------------------------------";
                
                
                
                temp=temp.rightChild();    // traverse to right child for greater number
            } 
        }
    }
    

    public void bookRide(int f_id){
        
        CaptainNode obj = searchNode(root,f_id);
        if(obj == null){
            System.out.println("Command BOOK_RIDE: Couldn’t find any captain with ID number "+f_id);
            System.out.println("\n\n----------------------------------------------------------------");
            
            data = data + "\nCommand BOOK_RIDE: Couldn’t find any captain with ID number "+f_id;
            data = data + "\n\n----------------------------------------------------------------";
            
        }
        else{
            
            if(obj.isAvailable()){
                // The captain is avilable lets book a ride
                obj.setAvailable(false);
                System.out.println("Command BOOK_RIDE: Book a new Ride with captin "+obj.getCaptainID());
                System.out.println("\n----------------------------------------------------------------");
                
                data = data + "\nCommand BOOK_RIDE: Book a new Ride with captin "+obj.getCaptainID();
                data = data + "\n\n----------------------------------------------------------------";
                
            }
            else{
                // The captain is not available 
                System.out.println("Command BOOK_RIDE: The captain "+obj.getCaptainName()+" is not available. He is on another ride!");
                System.out.println("\n----------------------------------------------------------------");
                
                data = data + "\nCommand BOOK_RIDE: The captain "+obj.getCaptainName()+" is not available. He is on another ride!";
                data = data + "\n\n\n----------------------------------------------------------------";
            }
            
        } 
        
        
    }
    public void finishRide(int f_id, int f_rating){
        
        CaptainNode obj = searchNode(root,f_id);
        if(obj == null){
            System.out.println("Command FINISH_RIDE: Couldn’t find any captain with ID number "+f_id);
            System.out.println("----------------------------------------------------------------");
        
            data = data + "\nCommand FINISH_RIDE: Couldn’t find any captain with ID number "+f_id;
            data = data + "\n----------------------------------------------------------------";
            
        
        }
        else{
            
            if(obj.isAvailable()){
                //The captain is available so we can't finsih ride
                System.out.println("Command FINISH_RIDE: The  captain "+obj.getCaptainName()+" is not in a ride!");
                System.out.println("----------------------------------------------------------------");
            
                data = data +  "\nCommand FINISH_RIDE: The  captain "+obj.getCaptainName()+" is not in a ride!";
                data = data +  "\n----------------------------------------------------------------";
            }
            else{
                // The captain is not avilable lets finish a ride
                obj.setAvailable(true); // Make Captain avialable
                
                if(f_rating == 1){
                    // rating is 1 so increase rating by 1
                    obj.setRating(1 + obj.getRating());  
                }
                if(f_rating == 0){
                    // rating is 1 so decrease rating by 1
                    obj.setRating(  obj.getRating() - 1);
                }
                
                System.out.println("Command FINISH_RIDE: Finish ride with captin "+ obj.getCaptainID());
                System.out.println("\n            ID: "+obj.getCaptainID()+"\n            Name: "
                    +obj.getCaptainName()+"\n            Available: "+obj.isAvailable()+"\n            Rating star: "+obj.getRating());
                System.out.println("----------------------------------------------------------------");
                
                data = data +"\nCommand FINISH_RIDE: Finish ride with captin "+ obj.getCaptainID();
                data = data + "\n\n            ID: "+obj.getCaptainID()+"\n            Name: "
                    +obj.getCaptainName()+"\n            Available: "+obj.isAvailable()+"\n            Rating star: "+obj.getRating();
                data = data + "\n----------------------------------------------------------------";
                
                
                
                /*
                Command FINISH_RIDE: Finish ride with captin 501

			ID: 501
			Name: Rida_Ahmad_Zahrani
			Available: True 
			Rating star: 0
                */
            }
            
        } 
        
        
    }
  
    public static CaptainNode deleteNode(CaptainNode f_root, int f_id)
    {
      
    // Base case
        if (f_root == null)
            return f_root;
  
        // Recursive calls for ancestors of
        // node to be deleted
        if (f_root.getCaptainID() > f_id) 
        {
            f_root.setLeftChild(deleteNode(f_root.leftChild(), f_id));
            return f_root;
        }
        else if (f_root.getCaptainID() < f_id) 
        {
            
            f_root.setRightChild(deleteNode(f_root.rightChild(), f_id));
            return f_root;
        
        }
  
        // We reach here when root is the node
        // to be deleted.
  
        // If one of the children is empty
        if (f_root.leftChild() == null) 
        {
            CaptainNode temp = f_root.rightChild();
            return temp;
        }
        else if (f_root.rightChild() == null) 
        {
            CaptainNode temp = f_root.leftChild();
            return temp;
        }
  
        // If both children exist
        else 
        {
            CaptainNode succParent = f_root;
  
            // Find successor
            CaptainNode succ = f_root.rightChild();
          
            while (succ.leftChild() != null) 
            {
                succParent = succ;
                succ = succ.leftChild();
            }
  
            // Delete successor. Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ->right to succParent->right
            if (succParent != f_root)
                succParent.setLeftChild(succ.rightChild());
            else
                succParent.setRightChild(succ.rightChild()) ;
            // Copy Successor Data to root
            f_root.copyCaptainNodeData(succ);
            return f_root;
        }
    }
    
    public void deleteCaptain(int f_id){
       CaptainNode obj = searchNode(root,f_id);
        if(obj == null){
            System.out.println("Command  DELETE_CAPTAIN: Couldn’t  found  any captain with ID number "+f_id);
            System.out.println("----------------------------------------------------------------");
        
            data = data + "\nCommand  DELETE_CAPTAIN: Couldn’t  found  any captain with ID number "+f_id;
            data = data + "\n----------------------------------------------------------------";
            
        
        }
        else{
            System.out.println("\nCommand  DELETE_CAPTAIN:The captain "+obj.getCaptainName()+" left Uber");
            System.out.println("\n----------------------------------------------------------------");
            root = deleteNode(root, f_id);
            
            data = data + "\nCommand  DELETE_CAPTAIN:The captain "+obj.getCaptainName()+" left Uber";
            data = data + "\n----------------------------------------------------------------";
        }
   }
   public String quit(){
       
       System.out.println("Thank you for using Uber System, Good Bye!");
       data = data + "\nThank you for using Uber System, Good Bye!\n";
       return data;
   }
   
   
   
   
   
   

} // end of class UberTree

