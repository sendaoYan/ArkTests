/*
 *- @TestCaseID:maple/runtime/rc/function/RC_Thread01/Cycle_Bm_2_00230.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination:Change Cycle_B_2_00230 in RC测试-Cycle-00.vsd to Multi thread testcase.
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: Cycle_Bm_2_00230.java
 *- @ExecuteClass: Cycle_Bm_2_00230
 *- @ExecuteArgs:
 *- @Remark:
 */
class ThreadRc_Cycle_Bm_2_00230 extends Thread {
    private boolean checkout;

    public void run() {
        Cycle_B_2_00230_A1 a1_0 = new Cycle_B_2_00230_A1();
        a1_0.a2_0 = new Cycle_B_2_00230_A2();
        a1_0.a2_0.a3_0 = new Cycle_B_2_00230_A3();
        a1_0.a2_0.a3_0.a4_0 = new Cycle_B_2_00230_A4();
        a1_0.a2_0.a3_0.a4_0.a5_0 = new Cycle_B_2_00230_A5();
        a1_0.a2_0.a3_0.a4_0.a5_0.a6_0 = new Cycle_B_2_00230_A6();
        a1_0.a2_0.a3_0.a4_0.a5_0.a6_0.a1_0 = a1_0;

        Cycle_B_2_00230_A10 a10_0 = new Cycle_B_2_00230_A10();
        a1_0.a2_0.a3_0.a4_0.a5_0.a6_0.a10_0 = a10_0;
        a10_0.a8_0 = new Cycle_B_2_00230_A8();
        a10_0.a8_0.a9_0 = new Cycle_B_2_00230_A9();
        a10_0.a8_0.a9_0.a7_0 = new Cycle_B_2_00230_A7();
        a10_0.a8_0.a9_0.a7_0.a4_0 = a1_0.a2_0.a3_0.a4_0;
        a1_0.add();
        a1_0.a2_0.add();
        a1_0.a2_0.a3_0.add();
        a1_0.a2_0.a3_0.a4_0.add();
        a1_0.a2_0.a3_0.a4_0.a5_0.add();
        a1_0.a2_0.a3_0.a4_0.a5_0.a6_0.add();
        a10_0.a8_0.add();
        a10_0.a8_0.a9_0.add();
        a10_0.a8_0.a9_0.a7_0.add();
        int nsum = (a1_0.sum + a1_0.a2_0.sum + a1_0.a2_0.a3_0.sum + a1_0.a2_0.a3_0.a4_0.sum + a1_0.a2_0.a3_0.a4_0.a5_0.sum + a1_0.a2_0.a3_0.a4_0.a5_0.a6_0.sum + a10_0.a8_0.sum + a10_0.a8_0.a9_0.sum + a10_0.a8_0.a9_0.a7_0.sum);

        //System.out.println(nsum);

        if (nsum == 97)
            checkout = true;
        //System.out.println(checkout);
    }

    public boolean check() {
        return checkout;
    }

    class Cycle_B_2_00230_A1 {
        Cycle_B_2_00230_A2 a2_0;
        int a;
        int sum;

        Cycle_B_2_00230_A1() {
            a2_0 = null;
            a = 1;
            sum = 0;
        }

        void add() {
            sum = a + a2_0.a;
        }
    }

    class Cycle_B_2_00230_A2 {
        Cycle_B_2_00230_A3 a3_0;
        int a;
        int sum;

        Cycle_B_2_00230_A2() {
            a3_0 = null;
            a = 2;
            sum = 0;
        }

        void add() {
            sum = a + a3_0.a;
        }
    }

    class Cycle_B_2_00230_A3 {
        Cycle_B_2_00230_A4 a4_0;
        int a;
        int sum;

        Cycle_B_2_00230_A3() {
            a4_0 = null;
            a = 3;
            sum = 0;
        }

        void add() {
            sum = a + a4_0.a;
        }
    }

    class Cycle_B_2_00230_A4 {
        Cycle_B_2_00230_A5 a5_0;
        int a;
        int sum;

        Cycle_B_2_00230_A4() {
            a5_0 = null;
            a = 4;
            sum = 0;
        }

        void add() {
            sum = a + a5_0.a;
        }
    }

    class Cycle_B_2_00230_A5 {
        Cycle_B_2_00230_A6 a6_0;
        int a;
        int sum;

        Cycle_B_2_00230_A5() {
            a6_0 = null;
            a = 5;
            sum = 0;
        }

        void add() {
            sum = a + a6_0.a;
        }
    }

    class Cycle_B_2_00230_A6 {
        Cycle_B_2_00230_A1 a1_0;
        Cycle_B_2_00230_A10 a10_0;
        int a;
        int sum;

        Cycle_B_2_00230_A6() {
            a1_0 = null;
            a10_0 = null;
            a = 6;
            sum = 0;
        }

        void add() {
            sum = a + a1_0.a + a10_0.a;
        }
    }

    class Cycle_B_2_00230_A8 {
        Cycle_B_2_00230_A9 a9_0;
        int a;
        int sum;

        Cycle_B_2_00230_A8() {
            a9_0 = null;
            a = 7;
            sum = 0;
        }

        void add() {
            sum = a + a9_0.a;
        }
    }

    class Cycle_B_2_00230_A9 {
        Cycle_B_2_00230_A7 a7_0;
        int a;
        int sum;

        Cycle_B_2_00230_A9() {
            a7_0 = null;
            a = 8;
            sum = 0;
        }

        void add() {
            sum = a + a7_0.a;
        }
    }

    class Cycle_B_2_00230_A7 {
        Cycle_B_2_00230_A4 a4_0;
        int a;
        int sum;

        Cycle_B_2_00230_A7() {
            a4_0 = null;
            a = 9;
            sum = 0;
        }

        void add() {
            sum = a + a4_0.a;
        }
    }

    class Cycle_B_2_00230_A10 {
        Cycle_B_2_00230_A8 a8_0;
        int a;
        int sum;

        Cycle_B_2_00230_A10() {
            a8_0 = null;
            a = 10;
            sum = 0;
        }

        void add() {
            sum = a + a8_0.a;
        }
    }
}


public class Cycle_Bm_2_00230 {

    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
        
    }

    private static void rc_testcase_main_wrapper() {
        ThreadRc_Cycle_Bm_2_00230 A1_Cycle_Bm_2_00230 = new ThreadRc_Cycle_Bm_2_00230();
        ThreadRc_Cycle_Bm_2_00230 A2_Cycle_Bm_2_00230 = new ThreadRc_Cycle_Bm_2_00230();
        ThreadRc_Cycle_Bm_2_00230 A3_Cycle_Bm_2_00230 = new ThreadRc_Cycle_Bm_2_00230();
        ThreadRc_Cycle_Bm_2_00230 A4_Cycle_Bm_2_00230 = new ThreadRc_Cycle_Bm_2_00230();
        ThreadRc_Cycle_Bm_2_00230 A5_Cycle_Bm_2_00230 = new ThreadRc_Cycle_Bm_2_00230();
        ThreadRc_Cycle_Bm_2_00230 A6_Cycle_Bm_2_00230 = new ThreadRc_Cycle_Bm_2_00230();

        A1_Cycle_Bm_2_00230.start();
        A2_Cycle_Bm_2_00230.start();
        A3_Cycle_Bm_2_00230.start();
        A4_Cycle_Bm_2_00230.start();
        A5_Cycle_Bm_2_00230.start();
        A6_Cycle_Bm_2_00230.start();

        try {
            A1_Cycle_Bm_2_00230.join();
            A2_Cycle_Bm_2_00230.join();
            A3_Cycle_Bm_2_00230.join();
            A4_Cycle_Bm_2_00230.join();
            A5_Cycle_Bm_2_00230.join();
            A6_Cycle_Bm_2_00230.join();

        } catch (InterruptedException e) {
        }
        if (A1_Cycle_Bm_2_00230.check() && A2_Cycle_Bm_2_00230.check() && A3_Cycle_Bm_2_00230.check() && A4_Cycle_Bm_2_00230.check() && A5_Cycle_Bm_2_00230.check() && A6_Cycle_Bm_2_00230.check())
            System.out.println("ExpectResult");
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n
