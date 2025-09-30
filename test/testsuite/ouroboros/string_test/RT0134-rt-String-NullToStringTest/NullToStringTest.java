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
 * -@TestCaseID: NullToStringTest.java
 * -@TestCaseName: Test null to String.
 * -@TestCaseType: Function Test
 * -@RequirementName: Java字符串实现
 * -@Brief:
 * -#case1
 * -#step1: Create int instance, cover 0, normal, null value.
 * -#step2: Create String by "<" + int instance + ">", check the string create correctly.
 * -#case2
 * -#step1: Create String instance, cover "", normal, null value.
 * -#step2: Create String by "<" + String instance + ">", check the string create correctly.
 * -@Expect: expected.txt
 * -@Priority: High
 * -@Source: NullToStringTest.java
 * -@ExecuteClass: NullToStringTest
 * -@ExecuteArgs:
 */

import java.io.PrintStream;

public class NullToStringTest {
    private static int processResult = 99;

    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }

    public static int run(String[] argv, PrintStream out) {
        int result = 2; /* STATUS_Success */
        try {
            NullToStringTest_1();
        } catch (Exception e) {
            processResult -= 10;
        }
        if (result == 2 && processResult == 99) {
            result = 0;
        }
        return result;
    }

    public static void NullToStringTest_1() {
        int i1_1 = 0;
        test1(i1_1);
        int i1_2 = 123;
        test1(i1_2);
        Integer i1_3 = (Integer) null;
        test3(i1_3);

        String str1_1 = "";
        test2(str1_1);
        String str1_2 = "abc";
        test2(str1_2);
        String str1_3 = null;
        test2(str1_3);

        System.out.println((String) null);
        System.out.println("<" + (String) null + ">");
    }

    private static void test1(int i) {
        String str1 = "<" + i + ">";
        System.out.println("str1 : " + str1);
    }

    private static void test2(String str) {
        String str2 = "<" + str + ">";
        System.out.println("str2 : " + str2);
    }

    private static void test3(final Integer i) {
        String str1 = "<" + i + ">";
        System.out.println("str1 : " + str1);
    }
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full str1 : <0>\nstr1 : <123>\nstr1 : <null>\nstr2 : <>\nstr2 : <abc>\nstr2 : <null>\nnull\n<null>\n0\n