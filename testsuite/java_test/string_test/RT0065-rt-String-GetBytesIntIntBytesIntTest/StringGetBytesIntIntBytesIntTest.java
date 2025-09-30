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
public class StringGetBytesIntIntBytesIntTest {
    private static int processResult = 99;
    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }
    public static int run(String[] argv, PrintStream out) {
        int result = 2; /* STATUS_Success*/

        try {
            StringGetBytesIntIntBytesIntTest_1();
        } catch (Exception e) {
            processResult -= 10;
        }
        if (result == 2 && processResult == 99) {
            result = 0;
        }
        return result;
    }
    public static void StringGetBytesIntIntBytesIntTest_1() {
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
        // Test 0 < srcBegin < srcEnd, srcEnd < instance.length. 0 =< dstBegin < dst.length -1.
        byte[] dst = {0x41, 0x42, 0x43, 0x44, 0x45, 0x46};
        str.getBytes(2, 5, dst, 2);
        String str_new = new String(dst);
        System.out.println(str_new);
        // Test srcBegin = 0, srcEnd < instance.length. 0 =< dstBegin < dst.length -1.
        dst = new byte[]{0x41, 0x42, 0x43, 0x44, 0x45, 0x46};
        str.getBytes(0, 3, dst, 2);
        str_new = new String(dst);
        System.out.println(str_new);
        // Test srcBegin = instance.length, srcEnd = instance.length, 0 =< dstBegin < dst.length -1.
        dst = new byte[]{0x41, 0x42, 0x43, 0x44, 0x45, 0x46};
        str.getBytes(str.length(), str.length(), dst, 2);
        str_new = new String(dst);
        System.out.println(str_new);
        // Test srcBegin = 0, srcEnd = 0, 0 =< dstBegin < dst.length -1.
        dst = new byte[]{0x41, 0x42, 0x43, 0x44, 0x45, 0x46};
        str.getBytes(0, 0, dst, 2);
        str_new = new String(dst);
        System.out.println(str_new);
        // Test 0 < srcBegin < srcEnd, srcEnd < instance.length, dstBegin = 0.
        dst = new byte[]{0x41, 0x42, 0x43, 0x44, 0x45, 0x46};
        str.getBytes(2, 3, dst, 0);
        str_new = new String(dst);
        System.out.println(str_new);
        // Test 0 < srcBegin < srcEnd, srcEnd < instance.length, dstBegin = dst.length -1.
        dst = new byte[]{0x41, 0x42, 0x43, 0x44, 0x45, 0x46};
        str.getBytes(2, 3, dst, 5);
        str_new = new String(dst);
        System.out.println(str_new);
    }
}
