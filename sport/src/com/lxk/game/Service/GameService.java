package com.lxk.game.Service;

import com.lxk.domain.Game;
import com.lxk.game.dao.GameDao;
import com.lxk.utils.PageBean;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GameService
{
  private GameDao gameDao;
  
  public void setGameDao(GameDao gameDao)
  {
    this.gameDao = gameDao;
  }
  
  public PageBean<Game> queryScores(Integer currentPage)
  {
    PageBean<Game> pageBean = new PageBean();
    pageBean.setCurrentPage(currentPage.intValue());
    int limit = 10;
    pageBean.setLimit(limit);
    int totleCount = this.gameDao.findGameCount();
    pageBean.setTotleCount(totleCount);
    int totlePages = (totleCount - 1) / limit + 1;
    pageBean.setTotlePages(totlePages);
    int begin = (currentPage.intValue() - 1) * limit;
    pageBean.setList(this.gameDao.findScoretList(null, begin, limit));
    return pageBean;
  }
  
  public PageBean<Game> queryScore(Integer currentPage)
  {
    PageBean<Game> pageBean = new PageBean();
    pageBean.setCurrentPage(currentPage.intValue());
    int limit = 10;
    pageBean.setLimit(limit);
    int totleCount = this.gameDao.findGameCounts();
    pageBean.setTotleCount(totleCount);
    int totlePages = (totleCount - 1) / limit + 1;
    pageBean.setTotlePages(totlePages);
    int begin = (currentPage.intValue() - 1) * limit;
    pageBean.setList(this.gameDao.findScoretLists(null, begin, limit));
    return pageBean;
  }
  
  public void saveGame(Game game)
  {
    this.gameDao.saveGame(game);
  }
  
  public void updateGame(Game game)
  {
    this.gameDao.updateGame(game);
  }
}
