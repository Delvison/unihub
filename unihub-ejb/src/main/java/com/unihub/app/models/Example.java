package com.unihub.app;
import java.util.Date;
import java.io.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Example implements Serializable {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;
  @NotNull public String name;
	
  public Example(String name){
    this.name = name;
  }
}