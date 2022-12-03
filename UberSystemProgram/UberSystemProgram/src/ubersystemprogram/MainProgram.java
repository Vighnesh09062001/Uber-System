/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ubersystemprogram;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class MainProgram {

    
    static public String inputfile_path;
    static public String outputfile_path;
    static public String output_file_data;
   
    public static void ouputfileGeneration(){
        
        try{
            
            File outputFileObj = new File(output_file_data);
            if (outputFileObj.createNewFile()) {
                System.out.println("File created: " + outputFileObj.getName());
            }    
            else {
                System.out.println("File already exists.");
            }
        
            PrintWriter writer = null;     
            writer = new PrintWriter(outputFileObj);  
            writer.write(output_file_data);                                                   
            writer.flush();  
            writer.close();  
            System.out.println("Successfully wrote to the file.");
            }    
        
        catch (Exception e) {
            System.out.println("Something went wrong ... ");
        }        
    }//end of outputfileGeneration 

    public static void fileManagement(){
    
        UberTree u = new UberTree();
        //the file to be opened for reading
        File inputFileObj= new File(inputfile_path);
        Scanner scannerobj;
        
        try {
            scannerobj = new Scanner(inputFileObj); //file to be scanned
        
        //returns true if there is another line to read
        while(scannerobj.hasNextLine())
        {
            
              
            String line = scannerobj.nextLine();      //returns the line that was skipped
      
            
            if(line.contains("Add_Captain")){
                
                String str = line;
                int id = Integer.parseInt(line.substring(13,16));
                String name = (line.substring(16)).trim();
                u.addCaptain(id, name);
                
            }
            if(line.contains("BOOK_RIDE")){
                int id = Integer.parseInt(line.substring(10,13));
                u.bookRide(id);
                
            }
            if(line.contains("DISPLAY_CAPTAIN_INFO")){
                int id = Integer.parseInt(line.substring(21,24));
                u.display_captain_info(id);
                
            }
            if(line.contains("FINISH_RIDE")){
                int id = Integer.parseInt(line.substring(12,15));
                int rating = Integer.parseInt((line.substring(16)).trim());
                u.finishRide(id, rating);
            }
            if(line.contains("DELETE_CAPTAIN")){
                int id = Integer.parseInt(line.substring(15,18));
                u.deleteCaptain(id);
            }
            if(line.contains("DISPLAY_ALL_CAPTAINS")){
                u.display_all_captains_info();
            }
            if(line.contains("Quit")){
                output_file_data = u.quit();
                
            }
            
        }
        scannerobj.close();     //closes the scanner
    
    } 
    catch (Exception e) {
            System.out.println("Something went wrong...");
    }
        
        
    } // method end 
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        // testing CaptainNode class
        CaptainNode a1 = new CaptainNode(123,"Tejas", 5, true , null, null);
        a1.setCaptainName("ABC");
        a1.setAvailable(false);
        a1.setRating(10);
        System.out.println("Hello");
        System.out.println("Name "+ a1.getCaptainName());
        System.out.println(a1.getCaptainID());
        System.out.println(a1.isAvailable());
        System.out.println(a1.leftChild());
        System.out.println(a1.getRating());
        System.out.println(a1.rightChild());
        System.out.println("Testin Done ....");
        // Testing done.....
        
        
        
        UberTree obj = new UberTree();
        obj.addCaptain(30, "Ahmed");
        obj.addCaptain(50, "Omar");
        obj.addCaptain(15, "Prithvi");
        obj.addCaptain(20, "Sanika");
        obj.addCaptain(10, "Tejas");
        obj.addCaptain(40, "ABDO");
        obj.addCaptain(60, "Sanket");
        //obj.inorder();
        obj.display_captain_info(40);
        obj.display_all_captains_info();
        obj.bookRide(99);
        obj.bookRide(40);
        obj.bookRide(40);
        obj.finishRide(40,1);
        obj.finishRide(40,1);
        obj.finishRide(99,1);
 
        
        obj.bookRide(40);
        obj.finishRide(40,1);
        obj.bookRide(40);
        obj.finishRide(40,1);
        obj.bookRide(40);
        obj.finishRide(40,1);
        obj.bookRide(40);
        obj.finishRide(40,1);
        obj.bookRide(40);
        obj.finishRide(40,1);
        obj.bookRide(40);
        obj.finishRide(40,1);
        obj.bookRide(40);
        obj.finishRide(40,1);
        obj.inorder();
        System.out.println("Hello");
        //obj.testingDelete();
        
        
        obj.deleteCaptain(40);
        obj.display_all_captains_info();
        obj.deleteCaptain(40);
        
        obj.quit();*/
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        inputfile_path ="D:\\c backup\\Desktop\\Vighnesh\\Project\\Uber\\input(1) (1).txt" ;
        outputfile_path ="D:\\c backup\\Desktop\\Vighnesh\\Project\\Uber\\output(1).txt" ;
        fileManagement();
        ouputfileGeneration();
        System.out.println(output_file_data);
        
    }
    
    
    
}
