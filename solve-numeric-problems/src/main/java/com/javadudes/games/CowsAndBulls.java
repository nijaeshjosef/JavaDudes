package com.javadudes.games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 
public class CowsAndBulls
{ 
    String inputString = "";
   
    public CowsAndBulls(String str)
    {
        this.inputString = str;
    }
    public static boolean lengthCheck(String str)
    {
        boolean lengthCriteriaMet = false;
       
        if(str.length() <= 10)
            lengthCriteriaMet = true;
       
        return lengthCriteriaMet;
    }
   
    public static boolean lengthCheck(String inputStr, String playerStr)
    {
        boolean lengthCriteriaMet = false;
       
        if(inputStr.length() == playerStr.length())
            lengthCriteriaMet = true;
       
        return lengthCriteriaMet;
    }
   
    public static boolean checkForRepetitions(String str)
    {
        Set<Character> charSet = new HashSet<Character>();
        boolean noRepetitions = true;
        
        for(int i = 0; i < str.length(); i++)
        {
            if(charSet.add(str.charAt(i)))
                continue;
            else
                noRepetitions = false;
        }
       
        return noRepetitions;
    }
 
    public static boolean standardCheck(String str, String playerStr, boolean player2Flag)
    {
        boolean meetsStandards = false;
       
        if(!player2Flag)
        {
            if(CowsAndBulls.lengthCheck(str))
                if(CowsAndBulls.checkForRepetitions(str))
                    meetsStandards = true;
        } else {
           
            if(CowsAndBulls.lengthCheck(str, playerStr))
                if(CowsAndBulls.checkForRepetitions(playerStr))
                    meetsStandards = true;
        }
       
        return meetsStandards;
    }
   
    public static boolean inputStrMatch(String player1Str, String player2Str)
    {
        if(player1Str.equalsIgnoreCase(player2Str))
            return true;
        else
            return false;
    }
   
    public static String returnCowsAndBulls(String player1Str, String player2Str)
    {
        char[] player1StrCharArray = player1Str.toCharArray();
        List<Character> player1CharacterList = new ArrayList<Character>();
        for(char c : player1StrCharArray)
           player1CharacterList.add(c);
       
        Set<Character> player1CharSet = new HashSet<Character>(player1CharacterList);
        int cows = 0;
        int bulls = 0;
       
        for(int i = 0; i < player2Str.length(); i++)
        {
            if(player1CharSet.add(player2Str.charAt(i)))
                continue;
            else
            {
                if(player1Str.charAt(i) == player2Str.charAt(i))
                    ++bulls;
                else
                    ++cows;
            }
        }
       
        return Integer.toString(bulls)+"~"+Integer.toString(cows);
       
    }
   
    public static void main(String args[])
    {
        HashMap<String, String> cowsAndBullsMap = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean metStandards = CowsAndBulls.standardCheck(str,"",false);
       
        for(int i = 0; i < (str.length()*2); i++)
        {
           
            String cowsAndBullsCount = "~";
            String playStr = sc.nextLine();
            boolean metPlayStandards = CowsAndBulls.standardCheck(str,playStr,true);
           
            boolean inputStringMatch = CowsAndBulls.inputStrMatch(str, playStr);
           
            if(inputStringMatch)
                System.out.println(playStr+"    YOU WON !!!");
            else if(metPlayStandards)
            {
                cowsAndBullsCount = CowsAndBulls.returnCowsAndBulls(str, playStr);
                System.out.println(playStr+"    [ Bulls : "+cowsAndBullsCount.split("~")[0]+" | Cows : "+ cowsAndBullsCount.split("~")[1]+" ]");
            }
               
            cowsAndBullsMap.put(playStr, cowsAndBullsCount);
        }
        
        sc.close();
       
    }
}