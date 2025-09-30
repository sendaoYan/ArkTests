/*
 *- @TestCaseID:maple/runtime/rc/function/Cycle_a_00390.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination: Cycle_a_00390 in RC测试-Cycle-01
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: Cycle_a_00390.java
 *- @ExecuteClass: Cycle_a_00390
 *- @ExecuteArgs:
 *- @Remark:
 * A1 depend A2 A3; A2 depend A1 A3; A3 depend A1 A2
 * A1.a=101 A2.a=102 A3.a=103
 * RC-Testing_Result=(101+102+103)+(102+101+103)+(103+101+102)=918
 *
 */

class Cycle_a_00390_A1 {
    Cycle_a_00390_A2 a2_0;
    Cycle_a_00390_A3 a3_0;
    int a;
    int sum;
    String strObjectName;

    Cycle_a_00390_A1(String strObjectName) {
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

class Cycle_a_00390_A2 {
    Cycle_a_00390_A1 a1_0;
    Cycle_a_00390_A3 a3_0;
    int a;
    int sum;
    String strObjectName;

    Cycle_a_00390_A2(String strObjectName) {
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

class Cycle_a_00390_A3 {
    Cycle_a_00390_A1 a1_0;
    Cycle_a_00390_A2 a2_0;
    int a;
    int sum;
    String strObjectName;

    Cycle_a_00390_A3(String strObjectName) {
        a1_0 = null;
        a2_0 = null;
        a = 103;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A3_"+strObjectName);
    }

    void add() {
        sum = a + a1_0.a + a2_0.a;
    }
}


public class Cycle_a_00390 {

    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
        
    }

    private static void rc_testcase_main_wrapper() {
        Cycle_a_00390_A1 a1_main = new Cycle_a_00390_A1("a1_main");
        a1_main.a2_0 = new Cycle_a_00390_A2("a2_0");
        a1_main.a2_0.a1_0 = a1_main;
        a1_main.a2_0.a3_0 = new Cycle_a_00390_A3("a3_0");
        a1_main.a3_0 = a1_main.a2_0.a3_0;
        a1_main.a3_0.a1_0 = a1_main;
        a1_main.a3_0.a2_0 = a1_main.a2_0;


        a1_main.add();
        a1_main.a2_0.add();
        a1_main.a2_0.a3_0.add();

        int result = a1_main.sum + a1_main.a2_0.sum + a1_main.a2_0.a3_0.sum;
        //System.out.println("RC-Testing_Result="+result);
        if (result == 918)
            System.out.println("ExpectResult");
    }

}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n
