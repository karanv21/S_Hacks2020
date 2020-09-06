package com.kdhm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {

//    public static void main(String[] args) throws IOException {
//
//    }
    public static List<Parsed_data> parse() throws IOException {
        List<Parsed_data> v = handleCSV();
        return v;
    }

    public static List<Parsed_data> handleCSV() throws IOException {
        List<Parsed_data> datasheet = new ArrayList<Parsed_data>(100);
//        String path = "C:\\Users\\Dhiraj\\Desktop\\SampleBankStatement.csv";
        String path = "/Users/dhiraj.h/Downloads/statement.csv";
        FileInputStream file = new FileInputStream(path);
        BufferedReader csv_reader = new BufferedReader(new InputStreamReader(file));

        String row;
        //int count=0;
        while ((row = csv_reader.readLine()) != null) {

            String[] data = row.split(",");
            String d_1= data[0];
            String d_2= data[1];
            String d_3= data[2];
            String d_4= data[3];
            String d_5= data[4];
//            System.out.println(d_1);
//            System.out.println(d_2);
//            System.out.println(d_3);
//            System.out.println(d_4);
//            System.out.println(d_5);
            //Parsed_data a = new Parsed_data();
            if((!data[1].equals("TRANS. DATE")/*&&datasheet.size()<10*/)) {
                //System.out.println("Run");
                //datasheet.get(datasheet.size()-1).print();

                Parsed_data a = new Parsed_data();
                a= new Parsed_data(d_1, d_2, d_3, d_4, d_5);
                //datasheet.get(datasheet.size()-1).print();
                //datasheet.set(count,a);

//                if(datasheet.size()>1) {
//                    for(int i=0; i< datasheet.size(); i++) {
//                        datasheet.get(i).print();
//                    }
//                }
                datasheet.add(a);
                //datasheet.get(0).print();
              // count++;
               //a.print();
            }else{
                //System.out.println("First row");
            }
           //a.print();
            System.out.println(" ");
        }
        csv_reader.close();
//        for(int i=0; i<datasheet.size(); i++){
//            datasheet.get(i).print();
//        }

        return datasheet;
    }
}
