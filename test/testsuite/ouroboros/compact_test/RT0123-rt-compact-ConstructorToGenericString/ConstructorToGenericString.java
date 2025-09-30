/*
 * - @TestCaseID: ConstructorToGenericString.java
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:ConstructorToGenericString.java
 * - @Title/Destination: Constructor.toGenericString() returns a string describing this Constructor, including type
 *                       parameters.
 * - @Condition: no
 * - @Brief:no:
 *  -#step1: 定义含注解的内部类MyTargetTest04。
 *  -#step2：通过调用getConstructor(Class[])从内部类MyTargetTest04中获取对应的构造方法。
 *  -#step3：调用toGenericString()获取描述此Field的字符串。
 *  -#step4：确认返回的描述正确。
 * - @Expect: 0\n
 * - @Priority: High
 * - @Remark:
 * - @Source: ConstructorToGenericString.java
 * - @ExecuteClass: ConstructorToGenericString
 * - @ExecuteArgs:
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;

public class ConstructorToGenericString {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyTarget {
        public String name();
        public String value();
    }

    public static void main(String[] args) {
        int result = 2;
        try {
            result = ConstructorToGenericString1();
        } catch (Exception e) {
            e.printStackTrace();
            result = 3;
        }
        System.out.println(result);
    }

    public static int ConstructorToGenericString1() {
        Constructor<MyTargetTest04> m;
        try {
            m = MyTargetTest04.class.getConstructor(new Class[] {ConstructorToGenericString.class, String.class});
            String str = m.toGenericString();
            if ("public ConstructorToGenericString$MyTargetTest04(ConstructorToGenericString,java.lang.String)"
                    .equals(str)) {
                return 0;
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return 2;
    }

    class MyTargetTest04 {
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
        public MyTargetTest04(String home) {
            this.home = home;
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n
