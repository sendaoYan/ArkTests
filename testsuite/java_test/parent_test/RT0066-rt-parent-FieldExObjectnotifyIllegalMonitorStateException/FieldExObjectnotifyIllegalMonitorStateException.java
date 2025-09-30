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


import java.lang.reflect.Field;
public class FieldExObjectnotifyIllegalMonitorStateException {
    static int res = 99;
    private Field[] rp = FieldExObjectnotifyIllegalMonitorStateException.class.getDeclaredFields();
    public static void main(String argv[]) {
        System.out.println(new FieldExObjectnotifyIllegalMonitorStateException().run());
    }
    /**
     * main test fun
     *
     * @return status code
    */

    public int run() {
        int result = 2; /*STATUS_FAILED*/
        try {
            result = methodExObjectnotifyIllegalMonitorStateException1();
        } catch (Exception e) {
            FieldExObjectnotifyIllegalMonitorStateException.res = FieldExObjectnotifyIllegalMonitorStateException.res - 20;
        }
        Thread t1 = new Thread(new MethodExObjectnotifyIllegalMonitorStateException11());
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
        if (result == 4 && FieldExObjectnotifyIllegalMonitorStateException.res == 58) {
            result = 0;
        }
        return result;
    }
    private int methodExObjectnotifyIllegalMonitorStateException1() {
        int result1 = 4; /*STATUS_FAILED*/
        // IllegalMonitorStateException - if the current thread is not the owner of the object's monitor.
        // final void notify()
        try {
            rp.notify();
            FieldExObjectnotifyIllegalMonitorStateException.res = FieldExObjectnotifyIllegalMonitorStateException.res - 10;
        } catch (IllegalMonitorStateException e2) {
            FieldExObjectnotifyIllegalMonitorStateException.res = FieldExObjectnotifyIllegalMonitorStateException.res - 1;
        }
        return result1;
    }
    private class MethodExObjectnotifyIllegalMonitorStateException11 implements Runnable {
        // final void notify()
        /**
         * Thread run fun
        */

        public void run() {
            synchronized (rp) {
                try {
                    rp.notify();
                    FieldExObjectnotifyIllegalMonitorStateException.res = FieldExObjectnotifyIllegalMonitorStateException.res - 40;
                } catch (IllegalMonitorStateException e2) {
                    FieldExObjectnotifyIllegalMonitorStateException.res = FieldExObjectnotifyIllegalMonitorStateException.res - 30;
                }
            }
        }
    }
}