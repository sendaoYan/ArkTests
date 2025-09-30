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


import java.io.PrintStream;
public class StringConvertToByteTest {
    private static int processResult = 99;
    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }
    public static int run(String[] argv, PrintStream out) {
        int result = 2; /* STATUS_Success*/

        try {
            StringConvertToByteTest_1();
        } catch (Exception e) {
            processResult -= 10;
        }
        if (result == 2 && processResult == 99) {
            result = 0;
        }
        return result;
    }
    // Test public static byte parseByte(String s).
    public static void StringConvertToByteTest_1() {
        // Create 2 byte primitives bt1, bt2.
        byte b_1, b_2;
        // Create and assign values to String's s1, s2.
        String s1 = "123";
        String s2 = "-1a";
        // Create and assign values to int r1, r2.
        int r1 = 8;  // Represents octal.
        int r2 = 16; // Represents hexadecimal.
        b_1 = Byte.parseByte(s1, r1);
        b_2 = Byte.parseByte(s2, r2);
        String str1_1 = s1 + " convert(8) to Byte:" + b_1;
        String str1_2 = s2 + " convert(16) to Byte:" + b_2;
        System.out.println(str1_1);
        System.out.println(str1_2);
    }
}
