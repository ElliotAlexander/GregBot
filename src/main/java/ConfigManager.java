import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ConfigManager {

    private InputStream inputStream;

    // Yes I know I'm reopening the file object each time, eh.

    public ConfigManager(){
        parseCountString();
        reloadConfig();
    }

    public void reloadConfig(){
        parseConfigRefreshString();
        parseRefreshMinuteString();
        parseHourString();
        parsePicturePath();
    }

    private Properties getConfig(){
        Properties prop = new Properties();
        String propFileName = "config/config.properties";
        try {
            FileInputStream fs = new FileInputStream(propFileName);
            inputStream = fs;
            prop.load(inputStream);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    private void parsePicturePath(){
        Properties prop = getConfig();
        String picture_path = prop.getProperty("picture_path");
        Constants.setPicture_path(picture_path);
        Logger.log_Info("Loaded picture path. (" + Constants.picture_path + ")");
    }

    private void parseRefreshMinuteString(){
        Properties prop = getConfig();
        String[] refreshMinuteString = (prop.getProperty("refresh_minutes")).split(",");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        try {
            for (int i = 0; i < refreshMinuteString.length; i++) {
                arr.add(Integer.parseInt(refreshMinuteString[i].replace(" ", "")));
            }
            Logger.log_Info("Loaded minute refresh rate. {" + arr.toString() + "}");
        } catch(NumberFormatException e){
            Logger.log_Info("Failed to parse config.");
            e.printStackTrace();
        }
        Constants.setMinutesPastHour(arr);
    }

    private void parseHourString(){
        Properties prop = getConfig();
        String[] refreshHourString = (prop.getProperty("refresh_hours")).split(",");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        try {
            for (int i = 0; i < refreshHourString.length; i++) {
                arr.add(Integer.parseInt(refreshHourString[i].replace(" ", "")));
            }
            Logger.log_Info("Loaded Hour refresh rate. {" + arr.toString() + "}");
        } catch(NumberFormatException e){
            Logger.log_Info("Failed to parse config.");
            e.printStackTrace();
        }
        Constants.setHourRefreshRate(arr);
    }

    private void parseCountString(){
        Properties prop = getConfig();
        String countString = prop.getProperty("count");
        Constants.setDayCount(Integer.parseInt(countString));
        Logger.log_Info("Loaded day count. (" + Constants.dayCount + ")");
    }

    private void parseConfigRefreshString() {
        Properties prop = getConfig();
        String[] configRefreshString = ((String)prop.getProperty("config_refresh_minutes")).split(",");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < configRefreshString.length; i++){
            arr.add(Integer.parseInt(configRefreshString[i]));
        }
        Logger.log_Info("Loaded config refresh rates. {" + arr.toString() + "}");
        Constants.setConfigRefreshRate(arr);
    }
}
