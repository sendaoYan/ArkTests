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
 * -@TestCaseID: UnsafegetShortByAddressTest
 * -@TestCaseName: Unsafe api:  getLong(long)
 * -@TestCaseType: Function Test
 * -@RequirementName: VMRuntime_registerNativeAllocation接口实现
 * -@Brief:
 * -#step1:prepare address from unsafe.allocateMemory,and put long number
 * -#step2:invoke unsafe.getLong(address)
 * -#step3:check return from step2 as step1
 * -@Expect:0\n
 * -@Priority: High
 * -@Source: UnsafegetLongByAddressTest.java
 * -@ExecuteClass: UnsafegetLongByAddressTest
 * -@ExecuteArgs:
 */

import sun.misc.Unsafe;

import java.io.PrintStream;
import java.lang.reflect.Field;

public class UnsafegetLongByAddressTest {
    private static int res = 99;
    public static void main(String[] args) {
        System.out.println(run(args, System.out));
    }

    private static int run(String[] args, PrintStream out) {
        int result = 2/*STATUS_FAILED*/;
        try {
            result = UnsafegetLongByAddressTest_1();
        } catch (Exception e) {
            e.printStackTrace();
            UnsafegetLongByAddressTest.res -= 2;
        }

        if (result == 3 && UnsafegetLongByAddressTest.res == 97) {
            result =0;
        }
        return result;
    }

    private static int UnsafegetLongByAddressTest_1() {
        Unsafe unsafe;
        Field field;
        long address;
        long result;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);
            address = unsafe.allocateMemory(2);
//            System.out.println(address);
            long l = 111L;
            unsafe.putLong(address, l);
            result = unsafe.getLong(address);
//            System.out.println(result);
            if (result == l) {
                UnsafegetLongByAddressTest.res -= 2;
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return 40;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 41;
        }
        return 3;
    }
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n