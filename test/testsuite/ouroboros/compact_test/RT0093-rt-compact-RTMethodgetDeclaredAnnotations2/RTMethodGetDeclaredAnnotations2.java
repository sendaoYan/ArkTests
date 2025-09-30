/*
 *- @TestCaseID: RTMethodGetDeclaredAnnotations2
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:RTMethodGetDeclaredAnnotations2.java
 *- @Title/Destination: When the target class method has the same name as its parent class method, it is obtained by
 *                      reflection as the annotation of the method in the target class, not the method of its parent
 *                      class
 *- @Condition: no
 *- @Brief:no:
 * -#step1: 通过Class.forName()方法获取MethodGetDeclaredAnnotations2_a类的运行时类clazz；
 * -#step2: 以ii、String.class为参数，通过getMethod()方法获取clazz的方法对象并记为method1；
 * -#step3: 以tt为参数，通过getDeclaredMethod()方法获取clazz的声明方法并记为method2；
 * -#step4: 经判断得知method1.getDeclaredAnnotations()和method2.getDeclaredAnnotations()的返回值的长度均为0；
 *- @Expect: 0\n
 *- @Priority: High
 *- @Remark:
 *- @Source: RTMethodGetDeclaredAnnotations2.java
 *- @ExecuteClass: RTMethodGetDeclaredAnnotations2
 *- @ExecuteArgs:
 */

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface IFw2 {
    int i() default 0;
    String t() default "";
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface IFw2_a {
    int i_a() default 2;
    String t_a() default "";
}

class MethodGetDeclaredAnnotations2 {
    @IFw2(i = 333, t = "test1")
    public static void ii(String name) {
    }

    @IFw2_a(i_a = 666, t_a = "right1")
    void tt(int number) {
    }
}

class MethodGetDeclaredAnnotations2_a extends MethodGetDeclaredAnnotations2 {
    public static void ii(String name) {
    }

    void tt() {
    }
}

public class RTMethodGetDeclaredAnnotations2 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("MethodGetDeclaredAnnotations2_a");
            Method method1 = clazz.getMethod("ii", String.class);
            Method method2 = clazz.getDeclaredMethod("tt");
            if (method1.getDeclaredAnnotations().length == 0 && method2.getDeclaredAnnotations().length == 0) {
                System.out.println(0);
            }
        } catch (ClassNotFoundException e) {
            System.err.println(e);
            System.out.println(2);
        } catch (NoSuchMethodException e1) {
            System.err.println(e1);
            System.out.println(2);
        } catch (NullPointerException e2) {
            System.err.println(e2);
            System.out.println(2);
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n
