package com.lxk.athlete.service;

import com.lxk.athlete.dao.AthleteDao;
import com.lxk.domain.Athlete;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AthleteService
{
  private AthleteDao athleteDao;
  
  public void setAthleteDao(AthleteDao athleteDao)
  {
    this.athleteDao = athleteDao;
  }
  
  public Athlete findBySnum(String snum)
  {
    return this.athleteDao.findBySnum(snum);
  }
}
