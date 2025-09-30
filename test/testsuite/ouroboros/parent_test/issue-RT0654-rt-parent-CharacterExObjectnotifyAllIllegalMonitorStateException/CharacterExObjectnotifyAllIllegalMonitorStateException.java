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
 * -@TestCaseID: CharacterExObjectnotifyAllIllegalMonitorStateException.java
 * -@TestCaseName: Exception in Character: final void notifyAll()
 * -@TestCaseType: Function Test
 * -@RequirementName: 补充重写类的父类方法
 * -@Brief:
 * -#step1: Create a private class to implement Runnable, call notifyAll () inside run
 * -#step2: Call the run of the use case, execute method 1, and call notifyAll () in the method
 * -#step3: Execute the start () method of the private class and wait 100 milliseconds
 * -#step4: Confirm method 1 throws an exception IllegalMonitorStateException, the class does not throw an exception
 * -@Expect:0\n
 * -@Priority: High
 * -@Source: CharacterExObjectnotifyAllIllegalMonitorStateException.java
 * -@ExecuteClass: CharacterExObjectnotifyAllIllegalMonitorStateException
 * -@ExecuteArgs:
 */

import java.lang.Thread;

public class CharacterExObjectnotifyAllIllegalMonitorStateException {
    static int res = 99;
    private char name = 'A';
    private Character rp = new Character(name);

    public static void main(String argv[]) {
        System.out.println(new CharacterExObjectnotifyAllIllegalMonitorStateException().run());
    }

    /**
     * main test fun
     * @return status code
     */
    public int run() {
        int result = 2; /*STATUS_FAILED*/
        try {
            result = characterExObjectnotifyAllIllegalMonitorStateException1();
        } catch (Exception e) {
            CharacterExObjectnotifyAllIllegalMonitorStateException.res = CharacterExObjectnotifyAllIllegalMonitorStateException.res - 20;
        }
        Thread t1 = new Thread(new CharacterExObjectnotifyAllIllegalMonitorStateException11());
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " : " + e.getMessage());
            }
        });
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (result == 4 && CharacterExObjectnotifyAllIllegalMonitorStateException.res == 58) {
            result = 0;
        }
        return result;
    }

    private int characterExObjectnotifyAllIllegalMonitorStateException1() {
        int result1 = 4; /*STATUS_FAILED*/
        // IllegalMonitorStateException - if the current thread is not the owner of the object's monitor.
        // final void notifyAll()
        try {
            rp.notifyAll();
            CharacterExObjectnotifyAllIllegalMonitorStateException.res = CharacterExObjectnotifyAllIllegalMonitorStateException.res - 10;
        } catch (IllegalMonitorStateException e2) {
            CharacterExObjectnotifyAllIllegalMonitorStateException.res = CharacterExObjectnotifyAllIllegalMonitorStateException.res - 1;
        }
        return result1;
    }

    private class CharacterExObjectnotifyAllIllegalMonitorStateException11 implements Runnable {
        // final void notifyAll()

        /**
         * Thread run fun
         */
        public void run() {
            synchronized (rp) {
                try {
                    rp.notifyAll();
                    CharacterExObjectnotifyAllIllegalMonitorStateException.res = CharacterExObjectnotifyAllIllegalMonitorStateException.res - 40;
                } catch (IllegalMonitorStateException e2) {
                    CharacterExObjectnotifyAllIllegalMonitorStateException.res = CharacterExObjectnotifyAllIllegalMonitorStateException.res - 30;
                }
            }
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n