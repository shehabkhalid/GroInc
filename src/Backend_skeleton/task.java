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

/**
 *
 * @author shehab
 */
public class task
  {
    private String title = new String("");
    private date deadLine;
    private String description = new String("");
    private ArrayList<member> mArrayList = new ArrayList<member>();
    boolean done,inProgress,toDo;
    
    public void editTitle(String newTitle)
      {
        title = newTitle;
      }
    public void editDescription(String newDiscription)
      {
        description = newDiscription;
      }
    public void editDeadLine(date newDate)
      {
        deadLine = newDate;
      }
    public  void editOrAddMembers(int choose, member newMember)
      {
        if(choose == 1)
          {
            mArrayList.add(newMember);
          }
        else
            mArrayList.remove(newMember);
      }
    
  }
