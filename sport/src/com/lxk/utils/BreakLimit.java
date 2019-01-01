package com.lxk.utils;

import java.util.List;

public class BreakLimit
{
  public static int[] Test(List<String> cellList, int size)
  {
    if (size == 5)
    {
      int index = 0;int[] arr = new int[size + 1];int state = 0;
      for (String li1 : cellList)
      {
        String li = li1.replace("\n", "").replaceAll(" ", "");
        if (li.equals("����"))
        {
          arr[0] = (index++);state++;
        }
        else if (li.equals("��������"))
        {
          arr[1] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[2] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[3] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[4] = (index++);state++;
        }
        else
        {
          index++;
        }
      }
      if (state != size) {
        arr[size] = -1;
      }
      return arr;
    }
    if (size == 7)
    {
      int index = 0;int[] arr = new int[size + 1];int state = 0;
      for (String li1 : cellList)
      {
        String li = li1.replace("\n", "").replaceAll(" ", "");
        if (li.equals("����"))
        {
          arr[0] = (index++);state++;
        }
        else if (li.equals("��������"))
        {
          arr[1] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[2] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[3] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[4] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[5] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[6] = (index++);state++;
        }
        else
        {
          index++;
        }
      }
      if (state != size) {
        arr[size] = -1;
      }
      return arr;
    }
    if (size == 8)
    {
      int index = 0;int[] arr = new int[size + 1];int state = 0;
      for (String li1 : cellList)
      {
        String li = li1.replace("\n", "").replaceAll(" ", "");
        if (li.equals("����"))
        {
          arr[0] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[1] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[2] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[3] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[4] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[5] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[6] = (index++);state++;
        }
        else if (li.equals("��������"))
        {
          arr[7] = (index++);state++;
        }
        else
        {
          index++;
        }
      }
      if (state != size) {
        arr[size] = -1;
      }
      return arr;
    }
    if (size == 4)
    {
      int index = 0;int[] arr = new int[size + 2];int state = 0;
      for (String li1 : cellList)
      {
        String li = li1.replace("\n", "").replaceAll(" ", "");
        if (li.equals("��������"))
        {
          arr[0] = (index++);state++;
        }
        else if (li.equals("��������"))
        {
          arr[1] = (arr[3] = index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[2] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[4] = (index++);state++;
        }
        else
        {
          index++;
        }
      }
      if (state != size + 1) {
        arr[(size + 1)] = -1;
      }
      return arr;
    }
    if (size == 6)
    {
      int index = 0;int[] arr = new int[size + 2];int state = 0;
      for (String li1 : cellList)
      {
        String li = li1.replace("\n", "").replaceAll(" ", "");
        if (li.equals("��������"))
        {
          arr[0] = (index++);state++;
        }
        else if (li.equals("��������"))
        {
          arr[1] = (arr[3] = index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[2] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[4] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[5] = (index++);state++;
        }
        else if (li.equals("����"))
        {
          arr[6] = (index++);state++;
        }
        else
        {
          index++;
        }
      }
      if (state != size + 1) {
        arr[(size + 1)] = -1;
      }
      return arr;
    }
    return null;
  }
}
