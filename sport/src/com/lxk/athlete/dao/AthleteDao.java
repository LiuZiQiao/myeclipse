package com.lxk.athlete.dao;

import com.lxk.domain.Athlete;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AthleteDao
  extends HibernateDaoSupport
{
  public Athlete findBySnum(String snum)
  {
    String hql = "from Athlete where snum=?";
    List<Athlete> alist = getHibernateTemplate().find(hql, snum);
    if ((alist != null) && (alist.size() > 0)) {
      return (Athlete)alist.get(0);
    }
    return null;
  }
}
