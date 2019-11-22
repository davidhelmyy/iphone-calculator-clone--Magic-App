package com.example.magiccalculator.Logic;


public class InfoCollector {

    private static String  day;
    private static String  month;
    private static String pass;

    private InfoCollector instance=new InfoCollector();


    public InfoCollector getInstance() {
        return instance;
    }


    public InfoCollector()
    {
        day=new String();
        month=new String();
        pass=new String();


    }




    public static void setDay(String day) {


        InfoCollector.day = day;
    }

    public static void setMonth(String month)
    {
        InfoCollector.month = month;
    }

    public static void setPass(String pass) {
        InfoCollector.pass = pass;
    }


    public static String getDay() {
        return day;
    }

    public static String getMonth() {
        return month;
    }

    public static String getPass() {
        return pass;
    }

    public static String getHorscope() {
        return knowMyZodiac();
    }



    public static void clearAll()
    {
        month="";
        day="";
        pass="";


    }


    private static String knowMyZodiac()
    {

        if(month.length()<4&&day.length()<3) {


            int MonthTemp=Integer.valueOf(month);
            int Daytemp=Integer.valueOf(day);

            switch (MonthTemp) {

                case 1:
                    return (Daytemp > 19) ? "Aquarius" : "Capricorn";
                case 2:
                    return (Daytemp > 18) ? "Pisces" : "Aquarius";
                case 3:
                    return (Daytemp > 20) ? "Aries" : "Pisces";
                case 4:
                    return (Daytemp > 19) ? "Taurus" : "Aries";
                case 5:
                    return (Daytemp > 20) ? "Gemini" : "Taurus";
                case 6:
                    return (Daytemp > 20) ? "Cancer" : "Gemini";
                case 7:
                    return (Daytemp > 22) ? "Leo" : "Cancer";
                case 8:
                    return (Daytemp > 22) ? "Virgo" : "Leo";
                case 9:
                    return (Daytemp > 22) ? "Libra" : "Virgo";
                case 10:
                    return (Daytemp > 22) ? "Scorpio" : "Libra";
                case 11:
                    return (Daytemp > 21) ? "Sagittarius" : "Scorpio";
                case 12:
                    return (Daytemp > 21) ? "Capricorn" : "Sagittarius";

                default:
                    return null;


            }


        }

        return null;
    }

}
