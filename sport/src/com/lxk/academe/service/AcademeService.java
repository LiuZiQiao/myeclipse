package com.lxk.academe.service;

import com.lxk.academe.dao.AcademeDao;
import com.lxk.domain.Academe;
import com.lxk.domain.Post;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AcademeService
{
  private AcademeDao academeDao;
  
  public void setAcademeDao(AcademeDao academeDao)
  {
    this.academeDao = academeDao;
  }
  
  public List<Academe> findAcademes()
  {
    return this.academeDao.findAcademes();
  }
  
  public Academe findAcademesById(Post post)
  {
    return this.academeDao.findAcademesById(post);
  }
  
  public void UpdateAcademe(Academe ac)
  {
    this.academeDao.updateAcademe(ac);
  }
  
  public Academe getAcademeByid(int parseInt)
  {
    return this.academeDao.getAcademeByid(parseInt);
  }
  
  public void SaveAcademe(Academe ac)
  {
    this.academeDao.saveAcademe(ac);
  }
  
  public void clearScore(List li)
  {
    this.academeDao.clearScore(li);
  }
  
  public List findAcademe()
  {
    return this.academeDao.findAcademe();
  }
}
