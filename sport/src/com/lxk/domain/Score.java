package com.lxk.domain;

import java.io.Serializable;

public class Score
  implements Serializable
{
  private Integer sid;
  private Game game;
  private Athlete athlete;
  private Integer sort;
  private Double integrate;
  private Double score;
  private Integer anum;
  
  public Integer getSid()
  {
    return this.sid;
  }
  
  public void setSid(Integer sid)
  {
    this.sid = sid;
  }
  
  public Game getGame()
  {
    return this.game;
  }
  
  public void setGame(Game game)
  {
    this.game = game;
  }
  
  public Athlete getAthlete()
  {
    return this.athlete;
  }
  
  public void setAthlete(Athlete athlete)
  {
    this.athlete = athlete;
  }
  
  public Integer getSort()
  {
    return this.sort;
  }
  
  public void setSort(Integer sort)
  {
    this.sort = sort;
  }
  
  public Double getIntegrate()
  {
    return this.integrate;
  }
  
  public void setIntegrate(Double integrate)
  {
    this.integrate = integrate;
  }
  
  public Double getScore()
  {
    return this.score;
  }
  
  public void setScore(Double score)
  {
    this.score = score;
  }
  
  public Integer getAnum()
  {
    return this.anum;
  }
  
  public void setAnum(Integer anum)
  {
    this.anum = anum;
  }
}
