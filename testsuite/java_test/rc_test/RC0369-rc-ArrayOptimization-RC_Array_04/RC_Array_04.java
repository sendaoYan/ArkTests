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


import java.lang.reflect.Array;
import java.util.Arrays;
class Base_004{
    //Parent interface
    volatile boolean[] base1;
    boolean[][] base2;
    boolean[][] base21;
    boolean[][][] base3;
}
public class RC_Array_04 extends Base_004{
    static int check_count = 0;
    static boolean[] arr1 = {true,false,false,true};
    static boolean[][] arr2 = {{true,false,false,true},{false,false},{true,true}};
    static boolean[][] arr21 = {{false,true,false,true},{true,false},{false,true}};
    static boolean[][][] arr3 = {arr2,arr21};
    private RC_Array_04(){
        base1 = new boolean[]{true,true,true,true};
        base2 = new boolean[][]{{true,true,true,true},{false,false},{true,true}};
        base21 = new boolean[][]{{false,true,true,true},{false,true},{true,true}};
        base3 = new boolean[][][]{{{true,true,true,true},{false,false},{true,true}},{{false,true,true,true},{false,true},{true,true}}};
    }
    private RC_Array_04(boolean[] booleanar){
        base1 = booleanar;
    }
    private RC_Array_04(boolean[][] booleanarr){
        base2 = booleanarr;
    }
    private RC_Array_04(boolean[][][] booleanarrr){
        base3 = booleanarrr;
    }
    private RC_Array_04(boolean[] booleanar, boolean[][] booleanarr, boolean[][][] booleanarrr){
        base1 = booleanar;
        base2 = booleanarr;
        base3 = booleanarrr;
    }
    public static void main(String[] args) {
        final boolean[] TEST1 = {true,true,true,true};
        final boolean[][] TEST2 = {TEST1,{false,false},{true,true}};
        final boolean[][] TEST21 = {{false,true,true,true},{false,true},{true,true}};
        final boolean[][][] TEST3 = {TEST2,TEST21};
        //Initialization check
        if(TEST1.length == 4 && TEST2.length == 3 && TEST3.length == 2
                && arr1.length == 4 && arr2.length == 3 && arr3.length == 2)
            check_count++;
        else
            System.out.println("ErrorResult boolean step1");
        //test01 interface call, internal initialization array, do not modify the parameter value, only judge
        test01(4,TEST1,TEST2,TEST3);
        test01(4,arr1,arr2,arr3);
        if(TEST1.length == 4 && TEST2.length == 3 && TEST3.length == 2
                && arr1.length == 4 && arr2.length == 3 && arr3.length == 2)
            check_count++;
        else
            System.out.println("ErrorResult in step2");
        //test02 interface call, call function change to modify the parameter value and judge
        test02(4,TEST1,TEST2,TEST3);
        test02(4,arr1,arr2,arr3);
        if(TEST1.length == 4 && TEST2.length == 3 && TEST3.length == 2
                && arr1.length == 4 && arr2.length == 3 && arr3.length == 2)
            check_count++;
        else
            System.out.println("ErrorResult in step3");
        //The test03 interface call, call the RC_Array_04_test01 function return value to the parameter third and judged.
        //RC_Array_04_test01,return 2D array，Call the multi-parameter constructor of RC_Array_01, and assign a value to
        //the newly created object field, and judge the result
        test03(TEST2);
        test03(arr2);
        if(TEST2.length == 3 && arr2.length == 3)
            check_count++;
        else
            System.out.println("ErrorResult in step4");
        //The calling function returns a constant value as the assignment of the constant of this function.
        //Call RC_Array_04() no argument construction method, initialize the variable of the parent class, and assign
        // a value to the domain of the newly created object, and judge the result
        //Test points: inheritance, constructor, return function call, constant, variable, do not receive return value
        RC_Array_04_test02();
        //Get an array object by returning a function call
        boolean[] getarr1 = RC_Array_get01();
        boolean[][] getarr2 = RC_Array_get02();
        boolean[][][] getarr3 = RC_Array_get03();
        if(getarr1.length == 4 && getarr2.length == 3 && getarr3.length == 2)
            check_count++;
        else
            System.out.println("ErrorResult in step5");
        //Exception testing
        boolean ret = RC_Array_Exception();
        if (ret == true)
            check_count++;
        else
            System.out.println("RC_Array_Exception ErrorResult");
        //Result judgment
        //System.out.println(check_count);
        if(check_count == 24)
            System.out.println("ExpectResult");
    }
    private static void test01(int first, boolean[] second, boolean[][] third, boolean[][][] four) {
        //test01 interface call, internal initialization array, do not modify the parameter value, only judge
        boolean [] xyz = {false,true,false,true};
        boolean[][] xyz2 = {{true,true,true,true},{false,false},{true}};
        boolean[][][] xyz3 = {xyz2,xyz2};
        if(second.length == 4 && third.length == 3 && four.length == 2
                && xyz.length == 4 && xyz2.length == 3 && xyz3.length == 2)
            check_count++;
        else
            System.out.println("ErrorResult in test01");
    }
    private static Object change(Object temp1, Object temp2){
        temp1 = temp2;
        return temp1;
    }
    private static void test02(int first, boolean[] second, boolean[][] third, boolean[][][] four) {
        //test02 interface call, call function change to modify the parameter value and judge
        boolean [] xyz = {false,true,false,true};
        boolean[][] xyz2 = {{true,true,true,true},{false,false},{true}};
        boolean[][][] xyz3 = {xyz2,xyz2};
        second = (boolean[]) change(second,xyz);
        third = (boolean[][])change(third,xyz2);
        four = (boolean[][][]) change(four,xyz3);
        if(second.length == 4 && third.length == 3 && four.length == 2)
            check_count++;
        else
            System.out.println("ErrorResult in test02");
    }
    private static void test03(boolean[][] third) {
        //The test03 interface is called, and the RC_Array_04_test01 function call is assigned as the return value to
        // the parameter third and judged.
        third = RC_Array_04_test01();
        if(third.length == 3)
            check_count++;
        else
            System.out.println("ErrorResult in test03");
    }
    private static boolean[] RC_Array_get01()
    {
        //Call the 1D array returned by RC_Array_set01
        return RC_Array_set01();
    }
    private static boolean[][] RC_Array_get02()
    {
        //Call the 2D array returned by RC_Array_set02
        return RC_Array_set02();
    }
    private static boolean[][][] RC_Array_get03()
    {
        //Call the 3D array returned by RC_Array_set03
        return RC_Array_set03();
    }
    private static boolean[] RC_Array_set01()
    {
        //return 1D array，Call the constructor of the 1D array parameter of RC_Array_set01, and assign a value to the
        // field of the newly created object, and judge the result
        boolean [] value1 = {false,false,false,false};
        RC_Array_04 rctest=new RC_Array_04(value1);
        if(Arrays.equals(rctest.base1,value1) && Arrays.equals(rctest.base2,null)
                && Arrays.equals(rctest.base3,null) && Arrays.equals(rctest.base21,null))
            check_count++;
        rctest.base1 = new boolean[] {true,true,true,true};
        if(rctest.base1.length == 4)
            check_count++;
        else
            System.out.println("ErrorResult in RC_Array_set01");
        return rctest.base1;
    }
    private static boolean[][] RC_Array_set02()
    {
        //return 2D array，Call the constructor of the 2D array parameter of RC_Array_set02, and assign a
        // value to the domain of the newly created object, and judge the result
        boolean[][] value2 = {{true,true,true,true},{false,false},{true}};
        RC_Array_04 rctest=new RC_Array_04(value2);
        if(Arrays.equals(rctest.base1,null) && Arrays.equals(rctest.base2,value2)
                && Arrays.equals(rctest.base3,null) && Arrays.equals(rctest.base21,null))
            check_count++;
        rctest.base2 = new boolean[][] {{false,false,false,false},{false,false},{true}};
        if(rctest.base2.length == 3)
            check_count++;
        else
            System.out.println("ErrorResult in RC_Array_set02");
        return rctest.base2;
    }
    private static boolean[][][] RC_Array_set03()
    {
        //return 3D array，Call the constructor of the 3D array parameter of RC_Array_set03, and assign a value to the
        // field of the newly created object, and judge the result
        boolean[][][] value3 = {{{true,true,true,true},{false,false},{true}},{{false,false,false,false},{false,false},{true}}};
        RC_Array_04 rctest=new RC_Array_04(value3);
        if(Arrays.equals(rctest.base1,null) && Arrays.equals(rctest.base2,null)
                && Arrays.equals(rctest.base3,value3) && Arrays.equals(rctest.base21,null))
            check_count++;
        rctest.base3 = new boolean[][][]{{{false,false,false,false},{false,false},{true}},{{true,true,true,true},{false,false},{true}}};
        if(rctest.base3.length == 2)
            check_count++;
        else
            System.out.println("ErrorResult in RC_Array_set03");
        return rctest.base3;
    }
    private static boolean[][] RC_Array_04_test01()
    {
        //return 2D array，Call the multi-parameter constructor of RC_Array_04, and assign a value to the newly created
        // object field, and judge the result
        boolean [] value1 = {true,true,true,true};
        boolean[][] value2 = {{true,true,true,true},{false,false},{true}};
        boolean[][][] value3 = {value2,value2};
        RC_Array_04 rctest=new RC_Array_04(value1,value2,value3);
        if(Arrays.equals(rctest.base1,value1) && Arrays.equals(rctest.base2,value2)
                && Arrays.equals(rctest.base3,value3) && Arrays.equals(rctest.base21,null))
            check_count++;
        rctest.base1 = new boolean[] {false,false,false,false};
        rctest.base2 = new boolean[][] {{false,false,false,false},{false,false},{true}};
        rctest.base21 = new boolean[][] {{false,true,true,false},{false,false},{true}};
        rctest.base3 = new boolean[][][]{{{false,false,false,false},{false,false},{true}},{{false,true,true,false},{false,false},{true}}};
        if(rctest.base1.length == 4 && rctest.base2.length == 3 && rctest.base21.length == 3 && rctest.base3.length == 2)
            check_count++;
        else
            System.out.println("ErrorResult in RC_Array_04_test01");
        return rctest.base21;
    }
    private static boolean[] RC_Array_final01()
    {
        final boolean[] VALUE1 = {true,true,true,true};
        return VALUE1;
    }
    private static boolean[][] RC_Array_final02()
    {
        final boolean[][] VALUE2 = {{false,false,false,false},{false,false},{true}};
        return VALUE2;
    }
    private static boolean[][][] RC_Array_final03()
    {
        final boolean[][][] VALUE3 = {{{false,true,true,false},{false,false},{true}},{{false,false,false,false},{false,false},{true}}};
        return VALUE3;
    }
    private static boolean[][] RC_Array_04_test02()
    {
        //The calling function returns a constant value as the assignment of the constant of this function.
        //Call RC_Array_04 () no argument construction method, initialize the variable of the parent class, and assign
        // a value to the domain of the newly created object, and judge the result
        final boolean[] VALUE1 = RC_Array_final01();
        final boolean[][] VALUE2 = RC_Array_final02();
        final boolean[][][] VALUE3 = RC_Array_final03();
        RC_Array_04 rctest=new RC_Array_04();
        if(rctest.base1.length == 4 && rctest.base2.length == 3 && rctest.base21.length == 3 && rctest.base3.length == 2)
            check_count++;
        else
            System.out.println("ErrorResult in RC_Array_04_test02");
        rctest.base1 = VALUE1;
        rctest.base2 = VALUE2;
        rctest.base21 = VALUE2;
        rctest.base3 = VALUE3;
        if(rctest.base1.length == 4 && rctest.base2.length == 3 && rctest.base21.length == 3 && rctest.base3.length == 2)
            check_count++;
        else
            System.out.println("ErrorResult in RC_Array_04_test02_2");
        return VALUE2;
    }
    private static boolean RC_Array_Exception()
    {
        //Exception test，exclude NullPointerException，ArrayIndexOutOfBoundsException and so on
        int check = 0;
        boolean[] value1 = RC_Array_final01();
        boolean[][] value2 = RC_Array_final02();
        boolean[][][] value3 = RC_Array_final03();
        //Is the value as expect after the assignment?
        if(value1.length == 4 && value2.length == 3  && value3.length == 2)
            check++;
        else
            System.out.println("ErrorResult in RC_Array_Exception——1");
        //ArrayIndexOutOfBoundsException
        try {
            Array.getBoolean(value1,5);
        }catch (ArrayIndexOutOfBoundsException e){
            check++;
        }
        try {
            value1[5] = false;
        }catch (ArrayIndexOutOfBoundsException e){
            check++;
        }
        try {
            Array.setBoolean(value1,5,true);
        }catch (ArrayIndexOutOfBoundsException e){
            check++;
        }
        try {
            Array.getBoolean(RC_Array_final01(),5);
        }catch (ArrayIndexOutOfBoundsException e){
            check++;
        }
        try {
            Array.getBoolean(value2[5],0);
        }catch (ArrayIndexOutOfBoundsException e){
            check++;
        }
        try {
            Array.getBoolean(value2[0],5);
        }catch (ArrayIndexOutOfBoundsException e){
            check++;
        }
        try {
            Array.getBoolean(RC_Array_final02()[0],5);
        }catch (ArrayIndexOutOfBoundsException e){
            check++;
        }
        try {
            Array.getBoolean(value3[0][3],0);
        }catch (ArrayIndexOutOfBoundsException e){
            check++;
        }
        try {
            Array.getBoolean(value3[0][1],5);
        }catch (ArrayIndexOutOfBoundsException e){
            check++;
        }
        try {
            Array.getBoolean(RC_Array_final03()[0][1],5);
        }catch (ArrayIndexOutOfBoundsException e){
            check++;
        }
        //IllegalArgumentException
        try {
            Array.getBoolean(value2,1);
        }catch (IllegalArgumentException e){
            check++;
        }
        try {
            Array.getBoolean(value3,1);
        }catch (IllegalArgumentException e){
            check++;
        }
        //ClassCastException
        RC_Array_04 rc1 = new RC_Array_04();
        try{
            Base_004 bs1 = new Base_004();
            rc1 = (RC_Array_04)bs1;
            rc1.base1[0] = false;
        }catch (ClassCastException e)
        {
            if (rc1.base1[0] != false)
                check++;
        }
        //Whether the judgment value is normal after Exception
        if(value1.length == 4 && value2.length == 3  && value3.length == 2)
            check++;
        else
            System.out.println("ErrorResult in RC_Array_Exception——2");
        //NullPointerException
        value1 = null;
        value2 = null;
        value3 = null;
        try {
            Array.getBoolean(value1,1);
        }catch (NullPointerException e){
            check++;
        }
        try {
            Array.getBoolean(value2,1);
        }catch (NullPointerException e){
            check++;
        }
        try {
            Array.getBoolean(value3,1);
        }catch (NullPointerException e){
            check++;
        }
        //System.out.println(check);
        if (check == 18)
            return true;
        else
            return false;
    }
}