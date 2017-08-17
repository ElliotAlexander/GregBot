public class Main {

    public Main(){
        TimeRunnable tr = new TimeRunnable();
        Thread clockThread = new Thread(tr);
        clockThread.start();
    }



    public static void main(String[] args) {
	    new Main();
    }
}
