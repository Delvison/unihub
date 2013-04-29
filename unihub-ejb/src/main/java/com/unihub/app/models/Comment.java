/* 
This class is a model for comments
*/
package com.unihub.app;
import java.io.*;
import javax.persistence.*;

@Entity
public class Comment implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int commentId;
  
  @Column(name="user", nullable=false)
  String user;
  
  @Column(name="itemId", nullable=false)
  public int itemId;
  
  @Column(name="comment", nullable=true)
  String comment;
  
  public Comment(){
  }

  public Comment(String user, String comment, int itemId){
    this.user = user;
    this.comment = comment;
    this.itemId = itemId;
  }
  
    //function to return all content
  public String[] getContentArray(){
    String[] a = new String[2];
    a[0] = this.user;
    a[1] = this.comment;
    return a;       
  }
}
