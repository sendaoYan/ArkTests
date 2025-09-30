/*
 *- @TestCaseID:maple/runtime/rc/function/RC_Thread01/Cycle_am_00440.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination:Change Cycle_a_00440 in RC测试-Cycle-01 to Multi thread testcase.
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: Cycle_am_00440.java
 *- @ExecuteClass: Cycle_am_00440
 *- @ExecuteArgs:
 *- @Remark:
 */

class ThreadRc_Cycle_am_00440 extends Thread {
    private boolean checkout;

    public void run() {
        Cycle_a_00440_A1 a1_main = new Cycle_a_00440_A1("a1_main");
        a1_main.a2_0 = new Cycle_a_00440_A2("a2_0");
        a1_main.a2_0.a3_0 = new Cycle_a_00440_A3("a3_0");
        a1_main.a2_0.a4_0 = new Cycle_a_00440_A4("a4_0");
        a1_main.a2_0.a1_0 = a1_main;
        a1_main.a2_0.a3_0.a1_0 = a1_main;
        a1_main.a2_0.a4_0.a2_0 = a1_main.a2_0;


        a1_main.add();
        a1_main.a2_0.add();
        a1_main.a2_0.a3_0.add();
        a1_main.a2_0.a4_0.add();


        int result = a1_main.sum + a1_main.a2_0.sum + a1_main.a2_0.a3_0.sum + a1_main.a2_0.a4_0.sum;
        //System.out.println("RC-Testing_Result="+result);

        if (result == 1023)
            checkout = true;
        //System.out.println(checkout);
    }

    public boolean check() {
        return checkout;
    }

    class Cycle_a_00440_A1 {
        Cycle_a_00440_A2 a2_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00440_A1(String strObjectName) {
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

    class Cycle_a_00440_A2 {
        Cycle_a_00440_A1 a1_0;
        Cycle_a_00440_A3 a3_0;
        Cycle_a_00440_A4 a4_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00440_A2(String strObjectName) {
            a1_0 = null;
            a3_0 = null;
            a4_0 = null;
            a = 102;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A2_"+strObjectName);
        }

        void add() {
            sum = a + a1_0.a + a3_0.a + a4_0.a;
        }
    }

    class Cycle_a_00440_A3 {
        Cycle_a_00440_A1 a1_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00440_A3(String strObjectName) {
            a1_0 = null;
            a = 103;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A3_"+strObjectName);
        }

        void add() {
            sum = a + a1_0.a;
        }
    }

    class Cycle_a_00440_A4 {
        Cycle_a_00440_A2 a2_0;
        int a;
        int sum;
        String strObjectName;

        Cycle_a_00440_A4(String strObjectName) {
            a2_0 = null;
            a = 104;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A4_"+strObjectName);
        }

        void add() {
            sum = a + a2_0.a;
        }
    }
}


public class Cycle_am_00440 {
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
        
    }

    private static void rc_testcase_main_wrapper() {
        ThreadRc_Cycle_am_00440 A1_Cycle_am_00440 = new ThreadRc_Cycle_am_00440();
        ThreadRc_Cycle_am_00440 A2_Cycle_am_00440 = new ThreadRc_Cycle_am_00440();
        ThreadRc_Cycle_am_00440 A3_Cycle_am_00440 = new ThreadRc_Cycle_am_00440();
        ThreadRc_Cycle_am_00440 A4_Cycle_am_00440 = new ThreadRc_Cycle_am_00440();
        ThreadRc_Cycle_am_00440 A5_Cycle_am_00440 = new ThreadRc_Cycle_am_00440();
        ThreadRc_Cycle_am_00440 A6_Cycle_am_00440 = new ThreadRc_Cycle_am_00440();

        A1_Cycle_am_00440.start();
        A2_Cycle_am_00440.start();
        A3_Cycle_am_00440.start();
        A4_Cycle_am_00440.start();
        A5_Cycle_am_00440.start();
        A6_Cycle_am_00440.start();

        try {
            A1_Cycle_am_00440.join();
            A2_Cycle_am_00440.join();
            A3_Cycle_am_00440.join();
            A4_Cycle_am_00440.join();
            A5_Cycle_am_00440.join();
            A6_Cycle_am_00440.join();

        } catch (InterruptedException e) {
        }
        if (A1_Cycle_am_00440.check() && A2_Cycle_am_00440.check() && A3_Cycle_am_00440.check() && A4_Cycle_am_00440.check() && A5_Cycle_am_00440.check() && A6_Cycle_am_00440.check())
            System.out.println("ExpectResult");
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n
