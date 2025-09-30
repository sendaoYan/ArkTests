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


class Cycle_B_2_00240_A1 {
    Cycle_B_2_00240_A2 a2_0;
    int a;
    int sum;
    String strObjectName;
    Cycle_B_2_00240_A1(String strObjectName) {
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
class Cycle_B_2_00240_A2 {
    Cycle_B_2_00240_A1 a1_0;
    Cycle_B_2_00240_A3 a3_0;
    Cycle_B_2_00240_A4 a4_0;
    int a;
    int sum;
    String strObjectName;
    Cycle_B_2_00240_A2(String strObjectName) {
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
class Cycle_B_2_00240_A3 {
    Cycle_B_2_00240_A1 a1_0;
    int a;
    int sum;
    String strObjectName;
    Cycle_B_2_00240_A3(String strObjectName) {
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
class Cycle_B_2_00240_A4 {
    Cycle_B_2_00240_A1 a1_0;
    Cycle_B_2_00240_A2 a2_0;
    int a;
    int sum;
    String strObjectName;
    Cycle_B_2_00240_A4(String strObjectName) {
        a2_0 = null;
        a = 104;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A4_"+strObjectName);
    }
    void add() {
        sum = a + a1_0.a + a2_0.a;
    }
}
class Cycle_B_2_00240_B1 {
    Cycle_B_2_00240_A3 a3_0;
    Cycle_B_2_00240_B2 b2_0;
    Nocycle_B_2_00240_C2 c2_0;
    int a;
    int sum;
    Cycle_B_2_00240_B1() {
        a3_0 = null;
        b2_0 = null;
        c2_0 = null;
        a = 1;
        sum = 0;
    }
    void add() {
        sum = a + a3_0.a + b2_0.a + c2_0.a;
    }
}
class Cycle_B_2_00240_B2 {
    Cycle_B_2_00240_B1 b1_0;
    int a;
    int sum;
    Cycle_B_2_00240_B2() {
        b1_0 = null;
        a = 2;
        sum = 0;
    }
    void add() {
        sum = a + b1_0.a;
    }
}
class Nocycle_B_2_00240_C1 {
    Nocycle_B_2_00240_C2 c2_0;
    int a;
    int sum;
    String strObjectName;
    Nocycle_B_2_00240_C1(String strObjectName) {
        c2_0 = null;
        a = 101;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
    }
    //   protected void finalize() throws java.lang.Throwable {
//       System.out.println("RC-Testing_Destruction_A1_"+strObjectName);
//   }
    void add() {
        sum = a + c2_0.a;
    }
}
class Nocycle_B_2_00240_C2 {
    int a;
    int sum;
    String strObjectName;
    Nocycle_B_2_00240_C2(String strObjectName) {
        a = 201;
        sum = 0;
        this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B1_"+strObjectName);
    }
    //   protected void finalize() throws java.lang.Throwable {
//       System.out.println("RC-Testing_Destruction_B1_"+strObjectName);
//   }
    void add() {
        sum = a + a;
    }
}
public class Cycle_B_2_00240 {
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
    }
    private static void rc_testcase_main_wrapper() {
        Cycle_B_2_00240_A1 a1_main = new Cycle_B_2_00240_A1("a1_main");
        a1_main.a2_0 = new Cycle_B_2_00240_A2("a2_0");
        a1_main.a2_0.a3_0 = new Cycle_B_2_00240_A3("a3_0");
        a1_main.a2_0.a4_0 = new Cycle_B_2_00240_A4("a4_0");
        a1_main.a2_0.a1_0 = a1_main;
        a1_main.a2_0.a3_0.a1_0 = a1_main;
        a1_main.a2_0.a4_0.a2_0 = a1_main.a2_0;
        a1_main.a2_0.a4_0.a1_0 = a1_main;
        a1_main.add();
        a1_main.a2_0.add();
        a1_main.a2_0.a3_0.add();
        a1_main.a2_0.a4_0.add();
        int result = a1_main.sum + a1_main.a2_0.sum + a1_main.a2_0.a3_0.sum + a1_main.a2_0.a4_0.sum;
        Cycle_B_2_00240_B1 b1_0 = new Cycle_B_2_00240_B1();
        b1_0.a3_0 = new Cycle_B_2_00240_A3("a3_b1");
        b1_0.b2_0 = new Cycle_B_2_00240_B2();
        b1_0.c2_0 = new Nocycle_B_2_00240_C2("c2_b1");
        b1_0.b2_0.b1_0 = b1_0;
        b1_0.add();
        b1_0.b2_0.add();
        int nsum = (b1_0.sum + b1_0.b2_0.sum);
        Nocycle_B_2_00240_C1 c1_main = new Nocycle_B_2_00240_C1("c1_main");
        c1_main.c2_0 = new Nocycle_B_2_00240_C2("c2_0");
        c1_main.add();
        c1_main.c2_0.add();
        int result2 = c1_main.sum + c1_main.c2_0.sum;
        if (result == 1124 && nsum == 310 && result2 == 704)
            System.out.println("ExpectResult");
    }
}
