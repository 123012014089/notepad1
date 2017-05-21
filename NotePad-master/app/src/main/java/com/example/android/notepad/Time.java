package com.example.android.notepad;

        import java.text.SimpleDateFormat;
        import java.util.Date;

public class Time
{
    private static String defaultDatePattern = "yyyy-MM-dd";
    private static String defaultTimeStampPattern = "yyyy-MM-dd HH:mm:ss";
    public static String getToday()
    {
        Date today = new Date();
        return convertDateToString(today,defaultDatePattern);
    }
    public static String getTodayTimeStampString()
    {
        Date today = new Date();
        return convertDateToString(today, defaultTimeStampPattern);
    }
    public static String convertDateToString(Date date)
    {
        return convertDateToString(date, defaultDatePattern);
    }
    public static String convertDateToString(Date date, String pattern)
    {
        String returnValue = "";

        if (date != null)
        {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return returnValue;
    }
}