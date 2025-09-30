/*
 *- @TestCaseID:maple/runtime/rc/function/RC_Thread01/RCAnnotationMultiCycleThread.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination:Change RCAnnotationMultiCycle to Multi thread testcase.
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\n
 *- @Priority: High
 *- @Source: RCAnnotationMultiCycleThread.java
 *- @ExecuteClass: RCAnnotationMultiCycleThread
 *- @ExecuteArgs:
 *- @Remark:Owner Zhang Wenlong 00292413
 */

import com.huawei.ark.annotation.Unowned;
import com.huawei.ark.annotation.Weak;

class ThreadRc_Cycle_am_00280 extends Thread {
    private boolean checkout;

    public void run() {
        Cycle_a_00280_A1 a1_main = new Cycle_a_00280_A1("a1_main");
        Cycle_a_00280_A6 a6_main = new Cycle_a_00280_A6("a6_main");
        a1_main.a2_0 = new Cycle_a_00280_A2("a2_0");
        a1_main.a2_0.a1_0 = a1_main;
        a1_main.a2_0.a3_0 = new Cycle_a_00280_A3("a3_0");
        a1_main.a2_0.a3_0.a1_0 = a1_main;
        a1_main.a2_0.a3_0.a2_0 = a1_main.a2_0;
        a1_main.a2_0.a3_0.a5_0 = new Cycle_a_00280_A5("a5_0");
        a1_main.a2_0.a3_0.a5_0.a6_0 = a6_main;
        a1_main.a3_0 = a1_main.a2_0.a3_0;
        a6_main.a3_0 = a1_main.a2_0.a3_0;

        a1_main.add();
        a6_main.add();
        a1_main.a2_0.add();
        a1_main.a2_0.a3_0.add();
        a1_main.a2_0.a3_0.a5_0.add();

        int result = a1_main.sum + a6_main.sum + a1_main.a2_0.sum + a1_main.a2_0.a3_0.sum + a1_main.a2_0.a3_0.a5_0.sum;
        //System.out.println("RC-Testing_Result="+result);

        if (result == 1443)
            checkout = true;
        //System.out.println(checkout);
    }

    public boolean check() {
        return checkout;
    }

    class Cycle_a_00280_A1 {
        Cycle_a_00280_A2 a2_0;
        @Unowned
        Cycle_a_00280_A3 a3_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00280_A1(String strObjectName) {
            a2_0 = null;
            a3_0 = null;
            a = 101;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
        }

        void add() {
            sum = a + a2_0.a + a3_0.a;
        }
    }

    class Cycle_a_00280_A2 {
        @Weak
        Cycle_a_00280_A1 a1_0;
        Cycle_a_00280_A3 a3_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00280_A2(String strObjectName) {
            a1_0 = null;
            a3_0 = null;
            a = 102;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A2_"+strObjectName);
        }

        void add() {
            sum = a + a1_0.a + a3_0.a;
        }
    }

    class Cycle_a_00280_A3 {
        @Weak
        Cycle_a_00280_A1 a1_0;
        @Weak
        Cycle_a_00280_A2 a2_0;
        Cycle_a_00280_A5 a5_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00280_A3(String strObjectName) {
            a1_0 = null;
            a2_0 = null;
            a5_0 = null;
            a = 103;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A3_"+strObjectName);
        }

        void add() {
            sum = a + a1_0.a + a2_0.a + a5_0.a;
        }
    }

    class Cycle_a_00280_A5 {
        @Unowned
        Cycle_a_00280_A6 a6_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00280_A5(String strObjectName) {
            a6_0 = null;
            a = 105;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A5_"+strObjectName);
        }

        void add() {
            sum = a + a6_0.a;
        }
    }

    class Cycle_a_00280_A6 {
        @Unowned
        Cycle_a_00280_A3 a3_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00280_A6(String strObjectName) {
            a3_0 = null;
            a = 106;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A6_"+strObjectName);
        }

        void add() {
            sum = a + a3_0.a;
        }
    }
}


public class RCAnnotationMultiCycleThread {
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
    }

    private static void rc_testcase_main_wrapper() {
        ThreadRc_Cycle_am_00280 A1_Cycle_am_00280 = new ThreadRc_Cycle_am_00280();
        ThreadRc_Cycle_am_00280 A2_Cycle_am_00280 = new ThreadRc_Cycle_am_00280();
        ThreadRc_Cycle_am_00280 A3_Cycle_am_00280 = new ThreadRc_Cycle_am_00280();
        ThreadRc_Cycle_am_00280 A4_Cycle_am_00280 = new ThreadRc_Cycle_am_00280();
        ThreadRc_Cycle_am_00280 A5_Cycle_am_00280 = new ThreadRc_Cycle_am_00280();
        ThreadRc_Cycle_am_00280 A6_Cycle_am_00280 = new ThreadRc_Cycle_am_00280();

        A1_Cycle_am_00280.start();
        A2_Cycle_am_00280.start();
        A3_Cycle_am_00280.start();
        A4_Cycle_am_00280.start();
        A5_Cycle_am_00280.start();
        A6_Cycle_am_00280.start();

        try {
            A1_Cycle_am_00280.join();
            A2_Cycle_am_00280.join();
            A3_Cycle_am_00280.join();
            A4_Cycle_am_00280.join();
            A5_Cycle_am_00280.join();
            A6_Cycle_am_00280.join();

        } catch (InterruptedException e) {
        }
        if (A1_Cycle_am_00280.check() && A2_Cycle_am_00280.check() && A3_Cycle_am_00280.check() && A4_Cycle_am_00280.check() && A5_Cycle_am_00280.check() && A6_Cycle_am_00280.check())
            System.out.println("ExpectResult");
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\n
