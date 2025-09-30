/*
 *- @TestCaseID: ReflectionGetDeclaredAnnotations2
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:ReflectionGetDeclaredAnnotations2.java
 *- @Title/Destination: Class.GetDeclaredAnnotations() does not result annotations that inherited from parent class.
 *- @Condition: no
 *- @Brief:no:
 * -#step1: Define two annotation.
 * -#step2：Use classloader to load class.
 * -#step3：Return an array of annotations by calling GetDeclaredAnnotations().
 * -#step4: Check that Class.GetDeclaredAnnotations() retrieves all annotations but annotations those inherited from
 *          parent class.
 *- @Expect: 0\n
 *- @Priority: High
 *- @Remark:
 *- @Source: ReflectionGetDeclaredAnnotations2.java
 *- @ExecuteClass: ReflectionGetDeclaredAnnotations2
 *- @ExecuteArgs:
 */

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface Ddd2 {
    int i() default 0;

    String t() default "";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface Ddd2_a {
    int i_a() default 2;

    String t_a() default "";
}

@Ddd2(i = 333, t = "test1")
class GetDeclaredAnnotations2 {
    public int i;
    public String t;
}

@Ddd2_a(i_a = 666, t_a = "right1")
class GetDeclaredAnnotations2_a extends GetDeclaredAnnotations2 {
    public int i_a;
    public String t_a;
}

class GetDeclaredAnnotations2_b extends GetDeclaredAnnotations2_a {
}

public class ReflectionGetDeclaredAnnotations2 {

    public static void main(String[] args) {
        int result = 0; /* STATUS_Success */
        try {
            Class zqp1 = Class.forName("GetDeclaredAnnotations2_b");
            if (zqp1.getDeclaredAnnotations().length == 0) {
                result = 0;
            }
        } catch (ClassNotFoundException e1) {
            System.err.println(e1);
            result = -1;
        } catch (NullPointerException e2) {
            System.err.println(e2);
            result = -1;
        }
        System.out.println(result);
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n
