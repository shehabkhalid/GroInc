/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;
import java.io.Serializable;

/**
 *
 * @author shehab
 */
public class request implements Serializable
  {
    private String command;

    public String getCommand()
      {
        return command;
      }

    public void setCommand(String command)
      {
        this.command = command;
      }
    
  }
