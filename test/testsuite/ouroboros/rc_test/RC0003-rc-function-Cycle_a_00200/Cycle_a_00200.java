/*
 *- @TestCaseID:maple/runtime/rc/function/Cycle_a_00200.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination: Cycle_a_00200 in RC测试-Cycle-01
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: Cycle_a_00200.java
 *- @ExecuteClass: Cycle_a_00200
 *- @ExecuteArgs:
 *- @Remark:
 * A1 depend A2;  A4 depend A3 ;
 * A2 depend A3 A6 A7; A3 depend A1 A5; A5 depend A4; A6 depend A7 ;
 * A1.a=101 A2.a=102 A3.a=103 ... A9.a=109
 * RC-Testing_Result=(101+102+106+107)+(102+103)+(103+101+105)+(104+103)+(105+104)+(106+107)+(107+107)=1773
 *
 */

class Cycle_a_00200_A1 {
    Cycle_a_00200_A2 a2_0;
    int a;
    int sum;
    String strObjectName;

    Cycle_a_00200_A1(String strObjectName) {
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

class Cycle_a_00200_A2 {
    Cycle_a_00200_A3 a3_0;
    Cycle_a_00200_A6 a6_0;
    Cycle_a_00200_A7 a7_0;
    int a;
    int sum;
    String strObjectName;

    Cycle_a_00200_A2(String strObjectName) {
        a3_0 = null;
        a6_0 = null;
        a7_0 = null;
        a = 102;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A2_"+strObjectName);
    }

    void add() {
        sum = a + a3_0.a + a6_0.a + a7_0.a;
    }
}

class Cycle_a_00200_A3 {
    Cycle_a_00200_A1 a1_0;
    Cycle_a_00200_A5 a5_0;
    int a;
    int sum;
    String strObjectName;

    Cycle_a_00200_A3(String strObjectName) {
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

class Cycle_a_00200_A4 {
    Cycle_a_00200_A3 a3_0;
    int a;
    int sum;
    String strObjectName;

    Cycle_a_00200_A4(String strObjectName) {
        a3_0 = null;
        a = 104;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A4_"+strObjectName);
    }

    void add() {
        sum = a + a3_0.a;
    }
}

class Cycle_a_00200_A5 {
    Cycle_a_00200_A4 a4_0;
    int a;
    int sum;
    String strObjectName;

    Cycle_a_00200_A5(String strObjectName) {
        a4_0 = null;
        a = 105;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A5_"+strObjectName);
    }

    void add() {
        sum = a + a4_0.a;
    }
}

class Cycle_a_00200_A6 {
    Cycle_a_00200_A7 a7_0;
    int a;
    int sum;
    String strObjectName;

    Cycle_a_00200_A6(String strObjectName) {
        a7_0 = null;
        a = 106;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A6_"+strObjectName);
    }

    void add() {
        sum = a + a7_0.a;
    }
}

class Cycle_a_00200_A7 {
    int a;
    int sum;
    String strObjectName;

    Cycle_a_00200_A7(String strObjectName) {
        a = 107;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A6_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}


public class Cycle_a_00200 {

    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
        
    }

    private static void rc_testcase_main_wrapper() {
        Cycle_a_00200_A1 a1_main = new Cycle_a_00200_A1("a1_main");
        Cycle_a_00200_A4 a4_main = new Cycle_a_00200_A4("a4_main");
        a1_main.a2_0 = new Cycle_a_00200_A2("a2_0");
        a1_main.a2_0.a3_0 = new Cycle_a_00200_A3("a3_0");
        a1_main.a2_0.a3_0.a1_0 = a1_main;
        a1_main.a2_0.a3_0.a5_0 = new Cycle_a_00200_A5("a5_0");
        a1_main.a2_0.a3_0.a5_0.a4_0 = a4_main;
        a4_main.a3_0 = a1_main.a2_0.a3_0;
        a1_main.a2_0.a6_0 = new Cycle_a_00200_A6("a6_0");
        a1_main.a2_0.a6_0.a7_0 = new Cycle_a_00200_A7("a7_0");
        a1_main.a2_0.a7_0 = a1_main.a2_0.a6_0.a7_0;

        a1_main.add();
        a4_main.add();
        a1_main.a2_0.add();
        a1_main.a2_0.a3_0.add();
        a1_main.a2_0.a3_0.a5_0.add();
        a1_main.a2_0.a6_0.add();
        a1_main.a2_0.a6_0.a7_0.add();

        int result = a1_main.sum + a4_main.sum + a1_main.a2_0.sum + a1_main.a2_0.a3_0.sum + a1_main.a2_0.a3_0.a5_0.sum + a1_main.a2_0.a6_0.sum + a1_main.a2_0.a6_0.a7_0.sum;
        if (result == 1773)
            System.out.println("ExpectResult");
    }

}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n
