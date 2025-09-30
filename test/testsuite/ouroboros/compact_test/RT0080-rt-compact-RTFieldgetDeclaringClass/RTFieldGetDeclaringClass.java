/*
 *- @TestCaseID: RTFieldGetDeclaringClass
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:RTFieldGetDeclaringClass.java
 *- @Title/Destination: Field.GetDeclaringClass() returns the class object of the class declaring the field represented
 *                      by this Field object.
 *- @Condition: no
 *- @Brief:no:
 * -#step1: 定义类FieldGetDeclaringClass。
 * -#step2: 通过调用forName()方法加载类FieldGetDeclaringClass。
 * -#step3: 通过调用 getField()、getDeclaredField()获取对应名称的成员变量。
 * -#step4: 通过调用FieldGetDeclaringClass()获取类对象，调用equals()方法进行判断获取正确。
 *- @Expect: 0\n
 *- @Priority: High
 *- @Remark:
 *- @Source: RTFieldGetDeclaringClass.java
 *- @ExecuteClass: RTFieldGetDeclaringClass
 *- @ExecuteArgs:
 */

import java.lang.reflect.Field;

class FieldGetDeclaringClass {
    public int num;
    char aChar;
}

public class RTFieldGetDeclaringClass {
    public static void main(String[] args) {
        try {
            Class cls = Class.forName("FieldGetDeclaringClass");
            Field instance1 = cls.getField("num");
            Field instance2 = cls.getDeclaredField("aChar");
            Class<?> j = instance1.getDeclaringClass();
            Class<?> k = instance2.getDeclaringClass();
            if (j.getName().equals("FieldGetDeclaringClass") && k.getName().equals("FieldGetDeclaringClass")) {
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
