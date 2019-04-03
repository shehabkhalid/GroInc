/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;

import attributes.date;
import attributes.email;
import attributes.name;

/**
 *
 * @author shehab
 */
public class member extends person
  {

    private String password;

    public member(name fullName, email mail, boolean gender, date birthDate, String password)
      {
        super(fullName, mail, gender, birthDate);
        this.password = password;
      }

  }
