
/**
 * @AUthor 邱夏
 * @Date 2020/07/26
 */
public class HappenBeforeTest {
    int a = 0;
    boolean flag = false;

    public void write() {
        a = 2;
        flag = true;
    }

    public void read() {
        if (flag) {
            int i = a * a;
            System.out.println("i: " + i);
        }
    }

    public void run() {
        HappenBeforeTest happenBeforeTest = new HappenBeforeTest();
        Thread tWrite = new Thread(new Runnable() {
            @Override
            public void run() {
                happenBeforeTest.write();
            }
        });

        Thread tRead = new Thread(new Runnable() {
            @Override
            public void run() {
                happenBeforeTest.read();
            }
        });
        tWrite.start();
        tRead.start();

        try
        {
            tWrite.join();
            tRead.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
