package testing;

import java.util.concurrent.TimeUnit;

public class DelayTesten {

    private static int i=100;

    public static void main(String[] args) {
        while(i>10){
            try {
                TimeUnit.SECONDS.sleep(2);
                System.err.println("i =" + i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
