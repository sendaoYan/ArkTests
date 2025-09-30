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
 * -@TestCaseID: StringConvertToDoubleTest.java
 * -@TestCaseName: Change String type to double, test method of Double: public static double parseDouble(String s).
 * -@TestCaseType: Function Test
 * -@RequirementName: Java字符串实现
 * -@Brief:
 * -#step1: Create Parameter s, assign values to String's s.
 * -#step2: Test method parseDouble(String s).
 * -#step3: Check the result get correctly.
 * -@Expect: expected.txt
 * -@Priority: High
 * -@Source: StringConvertToDoubleTest.java
 * -@ExecuteClass: StringConvertToDoubleTest
 * -@ExecuteArgs:
 */

import java.io.PrintStream;

public class StringConvertToDoubleTest {
    private static int processResult = 99;

    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }

    public static int run(String[] argv, PrintStream out) {
        int result = 2; /* STATUS_Success */
        try {
            StringConvertToDoubleTest_1();
        } catch (Exception e) {
            processResult -= 10;
        }
        if (result == 2 && processResult == 99) {
            result = 0;
        }
        return result;
    }

    // Test public static double parseDouble(String s).
    public static void StringConvertToDoubleTest_1() {
        double d_1 = Double.parseDouble("1.124");
        System.out.println(d_1);
    }
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 1.124\n0\n