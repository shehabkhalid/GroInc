/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;

import attributes.date;
import attributes.email;
import attributes.name;
import attributes.phoneNumber;

/**
 *
 * @author shehab
 */
public class teamLeader extends person
  {

    public teamLeader()
      {
      }

    
    public teamLeader(name fullName,phoneNumber phone, email mail, String gender, String birthDate, String password, String userName)
      {
       this.fullName = fullName;
        this.mail = mail;
        this.gender = gender;
        this.birthDate = birthDate;
        this.password = password;
        this.userName = userName;
        phoneNumber1 = phone;
      }
  }
