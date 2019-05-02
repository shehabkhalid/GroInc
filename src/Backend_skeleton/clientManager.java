/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import attributes.*;
import java.io.Serializable;

/**
 *
 * @author shehab
 */
public class clientManager
  {

    private static Socket clientSocket;

    private static ObjectInputStream input;
    private static ObjectOutputStream output;

    public static void openConnection()
      {
        //18.206.40.99
        try
          {
            clientSocket = new Socket("18.206.40.99", 8165);
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());

          } catch (Exception e)
          {
            e.getStackTrace();
          }

      }
    
    private static boolean opreationConfirmed(Object object) throws IOException,ClassNotFoundException
      {
      
        
        output.writeObject(object);
        String ans = (String) input.readObject();
        output.flush();

        return (ans.equals("true"));

      }

    public static boolean logInCheck(String userName, String Password) throws IOException, ClassNotFoundException
      {

         return  opreationConfirmed(new userNameAndPassword(userName, Password));
        
      }

    public static boolean addUser(member user)throws IOException,ClassNotFoundException
      {
       
          return opreationConfirmed(user);
         
      }

  }