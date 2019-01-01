package com.lxk.score.dao;

import com.lxk.domain.Athlete;
import com.lxk.domain.Game;
import com.lxk.domain.Score;
import com.lxk.utils.PageHibernateCallback;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ScoreDao
  extends HibernateDaoSupport
{
  public int findScoreCount()
  {
    String hql = "select count(*) from Score";
    List<Long> list = getHibernateTemplate().find(hql);
    if ((list != null) && (list.size() > 0)) {
      return ((Long)list.get(0)).intValue();
    }
    return 0;
  }
  
  public List<Score> findScoretList(Object object, int begin, int limit)
  {
    String hql = "from Score";
    List<Score> list = (List)getHibernateTemplate().execute(new PageHibernateCallback(hql, null, begin, limit));
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
  
  public Score findScore(Athlete ath, Game game)
  {
    String hql = "from Score where athlete.aid=? and game.gid=?";
    List<Score> list = getHibernateTemplate().find(hql, new Object[] { ath.getAid(), game.getGid() });
    if ((list != null) && (list.size() > 0)) {
      return (Score)list.get(0);
    }
    return null;
  }
  
  public Score findScore1(String snum, Integer gid)
  {
    String hql = "from Score where athlete.snum=? and game.gid=?";
    List<Score> list = getHibernateTemplate().find(hql, new Object[] { snum, gid });
    if ((list != null) && (list.size() > 0)) {
      return (Score)list.get(0);
    }
    return null;
  }
  
  @Test
  public List findGoldCount()
  {
    String hql = "select count(*),athlete.academe.id from Score where sort=? group by athlete.academe.acid";
    List list = getHibernateTemplate().find(hql, Integer.valueOf(1));
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
  
  public List findsolverCount()
  {
    String hql = "select count(*),athlete.academe.id from Score where sort=? group by athlete.academe.acid";
    List list = getHibernateTemplate().find(hql, Integer.valueOf(2));
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
  
  public List findcopCount()
  {
    String hql = "select count(*),athlete.academe.id from Score where sort=? group by athlete.academe.acid";
    List list = getHibernateTemplate().find(hql, Integer.valueOf(3));
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
  
  public List findcIntCount()
  {
    String hql = "select Sum(integrate),athlete.academe.id from Score  group by athlete.academe.acid";
    List list = getHibernateTemplate().find(hql);
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
  
  public int findALLScoreCount()
  {
    String hql = "select count(*) from Score where sort<?";
    List<Long> list = getHibernateTemplate().find(hql, Integer.valueOf(4));
    if (((list != null ? 1 : 0) & (list.size() > 0 ? 1 : 0)) != 0) {
      return ((Long)list.get(0)).intValue();
    }
    return 0;
  }
  
  public List<Score> findAllScoretList(Object object, int begin, int limit)
  {
    String hql = "from Score where sort<? order by sid";
    List<Score> list = (List)getHibernateTemplate().execute(new PageHibernateCallback(hql, new Object[] { Integer.valueOf(4) }, begin, limit));
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
  
  public List querySC(Integer gid)
  {
    String hql = "from Score where game.gid=?";
    List list = getHibernateTemplate().find(hql, gid);
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
  
  public List<Score> findAllScoretList()
  {
    String hql = "select * from score  where  sort<4 and sort>0 order by gid,sort";
    Session s = getHibernateTemplate().getSessionFactory().getCurrentSession();
    Query q = s.createSQLQuery(hql).addEntity(Score.class);
    List list = q.list();
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
}
