/*
 *- @TestCaseID:maple/runtime/rc/function/Nocycle_a_00110.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination: Nocycle_a_00110 in RC测试-No-Cycle-00.vsd.
 *- @Condition: no
 * -#c1
 *- @Brief:functionTest
 * -#step1
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: Nocycle_a_00110.java
 *- @ExecuteClass: Nocycle_a_00110
 *- @ExecuteArgs:
 *- @Remark:
 */
class Nocycle_a_00110_A1 {
    Nocycle_a_00110_B1 b1_0;
    Nocycle_a_00110_B2 b2_0;
    Nocycle_a_00110_B3 b3_0;
    Nocycle_a_00110_B4 b4_0;
    Nocycle_a_00110_D5 d5_0;
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_A1(String strObjectName) {
        b1_0 = null;
        b2_0 = null;
        b3_0 = null;
        b4_0 = null;
        d5_0 = null;
        a = 101;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
    }

    void add() {
        sum = a + b1_0.a + b2_0.a + b3_0.a + b4_0.a + d5_0.a;
    }
}

class Nocycle_a_00110_B1 {
    Nocycle_a_00110_D1 d1_0;
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_B1(String strObjectName) {
        a = 201;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B1_"+strObjectName);
    }

    void add() {
        sum = a + d1_0.a;
    }
}


class Nocycle_a_00110_B2 {
    Nocycle_a_00110_C2 c2_0;
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_B2(String strObjectName) {
        c2_0 = null;
        a = 202;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B2_"+strObjectName);
    }

    void add() {
        sum = a + c2_0.a;
    }
}


class Nocycle_a_00110_B3 {
    Nocycle_a_00110_C1 c1_0;
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_B3(String strObjectName) {
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


class Nocycle_a_00110_B4 {
    Nocycle_a_00110_C3 c3_0;
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_B4(String strObjectName) {
        c3_0 = null;
        a = 204;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B4_"+strObjectName);
    }

    void add() {
        sum = a + c3_0.a;
    }
}


class Nocycle_a_00110_C1 {
    Nocycle_a_00110_D2 d2_0;
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_C1(String strObjectName) {
        d2_0 = null;
        a = 301;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C1_"+strObjectName);
    }

    void add() {
        sum = a + d2_0.a;
    }
}

class Nocycle_a_00110_C2 {
    Nocycle_a_00110_D3 d3_0;
    Nocycle_a_00110_D4 d4_0;
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_C2(String strObjectName) {
        d3_0 = null;
        d4_0 = null;
        a = 302;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C2_"+strObjectName);
    }

    void add() {
        sum = a + d3_0.a + d4_0.a;
    }
}

class Nocycle_a_00110_C3 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_C3(String strObjectName) {
        a = 303;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C3_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}


class Nocycle_a_00110_D1 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_D1(String strObjectName) {
        a = 401;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D1_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00110_D2 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_D2(String strObjectName) {
        a = 402;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D2_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00110_D3 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_D3(String strObjectName) {
        a = 403;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D3_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00110_D4 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_D4(String strObjectName) {
        a = 404;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D4_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

class Nocycle_a_00110_D5 {
    int a;
    int sum;
    String strObjectName;

    Nocycle_a_00110_D5(String strObjectName) {
        a = 405;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D5_"+strObjectName);
    }

    void add() {
        sum = a + a;
    }
}

public class Nocycle_a_00110 {

    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
        
    }

    private static void rc_testcase_main_wrapper() {
        Nocycle_a_00110_A1 a1_main = new Nocycle_a_00110_A1("a1_main");
        a1_main.b1_0 = new Nocycle_a_00110_B1("b1_0");
        a1_main.b2_0 = new Nocycle_a_00110_B2("b2_0");
        a1_main.b3_0 = new Nocycle_a_00110_B3("b3_0");
        a1_main.b4_0 = new Nocycle_a_00110_B4("b4_0");
        a1_main.b1_0.d1_0 = new Nocycle_a_00110_D1("d1_0");
        a1_main.b2_0.c2_0 = new Nocycle_a_00110_C2("c2_0");
        a1_main.b3_0.c1_0 = new Nocycle_a_00110_C1("c1_0");
        a1_main.b4_0.c3_0 = new Nocycle_a_00110_C3("c3_0");
        a1_main.b3_0.c1_0.d2_0 = new Nocycle_a_00110_D2("d2_0");
        a1_main.b2_0.c2_0.d3_0 = new Nocycle_a_00110_D3("d3_0");
        a1_main.b2_0.c2_0.d4_0 = new Nocycle_a_00110_D4("d4_0");
        a1_main.d5_0 = new Nocycle_a_00110_D5("d5_0");
        a1_main.add();
        a1_main.b1_0.add();
        a1_main.b2_0.add();
        a1_main.b3_0.add();
        a1_main.b4_0.add();
        a1_main.b2_0.c2_0.add();
        a1_main.b3_0.c1_0.add();
        a1_main.b4_0.c3_0.add();
        a1_main.b1_0.d1_0.add();
        a1_main.b3_0.c1_0.d2_0.add();
        a1_main.b2_0.c2_0.d3_0.add();
        a1_main.b2_0.c2_0.d4_0.add();
        a1_main.d5_0.add();
        int result = a1_main.sum + a1_main.b1_0.sum + a1_main.b2_0.sum + a1_main.b3_0.sum + a1_main.b4_0.sum + a1_main.b2_0.c2_0.sum + a1_main.b3_0.c1_0.sum + a1_main.b4_0.c3_0.sum + a1_main.b1_0.d1_0.sum + a1_main.b3_0.c1_0.d2_0.sum + a1_main.b2_0.c2_0.d3_0.sum + a1_main.b2_0.c2_0.d4_0.sum + a1_main.d5_0.sum;
        if (result == 9881)
            System.out.println("ExpectResult");
    }

}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n
