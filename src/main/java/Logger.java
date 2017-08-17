import java.util.Date;

public class Logger {

    public static void log_Info(String s){
        Date d = new Date();
        System.out.println("[" + d + "] " + s);
    }

}
