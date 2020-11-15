package com.example.ikbq.entity;


public class Menuinfo {

  private Long mid;
  private String name;
  private String num;
  private String fnum;
  private String fname;

  public String getFname()
  {
    return fname;
  }

  public void setFname(String fname)
  {
    this.fname = fname;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  private String url;


  public Long getMid() {
    return mid;
  }

  public void setMid(Long mid) {
    this.mid = mid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }


  public String getFnum() {
    return fnum;
  }

  public void setFnum(String fnum) {
    this.fnum = fnum;
  }

}
