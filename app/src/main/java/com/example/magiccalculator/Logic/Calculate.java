package com.example.magiccalculator.Logic;

import com.example.magiccalculator.InfexExpression;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculate {



    private static  double forceNumber;
    private static int presses;
    private static InfexExpression converter;
    private static final Calculate ourInstance = new Calculate();

    private Calculate() {
        forceNumber=0;
        presses=3;
        converter=new InfexExpression();
    }

    public static int getPresses()
    {
        return presses;
    }

    public static void setForceNumber(double forceNumber)
    {
        Calculate.forceNumber=forceNumber;
    }

    public static void setPresses(int presses)
    {
        Calculate.presses=presses;
    }



    //Function used to return final number to display
    public static String CalculateExpression(String exp,int presses)
    {

        if(presses==Calculate.presses&& Calculate.forceNumber!=0)
        return Calculate.decimalAdder(Calculate.forceNumber);

        else
            return Calculate.decimalAdder(Calculate.converter.EvaluateString(exp));


    }

    public static String getForceNumber()
    {
        return String.valueOf(forceNumber);
    }




    public static String decimalAdder(String number)
    {
        DecimalFormat format= new DecimalFormat("#,###,###");

        return format.format(Double.valueOf(number));

    }


    public static String decimalAdder(double number)
    {
        DecimalFormat format= new DecimalFormat("#,###,###,###");

        return format.format(number);

    }









    public static Calculate getInstance() {
        return ourInstance;
    }
}
