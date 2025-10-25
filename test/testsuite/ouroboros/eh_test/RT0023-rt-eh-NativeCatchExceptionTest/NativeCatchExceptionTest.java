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
 * -@TestCaseID: NativeCatchExceptionTest.java
 * -@TestCaseName: Asynchronous: Native(exception at callback from Java), captured by Java.
 * -@TestCaseType: Function Test
 * -@RequirementName: [运行时需求]支持Java异常处理
 * -@Brief:
 * -#step1: Declare a native method, Create the native method in C file.
 * -#step2: The C file Method will Call java method callback, the callback will throw NumberFormatException.
 * -#step3: Invoke this native method.
 * -#step4: Check NumberFormatException is thrown.
 * -@Expect: expected.txt
 * -@Priority: High
 * -@Source: NativeCatchExceptionTest.java jniNativeCatchExceptionTest.cpp
 * -@ExecuteClass: NativeCatchExceptionTest
 * -@ExecuteArgs:
 */

import java.io.PrintStream;

public class NativeCatchExceptionTest extends Exception {
    private static int processResult = 99;

    public static void main(String[] argv) {
        System.exit(run(argv, System.out));
    }

    private native void nativeNativeCatchExceptionTest() throws IllegalStateException;

    private void callback() throws NumberFormatException {
        throw new NumberFormatException("JavaMethodThrows");
    }

    /**
     * main test fun
     * @return status code
     */
    public static int run(String[] argv, PrintStream out) {
        int result = 2; /* STATUS_FAILED */

        try {
            result = nativeCatchExceptionTest();
        } catch (Exception e) {
            processResult -= 10;
        }
        if (result == 1 && processResult == 95) {
            result = 0;
        }
        return result;
    }

    /**
     * Asynchronous: Native(exception at callback from Java), captured by Java.
     * @return status code
     */
    public static int nativeCatchExceptionTest() {
        int result1 = 4; /* STATUS_FAILED */

        NativeCatchExceptionTest cTest = new NativeCatchExceptionTest();
        try {
            cTest.nativeNativeCatchExceptionTest();
            processResult -= 10;
        } catch (NumberFormatException e1) {
            result1 = 1;
            processResult--;
        } catch (IllegalStateException e2) {
            processResult -= 10;
        } catch (StringIndexOutOfBoundsException e3) {
            processResult -= 10;
        }

        processResult -= 3;
        return result1;
    }
}

// DEPENDENCE: jniNativeCatchExceptionTest.cpp
// EXEC:%maple  NativeCatchExceptionTest.java jniNativeCatchExceptionTest.cpp %build_option -o %n.so
// EXEC:%run %n.so NativeCatchExceptionTest %run_option | compare %f
// ASSERT: scan-full ------>CheckPoint:CcanContinue\n