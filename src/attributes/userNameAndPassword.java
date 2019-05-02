/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attributes;

import java.io.Serializable;

/**
 *
 * @author shehab
 */
public class userNameAndPassword implements Serializable
  {
  private static final long serialVersionUID = 1L;
  
    private String userName, password;

    public userNameAndPassword(String userName, String password)
      {
        this.userName = userName;
        this.password = password;
      }

    public String getPassword()
      {
        return password;
      }

    public String getUserName()
      {
        return userName;
      }

  }
