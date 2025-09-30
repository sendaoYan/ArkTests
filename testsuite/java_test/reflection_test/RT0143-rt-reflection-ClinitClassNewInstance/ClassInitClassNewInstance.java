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
public class ClassInitClassNewInstance {
    static StringBuffer result = new StringBuffer("");
    public static void main(String[] args) {
        try{
            Class clazz = Class.forName("One", false, One.class.getClassLoader());
            /* Check point 1: no class initialization when calling following methods of Class
             * not test clazz.cast(Object obj) because it success only when obj is an instance of One or Two,
             * and need to call new One(), which result in Class initialization.*/

            clazz.asSubclass(clazz);
            clazz.desiredAssertionStatus();
            clazz.getAnnotation(A.class);
            clazz.getAnnotations();
            clazz.getAnnotationsByType(A.class);
            clazz.getCanonicalName();
            clazz.getClasses();
            clazz.getClassLoader();
            clazz.getComponentType();
            clazz.getConstructor(String.class);
            clazz.getConstructors();
            clazz.getDeclaredAnnotation(A.class);
            clazz.getDeclaredAnnotations();
            clazz.getDeclaredAnnotationsByType(A.class);
            clazz.getDeclaredClasses();
            clazz.getDeclaredConstructor(String.class);
            clazz.getDeclaredConstructors();
            clazz.getDeclaredField("what");
            clazz.getDeclaredFields();
            clazz.getDeclaredMethod("testOne", String.class);
            clazz.getDeclaredMethods();
            clazz.getDeclaringClass();
            clazz.getEnclosingClass();
            clazz.getEnclosingConstructor();
            clazz.getEnclosingMethod();
            clazz.getEnumConstants();
            clazz.getField("hi");
            clazz.getFields();
            clazz.getGenericInterfaces();
            clazz.getGenericSuperclass();
            clazz.getInterfaces();
            clazz.getMethod("testOne",String.class);
            clazz.getMethods();
            clazz.getModifiers();
            clazz.getName();
            clazz.getPackage();
            clazz.getProtectionDomain();
            clazz.getSigners();
            clazz.getSimpleName();
            clazz.getSuperclass();
            clazz.getTypeName();
            clazz.getTypeParameters();
            clazz.isAnnotation();
            clazz.isAnnotationPresent(A.class);
            clazz.isAnonymousClass();
            clazz.isArray();
            clazz.isAssignableFrom(clazz);
            clazz.isEnum();
            clazz.isInstance(new Object());
            clazz.isInterface();
            clazz.isLocalClass();
            clazz.isMemberClass();
            clazz.isPrimitive();
            clazz.isSynthetic();
            clazz.toString();
            clazz.toGenericString();
            clazz.getResource("hi");
            clazz.getResourceAsStream("hi");
            // Check point 2: when call newInstance, start class initialization
            if (result.toString().compareTo("") == 0) {
                clazz.newInstance();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (result.toString().compareTo("SuperOne") == 0) {
            System.out.println(0);
        } else {
            System.out.println(2);
        }
    }
}
@A
class Super {
    static {
        ClassInitClassNewInstance.result.append("Super");
    }
}
interface InterfaceSuper {
    String a = ClassInitClassNewInstance.result.append("|InterfaceSuper|").toString();
}
@A(i=1)
class One extends Super implements InterfaceSuper {
    static {
        ClassInitClassNewInstance.result.append("One");
    }
    String what = "lala";
    public String hi = "";
    One(){}
    public One(String s){
        what = s;
        System.out.println(s);
    }
    public int testOne(String a){
        System.out.println(a);
        return 0;
    }
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface A {
    int i() default 0;
    String a = ClassInitClassNewInstance.result.append("|InterfaceA|").toString();
}
class Two extends One {
    static {
        ClassInitClassNewInstance.result.append("Two");
    }
}