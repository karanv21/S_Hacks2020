#include <iostream>
#include <string>
#include<fstream>
#include<vector>
#include <algorithm>
#include<ctime>

using namespace std;




void error_check(int &i, int low, int up){
	while(i<low||i>up){
		cout<<"\nEnter the appropriate value between "<<low<<"and "<<up<<"- ";
		cim>>i;
		cout<<'\n';
	}
}


class Date{
public:
	int day=1;
	int month=1;
	int year=2020;
	int total=0;



	int months_to_days()const{
		int result=0;
		if(month>=2){
			result+=31;
			if(month>=3){
				if((year%4)==0){
					result+=29;
				}else{
					result+=28;
				}
				if(month>=4){
					result+=31;
					if(month>=5){
						result+=30;
						if(month>=6){
							result+=31;
							if(month>=7){
								result+=30;
								if(month>=8){
									result+=31;
									if(month>=9){
										result+=31;
										if(month>=10){
											result+=30;
											if(month>=11){
												result+=31;
												if(month==12){
													result+=30;
												} 
											} 
										} 
									} 
								} 
							} 
						} 
					} 
				} 
			}
		}
	}

	int years_to_days()const{
		int result=0;
		for(int current_year=2020; current_year<year; current_year++){
			if((current_year%4)==0){
				result++;
			}
			result+=365;
		}
	}
	int total(){
		//treating 2020 as our "zero", we calculate the number of days since then
		total=years_to_days();
		total= months_to_days();
		total+=days;
	}
	Date(int a, int b, int c){
		error_check(b, 1, 12);
		while(c<2020){
			cout<<"\nEnter the appropriate value greater than 2020- ";
			cim>>c;
			cout<<'\n';
		}
		if(b==1||b==3||b==5||b=7||b==8||b==10||b==12){
			error_check(a, 1, 31);
		}else if(b==2){
			if((c%4)!=0){
				error_check(a, 1, 28);
			}else{
				error_check(a, 1, 29);
			}
		}else{
			error_check(a, 1, 30);
		}
		day=a;
		month=b;
		year=c;
		total();
	}
};


Date get_current_date(){
	// current date/time based on current system
   time_t now = time(0);

   cout << "Number of sec since January 1,1970:" << now << "\n";

   tm *ltm = localtime(&now);
   Date i;

   i.year = 1900 + ltm->tm_year
   cout << "Year:" << i.year << "\n";
   i.month = 1 + ltm->tm_mon;
   cout << "Month: "<< i.month<< "\n";
   i.day =ltm->tm_mday;
   cout << "Day: "<<  i.day << "\n";
   cout << "Time: "<< 1 + ltm->tm_hour << ":";
   cout << 1 + ltm->tm_min << ":";
   cout << 1 + ltm->tm_sec << "\n";

   return i;
}

class Parsed_data{
public:
	int ref_no;
	Date trans_date;
	Date post_date;
	string details;
	int amount;

};


enum class Expense { 
	Rent,  
	P_H, //Personal & Household Expenses,
	P_FS,//Professional and Financial Services,
	Retail_Grocery,
	Transportation,
	Leisure,//Hotels, Entertainment, and Recreation,
	Restaurants,
	Home_Improvement,//Home & Office Improvement,
	Health_Education,
	Transfers, //Cash Advances and Balance Transfers,
	Foreign_transactions,// Currency Transactions,
	Other_transactions
};

class Processed_data{
public:
	Date trans_date;
	string details;
	Expense t;
	vector <Date> installments;
	int t_amount;

};

string expense_str{Expense a}{
	if(a=Expense.Rent) return "Rent";  
	if(a=Expense.P_H) return "Personal & Household Expenses";
	if(a=Expense.P_FS) return "Professional and Financial Services";
	if(a=Expense.Retail_Grocery) return "Retail and Groceries";
	if(a=Expense.Transportation) return "Transportation";
	if(a=Expense.Leisure) return "Hotels, Entertainment, and Recreation";
	if(a=Expense.Restaurants) return "Restaurants";
	if(a=Expense.Home_Improvement) return "Home & Office Improvement";
	if(a=Expense.Health_Education) return "Health and Education";
	if(a=Expense.Transfers) return "Cash Advances and Balance Transfers";
	if(a=Expense.Foreign_transactions) return "Currency Transactions";
	if(a=Expense.Other_transactions) return "Other transactions";
}

void sort(vector<Date> &d){
	//insertion sort using the totals of the dates
	int i, key, j;  
    for (i = 1; i < d.size(); i++) 
    {  
        key = d[i].total;  
        j = i - 1;  
  
        /* Move elements of arr[0..i-1], that are  
        greater than key, to one position ahead  
        of their current position */
        while (j >= 0 && d[j].total > key) 
        {  
            d[j + 1] = d[j].total;  
            j = j - 1;  
        }  
        d[j + 1] = key;  
    }  
}

vector<int> count(vector<Date> d){
	vector <int> n[31];
	for(int i=0; i<d.size(); i++){
		n[d.day-1]++;
	}
	return n;
}

int max_index(vector <int> v){
	for(int i=v.size()-1; i<0; i--){
		if(v[i]>0){
			return i+1;
		}
	}
}

int min_index(vector<int> v){
	for(int i=0; i<v.size(); i++){
		if(v[i]>0){
			return i+1;
		}
	}
}

int weighted_index(vector<int> v){
	int sum=0;
	for(int i=0; i<v.size(); i++){
		sum+=v[i];
	}

	int weighed_sum=0;
	for(int i=0; i<v.size();i++){
		weighed_sum+=((v[i]*(i+1))/sum);
	}
	return weighed_sum;
}

int average_index(vector<int> v){
	float sum=0;
	float count=0;
	for(int i=0; i<v.size(); i++){
		if(v[i]>0){
			sum+=(i+1);
			count++;
		}
	}
	float average = sum/count;  //we could use floating point division if need be
	return int(ceil(average)); //cast into into
}

int m_frequent(vector<int> v){
	int largest_index=0;
	for(int i=1; i<v.size();i++){
		if(v[i]>v[largest_index]){
			largest_index=i;
		}
	}
	return largest_index+1;
}

class Record{
public: 
	vector<Processed_data> v={};
	int n=0;
	vector<Date> window;

	void update_window(){
		vector<Date> rough_window;
		vector<Date> installments_window;
		for(int i=0; i<v.size(); i++){
			rough_window.push_back(v[i].trans_date);
			// for(int j=0; j<v[i].installments; j++){
			// 	installments_window.push_back(v[i].installments[j]);
			// }
		}

		//just realised this might be uselesss lol
		sort(rough_window);
		// sort(installments_window); 
		//go through each item and find adjacent dates- look for diff months check those etc


		vector<int> calc_1= count(rough_window);
		for(int i=0; i<calc_1.size(); i++){
			cout<<"\n"<<i+1<<" - ";
			for(int j=0; j<calc_1[i]; j++){
				cout<<"*";
			}
		}
		// vector<int> calc_2= count(installments_window);
		// for(int i=0; i<calc_1.size(); i++){
		// 	cout<<"\n"<<i+1<<" - ";
		// 	for(int j=0; j<calc_1[i]; j++){
		// 		cout<<"*";
		// 	}
		// }

		//store the latest, earliest, average, most frequent
		int max_1 = max_index(calc_1);
		int min_1 = min_index(calc_1);
		int ave_1 = average_index(calc_1);
		int weight_1 = weighted_index(calc_1);
		int frequent_1= m_frequent(calc_1)''
		Date current = get_current_date();
		Date latest_1(max_1, current.month, current.year);		window.pushback(latest_1);
		Date earliest_1(min_1, current.month, current.year);	window.pushback(earliest_1);
		Date average_1(ave_1, current.month, current.year);		window.pushback(average_1);
		Date weighted_1(weight_1, current.month, current.year);	window.pushback(weighted_1);		//error checking so that the month and day and year make sense e.g. 29th feb 2021 or 31 june 2022
		Date m_frequent_1(frequent_1, current.month, current.year); window.pushback(m_frequent_1);
		window.pushback(latest_1);

		// int max_2 = max_index(calc_2); 
		// int min_2 = min_index(calc_2);
		// int ave_2 = average_index(calc_2); 
		// int weighed_2 = weighted_index(calc_2);
		// int frequent_2= m_frequent(calc_2);
		// Date latest_2(max_2, current.month, current.year);		window.pushback(latest_2);
		// Date earliest_2(min_2, current.month, current.year);	window.pushback(earliest_2);
		// Date average_2(ave_2, current.month, current.year);		window.pushback(average_2);
		// Date weighted_2(weight_2, current.month, current.year);		window.pushback(weighted_2);//error checking so that the month and day and year make sense e.g. 29th feb 2021 or 31 june 2022 --- one way to deal with is calculate the difference between the end of a specific month and payment date and calculating which difference is maxx, ave, weighted....
		// Date m_frequent_2(frequent_2, current.month, current.year);  window.pushback(m_frequent_2);
		
		//repeats(windows); - also not sure how to handle installment paymetns
	}

	bool search(Date d){
		bool result=false;
		for(int i=0; i<windows.size(); i++){
			if(result==true) return result;
			result = (d.day==windows[i].day)&&(d.month==windows[i].month)&&(d.year==windows[i].year);
		}
		return result;
	}

	void alert()const{
		if(search(get_current_date())){
			string expense= expense_str(v[0].t); 
			cout<<"\nYYYOOOOOOOO "<<v[0].details<<", which is a "<<expense<<" needs to be paid my guy\n";
		}
	}


};

//create a record of all processed_data that has similar names return a vector of records
//within every record		
	//create a window
	//create an alert


int main(){
	return 0;
}


//tasks left
//track balance by comparing it to previous payments
//take note on months where the same payment was made twice then mark the earlier one as an installment and corresponding installment amount
//try to use amounts paid to estimate how much the monthly bill is worth
//uncomment work on installments
//alerts should look at main window and installment window but main window takes precedence
//access bank data
//convert to java
//parser- need to learn how to do that in java
//test both when working
//integrate to app