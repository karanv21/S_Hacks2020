package com.kdhm;
import java.util.*;

public class Processed_data
{
	public Date trans_date;
	public String details;
	public Cashflow t;
	//public ArrayList<Date> installments = new ArrayList<Date>();
	public double t_amount;

//constructors
	Processed_data() {

	}
	Processed_data(Parsed_data p, String s){
		trans_date = p.get_trans_date();
		details= p.get_details();
		t= get_cashflow_type(s);
		t_amount= p.get_amount();
	}
	public Cashflow get_cashflow_type(String s){
		Cashflow result;
		if(s.equals("OPERATING EXPENSE")){
			result= Cashflow.OE;
		}else if(s.equals("COST OF GOODS SOLD")){
			result= Cashflow.CG;
		}else if(s.equals("REVENUE")){
			result= Cashflow.RE;
		}else if(s.equals("TAX")){
			result= Cashflow.T;
		}else if(s.equals("INTEREST")){
			result= Cashflow.I;
		}else if(s.equals("GENERAL AND ADMIN")){
			result= Cashflow.GA;
		}else{
			System.out.println("Unable to determine which type of cashflow");
			result=Cashflow.U;
		}
		return result;
	}
	private void println_ctype(){
		if(t==Cashflow.OE){
			System.out.println("Operating Costs");
		}else if(t==Cashflow.CG){
			System.out.println("Cost of Goods Sold");
		}else if(t==Cashflow.RE){
			System.out.println("Revenue");
		}else if(t==Cashflow.T){
			System.out.println("Tax");
		}else if(t==Cashflow.I){
			System.out.println("Interest");
		}else if(t==Cashflow.GA){
			System.out.println("General and Administrative costs");
		}else{
			System.out.println("Unable to determine which type of cashflow");
		}
	}
	public void println(){
		System.out.println("Transaction details = "+details);
		System.out.print("Transaction date = "); trans_date.println();
		System.out.println("Transaction amount = $");
		if(t_amount<0){
			String a= Double.toString(t_amount);
			a=a.substring(1,a.length());
			System.out.println("-$"+a);
		}else{
			System.out.println("$"+t_amount);
		}
		System.out.print("Transaction type = "); println_ctype();

	}

}
