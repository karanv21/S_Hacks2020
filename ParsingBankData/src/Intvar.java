import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class Intvar {
    public static double r_int(String s){
        int size = s.length();
        int decim = s.indexOf(".");
        int negative = s.indexOf("-");
        //System.out.println("Is negative? Negative index - "+negative);
        double total=0;

        if(decim>-1){
            for(int i=size-1; i>decim;i--){
                if(r_int(s.charAt(i) )>-1) {
                    int pos= (i-decim);
                    double pv= Math.pow(10, -pos);
                    double val = r_int(s.charAt(i)) * pv;
                    total = total + val;
                    //System.out.println("Position - "+pos+" - equivalent value ="+val);
                }else{
                    //System.out.println("Error- string containing weird characters past to int parser - "+s);
                }
            }
            for(int i=decim-1; i>=0;i--){
                if(r_int(s.charAt(i) )>-1) {
                    int pos= (decim -i-1);
                    double pv= Math.pow(10, pos);
                    double val = r_int(s.charAt(i)) *pv;
                    total = total + val;
                    //System.out.println("Position - "+pos+" - equivalent value ="+val);
                }else{
                    System.out.println("Error- string containing weird characters past to int parser - "+s);
                }
            }
        }else{
            for(int i=size-1; i>=0;i--){
                if(r_int(s.charAt(i) )>-1) {
                    int pos= size-1-i;
                    double pv= Math.pow(10, pos);
                    double val = r_int(s.charAt(i)) * pv;
                    total = total + val;
                    //System.out.println("Position - "+pos+" - equivalent value ="+val);
                }else{
                    //System.out.println("Error- string containing weird characters past to int parser - "+s);
                }
            }
        }

        if(negative>0){
            total = total*-1;
        }
        //System.out.println("Output ="+total);
        return total;
    }
    public static int r_int(char c){
        if(c=='0'){
          return 0;
        }else if(c=='1'){
            return 1;
        }else if(c=='2'){
            return 2;
        }else if(c=='3'){
            return 3;
        }else if(c=='4'){
            return 4;
        }else if(c=='5'){
            return 5;
        }else if(c=='6'){
            return 6;
        }else if(c=='7'){
            return 7;
        }else if(c=='8'){
            return 8;
        }else if(c=='9'){
            return 9;
        }else{
            return -1;
        }
    }

}
