package com.lxk.score.action;

import com.lxk.domain.Score;
import com.lxk.score.service.ScoreService;
import com.lxk.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.util.List;

public class ScoreAction extends ActionSupport
{
  private ScoreService scoreService;
  private Integer currentPage;
  private Integer gid;
  
  public void setScoreService(ScoreService scoreService)
  {
    this.scoreService = scoreService;
  }
  
  public void setCurrentPage(Integer currentPage)
  {
    this.currentPage = currentPage;
  }
  
  public void setGid(Integer gid)
  {
    this.gid = gid;
  }
  
  public String inform()
  {
    PageBean<Score> pageBean = this.scoreService.queryScores(this.currentPage);
    
    ActionContext.getContext().getValueStack().set("pageBean", pageBean);
    return "inform";
  }
  
  public String queryResult()
  {
    List<Score> list = this.scoreService.queryAllScore();
    ActionContext.getContext().getValueStack().set("list", list);
    return "queryResult";
  }
  
  public String querySC()
  {
    List list = this.scoreService.querySC(this.gid);
    ActionContext.getContext().getValueStack().set("list", list);
    return "querySC";
  }
}
