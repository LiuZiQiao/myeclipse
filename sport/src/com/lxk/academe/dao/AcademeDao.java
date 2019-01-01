package com.lxk.academe.dao;

import com.lxk.domain.Academe;
import com.lxk.domain.Post;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AcademeDao
  extends HibernateDaoSupport
{
  public List<Academe> findAcademes()
  {
    String hql = "from Academe order by totalPost desc";
    List<Academe> list = getHibernateTemplate().find(hql);
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
  
  public Academe findAcademesById(Post post)
  {
    return (Academe)getHibernateTemplate().get(Academe.class, post.getAcademe().getAcid());
  }
  
  public void updateAcademe(Academe ac)
  {
    getHibernateTemplate().update(ac);
  }
  
  public Academe getAcademeByid(int parseInt)
  {
    return (Academe)getHibernateTemplate().get(Academe.class, Integer.valueOf(parseInt));
  }
  
  public void saveAcademe(Academe ac)
  {
    getHibernateTemplate().save(ac);
  }
  
  public void clearScore(List li)
  {
    for (int i = 0; i < li.size(); i++)
    {
      Academe ac = (Academe)li.get(i);
      ac.setCopper(Integer.valueOf(0));
      ac.setGold(Integer.valueOf(0));
      ac.setSilver(Integer.valueOf(0));
      ac.setTotalScore(Double.valueOf(0.0D));
      getHibernateTemplate().update(ac);
    }
  }
  
  public List findAcademe()
  {
    String hql = "from Academe order by totalScore desc";
    List<Academe> list = getHibernateTemplate().find(hql);
    if ((list != null) && (list.size() > 0)) {
      return list;
    }
    return null;
  }
}
