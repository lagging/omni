package com.creditsaison.omni.pojos;

import java.util.ArrayList;
import java.util.List;

public class Test {


    private static boolean isPalindrome(int n){
        List<Integer> list = new ArrayList<>();
        while(n!=0){
            list.add(n%10);
            n=n/10;
        }

        int size = list.size();
        int lo=0;
        int hi=size-1;
        while(lo<hi){
            if(list.get(lo)!=list.get(hi)){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }




    public static void main(String[] args) {
        if (isPalindrome(99)){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }
}
