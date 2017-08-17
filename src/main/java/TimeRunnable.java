import org.joda.time.LocalTime;

import static java.lang.Thread.sleep;


public class TimeRunnable implements Runnable {


    private int previous_minute = 99;
    private final ConfigManager manager;
    private final TweetManager tweetManager;

    public TimeRunnable(){
        manager = new ConfigManager();
        manager.reloadConfig();
        tweetManager = new TweetManager();
    }

    public void run() {
        tweetManager.send_Tweet();
        while(true){
            LocalTime lt = new LocalTime();
            int minute = lt.getMinuteOfHour();
            int hour = lt.getHourOfDay();
            if(minute != previous_minute){
                previous_minute = minute;
                if(Constants.CONFIG_REFRESH_RATE.contains(minute) ){
                    manager.reloadConfig();
                    Logger.log_Info("Refreshing Config...");
                }
                if(Constants.MINUTES_REFRESH_RATE.contains(minute) && Constants.HOUR_REFRESH_RATE.contains(hour)){
                    tweetManager.send_Tweet();
                    Constants.dayCount++;
                    Logger.log_Info("Sending tweet...");
                }
            } else{

                try {
                    sleep(Constants.REFRESH_RATE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
