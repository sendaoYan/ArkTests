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
 * -@TestCaseID:Alloc_Threadm_256x8B_2
 * -@TestCaseName:MyselfClassName
 * -@RequirementName:[运行时需求]支持自动内存管理
 * -@Title:ROS Allocator is in charge of applying and releasing objects.This mulit thread testcase is mainly for testing
 *         objects from 192*8B to 256*8B(max) with 6 threads and time sleep
 * -@Brief:functionTest
 * -@Expect:ExpectResult\n
 * -@Priority: High
 * -@Source: Alloc_Threadm_256x8B_2.java
 * -@ExecuteClass: Alloc_Threadm_256x8B_2
 * -@ExecuteArgs:
 */

import java.util.ArrayList;

class Alloc_Threadm_256x8B_2_01 extends Thread {
    private static final int PAGE_SIZE = 4 * 1024;
    private static final int OBJ_HEADSIZE = 8;
    private static final int MAX_256_8B = 256 * 8;
    private static boolean checkOut = false;

    public void run() {
        ArrayList<byte[]> store = new ArrayList<byte[]>();
        byte[] temp;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // do nothing
        }
        int check_size = 0;
        for (int i = 192 * 8 - OBJ_HEADSIZE; i <= MAX_256_8B - OBJ_HEADSIZE; i = i + 800) {
            for (int j = 0; j < (PAGE_SIZE * 1024 / (i + OBJ_HEADSIZE) + 10); j++) {
                if (j % 1000 == 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                }
                temp = new byte[i];
                store.add(temp);
                check_size++;
                store = new ArrayList<byte[]>();
            }
        }
        if (check_size == 2740) {
            checkOut = true;
        }
    }

    public boolean check() {
        return checkOut;
    }
}

public class Alloc_Threadm_256x8B_2 {
    public static void main(String[] args) {
        Runtime.getRuntime().gc();
        Alloc_Threadm_256x8B_2_01 test1 = new Alloc_Threadm_256x8B_2_01();
        test1.start();
        Alloc_Threadm_256x8B_2_01 test2 = new Alloc_Threadm_256x8B_2_01();
        test2.start();
        Alloc_Threadm_256x8B_2_01 test3 = new Alloc_Threadm_256x8B_2_01();
        test3.start();
        Alloc_Threadm_256x8B_2_01 test4 = new Alloc_Threadm_256x8B_2_01();
        test4.start();
        try {
            test1.join();
            test2.join();
            test3.join();
            test4.join();
        } catch (InterruptedException e) {
            // do nothing
        }
        if (test1.check() && test2.check() && test3.check() && test4.check()) {
            System.out.println("ExpectResult");
        } else {
            System.out.println("Error");
        }
    }

}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\n