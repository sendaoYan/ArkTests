/*
 *- @testCaseID: ReflectionAnnotationGetClass
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:ReflectionAnnotationGetClass.java
 *- @Title/Destination: Try to getClass of an Annotation, the result should contain "class $Proxy". add for
 *                      DTS2018122012009.
 *- @Condition: no
 *- @Brief:no:
 * -#step1: Define an Annotation A0 and define Class Two has one annotation A0.
 * -#step2: Get class by forName("Two"), call getAnnotations() of the get class.
 * -#step3: Check the Class of get annotation is "class $Proxy0".
 * -#step4: Get class by forName("java.lang.annotation.Documented"), call getAnnotations() of the get class.
 * -#step5: Check the three Class of get annotation is "class $Proxy1", "class $Proxy2", "class $Proxy3".
 *- @Expect: 0\n
 *- @Priority: High
 *- @Remark:
 *- @Source: ReflectionAnnotationGetClass.java
 *- @ExecuteClass: ReflectionAnnotationGetClass
 *- @ExecuteArgs:
 */

import java.lang.annotation.*;
import java.util.Arrays;

public class ReflectionAnnotationGetClass {
    public static void main(String[] args) {
        int result = 2;
        try{
            // Check point 1 : only 1 annotation in user-defined Class Two.
            Annotation[] annotations1 = Class.forName("Two").getAnnotations();
            if (annotations1.length == 1){
                if (annotations1[0].getClass().toString().startsWith("class $Proxy")) {
                    result --;
                }
            }

            // Check point 2 : 3 annotations in Class java.lang.annotation.Documented.
            Annotation[] annotations2 = Class.forName("java.lang.annotation.Documented").getAnnotations();
            String [] annoClazz = new String[annotations2.length];
            for (int i = 0; i < annoClazz.length; i++) {
                annoClazz[i] = annotations2[i].getClass().toString();
            }
            Arrays.sort(annoClazz);
            if (annotations2.length == 3) {
                if (annoClazz[0].startsWith("class $Proxy") && annoClazz[1]
                        .startsWith("class $Proxy")
                        && annoClazz[2].startsWith("class $Proxy")) {
                    result --;
                }
            }
        }catch (Exception e) {
            result = 3;
        }
        System.out.println(result);
    }
}

@A0
class Two{}

@Retention(RetentionPolicy.RUNTIME) @interface A0 {}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n
