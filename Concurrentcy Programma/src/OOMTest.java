import java.util.ArrayList;
import java.util.List;

/**
 * @AUthor 邱夏
 * @Date 2020/07/25
 */
public class OOMTest {
    /**
     * 单例模式：饿汉
     */
    public static OOMTest INSTANCE = getOOMTest();

    private void OOMTest() {

    }

    private static OOMTest getOOMTest() {
        return new OOMTest();
    }

     private static class OOMObject {

    }

    /**
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    public void oomHeapTest() {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
