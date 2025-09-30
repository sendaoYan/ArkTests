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


class ThreadRc_Cycle_am_00500 extends Thread {
    private boolean checkout;
    public void run() {
        Cycle_a_00500_A1 a1_main = new Cycle_a_00500_A1("a1_main");
        Cycle_a_00500_A4 a4_main = new Cycle_a_00500_A4("a4_main");
        Cycle_a_00500_A7 a7_main = new Cycle_a_00500_A7("a7_main");
        a1_main.a2_0 = new Cycle_a_00500_A2("a2_0");
        a1_main.a2_0.a3_0 = new Cycle_a_00500_A3("a3_0");
        a1_main.a2_0.a3_0.a1_0 = a1_main;
        a4_main.a1_0 = a1_main;
        a4_main.a5_0 = new Cycle_a_00500_A5("a5_0");
        a4_main.a5_0.a6_0 = new Cycle_a_00500_A6("a6_0");
        a4_main.a5_0.a6_0.a4_0 = a4_main;
        a4_main.a5_0.a8_0 = new Cycle_a_00500_A8("a8_0");
        a4_main.a5_0.a8_0.a7_0 = a7_main;
        a7_main.a9_0 = new Cycle_a_00500_A9("a9_0");
        a7_main.a9_0.a8_0 = new Cycle_a_00500_A8("a8_0");
        a7_main.a9_0.a8_0.a7_0 = a7_main;
        a1_main.add();
        a4_main.add();
        a7_main.add();
        a1_main.a2_0.add();
        a1_main.a2_0.a3_0.add();
        a1_main.a2_0.a3_0.a1_0.add();
        a4_main.a1_0.add();
        a4_main.a5_0.add();
        a4_main.a5_0.a6_0.add();
        a4_main.a5_0.a6_0.a4_0.add();
        a4_main.a5_0.a8_0.add();
        a4_main.a5_0.a8_0.a7_0.add();
        a7_main.a9_0.add();
        a7_main.a9_0.a8_0.add();
        a7_main.a9_0.a8_0.a7_0.add();
//		 System.out.println("a1_main.sum:"+a1_main.sum);
//		 System.out.println("a4_main.sum:"+a4_main.sum);
//		 System.out.println("a7_main.sum:"+a7_main.sum);
//		 System.out.println("a1_main.a2_0.sum:"+a1_main.a2_0.sum);
//		 System.out.println("a1_main.a2_0.a3_0.sum:"+a1_main.a2_0.a3_0.sum);
//		 System.out.println("a4_main.a5_0.sum:"+a4_main.a5_0.sum);
//		 System.out.println("a4_main.a5_0.a6_0.sum:"+a4_main.a5_0.a6_0.sum);
//		 System.out.println("a7_main.a9_0.sum:"+a7_main.a9_0.sum);
//		 System.out.println("a7_main.a9_0.a8_0.sum:"+a7_main.a9_0.a8_0.sum);
//		 System.out.printf("RC-Testing_Result=%d\n",a1_main.sum+a4_main.sum+a7_main.sum+a1_main.a2_0.sum+a1_main.a2_0.a3_0.sum+a4_main.a5_0.sum+a4_main.a5_0.a6_0.sum+a7_main.a9_0.sum+a7_main.a9_0.a8_0.sum);
        int result = a1_main.sum + a4_main.sum + a7_main.sum + a1_main.a2_0.sum + a1_main.a2_0.a3_0.sum + a4_main.a5_0.sum + a4_main.a5_0.a6_0.sum + a7_main.a9_0.sum + a7_main.a9_0.a8_0.sum;
        //System.out.println("RC-Testing_Result="+result);
        if (result == 2099)
            checkout = true;
        //System.out.println(checkout);
    }
    public boolean check() {
        return checkout;
    }
    class Cycle_a_00500_A1 {
        Cycle_a_00500_A2 a2_0;
        int a;
        int sum;
        String strObjectName;
        Cycle_a_00500_A1(String strObjectName) {
            a2_0 = null;
            a = 101;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
        }
        void add() {
            sum = a + a2_0.a;
        }
    }
    class Cycle_a_00500_A2 {
        Cycle_a_00500_A3 a3_0;
        int a;
        int sum;
        String strObjectName;
        Cycle_a_00500_A2(String strObjectName) {
            a3_0 = null;
            a = 102;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A2_"+strObjectName);
        }
        void add() {
            sum = a + a3_0.a;
        }
    }
    class Cycle_a_00500_A3 {
        Cycle_a_00500_A1 a1_0;
        int a;
        int sum;
        String strObjectName;
        Cycle_a_00500_A3(String strObjectName) {
            a1_0 = null;
            a = 103;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A3_"+strObjectName);
        }
        void add() {
            sum = a + a1_0.a;
        }
    }
    class Cycle_a_00500_A4 {
        Cycle_a_00500_A1 a1_0;
        Cycle_a_00500_A5 a5_0;
        int a;
        int sum;
        String strObjectName;
        Cycle_a_00500_A4(String strObjectName) {
            a1_0 = null;
            a5_0 = null;
            a = 104;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A4_"+strObjectName);
        }
        void add() {
            sum = a + a1_0.a + a5_0.a;
        }
    }
    class Cycle_a_00500_A5 {
        Cycle_a_00500_A6 a6_0;
        Cycle_a_00500_A8 a8_0;
        int a;
        int sum;
        String strObjectName;
        Cycle_a_00500_A5(String strObjectName) {
            a6_0 = null;
            a8_0 = null;
            a = 105;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A5_"+strObjectName);
        }
        void add() {
            sum = a + a6_0.a + a8_0.a;
        }
    }
    class Cycle_a_00500_A6 {
        Cycle_a_00500_A4 a4_0;
        int a;
        int sum;
        String strObjectName;
        Cycle_a_00500_A6(String strObjectName) {
            a4_0 = null;
            a = 106;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A6_"+strObjectName);
        }
        void add() {
            sum = a + a4_0.a;
        }
    }
    class Cycle_a_00500_A7 {
        Cycle_a_00500_A9 a9_0;
        int a;
        int sum;
        String strObjectName;
        Cycle_a_00500_A7(String strObjectName) {
            a9_0 = null;
            a = 107;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A7_"+strObjectName);
        }
        void add() {
            sum = a + a9_0.a;
        }
    }
    class Cycle_a_00500_A8 {
        Cycle_a_00500_A7 a7_0;
        int a;
        int sum;
        String strObjectName;
        Cycle_a_00500_A8(String strObjectName) {
            a7_0 = null;
            a = 108;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A8_"+strObjectName);
        }
        void add() {
            sum = a + a7_0.a;
        }
    }
    class Cycle_a_00500_A9 {
        Cycle_a_00500_A8 a8_0;
        int a;
        int sum;
        String strObjectName;
        Cycle_a_00500_A9(String strObjectName) {
            a8_0 = null;
            a = 109;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A9_"+strObjectName);
        }
        void add() {
            sum = a + a8_0.a;
        }
    }
}
public class Cycle_am_00500 {
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
        Runtime.getRuntime().gc();
        rc_testcase_main_wrapper();
        Runtime.getRuntime().gc();
        rc_testcase_main_wrapper();
        Runtime.getRuntime().gc();
        rc_testcase_main_wrapper();
    }
    private static void rc_testcase_main_wrapper() {
        ThreadRc_Cycle_am_00500 A1_Cycle_am_00500 = new ThreadRc_Cycle_am_00500();
        ThreadRc_Cycle_am_00500 A2_Cycle_am_00500 = new ThreadRc_Cycle_am_00500();
        ThreadRc_Cycle_am_00500 A3_Cycle_am_00500 = new ThreadRc_Cycle_am_00500();
        ThreadRc_Cycle_am_00500 A4_Cycle_am_00500 = new ThreadRc_Cycle_am_00500();
        ThreadRc_Cycle_am_00500 A5_Cycle_am_00500 = new ThreadRc_Cycle_am_00500();
        ThreadRc_Cycle_am_00500 A6_Cycle_am_00500 = new ThreadRc_Cycle_am_00500();
        A1_Cycle_am_00500.start();
        A2_Cycle_am_00500.start();
        A3_Cycle_am_00500.start();
        A4_Cycle_am_00500.start();
        A5_Cycle_am_00500.start();
        A6_Cycle_am_00500.start();
        try {
            A1_Cycle_am_00500.join();
            A2_Cycle_am_00500.join();
            A3_Cycle_am_00500.join();
            A4_Cycle_am_00500.join();
            A5_Cycle_am_00500.join();
            A6_Cycle_am_00500.join();
        } catch (InterruptedException e) {
        }
        if (A1_Cycle_am_00500.check() && A2_Cycle_am_00500.check() && A3_Cycle_am_00500.check() && A4_Cycle_am_00500.check() && A5_Cycle_am_00500.check() && A6_Cycle_am_00500.check())
            System.out.println("ExpectResult");
    }
}
