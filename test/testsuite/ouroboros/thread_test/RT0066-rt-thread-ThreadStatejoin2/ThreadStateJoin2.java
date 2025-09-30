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
 * -@TestCaseID: ThreadStateJoin2
 *- @TestCaseName: Thread_ThreadStateJoin2.java
 *- @RequirementName: Java Thread
 *- @Title/Destination: Wait time unit is seconds target thread ends.
 *- @Brief: see below
 * -#step1: 创建一个ThreadStateJoin2类的实例对象threadStateJoin2，并且ThreadStateJoin2类继承自Thread类；
 * -#step2: 调用threadStateJoin2的start()方法启动该线程；
 * -#step3: 调用threadStateJoin2的join()方法，参数为1000；
 * -#step4: run方法循环三次，每次令int类型的全局静态变量t的值加1；
 * -#step5: 经判断得知threadStateJoin2.getState().toString()的返回值与字符串"TERMINATED"相同，并且ThreadStateJoin2类在其
 *          内部的run()方法执行完之后t的值变为4；
 *- @Expect: 0\n
 *- @Priority: High
 *- @Source: ThreadStateJoin2.java
 *- @ExecuteClass: ThreadStateJoin2
 *- @ExecuteArgs:
 */

public class ThreadStateJoin2 extends Thread {
    static int t = 0;

    public static void main(String[] args) {
        ThreadStateJoin2 threadStateJoin2 = new ThreadStateJoin2();
        threadStateJoin2.start();
        try {
            threadStateJoin2.join(1000);
            t++;
        } catch (InterruptedException e1) {
            System.out.println("Join is interrupted");
        }
        if (threadStateJoin2.getState().toString().equals("TERMINATED") && t == 4) {
            System.out.println(0);
            return;
        }
        System.out.println(2);
    }

    public void run() {
        synchronized (currentThread()) {
            for (int i = 1; i <= 3; i++) {
                try {
                    sleep(200);
                    t++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n