/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;
import attributes.date;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author shehab
 */
public class task implements Serializable 
  {
    
    private static final long serialVersionUID = 121L;
    
    
    private String workSpaceName = new String("");
    private String title = new String("");
    private date deadLine;
    private String description = new String("");
   
    boolean done,inProgress,passed;

    public void setDeadLine(date deadLine)
      {
        this.deadLine = deadLine;
      }

    public void setDescription(String description)
      {
        this.description = description;
      }

 
    public void done()
      {
        done = true;
        inProgress =  !done;
        passed = !done;
      }
    
    public void inProgress()
      {
        inProgress = true;
        done =  !inProgress;
        passed = !inProgress;
      }
    
     public void passed()
      {
        passed = true;
        done =  !passed;
        inProgress = !passed;
      }

    public void setTitle(String title)
      {
        this.title = title;
      }
    
    public void setWorkSpaceName(String workSpaceName)
      {
        this.workSpaceName = workSpaceName;
      }
    
    
  }
