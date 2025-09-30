/*
 *- @TestCaseID:maple/runtime/rc/function/RC_Thread02/RC_Thread_09
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination:Multi Thread reads or writes static para.mofidfy from Nocycle_a_00180
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\n
 *- @Priority: High
 *- @Source: RC_Thread_09.java
 *- @ExecuteClass: RC_Thread_09
 *- @ExecuteArgs:
 *- @Remark:

 *
 */

class RC_Thread_09_1 extends Thread {
    public void run() {
        RC_Thread_09 rcth01 = new RC_Thread_09();
        try {
            rcth01.setA1null();
        } catch (NullPointerException e) {

        }
    }
}

class RC_Thread_09_2 extends Thread {
    public void run() {
        RC_Thread_09 rcth01 = new RC_Thread_09();
        try {
            rcth01.setA2null();
        } catch (NullPointerException e) {

        }
    }
}

class RC_Thread_09_3 extends Thread {
    public void run() {
        RC_Thread_09 rcth01 = new RC_Thread_09();
        try {
            rcth01.setA3();
        } catch (NullPointerException e) {

        }

    }
}

class RC_Thread_09_4 extends Thread {
    public void run() {
        RC_Thread_09 rcth01 = new RC_Thread_09();
        try {
            rcth01.setA3null();
        } catch (NullPointerException e) {

        }
    }
}

class RC_Thread_09_5 extends Thread {
    public void run() {
        RC_Thread_09 rcth01 = new RC_Thread_09();
        try {
            rcth01.setA4null();
        } catch (NullPointerException e) {

        }
    }
}


public class RC_Thread_09 {
    private static RC_Thread_09_A1 a1_main = null;
    private static RC_Thread_09_A2 a2_main = null;
    private static RC_Thread_09_A3 a3_main = null;
    private static RC_Thread_09_A4 a4_main = null;

    RC_Thread_09() {
        try {
            a1_main = new RC_Thread_09_A1("a1_main");
            a2_main = new RC_Thread_09_A2("a2_main");
            a3_main = new RC_Thread_09_A3("a3_main");
            a4_main = new RC_Thread_09_A4("a4_main");
            a1_main.b1_0 = new RC_Thread_09_B1("b1_0");
            a1_main.d1_0 = new RC_Thread_09_D1("d1_0");
            a1_main.b1_0.d2_0 = new RC_Thread_09_D2("d2_0");

            a2_main.b2_0 = new RC_Thread_09_B2("b2_0");
            a2_main.b2_0.c1_0 = new RC_Thread_09_C1("c1_0");
            a2_main.b2_0.d1_0 = new RC_Thread_09_D1("d1_0");
            a2_main.b2_0.d2_0 = new RC_Thread_09_D2("d2_0");
            a2_main.b2_0.d3_0 = new RC_Thread_09_D3("d3_0");
            a2_main.b2_0.c1_0.d1_0 = new RC_Thread_09_D1("d1_0");

            a3_main.b2_0 = new RC_Thread_09_B2("b2_0");
            a3_main.b2_0.c1_0 = new RC_Thread_09_C1("c1_0");
            a3_main.b2_0.c1_0.d1_0 = new RC_Thread_09_D1("d1_0");
            a3_main.b2_0.d1_0 = new RC_Thread_09_D1("d1_0");
            a3_main.b2_0.d2_0 = new RC_Thread_09_D2("d2_0");
            a3_main.b2_0.d3_0 = new RC_Thread_09_D3("d3_0");

            a3_main.c2_0 = new RC_Thread_09_C2("c2_0");
            a3_main.c2_0.d2_0 = new RC_Thread_09_D2("d2_0");
            a3_main.c2_0.d3_0 = new RC_Thread_09_D3("d3_0");

            a4_main.b3_0 = new RC_Thread_09_B3("b3_0");
            a4_main.b3_0.c1_0 = new RC_Thread_09_C1("c1_0");
            a4_main.b3_0.c1_0.d1_0 = new RC_Thread_09_D1("d1_0");
            a4_main.c2_0 = new RC_Thread_09_C2("c2_0");
            a4_main.c2_0.d2_0 = new RC_Thread_09_D2("d2_0");
            a4_main.c2_0.d3_0 = new RC_Thread_09_D3("d3_0");
        } catch (NullPointerException e) {

        }
    }

    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
        System.out.println("ExpectResult");
    }

    private static void rc_testcase_main_wrapper() {
        RC_Thread_09_1 t1 = new RC_Thread_09_1();
        RC_Thread_09_2 t2 = new RC_Thread_09_2();
        RC_Thread_09_3 t3 = new RC_Thread_09_3();
        RC_Thread_09_4 t4 = new RC_Thread_09_4();
        RC_Thread_09_5 t5 = new RC_Thread_09_5();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
        }

    }


    public void setA1null() {
        a1_main = null;
    }

    public void setA2null() {
        a2_main = null;
    }

    public void setA3() {
        try {
            a3_main.c2_0.d2_0 = new RC_Thread_09_D2("new");
            a3_main = new RC_Thread_09_A3("a3_new");
            a3_main = null;
        } catch (NullPointerException e) {

        }
    }

    public void setA3null() {
        a3_main = null;
    }

    public void setA4null() {
        a4_main = null;
    }

    class RC_Thread_09_A1 {
        RC_Thread_09_B1 b1_0;
        RC_Thread_09_D1 d1_0;
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_A1(String strObjectName) {
            b1_0 = null;
            d1_0 = null;
            a = 101;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
        }

        void add() {
            sum = a + b1_0.a + d1_0.a;
        }
    }


    class RC_Thread_09_A2 {
        RC_Thread_09_B2 b2_0;
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_A2(String strObjectName) {
            b2_0 = null;
            a = 102;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A2_"+strObjectName);
        }

        void add() {
            sum = a + b2_0.a;
        }
    }


    class RC_Thread_09_A3 {
        RC_Thread_09_B2 b2_0;
        RC_Thread_09_C2 c2_0;
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_A3(String strObjectName) {
            b2_0 = null;
            c2_0 = null;
            a = 103;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A3_"+strObjectName);
        }

        void add() {
            sum = a + b2_0.a + c2_0.a;
        }
    }

    class RC_Thread_09_A4 {
        RC_Thread_09_B3 b3_0;
        RC_Thread_09_C2 c2_0;
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_A4(String strObjectName) {
            b3_0 = null;
            c2_0 = null;
            a = 104;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A4_"+strObjectName);
        }

        void add() {
            sum = a + b3_0.a + c2_0.a;
        }
    }


    class RC_Thread_09_B1 {
        RC_Thread_09_D2 d2_0;
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_B1(String strObjectName) {
            d2_0 = null;
            a = 201;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B1_"+strObjectName);
        }

        void add() {
            sum = a + d2_0.a;
        }
    }


    class RC_Thread_09_B2 {
        RC_Thread_09_C1 c1_0;
        RC_Thread_09_D1 d1_0;
        RC_Thread_09_D2 d2_0;
        RC_Thread_09_D3 d3_0;
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_B2(String strObjectName) {
            c1_0 = null;
            d1_0 = null;
            d2_0 = null;
            d3_0 = null;
            a = 202;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B2_"+strObjectName);
        }

        void add() {
            sum = a + c1_0.a + d1_0.a + d2_0.a + d3_0.a;
        }
    }


    class RC_Thread_09_B3 {
        RC_Thread_09_C1 c1_0;
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_B3(String strObjectName) {
            c1_0 = null;
            a = 203;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B3_"+strObjectName);
        }

        void add() {
            sum = a + c1_0.a;
        }
    }


    class RC_Thread_09_C1 {
        RC_Thread_09_D1 d1_0;
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_C1(String strObjectName) {
            d1_0 = null;
            a = 301;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C1_"+strObjectName);
        }

        void add() {
            sum = a + d1_0.a;
        }
    }

    class RC_Thread_09_C2 {
        RC_Thread_09_D2 d2_0;
        RC_Thread_09_D3 d3_0;
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_C2(String strObjectName) {
            d2_0 = null;
            d3_0 = null;
            a = 302;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C2_"+strObjectName);
        }

        void add() {
            sum = a + d2_0.a + d3_0.a;
        }
    }


    class RC_Thread_09_D1 {
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_D1(String strObjectName) {
            a = 401;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D1_"+strObjectName);
        }

        void add() {
            sum = a + a;
        }
    }

    class RC_Thread_09_D2 {
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_D2(String strObjectName) {
            a = 402;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D2_"+strObjectName);
        }

        void add() {
            sum = a + a;
        }
    }

    class RC_Thread_09_D3 {
        int a;
        int sum;
        String strObjectName;

        RC_Thread_09_D3(String strObjectName) {
            a = 403;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D3_"+strObjectName);
        }

        void add() {
            sum = a + a;
        }
    }

}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\n
