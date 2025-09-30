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
 * -@TestCaseID: StringClassNewInstanceTest.java
 * -@TestCaseName: Calling String's no-argument constructor by reflection String.class.newInstance().
 * -@TestCaseType: Function Test
 * -@RequirementName: Java字符串实现
 * -@Brief:
 * -#step1: Test String.class.newInstance().
 * -#step2: Check newInstance() is correctly, and no Exception is thrown.
 * -@Expect: 0\n
 * -@Priority: High
 * -@Source: StringClassNewInstanceTest.java
 * -@ExecuteClass: StringClassNewInstanceTest
 * -@ExecuteArgs:
 */

import java.io.PrintStream;

public class StringClassNewInstanceTest  {
    private static int processResult = 99;

    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }

    public static int run(String[] argv, PrintStream out) {
        int result = 2;  /* STATUS_Success */

        try {
            StringClassNewInstanceTest_1();
        } catch (Exception e) {
            processResult -= 10;
        }
        if (result == 2 && processResult == 98) {
            result = 0;
        }
        return result;
    }

    public static void StringClassNewInstanceTest_1() {
        Object test1 = null;
        try {
            test1 = String.class.newInstance();
            processResult--;
        } catch (InstantiationException e1) {
            System.err.println(e1);
        } catch (IllegalAccessException e2) {
            System.err.println(e2);
        }
    }
}


// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n