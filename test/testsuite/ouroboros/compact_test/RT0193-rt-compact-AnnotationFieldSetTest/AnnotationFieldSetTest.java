/*
 *- @TestCaseID: Maple_Annotation_invoke_AnnotationSetTest
 *- @RequirementName: Java Reflection
 *- @RequirementID: SR000B7N9H
 *- @TestCaseName:AnnotationFieldSetTest.java
 *- @TestCaseName: AnnotationFieldSetTest
 *- @TestCaseType: Function Testing
 *- @RequirementID: AR000D0OR6
  *- @RequirementName: annotation
 *- @Title/Destination: positive test for User-defined Annotation with @Target(ElementType.FIELD)
 *- @Condition: no
 *- @Brief:no:
 * -#step1. User-defined Annotation with @Target(ElementType.FIELD) has field with primitive type, String, ENUM, annotation, class and their array
 * -#step2. verify able to set and get value for non-static field
 *- @Expect:0\n
 *- @Priority: Level 1
 *- @Remark:
 *- @Source: AnnotationFieldSetTest.java AnnoA.java AnnoB.java
 *- @ExecuteClass: AnnotationFieldSetTest
 *- @ExecuteArgs:
 */

import java.util.Arrays;

public class AnnotationFieldSetTest {
    static int[] passCnt;
    public static void main(String[] args) throws NoSuchFieldException {
        AnnoA anno = Test.class.getDeclaredField("a").getAnnotation(AnnoA.class);
        passCnt = new int[24];
        // 基本数据类型
        int i = 0;
        passCnt[i++] = anno.intA() == Integer.MAX_VALUE ? 1: 0;
        passCnt[i++] += anno.byteA() == Byte.MAX_VALUE ? 1: 0;
        passCnt[i++] += anno.charA() == Character.MAX_VALUE ? 1: 0;
        passCnt[i++] += Double.isNaN(anno.doubleA()) ? 1: 0;
        passCnt[i++] += anno.booleanA() ? 1: 0;
        passCnt[i++] += anno.longA() == Long.MAX_VALUE ? 1: 0;
        passCnt[i++] += Float.isNaN(anno.floatA())? 1: 0;
        passCnt[i++] += anno.shortA() == Short.MAX_VALUE ? 1: 0;

        //enum, string, annotation, class
        passCnt[i++] += anno.stateA() == Thread.State.BLOCKED ? 1: 0;
        passCnt[i++] += anno.stringA().compareTo("") == 0 ? 1: 0;
        passCnt[i++] += anno.classA() == Thread.class ? 1: 0;
        passCnt[i++] += Arrays.toString(anno.intAA()).compareTo("[1, 2]") == 0 ? 1: 0;

        //基本类型数组
        passCnt[i++] += (anno.byteAA().length == 1 && anno.byteAA()[0] == 0) ? 1: 0;
        passCnt[i++] += (anno.charAA().length == 1 && anno.charAA()[0] == ' ') ? 1: 0;
        passCnt[i++] += (anno.doubleAA().length == 3 && Double.isNaN(anno.doubleAA()[0]) && Double.isInfinite(anno.doubleAA()[1]) && Double.isInfinite(anno.doubleAA()[2]))? 1: 0;
        passCnt[i++] += (anno.booleanAA().length == 1 && anno.booleanAA()[0]) ? 1: 0;
        passCnt[i++] += (anno.longAA().length == 1 && anno.longAA()[0] == Long.MAX_VALUE) ? 1: 0;
        passCnt[i++] += (anno.floatAA().length == 3 && Float.isNaN(anno.floatAA()[0]) && Float.isInfinite(anno.floatAA()[1]) && Float.isInfinite(anno.floatAA()[2])) ? 1: 0;
        passCnt[i++] += (anno.shortAA().length == 1 && anno.shortAA()[0] == 0) ? 1: 0;
        passCnt[i++] += (anno.stringAA().length == 1 && anno.stringAA()[0].compareTo("")==0) ? 1: 0;
        passCnt[i++] += (anno.classAA().length == 1 && anno.classAA()[0] == Thread.class)? 1: 0;
        passCnt[i++] += (anno.stateAA().length == 1 && anno.stateAA()[0] == Thread.State.NEW) ? 1: 0;
        passCnt[i++] += anno.annoBA().toString().compareTo("@AnnoB(intB=999)")==0 ? 1: 0;
        passCnt[i++] += Arrays.toString(anno.annoBAA()).compareTo("[@AnnoB(intB=999), @AnnoB(intB=999)]") == 0 ? 1: 0;
        System.out.println(Arrays.toString(passCnt).compareTo("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]"));
    }
}

class Test{
    @AnnoA(intA = Integer.MAX_VALUE, byteA = Byte.MAX_VALUE, charA = Character.MAX_VALUE, doubleA = Double.NaN,
            booleanA = true, longA = Long.MAX_VALUE, floatA = Float.NaN, shortA = Short.MAX_VALUE,
            intAA = {1,2}, byteAA = {0}, charAA = {' '}, doubleAA = {Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY},
            booleanAA = {true}, longAA = {Long.MAX_VALUE}, floatAA = {Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY}, shortAA = {0},
            stringA = "", stringAA = "", classA = Thread.class, classAA = Thread.class, stateA = Thread.State.BLOCKED,
            stateAA = Thread.State.NEW, annoBA = @AnnoB, annoBAA = {@AnnoB, @AnnoB})
    String a;
}
// DEPENDENCE: AnnoA.java AnnoB.java
// EXEC:%maple  %f AnnoA.java AnnoB.java %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full 0\n
