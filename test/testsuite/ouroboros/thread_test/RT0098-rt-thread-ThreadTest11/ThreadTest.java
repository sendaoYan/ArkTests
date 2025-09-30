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
 * -@TestCaseID: ThreadTest
 *- @TestCaseName: Thread_ThreadTest.java
 *- @RequirementName: Java Thread
 *- @Title/Destination: test for isDaemon() and setDaemon()
 *- @Brief: see below
 * -#step1: 创建一个Thread类的实例对象thread；
 * -#step2: 打印thread的isDaemon()属性；
 * -#step3: 调用thread的setDaemon()方法，参数为true；
 * -#step4: 打印thread的isDaemon()属性；
 *- @Expect: expected.txt
 *- @Priority: High
 *- @Source: ThreadTest.java
 *- @ExecuteClass: ThreadTest
 *- @ExecuteArgs:
 */

public class ThreadTest {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread();
        System.out.println(
                "The newly created thread must not be daemon, and isDaemon()'s result is -- " +
                        thread.isDaemon());
        thread.setDaemon(true);
        System.out.println("The thread must be daemon, and isDaemon()'s result is -- " + thread.isDaemon());
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full The newly created thread must not be daemon, and isDaemon()'s result is -- false\nThe thread must be daemon, and isDaemon()'s result is -- true\n