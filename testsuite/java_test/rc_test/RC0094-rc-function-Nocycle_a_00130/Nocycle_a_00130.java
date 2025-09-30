/*
 * Copyright (c) [2021] Huawei Technologies Co.,Ltd.All rights reserved.
 *
 * OpenArkCompiler is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 *
 *     http://license.coscl.org.cn/MulanPSL2
 *
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR
 * FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
*/


class Nocycle_a_00130_A1 {
    Nocycle_a_00130_B1 b1_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_A1(String strObjectName) {
        b1_0 = null;
        a = 101;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_a_00130_A2 {
    Nocycle_a_00130_B1 b1_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_A2(String strObjectName) {
        b1_0 = null;
        a = 102;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A2_"+strObjectName);
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_a_00130_A3 {
    Nocycle_a_00130_B1 b1_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_A3(String strObjectName) {
        b1_0 = null;
        a = 103;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A3_"+strObjectName);
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_a_00130_A4 {
    Nocycle_a_00130_B1 b1_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_A4(String strObjectName) {
        b1_0 = null;
        a = 104;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A4_"+strObjectName);
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_a_00130_A5 {
    Nocycle_a_00130_B1 b1_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_A5(String strObjectName) {
        b1_0 = null;
        a = 105;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A5_"+strObjectName);
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_a_00130_A6 {
    Nocycle_a_00130_B1 b1_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_A6(String strObjectName) {
        b1_0 = null;
        a = 106;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A6_"+strObjectName);
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_a_00130_A7 {
    Nocycle_a_00130_B1 b1_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_A7(String strObjectName) {
        b1_0 = null;
        a = 107;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A7_"+strObjectName);
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_a_00130_A8 {
    Nocycle_a_00130_B1 b1_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_A8(String strObjectName) {
        b1_0 = null;
        a = 108;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A8_"+strObjectName);
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_a_00130_A9 {
    Nocycle_a_00130_B1 b1_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_A9(String strObjectName) {
        b1_0 = null;
        a = 109;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A9_"+strObjectName);
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_a_00130_A10 {
    Nocycle_a_00130_B1 b1_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_A10(String strObjectName) {
        b1_0 = null;
        a = 110;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A10_"+strObjectName);
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_a_00130_B1 {
    int a;
    int sum;
    String strObjectName;
    Nocycle_a_00130_B1(String strObjectName) {
        a = 201;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B1_"+strObjectName);
    }
    void add() {
        sum = a + a;
    }
}
public class Nocycle_a_00130 {
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
    }
    private static void rc_testcase_main_wrapper() {
        Nocycle_a_00130_A1 a1_main = new Nocycle_a_00130_A1("a1_main");
        Nocycle_a_00130_A2 a2_main = new Nocycle_a_00130_A2("a2_main");
        Nocycle_a_00130_A3 a3_main = new Nocycle_a_00130_A3("a3_main");
        Nocycle_a_00130_A4 a4_main = new Nocycle_a_00130_A4("a4_main");
        Nocycle_a_00130_A5 a5_main = new Nocycle_a_00130_A5("a5_main");
        Nocycle_a_00130_A6 a6_main = new Nocycle_a_00130_A6("a6_main");
        Nocycle_a_00130_A7 a7_main = new Nocycle_a_00130_A7("a7_main");
        Nocycle_a_00130_A8 a8_main = new Nocycle_a_00130_A8("a8_main");
        Nocycle_a_00130_A9 a9_main = new Nocycle_a_00130_A9("a9_main");
        Nocycle_a_00130_A10 a10_main = new Nocycle_a_00130_A10("a10_main");
        a1_main.b1_0 = new Nocycle_a_00130_B1("b1_0");
        a2_main.b1_0 = new Nocycle_a_00130_B1("b1_0");
        a3_main.b1_0 = new Nocycle_a_00130_B1("b1_0");
        a4_main.b1_0 = new Nocycle_a_00130_B1("b1_0");
        a5_main.b1_0 = new Nocycle_a_00130_B1("b1_0");
        a6_main.b1_0 = new Nocycle_a_00130_B1("b1_0");
        a7_main.b1_0 = new Nocycle_a_00130_B1("b1_0");
        a8_main.b1_0 = new Nocycle_a_00130_B1("b1_0");
        a9_main.b1_0 = new Nocycle_a_00130_B1("b1_0");
        a10_main.b1_0 = new Nocycle_a_00130_B1("b1_0");
        a1_main.add();
        a2_main.add();
        a3_main.add();
        a4_main.add();
        a5_main.add();
        a6_main.add();
        a7_main.add();
        a8_main.add();
        a9_main.add();
        a10_main.add();
        a1_main.b1_0.add();
        a2_main.b1_0.add();
        a3_main.b1_0.add();
        a4_main.b1_0.add();
        a5_main.b1_0.add();
        a6_main.b1_0.add();
        a7_main.b1_0.add();
        a8_main.b1_0.add();
        a9_main.b1_0.add();
        a10_main.b1_0.add();
        int result = a1_main.sum + a2_main.sum + a3_main.sum + a4_main.sum + a5_main.sum + a6_main.sum + a7_main.sum + a8_main.sum + a9_main.sum + a10_main.sum + a1_main.b1_0.sum;
        if (result == 3467)
            System.out.println("ExpectResult");
    }
}
