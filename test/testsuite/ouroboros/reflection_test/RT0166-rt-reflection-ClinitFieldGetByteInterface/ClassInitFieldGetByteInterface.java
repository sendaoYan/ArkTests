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
 * -@TestCaseID: ClassInitFieldGetByteInterface
 *- @RequirementName: Java Reflection
 *- @TestCaseName:ClassInitFieldGetByteInterface.java
 *- @Title/Destination: When f is a field of interface OneInterface and call f.getByte(), OneInterface is initialized,
 *                      it's parent interface is not initialized.
 *- @Brief:no:
 * -#step1: Class.forName("OneInterface", false, OneInterface.class.getClassLoader()) and clazz.getField to get field f
 *          of OneInterface.
 * -#step2: Call method f.getByte(null), OneInterface is initialized.
 *- @Expect: 0\n
 *- @Priority: High
 *- @Source: ClassInitFieldGetByteInterface.java
 *- @ExecuteClass: ClassInitFieldGetByteInterface
 *- @ExecuteArgs:
 */

import java.lang.reflect.Field;

public class ClassInitFieldGetByteInterface {
    static StringBuffer result = new StringBuffer("");

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("OneInterface", false, OneInterface.class.getClassLoader());
            Field f = clazz.getField("hiByte");
            if (result.toString().compareTo("") == 0) {
                f.getByte(null);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if (result.toString().compareTo("One") == 0) {
            System.out.println(0);
        } else {
            System.out.println(2);
        }
    }
}

interface SuperInterface {
    String aSuper = ClassInitFieldGetByteInterface.result.append("Super").toString();
}

@A
interface OneInterface extends SuperInterface {
    String aOne = ClassInitFieldGetByteInterface.result.append("One").toString();
    byte hiByte = (byte) 1;
}

interface TwoInterface extends OneInterface {
    String aTwo = ClassInitFieldGetByteInterface.result.append("Two").toString();
}

@interface A {
    String aA = ClassInitFieldGetByteInterface.result.append("Annotation").toString();
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n