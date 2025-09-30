/*
 * - @TestCaseID: MethodToGenericString
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:MethodToGenericString.java
 * - @Title/Destination: Method.toGenericString() Returns a string describing this Method, including type parameters.
 * - @Condition: no
 * - @Brief:no:
 *  -#step1: 定义含注解的内部类MyTargetTest15。
 *  -#step2：通过调用getMethod()从内部类MyTargetTest15中获取MyTargetTest_1。
 *  -#step3：调用toGenericString()获取描述此Method的字符串。
 *  -#step4：确认返回的描述正确。
 * - @Expect: 0\n
 * - @Priority: High
 * - @Remark:
 * - @Source: MethodToGenericString.java
 * - @ExecuteClass: MethodToGenericString
 * - @ExecuteArgs:
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class MethodToGenericString {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyTarget {
        public String name();
        public String value();
    }

    public static void main(String[] args) {
        int result = 2;
        try {
            result = MethodToGenericString1();
        } catch (Exception e) {
            e.printStackTrace();
            result = 3;
        }
        System.out.println(result);
    }

    public static int MethodToGenericString1() {
        Method m;
        try {
            m = MyTargetTest17.class.getMethod("MyTargetTest_1");
            String str = m.toGenericString();
            if ("public void MethodToGenericString$MyTargetTest17.MyTargetTest_1()".equals(str)) {
                return 0;
            }
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return 2;
    }

    class MyTargetTest17 {
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
        public MyTargetTest17(String home) {
            this.home = home;
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n
