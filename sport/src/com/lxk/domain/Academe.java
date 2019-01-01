package com.lxk.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Academe
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer acid;
  private String acname;
  private String picture;
  private Integer gold;
  private Integer silver;
  private Integer copper;
  private Double totalScore;
  private Integer totalPost;
  private Set athletes = new HashSet(0);
  private Set posts = new HashSet(0);
  
  public Integer getAcid()
  {
    return this.acid;
  }
  
  public void setAcid(Integer acid)
  {
    this.acid = acid;
  }
  
  public String getAcname()
  {
    return this.acname;
  }
  
  public void setAcname(String acname)
  {
    this.acname = acname;
  }
  
  public String getPicture()
  {
    return this.picture;
  }
  
  public void setPicture(String picture)
  {
    this.picture = picture;
  }
  
  public Integer getGold()
  {
    return this.gold;
  }
  
  public void setGold(Integer gold)
  {
    this.gold = gold;
  }
  
  public Integer getSilver()
  {
    return this.silver;
  }
  
  public void setSilver(Integer silver)
  {
    this.silver = silver;
  }
  
  public Integer getCopper()
  {
    return this.copper;
  }
  
  public void setCopper(Integer copper)
  {
    this.copper = copper;
  }
  
  public Double getTotalScore()
  {
    return this.totalScore;
  }
  
  public void setTotalScore(Double totalScore)
  {
    this.totalScore = totalScore;
  }
  
  public Integer getTotalPost()
  {
    return this.totalPost;
  }
  
  public void setTotalPost(Integer totalPost)
  {
    this.totalPost = totalPost;
  }
  
  public Set getAthletes()
  {
    return this.athletes;
  }
  
  public void setAthletes(Set athletes)
  {
    this.athletes = athletes;
  }
  
  public Set getPosts()
  {
    return this.posts;
  }
  
  public void setPosts(Set posts)
  {
    this.posts = posts;
  }
}
