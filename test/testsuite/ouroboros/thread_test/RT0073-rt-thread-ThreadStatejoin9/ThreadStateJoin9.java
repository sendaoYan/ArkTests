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
 * -@TestCaseID: ThreadStateJoin9
 *- @TestCaseName: Thread_ThreadStateJoin9.java
 *- @RequirementName: Java Thread
 *- @Title/Destination: Wait time unit is millisecond target thread is still sleeping.
 *- @Brief: see below
 * -#step1: 创建一个ThreadStateJoin9类的实例对象threadStateJoin9，并且ThreadStateJoin9类继承自Thread类；
 * -#step2: 调用threadStateJoin9的start()方法启动该线程；
 * -#step3: 调用threadStateJoin9的join()方法，参数为500,300；
 * -#step4: run方法循环5次，每次sleep后int类型的全局静态变量t的值加1；
 * -#step5: 经判断得知threadStateJoin9.getState().toString()的返回值与字符串"TIMED_WAITING"相同，并且ThreadStateJoin9类
 *          在其内部的run()方法执行完之后t的值变为3；
 *- @Expect: 0\n
 *- @Priority: High
 *- @Source: ThreadStateJoin9.java
 *- @ExecuteClass: ThreadStateJoin9
 *- @ExecuteArgs:
 */

public class ThreadStateJoin9 extends Thread {
    static int t = 0;

    public static void main(String[] args) {
        ThreadStateJoin9 threadStateJoin9 = new ThreadStateJoin9();
        threadStateJoin9.start();
        try {
            threadStateJoin9.join(500, 300);
            t++;
        } catch (InterruptedException e1) {
            System.out.println("Join is interrupted");
        }
        if (threadStateJoin9.getState().toString().equals("TIMED_WAITING") && t == 3) {
            System.out.println(0);
            return;
        }
        System.out.println(2);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                sleep(200);
                t++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n