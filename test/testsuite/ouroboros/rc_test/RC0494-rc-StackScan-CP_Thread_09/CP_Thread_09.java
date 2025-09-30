/*
 *- @TestCaseID: Maple_MemoryManagement2.0_CP_Thread_09
 *- @TestCaseName: CP_Thread_09
 *- @TestCaseType: Function Testing for placementRCTest
 *- @RequirementName: 运行时支持GCOnly
 *- @Condition:no
 *  -#c1: MultiThreadMode:Cycle is Cycle_a_0038.java;Nocycle is ClassLoader
 *- @Brief:一组有环的对象，他们的field指向一个hashMap，里面装满了对象
 *  -#step1: 创建一个环，环的类型参考了Cycle_a_0038.java;
 *  -#step2: 两个域test1和test2,里面装满了对象，对象格式参考ClassLoader，这样就构造了一个大对象。
 *  -#step3: 验证结果正确，再用GCverify验证无内存泄漏。
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: CP_Thread_09.java
 *- @ExecuteClass: CP_Thread_09
 *- @ExecuteArgs:
 *- @Remark:
 */

class CP_Thread_09_A1 {
    static ClassLoader[] test1;
    static
    int a;
    CP_Thread_09_A1 a2_0;
    int sum;
    String strObjectName;

    CP_Thread_09_A1(String strObjectName) {
        a2_0 = null;
        a = 101;
        sum = 0;
        this.strObjectName = strObjectName;
    }

    void add() {
        sum = a + a;
    }
}

class CP_Thread_09_test extends Thread {
    private static CP_Thread_09_A1 a1_main = null;
    private volatile static CP_Thread_09_A1 a2 = null;
    private volatile static ClassLoader test1;
    private static ClassLoader test2;

    private static void test_CP_Thread_09_A1(int times) {
        CP_Thread_09_A1.test1 = new ClassLoader[times];
        for (int i = 0; i < times; i++) {
            test1 = CP_Thread_09_A1.class.getClassLoader();
            CP_Thread_09_A1.test1[i] = test1;
        }
    }

    private static void test_CP_Thread_09_A2(int times) {
        CP_Thread_09_A1.test1 = new ClassLoader[times];
        for (int i = 0; i < times; i++) {
            test2 = CP_Thread_09_A1.class.getClassLoader();
            CP_Thread_09_A1.test1[i] = test2;
        }
    }

    public void run() {
        a1_main = new CP_Thread_09_A1("a1_main");
        a2 = new CP_Thread_09_A1("a2_0");
        a1_main.a2_0 = a2;
        a1_main.a2_0.a2_0 = a2;

        a1_main.add();
        a1_main.a2_0.add();
        test_CP_Thread_09_A1(10000);
        test_CP_Thread_09_A2(10000);
        int result = a1_main.sum + a1_main.a2_0.sum;
        //System.out.println("RC-Testing_Result="+result);
        if (result == 404)
            System.out.println("ExpectResult");
    }
}

public class CP_Thread_09 {
    private static CP_Thread_09_A1 a1_main = null;
    private volatile static CP_Thread_09_A1 a2 = null;

    public static void main(String[] args) {
        CP_Thread_09_test cptest1 = new CP_Thread_09_test();
        cptest1.run();
        CP_Thread_09_test cptest2 = new CP_Thread_09_test();
        cptest2.run();
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n
