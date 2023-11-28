package com.training.onetoone;

public class Student {
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Address getAddobj() {
		return addobj;
	}
	public void setAddobj(Address addobj) {
		this.addobj = addobj;
	}
	private Integer studentid;
	private String studentname;
	private Integer score;
	private Address addobj;

}
