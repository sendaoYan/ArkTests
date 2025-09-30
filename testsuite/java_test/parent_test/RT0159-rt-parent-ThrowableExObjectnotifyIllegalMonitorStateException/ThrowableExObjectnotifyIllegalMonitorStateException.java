/*
 * Copyright (c) [2021] Huawei Technologies Co.,Ltd.All rights reserved.
 *
 * OpenArkCompiler is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 *
 *     http://license.coscl.org.cn/MulanPSL2
 *
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR
 * FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
*/


import java.lang.Thread;
public class ThrowableExObjectnotifyIllegalMonitorStateException {
    static int res = 99;
    private Throwable cause = new Throwable("detailed message of cause");
    public static void main(String argv[]) {
        System.out.println(new ThrowableExObjectnotifyIllegalMonitorStateException().run());
    }
    /**
     * main test fun
     *
     * @return status code
    */

    public int run() {
        int result = 2; /*STATUS_FAILED*/
        try {
            result = throwableExObjectnotifyIllegalMonitorStateException1();
        } catch (Exception e) {
            ThrowableExObjectnotifyIllegalMonitorStateException.res = ThrowableExObjectnotifyIllegalMonitorStateException.res - 20;
        }
        Thread t1 = new Thread(new ThrowableExObjectnotifyIllegalMonitorStateException11(1));
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " : " + e.getMessage());
            }
        });
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (result == 4 && ThrowableExObjectnotifyIllegalMonitorStateException.res == 58) {
            result = 0;
        }
        return result;
    }
    private int throwableExObjectnotifyIllegalMonitorStateException1() {
        int result1 = 4; /*STATUS_FAILED*/
        // IllegalMonitorStateException - if the current thread is not the owner of the object's monitor.
        // final void notify()
        try {
            cause.notify();
            ThrowableExObjectnotifyIllegalMonitorStateException.res = ThrowableExObjectnotifyIllegalMonitorStateException.res - 10;
        } catch (IllegalMonitorStateException e2) {
            ThrowableExObjectnotifyIllegalMonitorStateException.res = ThrowableExObjectnotifyIllegalMonitorStateException.res - 1;
        }
        return result1;
    }
    private class ThrowableExObjectnotifyIllegalMonitorStateException11 implements Runnable {
        // final void notify()
        private int remainder;
        private ThrowableExObjectnotifyIllegalMonitorStateException11(int remainder) {
            this.remainder = remainder;
        }
        /**
         * Thread run fun
        */

        public void run() {
            synchronized (cause) {
                try {
                    cause.notify();
                    ThrowableExObjectnotifyIllegalMonitorStateException.res = ThrowableExObjectnotifyIllegalMonitorStateException.res - 40;
                } catch (IllegalMonitorStateException e2) {
                    ThrowableExObjectnotifyIllegalMonitorStateException.res = ThrowableExObjectnotifyIllegalMonitorStateException.res - 30;
                }
            }
        }
    }
}