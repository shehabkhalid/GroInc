/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;
import attributes.name;
import attributes.email;
import attributes.date;



/**
 *
 * @author shehab
 */
abstract class person
  {

    protected static int idGenrator = 1;

    protected final int id = idGenrator;
    protected name fullName;
    protected email mail;
    protected boolean gender;
    protected  date birthDate;

    public person(name fullName, email mail, boolean gender, date birthDate)
      {
        this.fullName = fullName;
        this.mail = mail;
        this.gender = gender;
        this.birthDate = birthDate;
        idGenrator++;

      }
    
    
   
    
   
    

   
    

  }
