package com.kdhm;
import java.util.*;
import java.time.LocalDate; // import the LocalDate class

public class Date
{
	private int day;
	private int month ;
	private int year;

  public void error_check(int i, int low, int up){
  	if(i<low||i>up){
  		System.out.println("The entered value, "+i+" is not within the appropriate range of ["+low+ "and "+ up+"].");
  	}
  }

	public Date(int a, int b, int c)
	{
		error_check(b, 1, 12);
		if (c < 2020)
		{
			System.out.println("The entered value, "+c+" is for a date that is not supported");
		}
		if (b==1||b==3||b== 5||b== 7||b==8||b==10||b==12)
		{
			error_check(a, 1, 31);
		}
		else if (b == 2)
		{
			if ((c % 4) != 0)
			{
				error_check(a, 1, 28);
			}
			else
			{
			    error_check(a, 1, 29);
			}
		}
		else
		{
			error_check(a, 1, 30);
		}
		day = a;
		month = b;
		year = c;
	}
  public Date(String s){

    LocalDate myObj = LocalDate.now(); // Create a date object
    String k=myObj.toString();
    int index1 = k.indexOf("-");
    String j = k.substring(0,index1);
    //System.out.println("1.Index of - in date ="+index1+" corresponding substring= "+j);
    int y= (int)Intvar.r_int(j);
    year=y;
    int index2 = s.indexOf("-");
    String da = s.substring(0,index2);
    index2++; //get right index
    //System.out.println("2.Index of - in date ="+index1+" corresponding substring= "+da+" tail end ="+s.substring(index2));


    int d= (int)Intvar.r_int(da);
    day =d;
    if(s.substring(index2).equals("Jan")){
      month =1;
    }else if(s.substring(index2).equals("Feb")){
      month =2;
    }else if(s.substring(index2).equals("Mar")){
      month =3;
    }else if(s.substring(index2).equals("Apr")){
      month =4;
    }else if(s.substring(index2).equals("May")){
      month =5;
    }else if(s.substring(index2).equals("Jun")){
      month =6;
    }else if(s.substring(index2).equals("Jul")){
      month =7;
    }else if(s.substring(index2).equals("Aug")){
      month =8;
    }else if(s.substring(index2).equals("Sep")){
      month =9;
    }else if(s.substring(index2).equals("Oct")){
      month =10;
    }else if(s.substring(index2).equals("Nov")){
      month =11;
    }else if(s.substring(index2).equals("Dec")){
      month =12 ;
    }else{
      System.out.println("Error- Wrong month format - "+s.substring(index2));
    }

  }
    public void println(){
        System.out.println(day+"/"+month+"/"+year);
    }

}
