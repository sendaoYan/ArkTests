/*
 * - @TestCaseID: ConstructorGetTypeParameters.java
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:ConstructorGetTypeParameters.java
 * - @Title/Destination: Constructor.getTypeParameters() returns an array of length 0 if the underlying generic
 *                       declaration declares no type variables.
 * - @Condition: no
 * - @Brief:no:
 *  -#step1: 定义含注解的内部类MyTargetTest03。
 *  -#step2：通过调用getConstructor(Class[])从内部类MyTargetTest03中获取对应的构造方法。
 *  -#step3：调用getTypeParameters()获取TypeVariable对象的数组。
 *  -#step4：确认返回的数组长度是0。
 * - @Expect: 0\n
 * - @Priority: High
 * - @Remark:
 * - @Source: ConstructorGetTypeParameters.java
 * - @ExecuteClass: ConstructorGetTypeParameters
 * - @ExecuteArgs:
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.TypeVariable;

public class ConstructorGetTypeParameters {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyTarget {
        public String name();
        public String value();
    }

    public static void main(String[] args) {
        int result = 2;
        try {
            result = ConstructorGetTypeParameters1();
        } catch (Exception e) {
            e.printStackTrace();
            result = 3;
        }
        System.out.println(result);
    }

    public static int ConstructorGetTypeParameters1() {
        Constructor<MyTargetTest03> m;
        try {
            m = MyTargetTest03.class.getConstructor(new Class[] {ConstructorGetTypeParameters.class, String.class});
            TypeVariable<Constructor<MyTargetTest03>>[] Target = m.getTypeParameters();
            if (Target.length == 0) {
                return 0;
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return 2;
    }

    class MyTargetTest03 {
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
        public MyTargetTest03(String home) {
            this.home = home;
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n
