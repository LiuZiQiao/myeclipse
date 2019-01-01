package com.lxk.Interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import java.util.Map;

public class PrivateInterceptor extends MethodFilterInterceptor
{
  private static final long serialVersionUID = 1L;
  
  protected String doIntercept(ActionInvocation arg0)
    throws Exception
  {
    Object admin = arg0.getInvocationContext().getSession().get("admin");
    if (admin != null) {
      return arg0.invoke();
    }
    arg0.getInvocationContext().getSession().put("error", "��������������");
    return "login";
  }
}
