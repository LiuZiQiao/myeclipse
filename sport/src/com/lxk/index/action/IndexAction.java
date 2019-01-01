package com.lxk.index.action;

import com.lxk.academe.service.AcademeService;
import com.lxk.score.service.ScoreService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.util.List;

public class IndexAction
  extends ActionSupport
{
  private ScoreService scoreService;
  private AcademeService academeService;
  
  public void setScoreService(ScoreService scoreService)
  {
    this.scoreService = scoreService;
  }
  
  public void setAcademeService(AcademeService academeService)
  {
    this.academeService = academeService;
  }
  
  public String execute()
  {
    List aclist = this.academeService.findAcademe();
    ActionContext.getContext().getValueStack().set("aclist", aclist);
    return "success";
  }
}
