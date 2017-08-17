import java.util.ArrayList;

public class Constants {

    public static ArrayList<Integer> MINUTES_REFRESH_RATE;
    public static ArrayList<Integer> CONFIG_REFRESH_RATE;
    public static ArrayList<Integer> HOUR_REFRESH_RATE;
    public static Integer REFRESH_RATE = 30000;
    public static Integer dayCount = 0;
    public static String picture_path;

    public static void setMinutesPastHour(ArrayList<Integer> input){
        MINUTES_REFRESH_RATE = input;
    }

    public static void setConfigRefreshRate(ArrayList<Integer> input){
        CONFIG_REFRESH_RATE = input;
    }

    public static void setHourRefreshRate(ArrayList<Integer> input){
        HOUR_REFRESH_RATE = input;
    }

    public static void setDayCount(Integer i){
        dayCount = i;
    }

    public static void setPicture_path(String s){
        picture_path = s;
    }
}
