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
 * -@TestCaseID: StringSubstringIntTest.java
 * -@TestCaseName: Test String Method: String substring(int beginIndex).
 * -@TestCaseType: Function Test
 * -@RequirementName: Java字符串实现
 * -@Brief:
 * -#step1: Create String instance.
 * -#step2: Create parameters: 0 =< beginIndex =< instance.length.
 * -#step3: Test method substring(int beginIndex).
 * -#step4: Check the String result is correctly.
 * -#step5: Replace instance or string which consists of one or more of the following: letters, numbers and special
 *          symbols, then to repeat step2~4.
 * -@Expect: expected.txt
 * -@Priority: High
 * -@Source: StringSubstringIntTest.java
 * -@ExecuteClass: StringSubstringIntTest
 * -@ExecuteArgs:
 */

import java.io.PrintStream;

public class StringSubstringIntTest {
    private static int processResult = 99;

    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }

    public static int run(String[] argv, PrintStream out) {
        int result = 2; /* STATUS_Success */

        try {
            StringSubstringIntTest_1();
        } catch (Exception e) {
            processResult -= 10;
        }

        if (result == 2 && processResult == 99) {
            result = 0;
        }
        return result;
    }

    public static void StringSubstringIntTest_1() {
        String str1_1 = new String("qwertyuiop{}[]\\|asdfghjkl;:'\"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+A" +
                "SDFGHJKLQWERTYUIOPZXCVBNM0x96");
        String str1_2 = new String(" @!.&%");
        String str1_3 = new String("abc123abc");

        String str2_1 = "qwertyuiop{}[]\\|asdfghjkl;:'\"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ASDFGHJKLQWERTY" +
                "UIOPZXCVBNM0x96";
        String str2_2 = " @!.&%";
        String str2_3 = "abc123ABC";

        test(str1_1);
        test(str1_2);
        test(str1_3);

        test(str2_1);
        test(str2_2);
        test(str2_3);
    }

    private static void test(String str) {
        // Test beginIndex = 0.
        System.out.println(str.substring(0));
        // Test 0 < beginIndex < str.length().
        System.out.println(str.substring(4));
        // Test beginIndex = str.length().
        System.out.println(str.substring(str.length()));
    }
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full qwertyuiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ASDFGHJKLQWERTYUIOPZXCVBNM0x96\ntyuiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ASDFGHJKLQWERTYUIOPZXCVBNM0x96\n\n @!.&%\n&%\n\nabc123abc\n23abc\n\nqwertyuiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ASDFGHJKLQWERTYUIOPZXCVBNM0x96\ntyuiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ASDFGHJKLQWERTYUIOPZXCVBNM0x96\n\n @!.&%\n&%\n\nabc123ABC\n23ABC\n\n0\n
