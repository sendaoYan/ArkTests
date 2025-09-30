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
public class Alloc_56_60x8B {
    private  final static int PAGE_SIZE=4*1024;
    private final static int OBJ_HEADSIZE = 8;
    private final static int MAX_56_8B=56*8;
    private final static int MAX_57_8B=57*8;
    private final static int MAX_58_8B=58*8;
    private final static int MAX_59_8B=59*8;
    private final static int MAX_60_8B=60*8;
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
            for(int j=0;j<(PAGE_SIZE*6/(i+OBJ_HEADSIZE)+10);j++)
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
        int countSize56 = alloc_test(MAX_56_8B);
        int countSize57 = alloc_test(MAX_57_8B);
        int countSize58 = alloc_test(MAX_58_8B);
        int countSize59 = alloc_test(MAX_59_8B);
        int countSize60 = alloc_test(MAX_60_8B);
        //System.out.println(countSize56);
        //System.out.println(countSize57);
        //System.out.println(countSize58);
        //System.out.println(countSize59);
        //System.out.println(countSize60);
        if (countSize56 == 518 && countSize57 == 511 && countSize58 == 503 && countSize59 == 496 && countSize60 == 488)
            System.out.println("ExpectResult");
        else
            System.out.println("Error");
    }
}
