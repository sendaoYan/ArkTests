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
 * -@TestCaseID: AccessibleObjectGetAnnotationsByTypeNullPointerExceptionTest.java
 * -@TestCaseName: Exception in addSuppressed:public T[] getAnnotationsByType(Class<T> annotationClass).
 * -@TestCaseType: Function Test
 * -@RequirementName: [运行时需求]支持Java异常处理
 * -@Brief:
 * -#step1: Get AccessibleObject object by getMethod(String name,Class<?>... parameterTypes).
 * -#step2: Test method getAnnotationsByType(), parameter annotationClass is null.
 * -#step3: Check that if NullPointerException occurs.
 * -@Expect: 0\n
 * -@Priority: High
 * -@Source: AccessibleObjectGetAnnotationsByTypeNullPointerExceptionTest.java
 * -@ExecuteClass: AccessibleObjectGetAnnotationsByTypeNullPointerExceptionTest
 * -@ExecuteArgs:
 */

import java.io.PrintStream;
import java.lang.reflect.AccessibleObject;

public class AccessibleObjectGetAnnotationsByTypeNullPointerExceptionTest {
    private static int processResult = 99;

    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }

    /**
     * main test fun
     *
     * @return status code
     */
    public static int run(String[] argv, PrintStream out) {
        int result = 2; /*STATUS_FAILED*/

        try {
            result = accessibleObjectgAnnotationsByTypeNullPointerException();
        } catch (Exception e) {
            processResult -= 10;
        }

        if (result == 4 && processResult == 98) {
            result = 0;
        }

        return result;
    }

    /**
     * Exception in addSuppressed:public T[] getAnnotationsByType(Class<T> annotationClass).
     *
     * @return status code
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    public static int accessibleObjectgAnnotationsByTypeNullPointerException()
            throws NoSuchMethodException, SecurityException {
        int result1 = 4; /*STATUS_FAILED*/
        AccessibleObject accessibleObject = Test013.class.getMethod("getName", new Class[]{});
        try {
            Object file1 = accessibleObject.getAnnotationsByType(null);
            processResult -= 10;
        } catch (NullPointerException e1) {
            processResult--;
        }
        return result1;
    }
}

class Test013 {
    private String name = "default";

    public String getName() {
        return name;
    }
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n