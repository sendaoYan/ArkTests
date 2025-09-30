/*
 *- @TestCaseID:maple/runtime/rc/function/Nocycle_a_00040.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination: Nocycle_a_00040 in RC测试-No-Cycle-00.vsd.
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: Nocycle_a_00040.java
 *- @ExecuteClass: Nocycle_a_00040
 *- @ExecuteArgs:
 *- @Remark:
 */
class Nocycle_a_00040_A1 {
    Nocycle_a_00040_B1 b1_0;
    Nocycle_a_00040_B2 b2_0;
    Nocycle_a_00040_B3 b3_0;
    Nocycle_a_00040_B4 b4_0;
    Nocycle_a_00040_B5 b5_0;
    Nocycle_a_00040_B6 b6_0;
    Nocycle_a_00040_B7 b7_0;
    Nocycle_a_00040_B8 b8_0;
    Nocycle_a_00040_B9 b9_0;
    Nocycle_a_00040_B10 b10_0;
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_A1(String strObjectName) {
        b1_0 = null;
        b2_0 = null;
        b3_0 = null;
        b4_0 = null;
        b5_0 = null;
        b6_0 = null;
        b7_0 = null;
        b8_0 = null;
        b9_0 = null;
        b10_0 = null;
        a = 101;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
    }

    void add() {
        sum = a + b1_0.a + b2_0.a + b3_0.a + b4_0.a + b5_0.a + b6_0.a + b7_0.a + b8_0.a + b9_0.a + b10_0.a;
    }
}

class Nocycle_a_00040_B1 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_B1(String strObjectName) {
        a = 201;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B1_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00040_B2 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_B2(String strObjectName) {
        a = 202;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B2_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}


class Nocycle_a_00040_B3 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_B3(String strObjectName) {
        a = 203;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B3_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00040_B4 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_B4(String strObjectName) {
        a = 204;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B4_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00040_B5 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_B5(String strObjectName) {
        a = 205;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B5_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00040_B6 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_B6(String strObjectName) {
        a = 206;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B6_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00040_B7 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_B7(String strObjectName) {
        a = 207;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B7_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}


class Nocycle_a_00040_B8 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_B8(String strObjectName) {
        a = 208;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B8_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00040_B9 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_B9(String strObjectName) {
        a = 209;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B9_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00040_B10 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00040_B10(String strObjectName) {
        a = 210;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B10_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

public class Nocycle_a_00040 {

    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
        
    }

    private static void rc_testcase_main_wrapper() {
        Nocycle_a_00040_A1 a1_main = new Nocycle_a_00040_A1("a1_main");
        a1_main.b1_0 = new Nocycle_a_00040_B1("b1_0");
        a1_main.b2_0 = new Nocycle_a_00040_B2("b2_0");
        a1_main.b3_0 = new Nocycle_a_00040_B3("b3_0");
        a1_main.b4_0 = new Nocycle_a_00040_B4("b4_0");
        a1_main.b5_0 = new Nocycle_a_00040_B5("b5_0");
        a1_main.b6_0 = new Nocycle_a_00040_B6("b6_0");
        a1_main.b7_0 = new Nocycle_a_00040_B7("b7_0");
        a1_main.b8_0 = new Nocycle_a_00040_B8("b8_0");
        a1_main.b9_0 = new Nocycle_a_00040_B9("b9_0");
        a1_main.b10_0 = new Nocycle_a_00040_B10("b10_0");
        a1_main.add();
        a1_main.b1_0.add();
        a1_main.b2_0.add();
        a1_main.b3_0.add();
        a1_main.b4_0.add();
        a1_main.b5_0.add();
        a1_main.b6_0.add();
        a1_main.b7_0.add();
        a1_main.b8_0.add();
        a1_main.b9_0.add();
        a1_main.b10_0.add();
        int result = a1_main.sum + a1_main.b1_0.sum + a1_main.b2_0.sum + a1_main.b3_0.sum + a1_main.b4_0.sum + a1_main.b5_0.sum + a1_main.b6_0.sum + a1_main.b7_0.sum + a1_main.b8_0.sum + a1_main.b9_0.sum + a1_main.b10_0.sum;
        if (result == 6266)
            System.out.println("ExpectResult");
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n
