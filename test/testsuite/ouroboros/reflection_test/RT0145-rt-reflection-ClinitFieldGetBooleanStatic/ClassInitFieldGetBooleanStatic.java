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
 * -@TestCaseID: ClassInitFieldGetBooleanStatic
 *- @RequirementName: Java Reflection
 *- @TestCaseName:ClassInitFieldGetBooleanStatic.java
 *- @Title/Destination: When f is a static field of class One and call f.getBoolean(), class One is initialized.
 *- @Brief:no:
 * -#step1: Class.forName("One" , false, One.class.getClassLoader()) and clazz.getField to get a static field f of class
 *          One.
 * -#step2: Call method f.getBoolean(null), class One is initialized.
 *- @Expect: 0\n
 *- @Priority: High
 *- @Source: ClassInitFieldGetBooleanStatic.java
 *- @ExecuteClass: ClassInitFieldGetBooleanStatic
 *- @ExecuteArgs:
 */

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class ClassInitFieldGetBooleanStatic {
    static StringBuffer result = new StringBuffer("");

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("One", false, One.class.getClassLoader());
            Field f = clazz.getField("hiBoolean");
            if (result.toString().compareTo("") == 0) {
                f.getBoolean(null);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (result.toString().compareTo("SuperOne") == 0) {
            System.out.println(0);
        } else {
            System.out.println(2);
        }
    }
}

@A
class Super {
    static {
        ClassInitFieldGetBooleanStatic.result.append("Super");
    }
}

interface InterfaceSuper {
    String a = ClassInitFieldGetBooleanStatic.result.append("|InterfaceSuper|").toString();
}

@A(i = 1)
class One extends Super implements InterfaceSuper {
    static {
        ClassInitFieldGetBooleanStatic.result.append("One");
    }

    public static boolean hiBoolean = false;
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface A {
    int i() default 0;
    String a = ClassInitFieldGetBooleanStatic.result.append("|InterfaceA|").toString();
}

class Two extends One {
    static {
        ClassInitFieldGetBooleanStatic.result.append("Two");
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n