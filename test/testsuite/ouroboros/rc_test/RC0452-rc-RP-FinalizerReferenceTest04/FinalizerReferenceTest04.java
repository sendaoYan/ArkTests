/*
 *- @TestCaseID: Maple_MemoryManagement2.0_FinalizerReferenceTest04
 *- @TestCaseName: FinalizerReferenceTest04
 *- @TestCaseType: Function Testing for FinalizerReference Test
 *- @RequirementName: 运行时支持GCOnly
 *- @Condition:no
 *  -#c1: 测试环境正常
 *- @Brief:测试正常情况下，Cleaner+FinalizerReference指向的对象
 *  -#step1: 创建带有重构finalize方法的类ReferenceTest04;
 *  -#step2: 创建一个cleaner引用指向ReferenceTest04的实例。
 *  -#step3: 触发用户GC，虚引用无法通过get获得，finalize方法被调用。
 *- @Expect:ExpectResult\n
 *- @Priority: High
 *- @Source: FinalizerReferenceTest04.java
 *- @ExecuteClass: FinalizerReferenceTest04
 *- @ExecuteArgs:
 *- @Remark:
 */

import sun.misc.Cleaner;

public class FinalizerReferenceTest04 {
    static Cleaner cleaner;

    public static void main(String[] args) {
        Cleaner.create(new ReferenceTest04(10), null);
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
    }
}

class ReferenceTest04 {
    String[] stringArray;

    public ReferenceTest04(int length) {
        stringArray = new String[length];
        for (int i = 0; i < length; i++) {
            stringArray[i] = "test" + i;
        }
    }

    @Override
    public void finalize() {
        for (int i = 0; i < this.stringArray.length; i++) {
            stringArray[i] = null;
        }
        System.out.println("ExpectResult");
    }
}
// EXEC:%maple  %f %build_option -o %n.so
// EXEC:%run %n.so %n %run_option | compare %f
// ASSERT: scan-full ExpectResult\n
