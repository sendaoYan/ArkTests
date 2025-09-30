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


class RC_Thread_01_1 extends Thread {
    public void run() {
        RC_Thread_01 rcth01 = new RC_Thread_01();
        try {
            rcth01.setA1null();
        } catch (NullPointerException e) {
        }
    }
}
class RC_Thread_01_2 extends Thread {
    public void run() {
        RC_Thread_01 rcth01 = new RC_Thread_01();
        try {
            rcth01.setA2null();
        } catch (NullPointerException e) {
        }
    }
}
class RC_Thread_01_3 extends Thread {
    public void run() {
        RC_Thread_01 rcth01 = new RC_Thread_01();
        try {
            rcth01.setA3();
        } catch (NullPointerException e) {
        }
    }
}
class RC_Thread_01_4 extends Thread {
    public void run() {
        RC_Thread_01 rcth01 = new RC_Thread_01();
        try {
            rcth01.setA3null();
        } catch (NullPointerException e) {
        }
    }
}
class RC_Thread_01_5 extends Thread {
    public void run() {
        RC_Thread_01 rcth01 = new RC_Thread_01();
        try {
            rcth01.setA4null();
        } catch (NullPointerException e) {
        }
    }
}
public class RC_Thread_01 {
    private volatile static RC_Thread_01_A1 a1_main = null;
    private volatile static RC_Thread_01_A2 a2_main = null;
    private volatile static RC_Thread_01_A3 a3_main = null;
    private volatile static RC_Thread_01_A4 a4_main = null;
    RC_Thread_01() {
        try {
            a1_main = new RC_Thread_01_A1("a1_main");
            a2_main = new RC_Thread_01_A2("a2_main");
            a3_main = new RC_Thread_01_A3("a3_main");
            a4_main = new RC_Thread_01_A4("a4_main");
            a1_main.b1_0 = new RC_Thread_01_B1("b1_0");
            a1_main.d1_0 = new RC_Thread_01_D1("d1_0");
            a1_main.b1_0.d2_0 = new RC_Thread_01_D2("d2_0");
            a2_main.b2_0 = new RC_Thread_01_B2("b2_0");
            a2_main.b2_0.c1_0 = new RC_Thread_01_C1("c1_0");
            a2_main.b2_0.d1_0 = new RC_Thread_01_D1("d1_0");
            a2_main.b2_0.d2_0 = new RC_Thread_01_D2("d2_0");
            a2_main.b2_0.d3_0 = new RC_Thread_01_D3("d3_0");
            a2_main.b2_0.c1_0.d1_0 = new RC_Thread_01_D1("d1_0");
            a3_main.b2_0 = new RC_Thread_01_B2("b2_0");
            a3_main.b2_0.c1_0 = new RC_Thread_01_C1("c1_0");
            a3_main.b2_0.c1_0.d1_0 = new RC_Thread_01_D1("d1_0");
            a3_main.b2_0.d1_0 = new RC_Thread_01_D1("d1_0");
            a3_main.b2_0.d2_0 = new RC_Thread_01_D2("d2_0");
            a3_main.b2_0.d3_0 = new RC_Thread_01_D3("d3_0");
            a3_main.c2_0 = new RC_Thread_01_C2("c2_0");
            a3_main.c2_0.d2_0 = new RC_Thread_01_D2("d2_0");
            a3_main.c2_0.d3_0 = new RC_Thread_01_D3("d3_0");
            a4_main.b3_0 = new RC_Thread_01_B3("b3_0");
            a4_main.b3_0.c1_0 = new RC_Thread_01_C1("c1_0");
            a4_main.b3_0.c1_0.d1_0 = new RC_Thread_01_D1("d1_0");
            a4_main.c2_0 = new RC_Thread_01_C2("c2_0");
            a4_main.c2_0.d2_0 = new RC_Thread_01_D2("d2_0");
            a4_main.c2_0.d3_0 = new RC_Thread_01_D3("d3_0");
        } catch (NullPointerException e) {
        }
    }
    public static void main(String[] args) {
        rc_testcase_main_wrapper();
	Runtime.getRuntime().gc();
	rc_testcase_main_wrapper();
		System.out.println("ExpectResult");
    }
    private static void rc_testcase_main_wrapper() {
        RC_Thread_01_1 t1=new RC_Thread_01_1();
        RC_Thread_01_2 t2=new RC_Thread_01_2();
        RC_Thread_01_3 t3=new RC_Thread_01_3();
        RC_Thread_01_4 t4=new RC_Thread_01_4();
        RC_Thread_01_5 t5=new RC_Thread_01_5();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {}
    }
    public void setA1null() {
        a1_main = null;
    }
    public void setA2null() {
        a2_main = null;
    }
    public void setA3() {
        try {
            a3_main.c2_0.d2_0 = new RC_Thread_01_D2("new");
            a3_main = new RC_Thread_01_A3("a3_new");
            a3_main = null;
        } catch (NullPointerException e) {
        }
    }
    public void setA3null() {
        a3_main = null;
    }
    public void setA4null() {
        a4_main = null;
    }
    class RC_Thread_01_A1 {
        volatile RC_Thread_01_B1 b1_0;
        volatile RC_Thread_01_D1 d1_0;
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_A1(String strObjectName) {
            b1_0 = null;
            d1_0 = null;
            a = 101;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A1_"+strObjectName);
        }
        void add() {
            sum = a + b1_0.a + d1_0.a;
        }
    }
    class RC_Thread_01_A2 {
        volatile RC_Thread_01_B2 b2_0;
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_A2(String strObjectName) {
            b2_0 = null;
            a = 102;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A2_"+strObjectName);
        }
        void add() {
            sum = a + b2_0.a;
        }
    }
    class RC_Thread_01_A3 {
        volatile RC_Thread_01_B2 b2_0;
        volatile RC_Thread_01_C2 c2_0;
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_A3(String strObjectName) {
            b2_0 = null;
            c2_0 = null;
            a = 103;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A3_"+strObjectName);
        }
        void add() {
            sum = a + b2_0.a + c2_0.a;
        }
    }
    class RC_Thread_01_A4 {
        volatile RC_Thread_01_B3 b3_0;
        volatile RC_Thread_01_C2 c2_0;
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_A4(String strObjectName) {
            b3_0 = null;
            c2_0 = null;
            a = 104;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_A4_"+strObjectName);
        }
        void add() {
            sum = a + b3_0.a + c2_0.a;
        }
    }
    class RC_Thread_01_B1 {
        volatile RC_Thread_01_D2 d2_0;
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_B1(String strObjectName) {
            d2_0 = null;
            a = 201;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B1_"+strObjectName);
        }
        void add() {
            sum = a + d2_0.a;
        }
    }
    class RC_Thread_01_B2 {
        volatile RC_Thread_01_C1 c1_0;
        volatile RC_Thread_01_D1 d1_0;
        volatile RC_Thread_01_D2 d2_0;
        volatile RC_Thread_01_D3 d3_0;
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_B2(String strObjectName) {
            c1_0 = null;
            d1_0 = null;
            d2_0 = null;
            d3_0 = null;
            a = 202;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B2_"+strObjectName);
        }
        void add() {
            sum = a + c1_0.a + d1_0.a + d2_0.a + d3_0.a;
        }
    }
    class RC_Thread_01_B3 {
        volatile RC_Thread_01_C1 c1_0;
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_B3(String strObjectName) {
            c1_0 = null;
            a = 203;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_B3_"+strObjectName);
        }
        void add() {
            sum = a + c1_0.a;
        }
    }
    class RC_Thread_01_C1 {
        volatile RC_Thread_01_D1 d1_0;
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_C1(String strObjectName) {
            d1_0 = null;
            a = 301;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C1_"+strObjectName);
        }
        void add() {
            sum = a + d1_0.a;
        }
    }
    class RC_Thread_01_C2 {
        volatile RC_Thread_01_D2 d2_0;
        volatile RC_Thread_01_D3 d3_0;
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_C2(String strObjectName) {
            d2_0 = null;
            d3_0 = null;
            a = 302;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_C2_"+strObjectName);
        }
        void add() {
            sum = a + d2_0.a + d3_0.a;
        }
    }
    class RC_Thread_01_D1 {
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_D1(String strObjectName) {
            a = 401;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D1_"+strObjectName);
        }
        void add() {
            sum = a + a;
        }
    }
    class RC_Thread_01_D2 {
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_D2(String strObjectName) {
            a = 402;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D2_"+strObjectName);
        }
        void add() {
            sum = a + a;
        }
    }
    class RC_Thread_01_D3 {
        int a;
        int sum;
        String strObjectName;
        RC_Thread_01_D3(String strObjectName) {
            a = 403;
            sum = 0;
            this.strObjectName = strObjectName;
//	    System.out.println("RC-Testing_Construction_D3_"+strObjectName);
        }
        void add() {
            sum = a + a;
        }
    }
}
