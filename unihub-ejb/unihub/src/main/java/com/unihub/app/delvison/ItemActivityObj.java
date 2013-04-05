package com.unihub.app;

public class ItemActivityObj{
  private String[] activityLog;
  private int count;
  private int itemId;

  public ItemActivityObj(int itemId){
    activityLog = new String[10];
    this.itemId = itemId;
    this.count = 0;
  }

  public void addActivity(String someActivity){
  /* NOTIFY USER EVERYTIME AN ACTIVITY IS ADDED */
    if (count < activityLog.length){
      activityLog[count] = someActivity;
      count = count +1;
    } else {
      this.shiftArray();
      count = count -1;
      activityLog[count] = someActivity;
    }
  }

  public void shiftArray(){
  /* ERASES OLDEST ACTIVITY AND SHIFTS OTHERS UP BY 1 */
    activityLog[0] = null; //erase oldest activity
    int next=1;
    for (int current=0; current<activityLog.length-1; current++){
      activityLog[current] = activityLog[next];
      next = next+1;
    }
  }

  public String[] getActivityArray(){
    return activityLog;
  }
}