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
 * -@TestCaseID: StringCodePointCountTest.java
 * -@TestCaseName: Test String Method: int codePointCount(int beginIndex, int endIndex).
 * -@TestCaseType: Function Test
 * -@RequirementName: Java字符串实现
 * -@Brief:
 * -#step1: Create String instance.
 * -#step2: Create parameters: beginIndex range from 0 to instance.length - 3, endIndex = beginIndex + 3.
 * -#step3: Test method codePointCount(int beginIndex, int endIndex), check the return result is correctly.
 * -#step4: Change instance as One or more kinds of letters, numbers, special symbols to repeat step2~3.
 * -@Expect: expected.txt
 * -@Priority: High
 * -@Source: StringCodePointCountTest.java
 * -@ExecuteClass: StringCodePointCountTest
 * -@ExecuteArgs:
 */

import java.io.PrintStream;

public class StringCodePointCountTest {
    private static int processResult = 99;

    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }

    public static int run(String[] argv, PrintStream out) {
        int result = 2; /* STATUS_Success */

        try {
            StringCodePointCountTest_1();
        } catch (Exception e) {
            processResult -= 10;
        }

        if (result == 2 && processResult == 99) {
            result = 0;
        }
        return result;
    }

    public static void StringCodePointCountTest_1() {
        String str1_1 = new String("qwertyuiop{}[]\\|asdfghjkl;:'\"zxcvbnm,.<>/?~`1234567890-=!" +
                "@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96");
        String str1_2 = new String(" @!.&%");
        String str1_3 = new String("abc123");

        String str2_1 = "qwertyuiop{}[]\\|asdfghjkl;:'\"zxcvbnm,.<>/?~`1234567890-=!" +
                "@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96";
        String str2_2 = " @!.&%";
        String str2_3 = "abc123";

        test(str1_1);
        test(str1_2);
        test(str1_3);
        test(str2_1);
        test(str2_2);
        test(str2_3);
    }

    private static void test(String str) {
        int codePoint = 0;
        for (int i = 0; i < 4; i++) {
            try {
                codePoint = str.codePointCount(i, i + 3);
                System.out.println("i=" + i + " " + "codePointCount=" + codePoint);
            } catch (IndexOutOfBoundsException e1) {
                System.out.println("codePointCount(): " + i + " out of length");
            } finally {
                try {
                    System.out.println(str.charAt(i) + " codePointCount is " + ":" + codePoint);
                } catch (StringIndexOutOfBoundsException e2) {
                    System.out.println("charAt(): " + i + " out of length");
                }
            }
        }
    }
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full i=0 codePointCount=3\nq codePointCount is :3\ni=1 codePointCount=3\nw codePointCount is :3\ni=2 codePointCount=3\ne codePointCount is :3\ni=3 codePointCount=3\nr codePointCount is :3\ni=0 codePointCount=3\n  codePointCount is :3\ni=1 codePointCount=3\n@ codePointCount is :3\ni=2 codePointCount=3\n! codePointCount is :3\ni=3 codePointCount=3\n. codePointCount is :3\ni=0 codePointCount=3\na codePointCount is :3\ni=1 codePointCount=3\nb codePointCount is :3\ni=2 codePointCount=3\nc codePointCount is :3\ni=3 codePointCount=3\n1 codePointCount is :3\ni=0 codePointCount=3\nq codePointCount is :3\ni=1 codePointCount=3\nw codePointCount is :3\ni=2 codePointCount=3\ne codePointCount is :3\ni=3 codePointCount=3\nr codePointCount is :3\ni=0 codePointCount=3\n  codePointCount is :3\ni=1 codePointCount=3\n@ codePointCount is :3\ni=2 codePointCount=3\n! codePointCount is :3\ni=3 codePointCount=3\n. codePointCount is :3\ni=0 codePointCount=3\na codePointCount is :3\ni=1 codePointCount=3\nb codePointCount is :3\ni=2 codePointCount=3\nc codePointCount is :3\ni=3 codePointCount=3\n1 codePointCount is :3\n0\n