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
 * -@TestCaseID: Maple_CompilerOptimization_LiverangeSubsumeRCTest01
 *- @TestCaseName: LiverangeSubsumeRCTest01
 *- @TestCaseType: Function Testing
 *- @RequirementName: Liverange subsumeRC优化
 *- @Brief:当确定一个对象的在某个生存区间内的存活状态时，去掉这个区间内的此对象的RC操作
 *  -#step1: 创建一个1个数组，先后用array1指针和array2指针指向了它;
 *  -#step2: 数组越界式的用一下这俩数组指针，第27行代码可以看出，array1指针存活状态包含了array2，所以array2的incref和decref都应该被优化掉。
 *  -#step3: str1 和str2同时指向一个字符串，str1指针存活状态包含了str2，所以str2的incref和decref都应该被优化掉。
 *  校验中间文件LiverangeSubsumeRCTest01.VtableImpl.mpl中无IncRef
 *- @Expect:ExpectResult\n
 *- @Priority: High
 *- @Source: LiverangeSubsumeRCTest01.java
 *- @ExecuteClass: LiverangeSubsumeRCTest01
 *- @ExecuteArgs:
 */

public class LiverangeSubsumeRCTest01 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = array1;
        String str1 = "ExpectResult";
        String str2 = str1;
        try {
            if (array2[10] == array1[10]) {
                System.out.print(str2); // 错误输出
            }
        } catch (Exception e) {
            System.out.println(str1);
        }
    }
}


// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\n