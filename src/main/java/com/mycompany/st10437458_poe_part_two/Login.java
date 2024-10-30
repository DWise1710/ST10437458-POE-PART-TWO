/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10437458_poe_part_two;

/**
 *
 * @author kabel
 */
class Login {
    boolean checkUserName(String user)
    {
        boolean fact1 = false, fact;
        //loop to check for special characters
        for(int x=0; x< user.length(); x++)
        {
            if(user.contains("_"))
            {
                fact1 = true;
            }
            else
            {
                fact1=false;
            }
        }
        if(user.length()<=5 && fact1)
        
        {
            fact=true;
        }
        else
        {
            fact=false;
        }
        
       
        return fact;
    }
    
    boolean checkPasswordComplex(String key)
    {
        boolean fact1 = false,fact2=false,fact3=false, fact;
        String specialChar="!@#$%^&*()_+{}:<>?|/*-+`~=[];'?/..,";
        String num="123456789";
        
        //loop to check password for special keys, numbers and Capital letter
        for(int x=0; x< key.length(); x++)
        {
            if(specialChar.contains(Character.toString(key.charAt(x))))
            {
                fact1 = true;
            }
             if(num.contains(Character.toString(key.charAt(x))))
            {
                fact2 = true;
            }
              if(Character.isUpperCase((key.charAt(x))))
            {
                fact3 = true;
            }
           
        }
        //check if length is above 8, and all other conditions are true
        if(fact1 && fact2 && fact3 && key.length()>=8)
        {
            fact =true;
        }
        else{  
        fact=false;
        }
        
        return fact;
    }
    
    String registerUser(String user,String key)
    {
        String verdict;
        boolean validName = checkUserName(user);
        boolean validKey = checkPasswordComplex(key);
        //Both name and password are valid
        if(validName && validKey)
        {
            verdict="Username and Password are Valid . Account Registered ;-)";
        }
        //Password invalid
        else if(validName && validKey == false)
        {
            verdict="FAILED TO REGISTER.Username Captured but Password is Invalid :-/";
        }
        //USername invalid
        else if(validName == false && validKey)
        {
           verdict="FAILED TO REGISTER.Password Captured but Username is invalid. :-/ ";
        }
        //Both invalid
        else
        {
           verdict="FAILED TO REGISTER. Both Username and PAssword are invalid :-(";
        }
        
    
    return verdict;
    }
    
    boolean loginUser(String name,String key, String userName, String passWord)
    {
        
            boolean status=false;
            if(name.compareTo(userName) == 0 && key.compareTo(passWord)==0)
            {
                status=true;
            }
            
    return status;
    }
    
    String loginStatus(String name,String key, String userName, String passWord)
    {
        String login = "failed login";
        boolean status = loginUser(name, key, userName, passWord);
        if(status)
        {
            login= "A successful login :-) ";
        }
        
        return login;
    }
        
}
