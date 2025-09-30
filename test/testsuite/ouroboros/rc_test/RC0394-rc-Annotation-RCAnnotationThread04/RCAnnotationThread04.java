/*
 *- @TestCaseID:maple/runtime/rc/function/RC_Thread02/RCAnnotationThread04.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination:Multi Thread reads or writes static para.mofidfy from Cycle_a_00320
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\n
 *- @Priority: High
 *- @Source: RCAnnotationThread04.java
 *- @ExecuteClass: RCAnnotationThread04
 *- @ExecuteArgs:
 *- @Remark:Owner Zhang Wenlong 00292413
 *
 */
 
import com.huawei.ark.annotation.Weak;
import com.huawei.ark.annotation.Unowned;
class RCAnnotationThread04_1 extends Thread {
    public void run() {
        RCAnnotationThread04 rcth01 = new RCAnnotationThread04();
        try {
            rcth01.ModifyA3();
        } catch (NullPointerException e) {

        }
    }
}

class RCAnnotationThread04_2 extends Thread {
    public void run() {
        RCAnnotationThread04 rcth01 = new RCAnnotationThread04();
        try {
            rcth01.checkA3();
        } catch (NullPointerException e) {

        }
    }
}

class RCAnnotationThread04_3 extends Thread {
    public void run() {
        RCAnnotationThread04 rcth01 = new RCAnnotationThread04();
        try {
            rcth01.setA3null();
        } catch (NullPointerException e) {

        }

    }
}

public class RCAnnotationThread04 {
    private volatile static RCAnnotationThread04_A1 a1_main = null;
    private volatile static RCAnnotationThread04_A4 a4_main = null;
    private volatile static RCAnnotationThread04_A6 a6_main = null;

    RCAnnotationThread04() {
        synchronized (this) {
            try {
                RCAnnotationThread04_A1 a1 = new RCAnnotationThread04_A1("a1");
                RCAnnotationThread04_A4 a4 = new RCAnnotationThread04_A4("a4");
                RCAnnotationThread04_A6 a6 = new RCAnnotationThread04_A6("a6");
                a1.a2_0 = new RCAnnotationThread04_A2("a2_0");
                a1.a2_0.a3_0 = new RCAnnotationThread04_A3("a3_0");
                a1.a2_0.a3_0.a1_0 = a1;
                a1.a2_0.a3_0.a5_0 = new RCAnnotationThread04_A5("a5_0");
                a1.a2_0.a3_0.a5_0.a6_0 = a6;
                a6.a1_0 = a1;
                a6.a3_0 = a1.a2_0.a3_0;
                a4.a5_0 = a1.a2_0.a3_0.a5_0;
                a6.a4_0 = a4;
                a1_main = a1;
                a4_main = a4;
                a6_main = a6;
            } catch (NullPointerException e) {
            }
        }
    }

    public static void main(String[] args) {
        rc_testcase_main_wrapper();
        System.out.println("ExpectResult");
    }

    private static void rc_testcase_main_wrapper() {
        RCAnnotationThread04_1 t_00010= new RCAnnotationThread04_1();
        RCAnnotationThread04_2 t_00020= new RCAnnotationThread04_2();
        RCAnnotationThread04_3 t_00030= new RCAnnotationThread04_3();
        t_00010.start();
        t_00020.start();
        t_00030.start();
        try {
            t_00010.join();
            t_00020.join();
            t_00030.join();

        } catch (InterruptedException e) {}

    }

    public void checkA3() {
        int[] arr = new int[2];
        try {
            arr[0] = a1_main.a2_0.a3_0.a;
            arr[1] = a1_main.a2_0.a3_0.sum;
        } catch (NullPointerException e) {

        }
    }

    public void ModifyA3() {
        try {
            a1_main.a2_0.a3_0 = new RCAnnotationThread04_A3("new-a3");
        } catch (NullPointerException e) {

        }
    }

    public void setA3null() {
        RCAnnotationThread04_A3 a3 = new RCAnnotationThread04_A3("test");
        try {
            a3 = this.a1_main.a2_0.a3_0;
            this.a1_main.a2_0.a3_0 = null;
        } catch (NullPointerException e) {

        }

    }

    static class RCAnnotationThread04_A1 {
        volatile RCAnnotationThread04_A2 a2_0;
        int a;
        int sum;
        String strObjectName;

        RCAnnotationThread04_A1(String strObjectName) {
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

    static class RCAnnotationThread04_A2 {
        volatile RCAnnotationThread04_A3 a3_0;
        int a;
        int sum;
        String strObjectName;

        RCAnnotationThread04_A2(String strObjectName) {
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

    static class RCAnnotationThread04_A3 {
        @Weak
        volatile RCAnnotationThread04_A1 a1_0;
        volatile RCAnnotationThread04_A5 a5_0;
        int a;
        int sum;
        String strObjectName;

        RCAnnotationThread04_A3(String strObjectName) {
            a1_0 = null;
            a5_0 = null;
            a = 103;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A3_"+strObjectName);
        }

        void add() {
            sum = a + a1_0.a + a5_0.a;
        }
    }


    static class RCAnnotationThread04_A4 {
        volatile RCAnnotationThread04_A5 a5_0;
        int a;
        int sum;
        String strObjectName;

        RCAnnotationThread04_A4(String strObjectName) {
            a5_0 = null;
            a = 104;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A4_"+strObjectName);
        }

        void add() {
            sum = a + a5_0.a;
        }
    }

    static class RCAnnotationThread04_A5 {
        @Unowned
        volatile RCAnnotationThread04_A6 a6_0;
        int a;
        int sum;
        String strObjectName;

        RCAnnotationThread04_A5(String strObjectName) {
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

    static class RCAnnotationThread04_A6 {
        @Unowned
        volatile RCAnnotationThread04_A1 a1_0;
        @Unowned
        volatile RCAnnotationThread04_A3 a3_0;
        @Unowned
        volatile RCAnnotationThread04_A4 a4_0;
        int a;
        int sum;
        String strObjectName;

        RCAnnotationThread04_A6(String strObjectName) {
            a1_0 = null;
            a3_0 = null;
            a4_0 = null;
            a = 106;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A6_"+strObjectName);
        }

        void add() {
            sum = a + a1_0.a + a3_0.a + a4_0.a;
        }
    }

}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\n
