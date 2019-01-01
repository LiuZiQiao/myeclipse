package com.lxk.athlete.action;

import com.lxk.athlete.service.AthleteService;
import com.opensymphony.xwork2.ActionSupport;

public class AthleteAction extends ActionSupport
{
  private AthleteService athleteService;
  
  public void setAthleteService(AthleteService athleteService)
  {
    this.athleteService = athleteService;
  }
}
