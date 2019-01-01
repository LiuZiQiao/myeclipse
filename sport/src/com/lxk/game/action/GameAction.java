package com.lxk.game.action;

import com.lxk.game.Service.GameService;
import com.lxk.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class GameAction
  extends ActionSupport
{
  private GameService gameService;
  private Integer currentPage;
  
  public void setGameService(GameService gameService)
  {
    this.gameService = gameService;
  }
  
  public void setCurrentPage(Integer currentPage)
  {
    this.currentPage = currentPage;
  }
  
  public String queryGames()
  {
    PageBean pageBean = this.gameService.queryScores(this.currentPage);
    ActionContext.getContext().getValueStack().set("pageBean", pageBean);
    return "queryGames";
  }
}
