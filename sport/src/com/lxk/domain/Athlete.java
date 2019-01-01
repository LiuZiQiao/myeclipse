package com.lxk.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Athlete
  implements Serializable
{
  private Integer aid;
  private Academe academe;
  private String aname;
  private String asex;
  private String snum;
  private Set<Score> scores = new HashSet();
  
  public Set<Score> getScores()
  {
    return this.scores;
  }
  
  public void setScores(Set<Score> scores)
  {
    this.scores = scores;
  }
  
  public Integer getAid()
  {
    return this.aid;
  }
  
  public void setAid(Integer aid)
  {
    this.aid = aid;
  }
  
  public Academe getAcademe()
  {
    return this.academe;
  }
  
  public void setAcademe(Academe academe)
  {
    this.academe = academe;
  }
  
  public String getAname()
  {
    return this.aname;
  }
  
  public void setAname(String aname)
  {
    this.aname = aname;
  }
  
  public String getAsex()
  {
    return this.asex;
  }
  
  public void setAsex(String asex)
  {
    this.asex = asex;
  }
  
  public String getSnum()
  {
    return this.snum;
  }
  
  public void setSnum(String snum)
  {
    this.snum = snum;
  }
}
