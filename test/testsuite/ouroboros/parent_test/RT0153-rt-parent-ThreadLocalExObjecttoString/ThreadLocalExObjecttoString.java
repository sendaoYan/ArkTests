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
 * -@TestCaseID: ThreadLocalExObjecttoString.java
 * -@TestCaseName: Exception in ThreadLocal:  String toString()
 * -@TestCaseType: Function Test
 * -@RequirementName: 补充重写类的父类方法
 * -@Brief:Test ThreadLocal api toString extends from Object
 * -@Expect:0\n
 * -@Priority: High
 * -@Source: ThreadLocalExObjecttoString.java
 * -@ExecuteClass: ThreadLocalExObjecttoString
 * -@ExecuteArgs:
 */

import java.lang.ThreadLocal;

public class ThreadLocalExObjecttoString {
    static int res = 99;

    public static void main(String argv[]) {
        System.out.println(new ThreadLocalExObjecttoString().run());
    }

    /**
     * main test fun
     * @return status code
     */
    public int run() {
        int result = 2; /*STATUS_FAILED*/
        try {
            result = threadLocalExObjecttoString1();
        } catch (Exception e) {
            ThreadLocalExObjecttoString.res = ThreadLocalExObjecttoString.res - 20;
        }

        if (result == 4 && ThreadLocalExObjecttoString.res == 89) {
            result = 0;
        }

        return result;
    }


    private int threadLocalExObjecttoString1() {
        int result1 = 4; /*STATUS_FAILED*/
        // String toString()

        ThreadLocal<Object> threadLocal1 = new ThreadLocal<Object>();
        String str1 = threadLocal1.toString();
        if (str1.contains("java.lang.ThreadLocal")) {
            ThreadLocalExObjecttoString.res = ThreadLocalExObjecttoString.res - 10;
        }
        return result1;
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n