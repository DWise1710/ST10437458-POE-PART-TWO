/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10437458_poe_part_two;

/**
 *
 * @author kabel
 */
class Tasks {
  
   String createID(String developer, String name , int taskNum){
      String taskId;
       String tempDev="", tempName="";
       developer = developer.toUpperCase();
       name =name.toUpperCase();
       for(int x=0;x<3;x+=1){
           tempDev = tempDev + developer.charAt(x);
           if(x<2){
               tempName = tempName + name.charAt(x);
           }
       }
          
       taskId = tempName + ":" + taskNum + ":" + tempDev;
       return taskId;
   }
   
   String printTaskDetails(String name,String description,String developer,String status, int duration,int taskNum, String taskId){
       
       return "Task Name"+"     : "+ name + "\nTask Description: "+ description +"\n Developer Name  : "+  developer +"\n Current Status  : " +  status+"\nTask Duration   : "+ duration 
             +"\n Task Number"+"   :"+ taskNum 
            + "\n Task ID:"+"     :"+ taskId ;
     
   }
   
   boolean checkTaskDescription(String description) {
   return description.length() <= 50;  
   }  
   
   int returnTotalHours(int arrayDuration[]){
       
        int totalTime=0;
         for(int x=0;x<arrayDuration.length;x+=1){
                             totalTime = totalTime + arrayDuration[x];
                      }
       return totalTime;
   }
}
