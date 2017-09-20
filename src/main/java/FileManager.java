import java.io.File;
import java.util.Random;

public class FileManager {

    private final Random rand;

    public FileManager(){
        rand = new Random();
    }

    public File getRandomFile(){
        File dir = new File(Constants.picture_path);
        if(!(dir.exists())){
            Logger.log_Info("Error - Cannot load pictures directory");
            return null;
        } else {
            File[] fileList = dir.listFiles();
            int x = rand.nextInt(fileList.length);
            x -= 1;
            return fileList[x];
        }
    }
}
