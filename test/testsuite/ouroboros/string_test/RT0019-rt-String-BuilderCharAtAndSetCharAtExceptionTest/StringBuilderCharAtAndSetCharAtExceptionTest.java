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
 * -@TestCaseID: StringBuilderCharAtAndSetCharAtExceptionTest.java
 * -@TestCaseName: Test Method charAt(int index)/setCharAt(int index, char ch) of StringBuilder and
 * -@TestCaseType: Function Test
 * -@RequirementName: Java字符串实现
 *                      StringIndexOutOfBoundsException occured in charAt/setCharAt.
 * -@Brief:
 * -#case1
 * -#step1: Create StringBuilder instance.
 * -#step2: Create parameters: index range from -1  to exceed instance.length.
 * -#step3: Test method char charAt(int index) and StringIndexOutOfBoundsException is thrown.
 * -#step4: Check the result char is correctly when index is range from 0 to (instance.length -1),
 *          StringIndexOutOfBoundsException is thrown when index < 0 or index > (instance.length -1).
 * -#step5: Change instance as One or more kinds of letters, numbers, special symbols/"" to repeat step2~4.
 * -#case2
 * -#step1: Create StringBuilder instance.
 * -#step2: Create parameters: index range from -1  to exceed instance.length. ch is a Letter char.
 * -#step3: Test Method void setCharAt(int index, char ch) and StringIndexOutOfBoundsException is thrown.
 * -#step4: Check the instance after setCharAt is replaced correctly when index is range from 0 to (instance.length -1),
 *          or StringIndexOutOfBoundsException is thrown when index < 0 or index > (instance.length -1).
 * -#step5: Change instance as One or more kinds of letters, numbers, special symbols/"" to repeat step2~4.
 * -@Expect: expected.txt
 * -@Priority: High
 * -@Source: StringBuilderCharAtAndSetCharAtExceptionTest.java
 * -@ExecuteClass: StringBuilderCharAtAndSetCharAtExceptionTest
 * -@ExecuteArgs:
 */

import java.io.PrintStream;

public class StringBuilderCharAtAndSetCharAtExceptionTest {
    private static int processResult = 99;

    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }

    public static int run(String[] argv, PrintStream out) {
        int result = 2; /* STATUS_Success */

        try {
            StringBuilderCharAtAndSetCharAtExceptionTest_1();
            StringBuilderCharAtAndSetCharAtExceptionTest_2();
        } catch (Exception e) {
            processResult -= 10;
        }

        if (result == 2 && processResult == 99) {
            result = 0;
        }
        return result;
    }

    public static void StringBuilderCharAtAndSetCharAtExceptionTest_1() {
        StringBuilder strBuilder1_1 = new StringBuilder("qwertyuiop{}[]\\|asdfghjkl;:'\"zxcvbnm,.<>/?~`1234567890" +
                "-=!@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96");
        StringBuilder strBuilder1_2 = new StringBuilder(" @!.&%()*");
        StringBuilder strBuilder1_3 = new StringBuilder("abc123");
        StringBuilder strBuilder1_4 = new StringBuilder("");

        test1(strBuilder1_1);
        test1(strBuilder1_2);
        test1(strBuilder1_3);
        test1(strBuilder1_4);
    }

    public static void StringBuilderCharAtAndSetCharAtExceptionTest_2() {
        StringBuilder strBuilder1_1 = new StringBuilder("qwertyuiop{}[]\\|asdfghjkl;:'\"zxcvbnm,.<>/?~`1234567890" +
                "-=!@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96");
        StringBuilder strBuilder1_2 = new StringBuilder(" @!.&%()*");
        StringBuilder strBuilder1_3 = new StringBuilder("abc123");
        StringBuilder strBuilder1_4 = new StringBuilder("");

        test2(strBuilder1_1);
        test2(strBuilder1_2);
        test2(strBuilder1_3);
        test2(strBuilder1_4);
    }

    // Test method char charAt(int index).
    private static void test1(StringBuilder strBuilder) {
        int charAt = 0;
        for (int i = -1; i < 8; i++) {
            try {
                charAt = strBuilder.charAt(i);
                System.out.println("i=" + i + "  " + "charAt=" + charAt);
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("index: " + i + "  String index out of range");
            }
        }
    }

    // Test Method void setCharAt(int index, char ch).
    private static void test2(StringBuilder strBuilder) {
        char ch = 'A';
        for (int i = -1; i < 8; i++) {
            try {
                strBuilder.setCharAt(i, ch);
                System.out.println("i=" + i + "  " + "setcharAt=" + strBuilder);
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("index: " + i + "  String index out of range");
            }
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full index: -1  String index out of range\ni=0  charAt=113\ni=1  charAt=119\ni=2  charAt=101\ni=3  charAt=114\ni=4  charAt=116\ni=5  charAt=121\ni=6  charAt=117\ni=7  charAt=105\nindex: -1  String index out of range\ni=0  charAt=32\ni=1  charAt=64\ni=2  charAt=33\ni=3  charAt=46\ni=4  charAt=38\ni=5  charAt=37\ni=6  charAt=40\ni=7  charAt=41\nindex: -1  String index out of range\ni=0  charAt=97\ni=1  charAt=98\ni=2  charAt=99\ni=3  charAt=49\ni=4  charAt=50\ni=5  charAt=51\nindex: 6  String index out of range\nindex: 7  String index out of range\nindex: -1  String index out of range\nindex: 0  String index out of range\nindex: 1  String index out of range\nindex: 2  String index out of range\nindex: 3  String index out of range\nindex: 4  String index out of range\nindex: 5  String index out of range\nindex: 6  String index out of range\nindex: 7  String index out of range\nindex: -1  String index out of range\ni=0  setcharAt=Awertyuiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96\ni=1  setcharAt=AAertyuiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96\ni=2  setcharAt=AAArtyuiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96\ni=3  setcharAt=AAAAtyuiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96\ni=4  setcharAt=AAAAAyuiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96\ni=5  setcharAt=AAAAAAuiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96\ni=6  setcharAt=AAAAAAAiop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96\ni=7  setcharAt=AAAAAAAAop{}[]\|asdfghjkl;:'"zxcvbnm,.<>/?~`1234567890-=!@#$%^&*()_+ ASDFGHJKLQWERTYUIOPZXCVBNM0x96\nindex: -1  String index out of range\ni=0  setcharAt=A@!.&%()*\ni=1  setcharAt=AA!.&%()*\ni=2  setcharAt=AAA.&%()*\ni=3  setcharAt=AAAA&%()*\ni=4  setcharAt=AAAAA%()*\ni=5  setcharAt=AAAAAA()*\ni=6  setcharAt=AAAAAAA)*\ni=7  setcharAt=AAAAAAAA*\nindex: -1  String index out of range\ni=0  setcharAt=Abc123\ni=1  setcharAt=AAc123\ni=2  setcharAt=AAA123\ni=3  setcharAt=AAAA23\ni=4  setcharAt=AAAAA3\ni=5  setcharAt=AAAAAA\nindex: 6  String index out of range\nindex: 7  String index out of range\nindex: -1  String index out of range\nindex: 0  String index out of range\nindex: 1  String index out of range\nindex: 2  String index out of range\nindex: 3  String index out of range\nindex: 4  String index out of range\nindex: 5  String index out of range\nindex: 6  String index out of range\nindex: 7  String index out of range\n0\n
