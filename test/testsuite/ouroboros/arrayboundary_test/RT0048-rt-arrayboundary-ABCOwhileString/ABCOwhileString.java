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
 * -@TestCaseID: Maple_ArrayBoundary_ABCOwhileString.java
 * -@TestCaseName: while visit Array element
 * -@TestCaseType: Function Test
 * -@RequirementName: Array Bounds Check优化
 * -@Brief:
 * -#step1: new Array[5]
 * -#step2: while visit Array element
 * -#step3: catch Exception
 * -@Expect: 0\n
 * -@Priority: High
 * -@Source: ABCOwhileString.java
 * -@ExecuteClass: ABCOwhileString
 * -@ExecuteArgs:
 */

import java.io.PrintStream;
import java.util.Arrays;

public class ABCOwhileString {
    static int RES_PROCESS = 99;

    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }

    public static int run(String argv[], PrintStream out) {
        int result = 4 /*STATUS_FAILED*/;
        try {
            result = test1();
        } catch (Exception e) {
            RES_PROCESS -= 10;
        }

        if (result == 1 && RES_PROCESS == 99) {
            result = 0;
        }
        return result;
    }

    public static int test1() {
        int res = 3 /*STATUS_FAILED*/;

        char[] a = new char[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = 'h';
        }
        String joinLine = Arrays.toString(a);

        char[] c = new char[joinLine.length()];
        int x = funx(1000);
        int y = funx(170000);
        try {
            while (x <= y) {
                c[x] = joinLine.charAt(y);
                ;
                x++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            res = 1;
        }

        return res;
    }

    public static int funx(int maxFlag) {
        int endIndex = maxFlag + 5;
        int index = 0;
        while (index < endIndex) {
            index = funy(index);
        }
        return index;
    }

    public static int funy(int forIdx) {
        int idx = forIdx + 100;
        return idx;
    }
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n