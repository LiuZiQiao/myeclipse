package com.lxk.score.service;

import com.lxk.domain.Athlete;
import com.lxk.domain.Game;
import com.lxk.domain.Score;
import com.lxk.score.dao.ScoreDao;
import com.lxk.utils.PageBean;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ScoreService
{
  private ScoreDao scoreDao;
  
  public void setScoreDao(ScoreDao scoreDao)
  {
    this.scoreDao = scoreDao;
  }
  
  public PageBean<Score> queryScores(Integer currentPage)
  {
    PageBean<Score> pageBean = new PageBean();
    pageBean.setCurrentPage(currentPage.intValue());
    int limit = 10;
    pageBean.setLimit(limit);
    int totleCount = this.scoreDao.findScoreCount();
    pageBean.setTotleCount(totleCount);
    int totlePages = (totleCount - 1) / limit + 1;
    pageBean.setTotlePages(totlePages);
    int begin = (currentPage.intValue() - 1) * limit;
    pageBean.setList(this.scoreDao.findScoretList(null, begin, limit));
    return pageBean;
  }
  
  public Score findScore(Athlete ath, Game game)
  {
    return this.scoreDao.findScore(ath, game);
  }
  
  public Score findScore1(String snum, Integer gid)
  {
    return this.scoreDao.findScore1(snum, gid);
  }
  
  public List findGoldCount()
  {
    return this.scoreDao.findGoldCount();
  }
  
  public List findsolverCount()
  {
    return this.scoreDao.findsolverCount();
  }
  
  public List findcopCount()
  {
    return this.scoreDao.findcopCount();
  }
  
  public List findcIntCount()
  {
    return this.scoreDao.findcIntCount();
  }
  
  public List<Score> queryAllScore()
  {
    return this.scoreDao.findAllScoretList();
  }
  
  public List querySC(Integer gid)
  {
    return this.scoreDao.querySC(gid);
  }
}
