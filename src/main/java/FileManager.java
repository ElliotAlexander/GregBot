import java.io.File;
import java.util.Random;

public class FileManager {

    private final Random rand;

    public FileManager(){
        rand = new Random();
    }

    public File getRandomFile(){
        File gregDir = new File(Constants.picture_path);
        if(!(gregDir.exists())){
            Logger.log_Info("Error - Cannot load pictures directory");
            return null;
        } else {
            File[] fileList = gregDir.listFiles();
            int x = rand.nextInt(fileList.length);
            x -= 1;
            return fileList[x];
        }
    }
}
