/* 
This class is a model for comments
*/
package com.unihub.app;
import java.io.*;

<<<<<<< HEAD
=======
import java.io.*;

>>>>>>> 45097bd0872f80c7e0602de8789669de13c36f0f
public class Comment implements Serializable{
  String user;
  int commentId;
  public int itemId;
  String comment;
  
  public Comment(String user, String comment, int commentId, int itemId){
    this.user = user;
    this.comment = comment;
    this.commentId = commentId;
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
