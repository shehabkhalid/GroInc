/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;

import java.io.IOException;
import java.sql.*;
import java.sql.CallableStatement;
import javax.imageio.IIOException;
import Backend_skeleton.*;
import com.mysql.cj.Session;


/**
 *
 * @author shehab
 */
public class dataBaseConnector 
  {

   
    private static Connection myConnection;

    public  static void closeDataBase()
            
      {
          try
            {
               myConnection.close();
            } catch (Exception e)
            {
                System.out.println(e);
            }
       
      }
    public static void openDataBase()
      {

        try
          {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection("jdbc:mysql://groinc.cofcwbekphsc.us-east-1.rds.amazonaws.com:3306/groincdatabase", "groinc", "groincisthebest");

          } catch (Exception e) 
          {
            System.out.println(e);
          }

      }

    public static boolean addUserToDataBase(person myUser)
      {

        
    
        try
          {
            CallableStatement myCallableStatement = myConnection.prepareCall("{call insertUser(?,?,?,?,?,?,?,?)}");
            myCallableStatement.setString( 1, myUser.getFullName().getNaString());
            myCallableStatement.setString(2, myUser.getFullName().getLaString());
            myCallableStatement.setString(3, myUser.getPhoneNumber1().getpString());
            myCallableStatement.setString(4, myUser.getMail().getMailString());
            myCallableStatement.setString(5,myUser.getPassword());
            myCallableStatement.setString(6, myUser.getBirthDate());
            myCallableStatement.setString(7, myUser.getGender());
            myCallableStatement.setString(8, myUser.getUserName());
         myCallableStatement.execute();
         
         return true;

           
          } catch (Exception e)
          {
           
            System.out.println(e);
             return false;
          }

       
      }

    public static boolean loginCheck(String userString, String passString)
      {
      //  openDataBase();
        try
          {

            // dataBaseConnector.openDataBase();
            CallableStatement myStatement = myConnection.prepareCall("{call logIN(?,?)}");

            myStatement.setString(1, userString);
            myStatement.setString(2, passString);

            ResultSet answser = myStatement.executeQuery();

            String ok = "false";
            while (answser.next())
              {
                ok = answser.getString(1);
              }

            //  myConnection.close();
          //  closeDataBase();
           
            return (ok.equals("true"))?true:false;

          } catch (Exception e)
          {
            System.out.println(e);
          }

        return false;
      }

    public static boolean checkUserName(String userNameString)
      {

          try
            {
              
              CallableStatement myCallableStatement = myConnection.prepareCall("{call checkUserName(?)}");
              myCallableStatement.setString(1, userNameString);
          
              ResultSet rs = myCallableStatement.executeQuery();
              
              String ans = "false";
              while(rs.next())
                  ans = rs.getString(1);
              
              return (ans.equals("true"))?true:false;
              
              
            } catch (Exception e)
            {
                System.out.println(e);
            }
           return false;
      }
    
    
    public static boolean phoneNumberChecker(String phoneNumberString)
      {
        
        try
            {
              
              CallableStatement myCallableStatement = myConnection.prepareCall("{call phoneNumberChecker(?)}");
              myCallableStatement.setString(1, phoneNumberString);
          
              ResultSet rs = myCallableStatement.executeQuery();
              
              String ans = "false";
              while(rs.next())
                  ans = rs.getString(1);
              
              return (ans.equals("true"))?true:false;
              
              
            } catch (Exception e)
            {
                System.out.println(e);
            }
           return false;
      }
        
      
    public  static  boolean emailChecker(String emailString)
      {
        
          
        try
            {
              
              CallableStatement myCallableStatement = myConnection.prepareCall("{call emailChecker(?)}");
              myCallableStatement.setString(1, emailString);
          
              ResultSet rs = myCallableStatement.executeQuery();
              
              String ans = "false";
              while(rs.next())
                  ans = rs.getString(1);
              
              return (ans.equals("true"))?true:false;
              
              
            } catch (Exception e)
            {
                System.out.println(e);
            }
           return false;
      }

  }
