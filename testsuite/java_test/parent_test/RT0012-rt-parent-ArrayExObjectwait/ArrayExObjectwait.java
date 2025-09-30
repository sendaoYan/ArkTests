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


import java.lang.reflect.Array;
public class ArrayExObjectwait {
    static int res = 99;
    private static Object ary1 = Array.newInstance(int.class, 10);
    public static void main(String argv[]) {
        System.out.println(new ArrayExObjectwait().run());
    }
    private class ArrayExObjectwait11 implements Runnable {
        // final void wait()
        /**
         * Thread run fun
        */

        public void run() {
            synchronized (ary1) {
                ary1.notifyAll();
                try {
                    ary1.wait();
                    ArrayExObjectwait.res = ArrayExObjectwait.res - 10;
                } catch (InterruptedException e1) {
                    ArrayExObjectwait.res = ArrayExObjectwait.res - 1;
                } catch (IllegalMonitorStateException e2) {
                    ArrayExObjectwait.res = ArrayExObjectwait.res - 30;
                }
            }
        }
    }
    private class ArrayExObjectwait12 implements Runnable {
        // final void wait(long millis)
        long millis = 10;
        /**
         * Thread run fun
        */

        public void run() {
            synchronized (ary1) {
                ary1.notifyAll();
                try {
                    ary1.wait(millis);
                    ArrayExObjectwait.res = ArrayExObjectwait.res - 10;
                } catch (InterruptedException e1) {
                    ArrayExObjectwait.res = ArrayExObjectwait.res - 1;
                } catch (IllegalMonitorStateException e2) {
                    ArrayExObjectwait.res = ArrayExObjectwait.res - 30;
                }
            }
        }
    }
    private class ArrayExObjectwait13 implements Runnable {
        // final void wait(long millis, int nanos)
        long millis = 10;
        int nanos = 10;
        /**
         * Thread run fun
        */

        public void run() {
            synchronized (ary1) {
                ary1.notifyAll();
                try {
                    ary1.wait(millis, nanos);
                    ArrayExObjectwait.res = ArrayExObjectwait.res - 10;
                } catch (InterruptedException e1) {
                    ArrayExObjectwait.res = ArrayExObjectwait.res - 1;
                } catch (IllegalMonitorStateException e2) {
                    ArrayExObjectwait.res = ArrayExObjectwait.res - 30;
                }
            }
        }
    }
    /**
     * sleep fun
     *
     * @param slpnum wait time
    */

    public void sleep(int slpnum) {
        try {
            Thread.sleep(slpnum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * main test fun
     *
     * @return status code
    */

    public int run() {
        int result = 2; /*STATUS_FAILED*/
        // final void wait()
        Thread t1 = new Thread(new ArrayExObjectwait11());
        Thread t2 = new Thread(new ArrayExObjectwait11());
        // final void wait(long millis)
        Thread t3 = new Thread(new ArrayExObjectwait12());
        // final void wait(long millis, int nanos)
        Thread t5 = new Thread(new ArrayExObjectwait13());
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " : " + e.getMessage());
            }
        });
        t1.start();
        sleep(1000);
        t3.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " : " + e.getMessage());
            }
        });
        t3.start();
        sleep(1000);
        t5.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " : " + e.getMessage());
            }
        });
        t5.start();
        sleep(1000);
        t2.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " : " + e.getMessage());
            }
        });
        t2.start();
        try {
            t1.join();
            t3.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (result == 2 && ArrayExObjectwait.res == 69) {
            result = 0;
        }
        t2.interrupt();
        return result;
    }
}
