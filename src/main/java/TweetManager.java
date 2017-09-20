import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TweetManager {

    private Twitter twitter;
    private FileManager fileManager;


    public TweetManager(){
        setup();
    }

    private void setup(){
        twitter = TwitterFactory.getSingleton();
        fileManager = new FileManager();
    }

    public void send_Tweet(){
        try {
            String statusMessage = Constants.tweet_string;
            StatusUpdate status = new StatusUpdate(statusMessage);
            status.setMedia(fileManager.getRandomFile());
            twitter.updateStatus(status);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
