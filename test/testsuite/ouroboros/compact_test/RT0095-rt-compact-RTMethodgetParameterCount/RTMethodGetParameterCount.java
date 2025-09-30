/*
 *- @TestCaseID: RTMethodGetParameterCount
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:RTMethodGetParameterCount.java
 *- @Title/Destination: Method.GetParameterCount() Returns the number of formal parameters (whether explicitly declared
 *                      or implicitly declared or neither) for the executable represented by this object.
 *- @Condition: no
 *- @Brief:no:
 * -#step1: 通过Class.forName()方法获取MethodGetParameterCount2类的运行时类clazz；
 * -#step2: 以test1为参数，通过getDeclaredMethod()方法获取clazz的声明方法并记为method1；
 * -#step3: 通过getMethods()方法获取clazz的所有的方法对象并记为methods；
 * -#step4: 经判断得知method.getParameterCount()的返回值为0，即method的参数个数为0；而methods[0].getParameterCount()的返
 *          回值为9，即methods[0]的所有的参数个数为9；
 *- @Expect: 0\n
 *- @Priority: High
 *- @Remark:
 *- @Source: RTMethodGetParameterCount.java
 *- @ExecuteClass: RTMethodGetParameterCount
 *- @ExecuteArgs:
 */

import java.lang.reflect.Method;

class MethodGetParameterCount2 {
    void test1() {
    }

    public void test2(String name, int number, char c, short s, float f, double d, long l, boolean b, byte bb) {
    }
}

public class RTMethodGetParameterCount {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("MethodGetParameterCount2");
            Method method = clazz.getDeclaredMethod("test1");
            Method[] methods = clazz.getMethods();
            if (method.getParameterCount() == 0) {
                if (methods[0].getParameterCount() == 9) {
                    System.out.println(0);
                }
            }
        } catch (ClassNotFoundException e1) {
            System.err.println(e1);
            System.out.println(2);
        } catch (NoSuchMethodException e2) {
            System.err.println(e2);
            System.out.println(2);
        }
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n
