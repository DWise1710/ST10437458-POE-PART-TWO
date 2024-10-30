/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10437458_poe_part_two;

import javax.swing.JOptionPane;

/**
 *
 * @author kabel
 */
public class ST10437458_POE_PART_TWO {

    public static void main(String[] args) {
        //Scanner and Calling Login class
        
        Login login = new Login();
        Tasks task = new Tasks();
        
        //Possible Replies from register, To allow users to retry
        String response = "Username and Password are Valid . Account Registered ;-)";
        String response1="FAILED TO REGISTER.Username Captured but Password is Invalid :-/";
        String response2="FAILED TO REGISTER.Password Captured but Username is invalid. :-/ ";
        String response3= "FAILED TO REGISTER.Both Username and Password are invalid :-(";
        
        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban:-) ");
        //Create username and Password
   
        String name = JOptionPane.showInputDialog("Create a Username: (must have an underscore and less than 5 characters)");
       
        String key = JOptionPane.showInputDialog("Create a Strong Password: (must have a capital letter, number, special character and more than 8 characters)");
        
        //Send data to registerUser() method
        String verdict = login.registerUser( name, key);
        
        
        //If username or password is invalid, Try again (loop)
        if(verdict.compareTo(response)!= 0)
        {
           
            while(verdict.compareTo(response)!= 0)
            {
                JOptionPane.showMessageDialog(null, "Please Try again");
                 
                if(verdict.compareTo(response1) == 0)
                {
                   JOptionPane.showMessageDialog(null, response1);
                    
                    key = JOptionPane.showInputDialog("Create a Strong Password: (must have a capital letter, number, special character and more than 8 characters)");
                    verdict = login.registerUser( name, key);
                }
                else if(verdict.compareTo(response2) == 0)
                {
                   JOptionPane.showMessageDialog(null, response2);
                     name =  key = JOptionPane.showInputDialog("Create a cool Username: (must have an underscore and less than 5 characters)");
                    verdict = login.registerUser( name, key);
                }
                else if(verdict.compareTo(response3) == 0)
                {
                     JOptionPane.showMessageDialog(null, response3);
                    name = JOptionPane.showInputDialog("Create a Username: (must have an underscore and less than 5 characters)");
                    key = JOptionPane.showInputDialog("Create a Strong Password: (must have a capital letter, number, special character and more than 8 characters)");
       
                    verdict = login.registerUser( name, key);
                }
            }
            
        }
        String firstName="",surname="";
        //Account successfully registered
        if(verdict.compareTo(response)== 0) 
        {
                    JOptionPane.showMessageDialog(null, verdict);
                    firstName = JOptionPane.showInputDialog("Enter your first name");
                    surname = JOptionPane.showInputDialog("Enter your surname");
       
          }
        
        
        //Logging in
        JOptionPane.showMessageDialog(null, "Please Log in WIth the Same UserName and Password from previous section : ");
        
        String userName = JOptionPane.showInputDialog("Enter your Username");
        String passWord = JOptionPane.showInputDialog("Enter your Password");
        
        String status = login.loginStatus( name, key, userName, passWord);
        JOptionPane.showMessageDialog(null, status);
         if(status.compareTo("A successful login :-) ")!=0)
        {
            while(status.compareTo("A successful login :-) ")!=0)
            {
                JOptionPane.showMessageDialog(null, "Please Log in WIth the Same UserName and Password from previous section : ");
        
                 userName = JOptionPane.showInputDialog("Enter your Username");
                 passWord = JOptionPane.showInputDialog("Enter your Password");
        
                 status = login.loginStatus( name, key, userName, passWord);
                JOptionPane.showMessageDialog(null, status);
            }
        
        }
         //Welcome @user
        if(status.compareTo("A successful login :-) ")==0)
        {
           JOptionPane.showMessageDialog(null, "Welcome to Easy KanBan " +firstName+" "+surname+ ", We hope you have a good day");
            
        }
        
        //Part 2
           int opp =0;
         
        while(opp != 3){
        //Choose Option
             JOptionPane.showMessageDialog(null, "Choose an Option" );    
            String menu[]={"Add Tasks" , "Show Report - 'Coming Soon'", "Quit"};
                            int menuChosen = JOptionPane.showOptionDialog(null, "Choose an Option","Add Tasks/Show Report - 'Coming Soon'/Quit" ,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menu,menu[0]);
                               
            opp = menuChosen +1;
            
            switch (opp){
                default:
                   
                    JOptionPane.showMessageDialog(null, "Invalid Option" );  
                case 3:
                    JOptionPane.showMessageDialog(null, "Goodbye" );    
                break;
                case 2:
                     JOptionPane.showMessageDialog(null, "Coming Soon" );    
                break;
                case 1:
                        
                    
                      int count = Integer.parseInt(JOptionPane.showInputDialog("How many Tasks would you like to add"));
                  
                      //Arrays to Store data
                        String arrayName[]=new String[count];
                        String arrayDescription[] =new String[count];
                        String arrayDeveloper[]=new String[count];
                       String arrayStatus[] = new String[count];
                        String arrayTaskId[]=new String[count];
                        int arrayDuration[]=new int[count];
                     
                        
                        //Loop to create tasks
                       for(int x=0;x<count;x+=1){
                            JOptionPane.showMessageDialog(null, "Create Task Number :" +(x+1) );  
                             
                             arrayName[x] = JOptionPane.showInputDialog("Enter Task Name (Atleast 3 Characters)");
                             while(arrayName[x].length()<3)
                             {
                                 arrayName[x] = JOptionPane.showInputDialog("Enter Task Name (Atleast 3 Characters)");
                              }
                            
                             arrayDeveloper[x] =JOptionPane.showInputDialog("Enter Developer Name (Atleast 4 Characters)");
                              while(arrayDeveloper[x].length()<4)
                             {
                                 arrayDeveloper[x] =JOptionPane.showInputDialog("Enter Developer Name (Atleast 4 Characters)");
                              }
                            
                             arrayDuration[x] = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (to the nearest hour)"));
                             
                             arrayDescription[x] = JOptionPane.showInputDialog("Enter a task description ");
                             while(!task.checkTaskDescription(arrayDescription[x]))
                             {
                                 arrayDescription[x] = JOptionPane.showInputDialog("Enter a task description ");
                              }
                 
                             String choices[]={"Doing" , "Done", "To Do"};
                            int choice = JOptionPane.showOptionDialog(null, "Choose an Option","Doing/Done/To Do" ,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choices,choices[0]);
                                arrayStatus[x] = choices[choice];
                         
                            arrayTaskId[x] = task.createID(arrayDeveloper[x],arrayName[x], x+1);
                           JOptionPane.showMessageDialog(null, "Task Added" );        
                       }
                      
                       //Display all tasks
                      for(int x=0;x<count;x+=1){
                          JOptionPane.showMessageDialog(null, task.printTaskDetails( arrayName[x],arrayDescription[x], arrayDeveloper[x] , arrayStatus[x],  arrayDuration[x], x+1,  arrayTaskId[x]));  
                         
                      }//Total Calculation
                       int totalTime = task.returnTotalHours(arrayDuration);
                     JOptionPane.showMessageDialog(null, "Total Duration  :" +totalTime );  
                   break;
            }
        }
    }
      
}
