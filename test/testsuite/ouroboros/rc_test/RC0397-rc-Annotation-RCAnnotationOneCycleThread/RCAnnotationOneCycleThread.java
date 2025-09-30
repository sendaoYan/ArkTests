/*
 *- @TestCaseID:maple/runtime/rc/function/RC_Thread01/RCAnnotationOneCycleThread.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination:Change RCAnnotationOneCycle to Multi thread testcase.
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\n
 *- @Priority: High
 *- @Source: RCAnnotationOneCycleThread.java
 *- @ExecuteClass: RCAnnotationOneCycleThread
 *- @ExecuteArgs:
 *- @Remark:Owner Zhang Wenlong 00292413
 */

import com.huawei.ark.annotation.Unowned;
import com.huawei.ark.annotation.Weak;

class ThreadRc_Cycle_Bm_1_00180 extends Thread {
    private boolean checkout;

    public void run() {
        Cycle_B_1_00180_A1 a1_0 = new Cycle_B_1_00180_A1();
        a1_0.a2_0 = new Cycle_B_1_00180_A2();
        a1_0.a2_0.a3_0 = new Cycle_B_1_00180_A3();
        Cycle_B_1_00180_A4 a4_0 = new Cycle_B_1_00180_A4();
        Cycle_B_1_00180_A5 a5_0 = new Cycle_B_1_00180_A5();
        a4_0.a1_0 = a1_0;
        a5_0.a1_0 = a1_0;
        a1_0.a2_0.a3_0.a1_0 = a1_0;
        a1_0.add();
        a1_0.a2_0.add();
        a1_0.a2_0.a3_0.add();
        a4_0.add();
        a5_0.add();
        int nsum = (a1_0.sum + a1_0.a2_0.sum + a1_0.a2_0.a3_0.sum + a4_0.sum + a5_0.sum);
        //System.out.println(nsum);

        if (nsum == 23)
            checkout = true;
        //System.out.println(checkout);
    }

    public boolean check() {
        return checkout;
    }

    class Cycle_B_1_00180_A1 {
        Cycle_B_1_00180_A2 a2_0;
        int a;
        int sum;

        Cycle_B_1_00180_A1() {
            a2_0 = null;
            a = 1;
            sum = 0;
        }

        void add() {
            sum = a + a2_0.a;
        }
    }

    class Cycle_B_1_00180_A2 {
        Cycle_B_1_00180_A3 a3_0;
        int a;
        int sum;

        Cycle_B_1_00180_A2() {
            a3_0 = null;
            a = 2;
            sum = 0;
        }

        void add() {
            sum = a + a3_0.a;
        }
    }

    class Cycle_B_1_00180_A3 {
        @Weak
        Cycle_B_1_00180_A1 a1_0;
        int a;
        int sum;

        Cycle_B_1_00180_A3() {
            a1_0 = null;
            a = 3;
            sum = 0;
        }

        void add() {
            sum = a + a1_0.a;
        }
    }

    class Cycle_B_1_00180_A4 {
        @Unowned
        Cycle_B_1_00180_A1 a1_0;
        int a;
        int sum;

        Cycle_B_1_00180_A4() {
            a1_0 = null;
            a = 4;
            sum = 0;
        }

        void add() {
            sum = a + a1_0.a;
        }
    }

    class Cycle_B_1_00180_A5 {
        @Unowned
        Cycle_B_1_00180_A1 a1_0;
        int a;
        int sum;

        Cycle_B_1_00180_A5() {
            a1_0 = null;
            a = 5;
            sum = 0;
        }

        void add() {
            sum = a + a1_0.a;
        }
    }
}


public class RCAnnotationOneCycleThread {

    public static void main(String[] args) {
        rc_testcase_main_wrapper();
    }

    private static void rc_testcase_main_wrapper() {
        ThreadRc_Cycle_Bm_1_00180 A1_Cycle_Bm_1_00180 = new ThreadRc_Cycle_Bm_1_00180();
        ThreadRc_Cycle_Bm_1_00180 A2_Cycle_Bm_1_00180 = new ThreadRc_Cycle_Bm_1_00180();
        ThreadRc_Cycle_Bm_1_00180 A3_Cycle_Bm_1_00180 = new ThreadRc_Cycle_Bm_1_00180();
        ThreadRc_Cycle_Bm_1_00180 A4_Cycle_Bm_1_00180 = new ThreadRc_Cycle_Bm_1_00180();
        ThreadRc_Cycle_Bm_1_00180 A5_Cycle_Bm_1_00180 = new ThreadRc_Cycle_Bm_1_00180();
        ThreadRc_Cycle_Bm_1_00180 A6_Cycle_Bm_1_00180 = new ThreadRc_Cycle_Bm_1_00180();

        A1_Cycle_Bm_1_00180.start();
        A2_Cycle_Bm_1_00180.start();
        A3_Cycle_Bm_1_00180.start();
        A4_Cycle_Bm_1_00180.start();
        A5_Cycle_Bm_1_00180.start();
        A6_Cycle_Bm_1_00180.start();

        try {
            A1_Cycle_Bm_1_00180.join();
            A2_Cycle_Bm_1_00180.join();
            A3_Cycle_Bm_1_00180.join();
            A4_Cycle_Bm_1_00180.join();
            A5_Cycle_Bm_1_00180.join();
            A6_Cycle_Bm_1_00180.join();

        } catch (InterruptedException e) {
        }
        if (A1_Cycle_Bm_1_00180.check() && A2_Cycle_Bm_1_00180.check() && A3_Cycle_Bm_1_00180.check() && A4_Cycle_Bm_1_00180.check() && A5_Cycle_Bm_1_00180.check() && A6_Cycle_Bm_1_00180.check())
            System.out.println("ExpectResult");
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\n
