package com.lxk.domain;

import java.io.Serializable;

public class Admin
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer aid;
  private String aname;
  private String apwd;
  
  public Integer getAid()
  {
    return this.aid;
  }
  
  public void setAid(Integer aid)
  {
    this.aid = aid;
  }
  
  public String getAname()
  {
    return this.aname;
  }
  
  public void setAname(String aname)
  {
    this.aname = aname;
  }
  
  public String getApwd()
  {
    return this.apwd;
  }
  
  public void setApwd(String apwd)
  {
    this.apwd = apwd;
  }
}
