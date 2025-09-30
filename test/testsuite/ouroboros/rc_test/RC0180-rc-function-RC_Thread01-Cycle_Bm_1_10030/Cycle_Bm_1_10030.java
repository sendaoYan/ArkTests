/*
 *- @TestCaseID:maple/runtime/rc/function/RC_Thread01/Cycle_Bm_1_10030.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination:Change Cycle_B_1_10030 in RC测试-Cycle-00.vsd to Multi thread testcase.
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: Cycle_Bm_1_10030.java
 *- @ExecuteClass: Cycle_Bm_1_10030
 *- @ExecuteArgs:
 *- @Remark:
 */
class ThreadRc_Cycle_Bm_1_10010B extends Thread {
    private boolean checkout;

    public void run() {
        Cycle_B_1_10010_A1 a1_0 = new Cycle_B_1_10010_A1();
        a1_0.a2_0 = new Cycle_B_1_10010_A2();
        a1_0.a2_0.a3_0 = new Cycle_B_1_10010_A3();
        a1_0.a2_0.a3_0.a1_0 = a1_0;
        a1_0.add();
        a1_0.a2_0.add();
        a1_0.a2_0.a3_0.add();
        int nsum = (a1_0.sum + a1_0.a2_0.sum + a1_0.a2_0.a3_0.sum);
        Cycle_B_1_10010_2A1 a1_10 = new Cycle_B_1_10010_2A1();
        a1_10.a2_0 = new Cycle_B_1_10010_2A2();
        a1_10.a2_0.a3_0 = new Cycle_B_1_10010_2A3();
        a1_10.a2_0.a3_0.a1_0 = a1_10;
        a1_10.add();
        a1_10.a2_0.add();
        a1_10.a2_0.a3_0.add();
        int nsum2 = (a1_10.sum + a1_10.a2_0.sum + a1_10.a2_0.a3_0.sum);
        //System.out.println(nsum);
        nsum += nsum2;

        if (nsum == 24)
            checkout = true;
        //System.out.println(checkout);
    }

    public boolean check() {
        return checkout;
    }

    class Cycle_B_1_10010_A1 {
        Cycle_B_1_10010_A2 a2_0;
        int a;
        int sum;

        Cycle_B_1_10010_A1() {
            a2_0 = null;
            a = 1;
            sum = 0;
        }

        void add() {
            sum = a + a2_0.a;
        }
    }

    class Cycle_B_1_10010_A2 {
        Cycle_B_1_10010_A3 a3_0;
        int a;
        int sum;

        Cycle_B_1_10010_A2() {
            a3_0 = null;
            a = 2;
            sum = 0;
        }

        void add() {
            sum = a + a3_0.a;
        }
    }

    class Cycle_B_1_10010_A3 {
        Cycle_B_1_10010_A1 a1_0;
        int a;
        int sum;

        Cycle_B_1_10010_A3() {
            a1_0 = null;
            a = 3;
            sum = 0;
        }

        void add() {
            sum = a + a1_0.a;
        }
    }

    class Cycle_B_1_10010_2A1 {
        Cycle_B_1_10010_2A2 a2_0;
        int a;
        int sum;

        Cycle_B_1_10010_2A1() {
            a2_0 = null;
            a = 1;
            sum = 0;
        }

        void add() {
            sum = a + a2_0.a;
        }
    }

    class Cycle_B_1_10010_2A2 {
        Cycle_B_1_10010_2A3 a3_0;
        int a;
        int sum;

        Cycle_B_1_10010_2A2() {
            a3_0 = null;
            a = 2;
            sum = 0;
        }

        void add() {
            sum = a + a3_0.a;
        }
    }

    class Cycle_B_1_10010_2A3 {
        Cycle_B_1_10010_2A1 a1_0;
        int a;
        int sum;

        Cycle_B_1_10010_2A3() {
            a1_0 = null;
            a = 3;
            sum = 0;
        }

        void add() {
            sum = a + a1_0.a;
        }
    }
}

class ThreadRc_Cycle_Bm_1_10020B extends Thread {
    private boolean checkout;

    public void run() {
        Cycle_B_1_10020_A1 a1_0 = new Cycle_B_1_10020_A1();
        a1_0.a2_0 = new Cycle_B_1_10020_A2();
        a1_0.a2_0.a3_0 = new Cycle_B_1_10020_A3();
        Cycle_B_1_10020_A4 a4_0 = new Cycle_B_1_10020_A4();
        Cycle_B_1_10020_A5 a5_0 = new Cycle_B_1_10020_A5();
        a4_0.a1_0 = a1_0;
        a5_0.a1_0 = a1_0;
        a1_0.a2_0.a3_0.a1_0 = a1_0;
        a1_0.add();
        a1_0.a2_0.add();
        a1_0.a2_0.a3_0.add();
        a4_0.add();
        a5_0.add();
        int nsum = (a1_0.sum + a1_0.a2_0.sum + a1_0.a2_0.a3_0.sum + a4_0.sum + a5_0.sum);
        Cycle_B_1_10020_2A1 a1_20 = new Cycle_B_1_10020_2A1();
        a1_20.a2_0 = new Cycle_B_1_10020_2A2();
        a1_20.a2_0.a3_0 = new Cycle_B_1_10020_2A3();
        Cycle_B_1_10020_2A4 a4_20 = new Cycle_B_1_10020_2A4();
        Cycle_B_1_10020_2A5 a5_20 = new Cycle_B_1_10020_2A5();
        a1_20.a4_0 = a4_20;
        a1_20.a5_0 = a5_20;
        a1_20.a2_0.a3_0.a1_0 = a1_20;
        a1_20.add();
        a1_20.a2_0.add();
        a1_20.a2_0.a3_0.add();
        a4_20.add();
        a5_20.add();
        int nsum1 = (a1_20.sum + a1_20.a2_0.sum + a1_20.a2_0.a3_0.sum + a4_20.sum + a5_20.sum);
        nsum += nsum1;

        if (nsum == 61)
            checkout = true;
        //System.out.println(checkout);
    }

    public boolean check() {
        return checkout;
    }

    class Cycle_B_1_10020_A1 {
        Cycle_B_1_10020_A2 a2_0;
        int a;
        int sum;

        Cycle_B_1_10020_A1() {
            a2_0 = null;
            a = 1;
            sum = 0;
        }

        void add() {
            sum = a + a2_0.a;
        }
    }

    class Cycle_B_1_10020_A2 {
        Cycle_B_1_10020_A3 a3_0;
        int a;
        int sum;

        Cycle_B_1_10020_A2() {
            a3_0 = null;
            a = 2;
            sum = 0;
        }

        void add() {
            sum = a + a3_0.a;
        }
    }

    class Cycle_B_1_10020_A3 {
        Cycle_B_1_10020_A1 a1_0;
        int a;
        int sum;

        Cycle_B_1_10020_A3() {
            a1_0 = null;
            a = 3;
            sum = 0;
        }

        void add() {
            sum = a + a1_0.a;
        }
    }

    class Cycle_B_1_10020_A4 {
        Cycle_B_1_10020_A1 a1_0;
        int a;
        int sum;

        Cycle_B_1_10020_A4() {
            a1_0 = null;
            a = 4;
            sum = 0;
        }

        void add() {
            sum = a + a1_0.a;
        }
    }

    class Cycle_B_1_10020_A5 {
        Cycle_B_1_10020_A1 a1_0;
        int a;
        int sum;

        Cycle_B_1_10020_A5() {
            a1_0 = null;
            a = 5;
            sum = 0;
        }

        void add() {
            sum = a + a1_0.a;
        }
    }

    class Cycle_B_1_10020_2A1 {
        Cycle_B_1_10020_2A2 a2_0;
        Cycle_B_1_10020_2A4 a4_0;
        Cycle_B_1_10020_2A5 a5_0;
        int a;
        int sum;

        Cycle_B_1_10020_2A1() {
            a2_0 = null;
            a4_0 = null;
            a5_0 = null;
            a = 1;
            sum = 0;
        }

        void add() {
            sum = a + a2_0.a;
        }
    }

    class Cycle_B_1_10020_2A2 {
        Cycle_B_1_10020_2A3 a3_0;
        int a;
        int sum;

        Cycle_B_1_10020_2A2() {
            a3_0 = null;
            a = 2;
            sum = 0;
        }

        void add() {
            sum = a + a3_0.a;
        }
    }

    class Cycle_B_1_10020_2A3 {
        Cycle_B_1_10020_2A1 a1_0;
        int a;
        int sum;

        Cycle_B_1_10020_2A3() {
            a1_0 = null;
            a = 3;
            sum = 0;
        }

        void add() {
            sum = a + a1_0.a;
        }
    }

    class Cycle_B_1_10020_2A4 {
        int a;
        int sum;

        Cycle_B_1_10020_2A4() {
            a = 5;
            sum = 0;
        }

        void add() {
            sum = a + 6;
        }
    }

    class Cycle_B_1_10020_2A5 {
        int a;
        int sum;

        Cycle_B_1_10020_2A5() {
            a = 7;
            sum = 0;
        }

        void add() {
            sum = a + 8;
        }
    }
}

public class Cycle_Bm_1_10030 {

    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
        
    }

    private static void rc_testcase_main_wrapper() {
        ThreadRc_Cycle_Bm_1_10010B A1_Cycle_Bm_1_10010 = new ThreadRc_Cycle_Bm_1_10010B();
        ThreadRc_Cycle_Bm_1_10010B A2_Cycle_Bm_1_10010 = new ThreadRc_Cycle_Bm_1_10010B();
        ThreadRc_Cycle_Bm_1_10010B A3_Cycle_Bm_1_10010 = new ThreadRc_Cycle_Bm_1_10010B();
        ThreadRc_Cycle_Bm_1_10010B A4_Cycle_Bm_1_10010 = new ThreadRc_Cycle_Bm_1_10010B();
        ThreadRc_Cycle_Bm_1_10010B A5_Cycle_Bm_1_10010 = new ThreadRc_Cycle_Bm_1_10010B();
        ThreadRc_Cycle_Bm_1_10010B A6_Cycle_Bm_1_10010 = new ThreadRc_Cycle_Bm_1_10010B();
        ThreadRc_Cycle_Bm_1_10020B A1_Cycle_Bm_1_10020 = new ThreadRc_Cycle_Bm_1_10020B();
        ThreadRc_Cycle_Bm_1_10020B A2_Cycle_Bm_1_10020 = new ThreadRc_Cycle_Bm_1_10020B();
        ThreadRc_Cycle_Bm_1_10020B A3_Cycle_Bm_1_10020 = new ThreadRc_Cycle_Bm_1_10020B();
        ThreadRc_Cycle_Bm_1_10020B A4_Cycle_Bm_1_10020 = new ThreadRc_Cycle_Bm_1_10020B();
        ThreadRc_Cycle_Bm_1_10020B A5_Cycle_Bm_1_10020 = new ThreadRc_Cycle_Bm_1_10020B();
        ThreadRc_Cycle_Bm_1_10020B A6_Cycle_Bm_1_10020 = new ThreadRc_Cycle_Bm_1_10020B();
        A1_Cycle_Bm_1_10010.start();
        A2_Cycle_Bm_1_10010.start();
        A3_Cycle_Bm_1_10010.start();
        A4_Cycle_Bm_1_10010.start();
        A5_Cycle_Bm_1_10010.start();
        A6_Cycle_Bm_1_10010.start();
        A1_Cycle_Bm_1_10020.start();
        A2_Cycle_Bm_1_10020.start();
        A3_Cycle_Bm_1_10020.start();
        A4_Cycle_Bm_1_10020.start();
        A5_Cycle_Bm_1_10020.start();
        A6_Cycle_Bm_1_10020.start();

        try {
            A1_Cycle_Bm_1_10010.join();
            A2_Cycle_Bm_1_10010.join();
            A3_Cycle_Bm_1_10010.join();
            A4_Cycle_Bm_1_10010.join();
            A5_Cycle_Bm_1_10010.join();
            A6_Cycle_Bm_1_10010.join();
            A1_Cycle_Bm_1_10020.join();
            A2_Cycle_Bm_1_10020.join();
            A3_Cycle_Bm_1_10020.join();
            A4_Cycle_Bm_1_10020.join();
            A5_Cycle_Bm_1_10020.join();
            A6_Cycle_Bm_1_10020.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        if (A1_Cycle_Bm_1_10010.check() && A2_Cycle_Bm_1_10010.check() && A3_Cycle_Bm_1_10010.check() && A4_Cycle_Bm_1_10010.check() && A5_Cycle_Bm_1_10010.check() && A6_Cycle_Bm_1_10010.check() && A1_Cycle_Bm_1_10020.check() && A2_Cycle_Bm_1_10020.check() && A3_Cycle_Bm_1_10020.check() && A4_Cycle_Bm_1_10020.check() && A5_Cycle_Bm_1_10020.check() && A6_Cycle_Bm_1_10020.check())
            System.out.println("ExpectResult");
    }


}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n
