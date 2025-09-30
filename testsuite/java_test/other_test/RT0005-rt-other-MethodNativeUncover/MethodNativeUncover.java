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
import java.lang.reflect.Method;
public class MethodNativeUncover {
private static int res = 99;
	public static void sayHello() {
		String hello = "halo";
	}
	public static void main(String[] args) {
		int result = 2;
		MethodDemo1();
		if(result == 2 && res == 95) {
			res = 0;
		}
		System.out.println(res);
	}
	public static void MethodDemo1(){
		MethodNativeUncover methodNativeUncover = new MethodNativeUncover();
		test(methodNativeUncover);
		test1(methodNativeUncover);
	}
	/**
	 * public native Class<?>[] getExceptionTypes();
	 * @param methodNativeUncover
	*/

	public static void test(MethodNativeUncover methodNativeUncover) {
		Class class1 = methodNativeUncover.getClass();
		try {
			Method method = class1.getMethod("sayHello");
			Class[] newClass = method.getExceptionTypes();
			if(newClass.length == 0 && newClass.getClass().toString().equals("class [Ljava.lang.Class;")) {
			//System.out.println(newClass.length);
			//System.out.println(newClass.getClass());
			MethodNativeUncover.res = MethodNativeUncover.res - 2;
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	/**
	 * public native Object getDefaultValue();
	 * @param methodNativeUncover
	*/

	public static void test1(MethodNativeUncover methodNativeUncover) {
		Class class1 = methodNativeUncover.getClass();
		try {
			Method method = class1.getMethod("sayHello");
			Object object = method.getDefaultValue();
			if(object == null) {
			//System.out.println(object);
			MethodNativeUncover.res = MethodNativeUncover.res - 2;
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
