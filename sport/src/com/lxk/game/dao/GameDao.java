package com.lxk.game.dao;

import com.lxk.domain.Game;
import com.lxk.utils.PageHibernateCallback;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GameDao  extends HibernateDaoSupport
{
  public int findGameCount()
  {
    String hql = "select count(*) from Game order by gname";
    List<Long> list = getHibernateTemplate().find(hql);
    if ((list != null) && (list.size() > 0)) {
      return ((Long)list.get(0)).intValue();
    }
    return 0;
  }
  
  public List<Game> findScoretList(Object object, int begin, int limit)
  {
    String hql = "from Game order by gname";
    List<Game> list = (List)getHibernateTemplate().execute(new PageHibernateCallback(hql, null, begin, limit));
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
  
  public void saveGame(Game game)
  {
    getHibernateTemplate().save(game);
  }
  
  public void updateGame(Game game)
  {
    getHibernateTemplate().update(game);
  }
  
  public int findGameCounts()
  {
    String hql = "select  count(*) from Game where gameType=?";
    List<Long> list = getHibernateTemplate().find(hql, "����");
    if ((list != null) && (list.size() > 0)) {
      return ((Long)list.get(0)).intValue();
    }
    return 0;
  }
  
  public List<Game> findScoretLists(Object object, int begin, int limit)
  {
    String hql = "from Game where gameType=?";
    List<Game> list = (List)getHibernateTemplate().execute(new PageHibernateCallback(hql, new Object[] { "����" }, begin, limit));
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
}
