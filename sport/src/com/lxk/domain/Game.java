package com.lxk.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Game implements Serializable
{
  private Integer gid;
  private String gname;
  private String groupType;
  private String start;
  private String gdate;
  private String groupCount;
  private String people;
  private String gameType;
  
  public String getGameType()
  {
    return this.gameType;
  }
  
  public void setGameType(String gameType)
  {
    this.gameType = gameType;
  }
  
  private Set<Score> scores = new HashSet();
  
  public Integer getGid()
  {
    return this.gid;
  }
  
  public void setGid(Integer gid)
  {
    this.gid = gid;
  }
  
  public String getGname()
  {
    return this.gname;
  }
  
  public void setGname(String gname)
  {
    this.gname = gname;
  }
  
  public String getGroupType()
  {
    return this.groupType;
  }
  
  public void setGroupType(String groupType)
  {
    this.groupType = groupType;
  }
  
  public String getStart()
  {
    return this.start;
  }
  
  public void setStart(String start)
  {
    this.start = start;
  }
  
  public String getGdate()
  {
    return this.gdate;
  }
  
  public void setGdate(String gdate)
  {
    this.gdate = gdate;
  }
  
  public String getGroupCount()
  {
    return this.groupCount;
  }
  
  public void setGroupCount(String groupCount)
  {
    this.groupCount = groupCount;
  }
  
  public String getPeople()
  {
    return this.people;
  }
  
  public void setPeople(String people)
  {
    this.people = people;
  }
  
  public Set<Score> getScores()
  {
    return this.scores;
  }
  
  public void setScores(Set<Score> scores)
  {
    this.scores = scores;
  }
}
