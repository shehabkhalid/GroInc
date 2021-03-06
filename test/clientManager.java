/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Backend_skeleton.*;
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
import java.util.ArrayList;

/**
 *
 * @author shehab
 */
public class clientManager
  {

    private static Socket clientSocket;

    private static ObjectInputStream input;
    private static ObjectOutputStream output;

    private static ArrayList<Object> myData;

    public static void openConnection()
      {
        //18.206.40.99
        try
          {
            clientSocket = new Socket("localhost", 8165);
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());

          } catch (Exception e)
          {
            e.getStackTrace();
          }

      }

    private static Object getData() throws ClassNotFoundException, Exception
      {
        return input.readObject();
      }

    private static boolean opreationWithData(Object object) throws IOException, ClassNotFoundException
      {
        output.writeObject(object);
        output.flush();
        output.reset();
        myData = (ArrayList<Object>) input.readObject();
        String ans = (String) input.readObject();
        return (ans.equals("true"));
        
      }

    private static boolean opreationConfirmed(Object object) throws IOException, ClassNotFoundException
      {

        output.writeObject(object);
        output.flush();
        output.reset();
        String ans = (String) input.readObject();

        return (ans.equals("true"));

      }

    public static boolean logInCheck(String userName, String Password) throws IOException, ClassNotFoundException
      {

        userNameAndPassword temp = new userNameAndPassword(userName, Password);
        temp.setCommand("NULL");

        return opreationConfirmed(temp);

      }

    public static boolean addUser(member user) throws IOException, ClassNotFoundException
      {

        return opreationConfirmed(user);

      }

    public static boolean checkUserName(String userName) throws IOException, ClassNotFoundException
      {

        userNameAndPassword temp = new userNameAndPassword(userName, "NULL");
        temp.setCommand("USERNAME");
        return opreationConfirmed(temp);
      }

    public static boolean checkMail(String Mail) throws IOException, ClassNotFoundException
      {

        email tempMail = new email();
        tempMail.setMailString(Mail);
        return opreationConfirmed(tempMail);
      }

    public static boolean addTask(String workSpaceName, String taskName, String Taskdescription, date deadLine) throws ClassNotFoundException, IOException
      {
        task temp = new task();
        temp.setTitle(taskName);
        temp.setDeadLine(deadLine);
        temp.setWorkSpaceName(workSpaceName);
        temp.inProgress();
        return opreationConfirmed(temp);

      }

    public static boolean getWorkSpaceTasks(String workSpaceName) throws IOException, ClassNotFoundException
      {
        request myRequest = new request();
        myRequest.setCommand("getWorkSpaceTasks");
        myRequest.setWorkSpaceName(workSpaceName);
        return opreationWithData(myRequest);

      }

    public static ArrayList<Object> getMyData()
      {
        return myData;
      }
    

    public static void main(String[] args) throws IOException, ClassNotFoundException
      {
        openConnection();
          getWorkSpaceTasks("shehab_Test_final");
          System.out.println((String)myData.get(0));
        
      }
  }
