/*
 *- @TestCaseID:maple/runtime/rc/function/RC_Thread01/Cycle_am_00470.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination:Change Cycle_a_00470 in RC测试-Cycle-01 to Multi thread testcase.
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: Cycle_am_00470.java
 *- @ExecuteClass: Cycle_am_00470
 *- @ExecuteArgs:
 *- @Remark:
 */

class ThreadRc_Cycle_am_00470 extends Thread {
    private boolean checkout;

    public void run() {
        Cycle_a_00470_A1 a1_main = new Cycle_a_00470_A1("a1_main");
        Cycle_a_00470_A5 a5_main = new Cycle_a_00470_A5("a5_main");
        a1_main.a2_0 = new Cycle_a_00470_A2("a2_0");
        a1_main.a2_0.a3_0 = new Cycle_a_00470_A3("a3_0");
        a1_main.a2_0.a3_0.a4_0 = new Cycle_a_00470_A4("a4_0");
        a1_main.a2_0.a3_0.a4_0.a1_0 = a1_main;
        a1_main.a2_0.a3_0.a4_0.a6_0 = new Cycle_a_00470_A6("a6_0");
        a1_main.a2_0.a3_0.a4_0.a6_0.a5_0 = a5_main;

        a5_main.a3_0 = a1_main.a2_0.a3_0;
        a5_main.a1_0 = a1_main;

        a1_main.add();
        a5_main.add();
        a1_main.a2_0.add();
        a1_main.a2_0.a3_0.add();
        a1_main.a2_0.a3_0.a4_0.add();
        a1_main.a2_0.a3_0.a4_0.a6_0.add();

        int result = a1_main.sum + a5_main.sum + a1_main.a2_0.sum + a1_main.a2_0.a3_0.sum + a1_main.a2_0.a3_0.a4_0.sum + a1_main.a2_0.a3_0.a4_0.a6_0.sum;
        //System.out.println("RC-Testing_Result="+result);

        if (result == 1446)
            checkout = true;
        //System.out.println(checkout);
    }

    public boolean check() {
        return checkout;
    }

    class Cycle_a_00470_A1 {
        Cycle_a_00470_A2 a2_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00470_A1(String strObjectName) {
            a2_0 = null;
            a = 101;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
        }

        void add() {
            sum = a + a2_0.a;
        }
    }

    class Cycle_a_00470_A2 {
        Cycle_a_00470_A3 a3_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00470_A2(String strObjectName) {
            a3_0 = null;
            a = 102;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A2_"+strObjectName);
        }

        void add() {
            sum = a + a3_0.a;
        }
    }

    class Cycle_a_00470_A3 {
        Cycle_a_00470_A4 a4_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00470_A3(String strObjectName) {
            a4_0 = null;
            a = 103;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A3_"+strObjectName);
        }

        void add() {
            sum = a + a4_0.a;
        }
    }

    class Cycle_a_00470_A4 {
        Cycle_a_00470_A1 a1_0;
        Cycle_a_00470_A6 a6_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00470_A4(String strObjectName) {
            a1_0 = null;
            a6_0 = null;
            a = 104;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A4_"+strObjectName);
        }

        void add() {
            sum = a + a1_0.a + a6_0.a;
        }
    }

    class Cycle_a_00470_A5 {
        Cycle_a_00470_A1 a1_0;
        Cycle_a_00470_A3 a3_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00470_A5(String strObjectName) {
            a1_0 = null;
            a3_0 = null;
            a = 105;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A5_"+strObjectName);
        }

        void add() {
            sum = a + a1_0.a + a3_0.a;
        }
    }

    class Cycle_a_00470_A6 {
        Cycle_a_00470_A5 a5_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00470_A6(String strObjectName) {
            a5_0 = null;
            a = 106;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A6_"+strObjectName);
        }

        void add() {
            sum = a + a5_0.a;
        }
    }
}


public class Cycle_am_00470 {
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
        
    }

    private static void rc_testcase_main_wrapper() {
        ThreadRc_Cycle_am_00470 A1_Cycle_am_00470 = new ThreadRc_Cycle_am_00470();
        ThreadRc_Cycle_am_00470 A2_Cycle_am_00470 = new ThreadRc_Cycle_am_00470();
        ThreadRc_Cycle_am_00470 A3_Cycle_am_00470 = new ThreadRc_Cycle_am_00470();
        ThreadRc_Cycle_am_00470 A4_Cycle_am_00470 = new ThreadRc_Cycle_am_00470();
        ThreadRc_Cycle_am_00470 A5_Cycle_am_00470 = new ThreadRc_Cycle_am_00470();
        ThreadRc_Cycle_am_00470 A6_Cycle_am_00470 = new ThreadRc_Cycle_am_00470();

        A1_Cycle_am_00470.start();
        A2_Cycle_am_00470.start();
        A3_Cycle_am_00470.start();
        A4_Cycle_am_00470.start();
        A5_Cycle_am_00470.start();
        A6_Cycle_am_00470.start();

        try {
            A1_Cycle_am_00470.join();
            A2_Cycle_am_00470.join();
            A3_Cycle_am_00470.join();
            A4_Cycle_am_00470.join();
            A5_Cycle_am_00470.join();
            A6_Cycle_am_00470.join();

        } catch (InterruptedException e) {
        }
        if (A1_Cycle_am_00470.check() && A2_Cycle_am_00470.check() && A3_Cycle_am_00470.check() && A4_Cycle_am_00470.check() && A5_Cycle_am_00470.check() && A6_Cycle_am_00470.check())
            System.out.println("ExpectResult");
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n
