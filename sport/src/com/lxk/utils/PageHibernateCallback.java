package com.lxk.utils;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class PageHibernateCallback<T>
  implements HibernateCallback<List<T>>
{
  private String hql;
  private Object[] params;
  private int startIndex;
  private int pageSize;
  
  public PageHibernateCallback(String hql, Object[] params, int startIndex, int pageSize)
  {
    this.hql = hql;
    this.params = params;
    this.startIndex = startIndex;
    this.pageSize = pageSize;
  }
  
  public List<T> doInHibernate(Session session)
    throws HibernateException, SQLException
  {
    Query query = session.createQuery(this.hql);
    if (this.params != null) {
      for (int i = 0; i < this.params.length; i++) {
        query.setParameter(i, this.params[i]);
      }
    }
    query.setFirstResult(this.startIndex);
    query.setMaxResults(this.pageSize);
    
    return query.list();
  }
}
