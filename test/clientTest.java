
import java.net.Socket;
import java.util.Scanner;
import Backend_skeleton.clientManager;
import Backend_skeleton.member;
import Backend_skeleton.person;
import attributes.email;
import attributes.name;
import attributes.phoneNumber;
import attributes.userNameAndPassword;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shehab
 */
public class clientTest
  {
    
    public static void main(String[] args)
      {

        //18.206.40.99
        try (Socket socket = new Socket("localhost", 8165))
          {
            
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            
            email m = new email();
            m.setMailString("dasad@dasd");
       //     person temp = new member(new name("mohamed", "khaled"), new phoneNumber("01122887577"), m, "MALE", "1999-05-28", "123456789", "mohadkhald");
           // temp.setCommand("ADD");
            //output.writeObject(temp);
            
            System.out.println((String) input.readObject());

            //    output.writeObject(temp);
            System.out.println((String) input.readObject());
            
          } catch (Exception e)
          {
            System.out.println(e);
          }
        
      }
    
  }
