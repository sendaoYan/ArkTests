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


import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.Arrays;
public class StringEmojiTest {
    private static int processResult = 99;
    public static void main(String[] argv) {
        System.out.println(run(argv, System.out));
    }
    public static int run(String argv[],PrintStream out){
        int result = 2 /* STATUS_FAILED*/
;
        try {
            if(StringEmojiTest()){
                result =1;
            }
        } catch(Exception e){
            System.out.println(e);
            processResult = processResult - 10;
        }
//        System.out.println("result: " + result);
//        System.out.println("processResult:" + processResult);
        if (result == 1 && processResult == 99){
            result =0;
        }
        return result;
    }
    public static boolean StringEmojiTest() throws UnsupportedEncodingException {
        // 以下用byte[]构造string 😘
        byte[] emoji_FacewithTearsofJoy = {(byte) 0xD8, (byte) 0x3D, (byte) 0xDE, (byte) 0x02}; // U+1F602
        byte[] emoji = {(byte) 0xD8, (byte) 0x3D, (byte) 0xDE, (byte) 0x18};
        String emojis = "\uD83D\uDE18";
//        System.out.println(new String(emoji, Charset.forName("unicode")));
        /* 以上处理用例输出，用例输出是"😘"
         * 得到unicode [-2 -1 -40 61 -34 24]
         * 得到UTF-16  [-2 -1 -40 61 -34 24]
         * 得到UTF-8   [-16 -97 -104 -104]
         * 得到ISO-8859-1 [63] 已经出错了
         * 得到ASCII   [63] 已经出错了
        */

        byte[] ab_10 = "\uD83D\uDE18".getBytes("unicode");
//        for (int i = 0; i <ab_10.length ; i++) {
//            System.out.print(ab_10[i]+" ");
//        }
//        System.out.println();
        return Arrays.equals(emojis.getBytes("unicode"),ab_10);
    }
}
