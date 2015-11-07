package com.examplemyapplication;

/**
 * Created by 007 on 2015/11/7.
 */
public class StringMatcher {
    public static boolean match(String value,String keyword){
        if (value ==null || keyword ==null){
            return false;
        }
        if (keyword.length()>value.length()){
            return false;
        }
        int i = 0,j=0;
        do {
            if (keyword.charAt(j)== value.charAt(i)){
                i++;
                j++;
            }
            else if (j>0){
                break;
            }else {
                j++;
            }
        }while (i<value.length()&&j<keyword.length());
        return (j == keyword.length())?true:false;
    }
}
