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
 * -@TestCaseID: FieldgetAnnotationsByTypeNullPointerException.java
 * -@TestCaseName: Exception in reflect Field:public T[] getAnnotationsByType(Class<T> annotationClass)
 * -@TestCaseType: Function Test
 * -@RequirementName: [运行时需求]支持Java异常处理
 * -@Brief:
 * -#step1:invoke getAnnotationsByType(Class<T> annotationClass) with null(annotationClass)
 * -#step2:catch EH
 * -@Expect:0\n
 * -@Priority: High
 * -@Source: FieldgetAnnotationsByTypeNullPointerException.java
 * -@ExecuteClass: FieldgetAnnotationsByTypeNullPointerException
 * -@ExecuteArgs:
 */

import java.io.PrintStream;
import java.lang.reflect.Field;

public class FieldgetAnnotationsByTypeNullPointerException {
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
            result = fieldGetAnnotationsByTypeNullPointerException();
        } catch (Exception e) {
            processResult -= 10;
        }

        if (result == 4 && processResult == 98) {
            result = 0;
        }

        return result;
    }

    /**
     * Exception in reflect Field:public T[] getAnnotationsByType(Class<T> annotationClass)
     *
     * @return status code
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws SecurityException
     */
    public static int fieldGetAnnotationsByTypeNullPointerException()
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        int result1 = 4; /*STATUS_FAILED*/

        // NullPointerException -         if the specified object is null and the field is an instance field.
        // public T[] getAnnotationsByType(Class<T> annotationClass)

        Field field = Test01a.class.getDeclaredField("field1");
        try {
            Object value = field.getAnnotationsByType(null);
            processResult -= 10;
        } catch (NullPointerException e1) {
            processResult -= 1;
        }

        return result1;
    }

    class Test01a {
        /**
         * a field for test
         */
        public int field1 = 1;
    }
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n