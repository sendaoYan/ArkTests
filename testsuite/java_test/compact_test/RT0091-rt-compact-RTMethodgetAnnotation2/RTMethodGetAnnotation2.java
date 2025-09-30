/*
 * Copyright (c) [2021] Huawei Technologies Co.,Ltd.All rights reserved.
 *
 * OpenArkCompiler is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 *
 *     http://license.coscl.org.cn/MulanPSL2
 *
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR
 * FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
*/


import java.lang.annotation.*;
import java.lang.reflect.Method;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
@Documented
@Inherited
@interface IF2 {
    int i() default 0;
    String t() default "";
}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@Documented
@Inherited
@interface IF2_a {
    int c() default 0;
    String d() default "";
}
class MethodGetAnnotation2 {
    @IF2(i = 333, t = "MethodGetAnnotation")
    public void test1() {
    }
    @IF2_a(c = 666, d = "Method")
    void test3(int number) {
    }
}
public class RTMethodGetAnnotation2 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("MethodGetAnnotation2");
            Method method1 = clazz.getDeclaredMethod("test3", int.class);
            Method method2 = clazz.getMethod("test1");
            if (method1.getAnnotation(IF2_a.class) == null && method2.getAnnotation(IF2.class) == null) {
                System.out.println(0);
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
