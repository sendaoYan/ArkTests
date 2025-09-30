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
 * -@TestCaseID: StringCompareToIgnoreCaseTest.java
 * -@TestCaseName: Test String Method: int compareToIgnoreCase(String str).
 * -@TestCaseType: Function Test
 * -@RequirementName: Java字符串实现
 * -@Brief:
 * -#step1: Create String instance, parameter anotherString instance.
 * -#step2: Test method test.compareTo(anotherString).
 * -#step3: Check the int result is correctly.
 * -#step4: Change anotherString as One or more kinds of letters, numbers, special symbols/""/NoParam to repeat step2~3.
 * -@Expect: expected.txt
 * -@Priority: High
 * -@Source: StringCompareToIgnoreCaseTest.java
 * -@ExecuteClass: StringCompareToIgnoreCaseTest
 * -@ExecuteArgs:
 */

import java.io.PrintStream;

public class StringCompareToIgnoreCaseTest {
    private static int processResult = 99;

    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }

    public static int run(String[] argv, PrintStream out) {
        int result = 2; /* STATUS_Success */

        try {
            StringCompareToIgnoreCaseTest_1();
        } catch (Exception e) {
            processResult -= 10;
        }

        if (result == 2 && processResult == 99) {
            result = 0;
        }
        return result;
    }

    public static void StringCompareToIgnoreCaseTest_1() {
        String str1_1 = new String("ABC123");
        String str1_2 = new String("******");
        String str1_3 = new String("abc123");
        String str1_4 = new String("");
        String str1_5 = new String();

        String str2_1 = "ABC123";
        String str2_2 = "******";
        String str2_3 = "abc123";
        String str2_4 = "";

        test(str1_1);
        test(str1_2);
        test(str1_3);
        test(str1_4);
        test(str1_5);

        test(str2_1);
        test(str2_2);
        test(str2_3);
        test(str2_4);
    }

    private static void test(String str) {
        String test = "ABC123";
        int result = test.compareToIgnoreCase(str);
        System.out.println(result);
    }
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n55\n0\n6\n6\n0\n55\n0\n6\n0\n