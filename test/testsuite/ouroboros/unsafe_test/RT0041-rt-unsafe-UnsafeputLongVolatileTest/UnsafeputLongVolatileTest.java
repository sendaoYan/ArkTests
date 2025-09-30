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
 * -@TestCaseID: UnsafeputLongVolatileTest
 * -@TestCaseName: Unsafe api: putLongvolatile()
 * -@TestCaseType: Function Test
 * -@RequirementName: VMRuntime_registerNativeAllocation接口实现
 * -@Brief:
 * -#step1:prepare one Class and get Field of Long
 * -#step2:invoke Unsafe.getVolatileLong to visit this Field
 * -#step3:set value of step2 by Unsafe.putVolatileLong
 * -#step4:check value of step3 correct
 * -@Expect:0\n
 * -@Priority: High
 * -@Source: UnsafeputLongVolatileTest.java
 * -@ExecuteClass: UnsafeputLongVolatileTest
 * -@ExecuteArgs:
 */
import sun.misc.Unsafe;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UnsafeputLongVolatileTest {
    private static int res = 99;
    public static void main(String[] args) {
        System.out.println(run(args, System.out));
    }

    private static int run(String[] args, PrintStream out) {
        int result = 2/*STATUS_FAILED*/;
        try {
            result = UnsafeputLongVolatileTest_1();
        } catch (Exception e) {
            e.printStackTrace();
            UnsafeputLongVolatileTest.res -= 2;
        }

        if (result == 3 && UnsafeputLongVolatileTest.res == 97) {
            result =0;
        }
        return result;
    }

    private static int UnsafeputLongVolatileTest_1() {
        Unsafe unsafe;
        Field field;
        Long offset;
        Field param;
        Object obj;
        Long result;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);
            param = Billie9.class.getDeclaredField("birth");
            offset = unsafe.objectFieldOffset(param);
            obj = new Billie9();
            result = unsafe.getLongVolatile(obj, offset);
            unsafe.putLongVolatile(obj, offset, 20020214L);
            result = unsafe.getLongVolatile(obj, offset);
            if (result == 20020214L) {
                UnsafeputLongVolatileTest.res -= 2;
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

class Billie9 {
    public int height = 8;
    private String[] color = {"black","white"};
    private String owner = "Me";
    private byte length = 0x7;
    private String[] water = {"day","wet"};
    private long weight = 100L;
    private volatile int age = 18;
    private volatile long birth = 20010214L;
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n