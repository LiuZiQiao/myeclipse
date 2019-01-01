package com.lxk.utils;

import java.util.List;

public class PageBean<T>
{
  private int currentPage;
  private int totlePages;
  private int totleCount;
  private int limit;
  private List<T> list;
  
  public void setCurrentPage(int currentPage)
  {
    this.currentPage = currentPage;
  }
  
  public void setTotlePages(int totlePages)
  {
    this.totlePages = totlePages;
  }
  
  public void setTotleCount(int totleCount)
  {
    this.totleCount = totleCount;
  }
  
  public void setLimit(int limit)
  {
    this.limit = limit;
  }
  
  public void setList(List<T> list)
  {
    this.list = list;
  }
  
  public int getCurrentPage()
  {
    return this.currentPage;
  }
  
  public int getTotlePages()
  {
    return this.totlePages;
  }
  
  public int getTotleCount()
  {
    return this.totleCount;
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public List<T> getList()
  {
    return this.list;
  }
}
