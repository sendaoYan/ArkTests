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


import java.util.HashMap;
class CB_09_A1 {
    static HashMap test1;
    static
    int a;
    CB_09_A2 a2_0;
    CB_09_A3 a3_0;
    int sum;
    String strObjectName;
    CB_09_A1(String strObjectName) {
        a2_0 = null;
        a3_0 = null;
        a = 101;
        sum = 0;
        this.strObjectName = strObjectName;
    }
    void add() {
        sum = a + a2_0.a + a3_0.a;
    }
    @Override
    public void finalize() throws Throwable {
        super.finalize();
        CB_09.check = this;
    }
}
class CB_09_A2 {
    volatile static HashMap test2;
    CB_09_A1 a1_0;
    CB_09_A3 a3_0;
    int a;
    int sum;
    String strObjectName;
    CB_09_A2(String strObjectName) {
        a1_0 = null;
        a3_0 = null;
        a = 102;
        sum = 0;
        this.strObjectName = strObjectName;
    }
    void add() {
        sum = a + CB_09_A1.a + a3_0.a;
    }
    @Override
    public void finalize() throws Throwable {
        super.finalize();
    }
}
class CB_09_A3 {
    CB_09_A1 a1_0;
    CB_09_A2 a2_0;
    int a;
    int sum;
    String strObjectName;
    CB_09_A3(String strObjectName) {
        a1_0 = null;
        a2_0 = null;
        a = 103;
        sum = 0;
        this.strObjectName = strObjectName;
    }
    void add() {
        sum = a + CB_09_A1.a + a2_0.a;
    }
}
public class CB_09 {
    public static CB_09_A1 a1_main = null;
    public volatile static CB_09_A1 check = null;
    public volatile static ClassLoader test1;
    public static ClassLoader test2;
    public CB_09() {
        a1_main = new CB_09_A1("a1_main");
        a1_main.a2_0 = new CB_09_A2("a2_0");
        a1_main.a2_0.a1_0 = a1_main;
        a1_main.a2_0.a3_0 = new CB_09_A3("a3_0");
        a1_main.a3_0 = a1_main.a2_0.a3_0;
        a1_main.a3_0.a1_0 = a1_main;
        a1_main.a3_0.a2_0 = a1_main.a2_0;
        a1_main.add();
        a1_main.a2_0.add();
        a1_main.a2_0.a3_0.add();
    }
    public static void test_CB_09(int times) {
        CB_09_A1.test1 = new HashMap();
        CB_09_A2.test2 = new HashMap();
        for (int i = 0; i < times; i++) {
            test1 = CB_09_A1.class.getClassLoader();
            CB_09_A1.test1.put(i, test1);
            test2 = CB_09_A1.class.getClassLoader();
            CB_09_A2.test2.put(i, test2);
        }
    }
    public static void rc_testcase_main_wrapper() {
        CB_09 cb01 = new CB_09();
        test_CB_09(100000);
        check = a1_main;
        try {
            int result = CB_09.check.sum + CB_09.check.a2_0.sum + CB_09.check.a2_0.a3_0.sum;
            if (result == 918)
                System.out.println("ExpectResult");
        } catch (NullPointerException n) {
            System.out.println("ErrorResult");
        }
    }
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
    }
}
