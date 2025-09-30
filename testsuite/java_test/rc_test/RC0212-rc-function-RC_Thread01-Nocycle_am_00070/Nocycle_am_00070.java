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


class ThreadRc_00070 extends Thread {
    private boolean checkout;
    public void run() {
        Nocycle_a_00070_A1 a1_main = new Nocycle_a_00070_A1("a1_main");
        a1_main.b1_0 = new Nocycle_a_00070_B1("b1_0");
        a1_main.b2_0 = new Nocycle_a_00070_B2("b2_0");
        a1_main.b3_0 = new Nocycle_a_00070_B3("b3_0");
        a1_main.b4_0 = new Nocycle_a_00070_B4("b4_0");
        a1_main.b4_0.c1_0 = new Nocycle_a_00070_C1("c1_0");
        a1_main.b4_0.c2_0 = new Nocycle_a_00070_C2("c2_0");
        a1_main.b4_0.c3_0 = new Nocycle_a_00070_C3("c3_0");
        a1_main.add();
        a1_main.b1_0.add();
        a1_main.b2_0.add();
        a1_main.b3_0.add();
        a1_main.b4_0.add();
        a1_main.b4_0.c1_0.add();
        a1_main.b4_0.c2_0.add();
        a1_main.b4_0.c3_0.add();
//		 System.out.printf("RC-Testing_Result=%d\n",a1_main.sum+a1_main.b1_0.sum+a1_main.b2_0.sum+a1_main.b3_0.sum+a1_main.b4_0.sum+a1_main.b4_0.c1_0.sum+a1_main.b4_0.c2_0.sum+a1_main.b4_0.c3_0.sum);
        int result = a1_main.sum + a1_main.b1_0.sum + a1_main.b2_0.sum + a1_main.b3_0.sum + a1_main.b4_0.sum + a1_main.b4_0.c1_0.sum + a1_main.b4_0.c2_0.sum + a1_main.b4_0.c3_0.sum;
        //System.out.println("RC-Testing_Result="+result);
        if (result == 5045)
            checkout = true;
        //System.out.println(checkout);
    }
    public boolean check() {
        return checkout;
    }
    class Nocycle_a_00070_A1 {
        Nocycle_a_00070_B1 b1_0;
        Nocycle_a_00070_B2 b2_0;
        Nocycle_a_00070_B3 b3_0;
        Nocycle_a_00070_B4 b4_0;
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00070_A1(String strObjectName) {
            b1_0 = null;
            b2_0 = null;
            b3_0 = null;
            b4_0 = null;
            a = 101;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
        }
        void add() {
            sum = a + b1_0.a + b2_0.a + b3_0.a + b4_0.a;
        }
    }
    class Nocycle_a_00070_B1 {
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00070_B1(String strObjectName) {
            a = 201;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B1_"+strObjectName);
        }
        void add() {
            sum = a + a;
        }
    }
    class Nocycle_a_00070_B2 {
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00070_B2(String strObjectName) {
            a = 202;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B2_"+strObjectName);
        }
        void add() {
            sum = a + a;
        }
    }
    class Nocycle_a_00070_B3 {
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00070_B3(String strObjectName) {
            a = 203;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B3_"+strObjectName);
        }
        void add() {
            sum = a + a;
        }
    }
    class Nocycle_a_00070_B4 {
        Nocycle_a_00070_C1 c1_0;
        Nocycle_a_00070_C2 c2_0;
        Nocycle_a_00070_C3 c3_0;
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00070_B4(String strObjectName) {
            c1_0 = null;
            c2_0 = null;
            c3_0 = null;
            a = 204;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B4_"+strObjectName);
        }
        void add() {
            sum = a + c1_0.a + c2_0.a + c3_0.a;
        }
    }
    class Nocycle_a_00070_C1 {
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00070_C1(String strObjectName) {
            a = 301;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C1_"+strObjectName);
        }
        void add() {
            sum = a + a;
        }
    }
    class Nocycle_a_00070_C2 {
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00070_C2(String strObjectName) {
            a = 302;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C2_"+strObjectName);
        }
        void add() {
            sum = a + a;
        }
    }
    class Nocycle_a_00070_C3 {
        int a;
        int sum;
        String strObjectName;
        Nocycle_a_00070_C3(String strObjectName) {
            a = 303;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C3_"+strObjectName);
        }
        void add() {
            sum = a + a;
        }
    }
}
public class Nocycle_am_00070 {
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
    }
    private static void rc_testcase_main_wrapper() {
        ThreadRc_00070 A1_00070 = new ThreadRc_00070();
        ThreadRc_00070 A2_00070 = new ThreadRc_00070();
        ThreadRc_00070 A3_00070 = new ThreadRc_00070();
        ThreadRc_00070 A4_00070 = new ThreadRc_00070();
        ThreadRc_00070 A5_00070 = new ThreadRc_00070();
        ThreadRc_00070 A6_00070 = new ThreadRc_00070();
        A1_00070.start();
        A2_00070.start();
        A3_00070.start();
        A4_00070.start();
        A5_00070.start();
        A6_00070.start();
        try {
            A1_00070.join();
            A2_00070.join();
            A3_00070.join();
            A4_00070.join();
            A5_00070.join();
            A6_00070.join();
        } catch (InterruptedException e) {
        }
        if (A1_00070.check() && A2_00070.check() && A3_00070.check() && A4_00070.check() && A5_00070.check() && A6_00070.check())
            System.out.println("ExpectResult");
    }
}
