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
 * -@TestCaseID: Maple_MemoryManagement2.0_CP_Thread_05
 *- @TestCaseName: CP_Thread_05
 *- @TestCaseType: Function Testing for placementRCTest
 *- @RequirementName: 运行时支持GCOnly
 *- @Brief:一组有环的对象，他们的field指向一个hashMap，里面装满了对象
 *  -#step1: 创建一个环，环的类型参考了Cycle_a_0038.java;
 *  -#step2: 两个域test1和test2,里面装满了对象，对象格式参考SoftReference，这样就构造了一个大对象。
 *  -#step3: 验证结果正确，再用GCverify验证无内存泄漏。
 *- @Expect:ExpectResult\nExpectResult\n
 *- @Priority: High
 *- @Source: CP_Thread_05.java
 *- @ExecuteClass: CP_Thread_05
 *- @ExecuteArgs:
 */

import java.lang.ref.SoftReference;

class CP_Thread_05_A1 {
    static SoftReference[] test1;
    static
    int a;
    CP_Thread_05_A1 a2_0;
    int sum;
    String strObjectName;

    CP_Thread_05_A1(String strObjectName) {
        a2_0 = null;
        a = 101;
        sum = 0;
        this.strObjectName = strObjectName;
    }

    void add() {
        sum = a + a;
    }
}

class CP_Thread_05_test extends Thread {
    static String str;
    private static CP_Thread_05_A1 a1_main = null;
    private volatile static CP_Thread_05_A1 a2 = null;
    private volatile static SoftReference test1;
    private static SoftReference test2;

    private static void test_CP_Thread_05_A1(int times) {
        CP_Thread_05_A1.test1 = new SoftReference[times];
        for (int i = 0; i < times; i++) {
            str = "maple" + i;
            test1 = new SoftReference<>(str);
            CP_Thread_05_A1.test1[i] = test1;
        }
    }

    private static void test_CP_Thread_05_A2(int times) {
        CP_Thread_05_A1.test1 = new SoftReference[times];
        for (int i = 0; i < times; i++) {
            test2 = new SoftReference<>("maple" + times + i);
            CP_Thread_05_A1.test1[i] = test2;
        }
    }

    public void run() {
        a1_main = new CP_Thread_05_A1("a1_main");
        a2 = new CP_Thread_05_A1("a2_0");
        a1_main.a2_0 = a2;
        a1_main.a2_0.a2_0 = a2;

        a1_main.add();
        a1_main.a2_0.add();
        test_CP_Thread_05_A1(10000);
        test_CP_Thread_05_A2(10000);
        int result = a1_main.sum + a1_main.a2_0.sum;
        //System.out.println("RC-Testing_Result="+result);
        if (result == 404)
            System.out.println("ExpectResult");
    }
}

public class CP_Thread_05 {
    private static CP_Thread_05_A1 a1_main = null;
    private static CP_Thread_05_A1 a2 = null;

    public static void main(String[] args) {
        CP_Thread_05_test cptest1 = new CP_Thread_05_test();
        cptest1.run();
        CP_Thread_05_test cptest2 = new CP_Thread_05_test();
        cptest2.run();
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\nExpectResult\n