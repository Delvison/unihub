package com.unihub.app;

import java.io.Serializable;
import javax.persistence.*;
 
@Entity
@Table(name="language")
public class MyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="message", nullable=false)
	private String message;

	@Column(name="language", nullable=false)
	private String language;

	public MyEntity() {}
 
	public MyEntity(String message, String language) {
	   this.message = message;
	   this.language = language;
	}
 
	public String toString() {
	   return "Greeting id=" + id + ", message=" + message + 
	        ", language=" + language;
	}
}