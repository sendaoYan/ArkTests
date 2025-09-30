/*
 *- @TestCaseID: RTFieldGetModifiers
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:RTFieldGetModifiers.java
 *- @Title/Destination: Field.GetModifiers() Returns the Java language modifiers for the field represented by this Field
 *                      object, as an integer.
 *- @Condition: no
 *- @Brief:no:
 * -#step1: 定义含受保护的今天成员变量的类FieldGetModifiers。
 * -#step2: 通过调用forName()方法加载类FieldGetModifiers。
 * -#step3: 通过调用getField()、getDeclaredField()获取对应名称的成员变量。
 * -#step4: 通过调用getModifiers()获取对应字段的Java语言修饰符,调用equals()方法进行判断描述正确。
 *- @Expect: 0\n
 *- @Priority: High
 *- @Remark:
 *- @Source: RTFieldGetModifiers.java
 *- @ExecuteClass: RTFieldGetModifiers
 *- @ExecuteArgs:
 */

import java.lang.reflect.Field;

class FieldGetModifiers {
    public static int num;
    final String str = "aaa";
    private String string = "ccc";
    protected static int number;
}

public class RTFieldGetModifiers {
    public static void main(String[] args) {
        try {
            Class cls = Class.forName("FieldGetModifiers");
            Field instance1 = cls.getField("num");
            Field instance2 = cls.getDeclaredField("str");
            Field instance3 = cls.getDeclaredField("string");
            Field field = cls.getDeclaredField("number");
            if (instance1.getModifiers() == 9 && instance2.getModifiers() == 16 && instance3.getModifiers() == 2
                    && field.getModifiers()
                    == 12) {
                System.out.println(0);
            }
        } catch (ClassNotFoundException e1) {
            System.err.println(e1);
            System.out.println(2);
        } catch (NoSuchFieldException e2) {
            System.err.println(e2);
            System.out.println(2);
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n
