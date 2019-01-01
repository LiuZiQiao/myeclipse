package com.lxk.utils;

public class Dealtime
{
  public static String dealTime(String s)
  {
    if (s.contains(":")) {
      return s.trim();
    }
    float a = Float.parseFloat(s);
    int m = (int)Math.rint((a * 24.0F - Math.floor(a * 24.0F)) * 60.0D);
    if (m < 10) {
      return (int)Math.floor(a * 24.0F) + ":" + "0" + m;
    }
    return (int)Math.floor(a * 24.0F) + ":" + m;
  }
}
