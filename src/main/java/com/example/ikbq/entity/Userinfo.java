package com.example.ikbq.entity;


public class Userinfo {

  private Long uid;
  private String account;
  private String password;
  private String name;
  private String sex;
  private String stu;
  private Long did;
  private String dname;

  public String getDname()
  {
    return dname;
  }

  public void setDname(String dname)
  {
    this.dname = dname;
  }

  public Long getDid()
  {
    return did;
  }

  public void setDid(Long did)
  {
    this.did = did;
  }

  public String getRole()
  {
    return role;
  }

  public void setRole(String role)
  {
    this.role = role;
  }

  private String role;

  public String getDate()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  private String date;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getSex()
  {
    return sex;
  }

  public void setSex(String sex)
  {
    this.sex = sex;
  }

  public String getStu()
  {
    return stu;
  }

  public void setStu(String stu)
  {
    this.stu = stu;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
