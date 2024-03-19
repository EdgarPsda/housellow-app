package com.psdadev.housellow.housellowapp.utils;

public class ValidationsUtils {

  public static boolean isNumeric(String str){
    System.out.println(str);
    return str.matches("\\d+");
  }

}
