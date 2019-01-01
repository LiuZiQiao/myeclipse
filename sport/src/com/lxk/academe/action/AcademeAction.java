package com.lxk.academe.action;

import com.lxk.academe.service.AcademeService;
import com.lxk.domain.Academe;
import com.lxk.utils.ImportExecl;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

public class AcademeAction
  extends ActionSupport
{
  private AcademeService academeService;
  
  public void setAcademeService(AcademeService academeService)
  {
    this.academeService = academeService;
  }
  
  public String initAcademe()
  {
    String fileName = "学院.xlsx";
    ImportExecl poi = new ImportExecl();
    String pathload = ServletActionContext.getServletContext().getRealPath("/picture") + "\\" + fileName;
    List<List<String>> list = poi.read(pathload, fileName);
    for (int i = 1; i < list.size(); i++)
    {
      List<String> cellList = (List)list.get(i);
      Academe ac = new Academe();
      ac.setAcid(Integer.valueOf(Integer.parseInt(((String)cellList.get(0)).split("\\.")[0])));
      ac.setAcname((String)cellList.get(1));
      ac.setPicture((String)cellList.get(2));
      this.academeService.SaveAcademe(ac);
    }
    return "initAcademe";
  }
}
