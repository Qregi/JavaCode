/**
 * @AUthor 邱夏
 * @Date 2020/07/25
 * 主函数入口，一些简单的实验类在这里加载
 */
public class MainTestClass {
    public static void main(String[] args) {
        /**
        OOMTest test = OOMTest.INSTANCE;
        test.oomHeapTest();
        **/
        // JavaVmStacksOF.vmStacksOFTest();

        HappenBeforeTest test = new HappenBeforeTest();
        test.run();
    }

}
