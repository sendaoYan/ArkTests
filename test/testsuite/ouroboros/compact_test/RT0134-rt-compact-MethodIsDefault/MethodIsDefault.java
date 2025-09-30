/*
 * - @TestCaseID: MethodIsDefault
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:MethodIsDefault.java
 * - @Title/Destination: Method.isDefault() Returns true if this method is a default method。
 * - @Condition: no
 * - @Brief:no:
 *  -#step1: 定义含注解的内部类MyTargetTest16。
 *  -#step2：通过调用getMethod()从内部类MyTargetTest16中获取MyTargetTest_1。
 *  -#step3：调用isDefault()判断是否是default method。
 *  -#step4：确认返回false。
 * - @Expect: 0\n
 * - @Priority: High
 * - @Remark:
 * - @Source: MethodIsDefault.java
 * - @ExecuteClass: MethodIsDefault
 * - @ExecuteArgs:
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class MethodIsDefault {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyTarget {
        public String name();
        public String value();
    }

    public static void main(String[] args) {
        int result = 2;
        try {
            result = MethodIsDefault1();
        } catch (Exception e) {
            e.printStackTrace();
            result = 3;
        }
        System.out.println(result);
    }

    public static int MethodIsDefault1() {
        Method m;
        try {
            m = MyTargetTest16.class.getMethod("MyTargetTest_1");
            boolean flag = m.isDefault();
            if (!flag) {
                return 0;
            }
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return 2;
    }

    class MyTargetTest16 {
        @MyTarget(name = "newName", value = "newValue")
        public String home;

        @MyTarget(name = "name", value = "value")
        public void MyTargetTest_1() {
            System.out.println("This is Example:hello world");
        }

        public void newMethod(@MyTarget(name = "name1", value = "value1") String home) {
            System.out.println("my home at:" + home);
        }

        @MyTarget(name = "cons", value = "constructor")
        public MyTargetTest16(String home) {
            this.home = home;
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n
