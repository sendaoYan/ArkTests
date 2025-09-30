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
 * -@TestCaseID: ClassInitFieldSetDoubleInterface
 *- @RequirementName: Java Reflection
 *- @TestCaseName:ClassInitFieldSetDoubleInterface.java
 *- @Title/Destination: When f is a field of interface OneInterface and call f.setDouble(), OneInterface is initialized,
 *                      it's parent interface is not initialized.
 *- @Brief:no:
 * -#step1: Class.forName("OneInterface", false, OneInterface.class.getClassLoader()) and clazz.getField to get field f
 *          of OneInterface.
 * -#step2: Call method f.setDouble(null), OneInterface is initialized.
 *- @Expect: 0\n
 *- @Priority: High
 *- @Source: ClassInitFieldSetDoubleInterface.java
 *- @ExecuteClass: ClassInitFieldSetDoubleInterface
 *- @ExecuteArgs:
 */

import java.lang.reflect.Field;

public class ClassInitFieldSetDoubleInterface {
    static StringBuffer result = new StringBuffer("");

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("OneInterface", false, OneInterface.class.getClassLoader());
            Field f = clazz.getField("hiDouble");
            if (result.toString().compareTo("") == 0) {
                f.setDouble(null, 0.265874);
            }
        } catch (IllegalAccessException e) {
            result.append("IllegalAccessException");
        } catch (Exception e) {
            System.out.println(e);
        }

        if (result.toString().compareTo("OneIllegalAccessException") == 0) {
            System.out.println(0);
            return;
        } else {
            System.out.println(2);
            return;
        }
    }
}

interface SuperInterface {
    String aSuper = ClassInitFieldSetDoubleInterface.result.append("Super").toString();
}

@A
interface OneInterface extends SuperInterface {
    String aOne = ClassInitFieldSetDoubleInterface.result.append("One").toString();
    double hiDouble = 0.1532;
}

interface TwoInterface extends OneInterface {
    String aTwo = ClassInitFieldSetDoubleInterface.result.append("Two").toString();
}

@interface A {
    String aA = ClassInitFieldSetDoubleInterface.result.append("Annotation").toString();
}

// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n