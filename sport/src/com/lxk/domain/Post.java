package com.lxk.domain;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;

public class Post
  implements Serializable
{
  private Integer pid;
  private Academe academe;
  private String content;
  private Timestamp time;
  
  public Integer getPid()
  {
    return this.pid;
  }
  
  public void setPid(Integer pid)
  {
    this.pid = pid;
  }
  
  public Academe getAcademe()
  {
    return this.academe;
  }
  
  public void setAcademe(Academe academe)
  {
    this.academe = academe;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setContent(String content)
  {
    this.content = content;
  }
  
  public Timestamp getTime()
  {
    return this.time;
  }
  
  public void setTime(Timestamp time)
  {
    this.time = time;
  }
  
  public static String getTrue(String c)
    throws UnsupportedEncodingException
  {
    return URLDecoder.decode(c, "UTF-8");
  }
}
