package com.gesac.pub;

import java.text.SimpleDateFormat;
 
 
public class jdbctest {
    public static void main(String[] args) throws Exception {
    	SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
        String date = sDateFormat.format(new java.util.Date());
 System.out.println(date);
    }
 
}
