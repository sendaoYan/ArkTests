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


import java.util.Arrays;
class Base{
    String[] strArray;
    volatile String str2;
}
public class RC_newObjectIassign_02 extends Base{
    final static String STR = "MapleTest";
    static int check = 0;
    static String str1;
    private RC_newObjectIassign_02(){
        strArray=new String[10];
        str1="MapleTest";
        str2="FigoTest";
    }
    private RC_newObjectIassign_02(String str){
        str1=str;
        str2=str;
    }
    private RC_newObjectIassign_02(String[] str){
        strArray=str;
    }
    public static void main(String[] args){
        for(int i =1; i<=100 ; i++){
            test_new_objct_assign();
            if(check != 5){
                System.out.println("ErrorResult");
                break;
            }else{
                check=0;
                str1=null;
            }
        }
        System.out.println("ExpectResult");
    }
    private static void test_new_objct_assign(){
        String[] example = {"a","b","c"};
        String[] arrayStr = {"a","b","c"};
        RC_newObjectIassign_02 rctest=new RC_newObjectIassign_02(arrayStr);
        if(Arrays.equals(rctest.strArray,example) && rctest.str1 ==null && rctest.str2== null)
            check +=1;
        rctest.str1="firstTimeTestStr1";
        rctest.str2="firstTimeTestStr2";
        if(Arrays.equals(rctest.strArray,example) && rctest.str1 =="firstTimeTestStr1" && rctest.str2== "firstTimeTestStr2")
            check +=1;
        rctest = new RC_newObjectIassign_02("secondTimeTest");
        if(Arrays.equals(rctest.strArray,null) && rctest.str1 =="secondTimeTest" && rctest.str2== "secondTimeTest")
            check +=1;
        rctest.strArray = arrayStr;
        if(Arrays.equals(rctest.strArray,example) && rctest.str1 =="secondTimeTest" && rctest.str2== "secondTimeTest")
            check +=1;
        rctest=new RC_newObjectIassign_02();
        if(rctest.strArray.length == 10 && rctest.str1 =="MapleTest" && rctest.str2== "FigoTest")
            check +=1;
    }
}
