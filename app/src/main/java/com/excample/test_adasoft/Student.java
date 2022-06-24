package com.excample.test_adasoft;

public class Student {
    private String id ;
    private String Fname ;
    private String Lname;
    private String tel;
    private String Email;

    public Student(String string, String cursorString, String s, String string1) {
        super();
    }

    public Student(String id, String fname, String lname, String tel, String email) {
        this.id = id;
        this.Fname = fname;
        this.Lname = lname;
        this.tel = tel;
        this.Email = email;
    }

    public Student() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
