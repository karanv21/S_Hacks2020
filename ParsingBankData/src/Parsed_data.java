public class Parsed_data
{
	public static int ref_no;
	public static Date trans_date;
	public static Date post_date;
	public static String details;
	public static double amount;
    Parsed_data(){

    }
  Parsed_data(String a, String t, String p, String d, String c){
    ref_no = (int)Intvar.r_int(a);//change
    trans_date= new Date(t);
    post_date= new Date(p);
    details =d;
    amount =Intvar.r_int(c);//change
  }
    public static void print() {
        System.out.println("REF#: "+ ref_no);
        System.out.print("Transaction date: "); trans_date.println();
        System.out.print("Post date: "); post_date.println();
        System.out.println("Details: "+ details);
        System.out.println("Amount($): "+ amount);
    }
}
