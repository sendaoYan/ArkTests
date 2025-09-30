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
 *- @Title/Destination: GetThreadGroup() Returns the thread group to which this thread belongs. This method returns
 *                      null if this thread has died (been stopped).
 *- @Brief: see below
 * -#step1: Define test class which inherited from thread class.
 * -#step2: Create a ThreadRunning instance.
 * -#step3: Start the thread.
 * -#step4: Finish the thread by calling join().
 * -#step5: Check that GetThreadGroup() returns null.
 *- @Expect: expected.txt
 *- @Priority: High
 *- @Source: ThreadTest.java
 *- @ExecuteClass: ThreadTest
 *- @ExecuteArgs:
 */

public class ThreadTest {
    public static void main(String[] args) throws Exception {
        ThreadRunning threadRunning = new ThreadRunning();
        threadRunning.start();
        threadRunning.stopWork = true;
        threadRunning.join();
        System.out.println("Thread group of a dead thread must be null --- " +
                threadRunning.getThreadGroup());
        System.out.println("PASS");
    }

    static class ThreadRunning extends Thread {
        public volatile int i = 0;
        volatile boolean stopWork = false;

        ThreadRunning() {
            super();
        }

        public void run() {
            while (!stopWork) {
                i++;
                i--;
            }
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full Thread group of a dead thread must be null --- null\nPASS\n