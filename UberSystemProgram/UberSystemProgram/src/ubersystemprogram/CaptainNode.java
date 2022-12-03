/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubersystemprogram;

/**
 *
 * @author
 */

public class CaptainNode{

	private int captainID;
	private String CaptainName;
	private int star;
	private boolean available;
	private CaptainNode right;
	private CaptainNode left;

	public CaptainNode leftChild(){

		// Method return left child node of CaptainNode object  
		return left;
	
	}
        public void setLeftChild(CaptainNode f_node){
             this.left = f_node;
        }

	public CaptainNode rightChild(){
	
		// Method return left child node of CaptainNode object  
		return right;
	}
        public void setRightChild(CaptainNode f_node){
             this.right = f_node;
        }
	
	public int getCaptainID(){

            //Method return ID of the CaptainNode object
            return captainID;

	}
        
        
	
	public boolean isAvailable(){

            return available;

	}
        public void setAvailable(boolean f_available ){

            this.available = f_available;

	}
        
	public String getCaptainName(){

            return CaptainName;
	}
        
	public void setCaptainName(String f_CaptainName){

            this.CaptainName = f_CaptainName;
                
	}



	public int getRating(){

            return star;
	}
	public void setRating(int f_star){
            // try to keep rating always in range of 0 - 5
            if(f_star > 5 || f_star < 0){
                return;
            }
            this.star = f_star; 	
	}



	public CaptainNode(int f_captainID, String f_CaptainName , int f_star , boolean f_available , CaptainNode f_right , CaptainNode f_left ){
            
            captainID = f_captainID;    
            CaptainName = f_CaptainName;
            star = f_star;
            available =f_available;
            left = f_left;
            right = f_right;
           
	} // Constructor End
        
        public CaptainNode(int f_captainID, String f_CaptainName ){
            
            captainID = f_captainID;    
            CaptainName = f_CaptainName;
            star =  0;
            available = true;
            left = null;
            right = null;
           
	} // Constructor End
        
        public void copyCaptainNodeData(CaptainNode f_obj ){
            
            this.captainID = f_obj.getCaptainID();    
            this.CaptainName = f_obj.getCaptainName();
            this.star =  f_obj.getRating();
            this.available =f_obj.isAvailable();
            this.left = f_obj.leftChild();
            this.right = f_obj.rightChild();
           
	}

}

