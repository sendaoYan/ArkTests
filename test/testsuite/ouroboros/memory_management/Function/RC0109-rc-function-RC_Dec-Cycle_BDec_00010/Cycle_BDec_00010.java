/*
 * Copyright (c) [2020] Huawei Technologies Co.,Ltd.All rights reserved.
 *
 * OpenArkCompiler is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *
 *     http://license.coscl.org.cn/MulanPSL2
 *
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR
 * FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * -@TestCaseID:maple/runtime/rc/function/RC_Dec/Cycle_BDec_00010.java
 *- @TestCaseName:MyselfClassName
 *- @RequirementName:[运行时需求]支持自动内存管理
 *- @Title/Destination: Cycle_BDec_00010 in RC测试-Cycle-00.vsd
 *- @Brief:functionTest
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: Cycle_BDec_00010.java
 *- @ExecuteClass: Cycle_BDec_00010
 *- @ExecuteArgs:
 */
class Cycle_BDec_00010_A1 {
    Cycle_BDec_00010_A2 a2_0;
    int a;
    int sum;

    Cycle_BDec_00010_A1() {
        a2_0 = null;
        a = 1;
        sum = 0;
    }

    void add() {
        sum = a + a2_0.a;
    }
}


class Cycle_BDec_00010_A2 {
    Cycle_BDec_00010_A1 a1_0;
    int a;
    int sum;

    Cycle_BDec_00010_A2() {
        a1_0 = null;
        a = 2;
        sum = 0;
    }

    void add() {
        sum = a + a1_0.a;
    }
}


public class Cycle_BDec_00010 {

    public static void main(String[] args) {
        rc_testcase_main_wrapper();
        Runtime.getRuntime().gc();
        rc_testcase_main_wrapper();

    }

    private static boolean ModifyA1(Cycle_BDec_00010_A1 a1_0) {
        a1_0.add();
        a1_0.a2_0.add();
        int nsum = (a1_0.sum + a1_0.a2_0.sum);
        //System.out.println(nsum);
        if (nsum == 6)
            return true;
        else
            return false;

    }

    public static void rc_testcase_main_wrapper() {
        Cycle_BDec_00010_A1 a1_0 = new Cycle_BDec_00010_A1();
        a1_0.a2_0 = new Cycle_BDec_00010_A2();
        a1_0.a2_0.a1_0 = a1_0;
        boolean ret = ModifyA1(a1_0);
        a1_0 = null;
        if (ret == true && a1_0 == null)
            System.out.println("ExpectResult");
    }
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n