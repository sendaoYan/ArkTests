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


class Cycle_B_2_00230_A1 {
    Cycle_B_2_00230_A2 a2_0;
    int a;
    int sum;
    Cycle_B_2_00230_A1() {
        a2_0 = null;
        a = 1;
        sum = 0;
    }
    void add() {
        sum = a + a2_0.a;
    }
}
class Cycle_B_2_00230_A2 {
    Cycle_B_2_00230_A3 a3_0;
    int a;
    int sum;
    Cycle_B_2_00230_A2() {
        a3_0 = null;
        a = 2;
        sum = 0;
    }
    void add() {
        sum = a + a3_0.a;
    }
}
class Cycle_B_2_00230_A3 {
    Cycle_B_2_00230_A4 a4_0;
    int a;
    int sum;
    Cycle_B_2_00230_A3() {
        a4_0 = null;
        a = 3;
        sum = 0;
    }
    void add() {
        sum = a + a4_0.a;
    }
}
class Cycle_B_2_00230_A4 {
    Cycle_B_2_00230_A5 a5_0;
    int a;
    int sum;
    Cycle_B_2_00230_A4() {
        a5_0 = null;
        a = 4;
        sum = 0;
    }
    void add() {
        sum = a + a5_0.a;
    }
}
class Cycle_B_2_00230_A5 {
    Cycle_B_2_00230_A6 a6_0;
    int a;
    int sum;
    Cycle_B_2_00230_A5() {
        a6_0 = null;
        a = 5;
        sum = 0;
    }
    void add() {
        sum = a + a6_0.a;
    }
}
class Cycle_B_2_00230_A6 {
    Cycle_B_2_00230_A1 a1_0;
    Cycle_B_2_00230_A10 a10_0;
    int a;
    int sum;
    Cycle_B_2_00230_A6() {
        a1_0 = null;
        a10_0 = null;
        a = 6;
        sum = 0;
    }
    void add() {
        sum = a + a1_0.a + a10_0.a;
    }
}
class Cycle_B_2_00230_A8 {
    Cycle_B_2_00230_A9 a9_0;
    int a;
    int sum;
    Cycle_B_2_00230_A8() {
        a9_0 = null;
        a = 7;
        sum = 0;
    }
    void add() {
        sum = a + a9_0.a;
    }
}
class Cycle_B_2_00230_A9 {
    Cycle_B_2_00230_A7 a7_0;
    int a;
    int sum;
    Cycle_B_2_00230_A9() {
        a7_0 = null;
        a = 8;
        sum = 0;
    }
    void add() {
        sum = a + a7_0.a;
    }
}
class Cycle_B_2_00230_A7 {
    Cycle_B_2_00230_A4 a4_0;
    int a;
    int sum;
    Cycle_B_2_00230_A7() {
        a4_0 = null;
        a = 9;
        sum = 0;
    }
    void add() {
        sum = a + a4_0.a;
    }
}
class Cycle_B_2_00230_A10 {
    Cycle_B_2_00230_A8 a8_0;
    int a;
    int sum;
    Cycle_B_2_00230_A10() {
        a8_0 = null;
        a = 10;
        sum = 0;
    }
    void add() {
        sum = a + a8_0.a;
    }
}
public class Cycle_B_2_00230 {
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
    }
    private static void rc_testcase_main_wrapper() {
        Cycle_B_2_00230_A1 a1_0 = new Cycle_B_2_00230_A1();
        a1_0.a2_0 = new Cycle_B_2_00230_A2();
        a1_0.a2_0.a3_0 = new Cycle_B_2_00230_A3();
        a1_0.a2_0.a3_0.a4_0 = new Cycle_B_2_00230_A4();
        a1_0.a2_0.a3_0.a4_0.a5_0 = new Cycle_B_2_00230_A5();
        a1_0.a2_0.a3_0.a4_0.a5_0.a6_0 = new Cycle_B_2_00230_A6();
        a1_0.a2_0.a3_0.a4_0.a5_0.a6_0.a1_0 = a1_0;
        Cycle_B_2_00230_A10 a10_0 = new Cycle_B_2_00230_A10();
        a1_0.a2_0.a3_0.a4_0.a5_0.a6_0.a10_0 = a10_0;
        a10_0.a8_0 = new Cycle_B_2_00230_A8();
        a10_0.a8_0.a9_0 = new Cycle_B_2_00230_A9();
        a10_0.a8_0.a9_0.a7_0 = new Cycle_B_2_00230_A7();
        a10_0.a8_0.a9_0.a7_0.a4_0 = a1_0.a2_0.a3_0.a4_0;
        a1_0.add();
        a1_0.a2_0.add();
        a1_0.a2_0.a3_0.add();
        a1_0.a2_0.a3_0.a4_0.add();
        a1_0.a2_0.a3_0.a4_0.a5_0.add();
        a1_0.a2_0.a3_0.a4_0.a5_0.a6_0.add();
        a10_0.a8_0.add();
        a10_0.a8_0.a9_0.add();
        a10_0.a8_0.a9_0.a7_0.add();
        int nsum = (a1_0.sum + a1_0.a2_0.sum + a1_0.a2_0.a3_0.sum + a1_0.a2_0.a3_0.a4_0.sum + a1_0.a2_0.a3_0.a4_0.a5_0.sum + a1_0.a2_0.a3_0.a4_0.a5_0.a6_0.sum + a10_0.a8_0.sum + a10_0.a8_0.a9_0.sum + a10_0.a8_0.a9_0.a7_0.sum);
        //System.out.println(nsum);
        if (nsum == 97)
            System.out.println("ExpectResult");
    }
}
