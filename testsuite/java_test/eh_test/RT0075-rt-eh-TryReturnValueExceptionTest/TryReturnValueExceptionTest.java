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
public class TryReturnValueExceptionTest {
    private static int processResult = 99;
    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }
    /**
     * main test fun
     * @return status code
    */

    public static int run(String[] argv, PrintStream out) {
        int result = 2; /* STATUS_FAILED*/

        try {
            result = tryReturnValueExceptionTest1();
        } catch (NumberFormatException e) {
            processResult -= 10;
        }
        if (result == 5 && processResult == 95) {
            result = 0;
        }
        return result;
    }
    /**
     * try{return_v}-catch（x){return_x}-finally{return_x}
     * @return status code
    */

    public static int tryReturnValueExceptionTest1() {
        int result1 = 4; /* STATUS_FAILED*/

        String str = "123456";
        try {
            Integer.parseInt(str);
            return result1; // Execute return result1++.
        } catch (ClassCastException e) {
            System.out.println("=====See:ERROR!!!");
            result1 = 3;
            return 3;
        } catch (NumberFormatException e) {
            System.out.println("=====See:ERROR!!!");
            result1 = 3;
            return 3;
        } catch (IllegalStateException e) {
            System.out.println("=====See:ERROR!!!");
            result1 = 3;
            return 3;
        } finally {
            processResult -= 4;
            result1++;
            return result1;
        }
    }
}
