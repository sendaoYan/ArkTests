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
 * -@TestCaseID: ThreadStatewait9
 *- @TestCaseName: Thread_ThreadStatewait9.java
 *- @RequirementName: Java Thread
 *- @Title/Destination: Invalid input for Object.wait(long timeout).
 *- @Brief: see below
 * -#step1: 调用Thread()来构造对象实例。
 * -#step2：调用start()启动线程。
 * -#step3: 构造参数timeout为负数，调用wait(long timeout)，确认会抛出IllegalArgumentException异常。
 * -#step4：等待线程结束。
 *- @Expect: 0\n
 *- @Priority: High
 *- @Source: ThreadStatewait9.java
 *- @ExecuteClass: ThreadStatewait9
 *- @ExecuteArgs:
 */

public class ThreadStatewait9 extends Thread {
    static Object ob = "aa";
    static int i = 0;

    public static void main(String[] args) {
        ThreadStatewait9 threadWait = new ThreadStatewait9();
        threadWait.start();
        try {
            threadWait.join();
        } catch (InterruptedException ee) {
            System.out.println(2);
            return;
        }

        if (i == 1) {
            System.out.println(0);
            return;
        }
        System.out.println(2);
    }

    public void run() {
        synchronized (ob) {
            try {
                ob.wait(-1000);
            } catch (IllegalArgumentException ee) {
                i++;
            } catch (InterruptedException e) {
                System.out.println("Wait is interrupted");
            }
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n