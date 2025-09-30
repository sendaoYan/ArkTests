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


import java.util.ArrayList;
public class Alloc_21_25x8B {
    private  final static int PAGE_SIZE=4*1024;
    private final static int OBJ_HEADSIZE = 8;
    private final static int MAX_21_8B=21*8;
    private final static int MAX_22_8B=22*8;
    private final static int MAX_23_8B=23*8;
    private final static int MAX_24_8B=24*8;
    private final static int MAX_25_8B=25*8;
    private static ArrayList<byte[]> store;
    private static int alloc_test(int slot_type){
        store=new ArrayList<byte[]>();
        byte[] temp;
        int i;
        if(slot_type==24){
            i=1;}
        else if(slot_type==1024){
            i=64*8+1-OBJ_HEADSIZE;
        }else{
            i=slot_type-2*8+1;
        }
        for(;i<=slot_type-OBJ_HEADSIZE;i++)
        {
            for(int j=0;j<(PAGE_SIZE*3/(i+OBJ_HEADSIZE)+10);j++)
            {
                temp = new byte[i];
                store.add(temp);
            }
        }
        int check_size=store.size();
        store=new ArrayList<byte[]>();
        return check_size;
    }
    public static void main(String[] args) {
        store = new ArrayList<byte[]>();
        int countSize21 = alloc_test(MAX_21_8B);
        int countSize22 = alloc_test(MAX_22_8B);
        int countSize23 = alloc_test(MAX_23_8B);
        int countSize24 = alloc_test(MAX_24_8B);
        int countSize25 = alloc_test(MAX_25_8B);
        //System.out.println(countSize21);
        //System.out.println(countSize22);
        //System.out.println(countSize23);
        //System.out.println(countSize24);
        //System.out.println(countSize25);
        if (countSize21 == 674 && countSize22 == 646 && countSize23 == 621 && countSize24 == 599 && countSize25 == 577)
            System.out.println("ExpectResult");
        else
            System.out.println("Error");
    }
}
