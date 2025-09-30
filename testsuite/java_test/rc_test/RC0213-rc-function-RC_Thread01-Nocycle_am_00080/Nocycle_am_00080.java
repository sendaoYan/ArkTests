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


class ThreadRc_00080 extends Thread {
    private boolean checkout;
    public void run() {
        Nocycle_a_00080_A1 a1_main = new Nocycle_a_00080_A1("a1_main");
        a1_main.b1_0 = new Nocycle_a_00080_B1("b1_0");
        a1_main.b1_0.c1_0 = new Nocycle_a_00080_C1("c1_0");
        a1_main.add();
        a1_main.b1_0.add();
        a1_main.b1_0.c1_0.add();
//		 System.out.printf("RC-Testing_Result=%d\n",a1_main.sum+a1_main.b1_0.sum+a1_main.b1_0.c1_0.sum);
        int result = a1_main.sum + a1_main.b1_0.sum + a1_main.b1_0.c1_0.sum;
        //System.out.println("RC-Testing_Result_Thread1="+result);
        if (result == 1406)
            checkout = true;
        //System.out.println(checkout);
    }
    public boolean check() {
        return checkout;
    }
    class Nocycle_a_00080_A1 {
        Nocycle_a_00080_B1 b1_0;
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00080_A1(String strObjectName) {
            b1_0 = null;
            a = 101;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
        }
        void add() {
            sum = a + b1_0.a;
        }
    }
    class Nocycle_a_00080_B1 {
        Nocycle_a_00080_C1 c1_0;
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00080_B1(String strObjectName) {
            c1_0 = null;
            a = 201;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B1_"+strObjectName);
        }
        void add() {
            sum = a + c1_0.a;
        }
    }
    class Nocycle_a_00080_C1 {
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00080_C1(String strObjectName) {
            a = 301;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C1_"+strObjectName);
        }
        void add() {
            sum = a + a;
        }
    }
}
public class Nocycle_am_00080 {
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
    }
    private static void rc_testcase_main_wrapper() {
        ThreadRc_00080 A1_00080 = new ThreadRc_00080();
        ThreadRc_00080 A2_00080 = new ThreadRc_00080();
        ThreadRc_00080 A3_00080 = new ThreadRc_00080();
        ThreadRc_00080 A4_00080 = new ThreadRc_00080();
        ThreadRc_00080 A5_00080 = new ThreadRc_00080();
        ThreadRc_00080 A6_00080 = new ThreadRc_00080();
        A1_00080.start();
        A2_00080.start();
        A3_00080.start();
        A4_00080.start();
        A5_00080.start();
        A6_00080.start();
        try {
            A1_00080.join();
            A2_00080.join();
            A3_00080.join();
            A4_00080.join();
            A5_00080.join();
            A6_00080.join();
        } catch (InterruptedException e) {
        }
        if (A1_00080.check() && A2_00080.check() && A3_00080.check() && A4_00080.check() && A5_00080.check() && A6_00080.check())
            System.out.println("ExpectResult");
    }
}