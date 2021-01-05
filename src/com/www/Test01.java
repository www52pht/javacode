package com.www;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * java映射的测试
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class cl = Class.forName("com.www.User");
        //获得类的名字
        System.out.println(cl.getName());

        System.out.println(cl.getSimpleName());

        System.out.println(cl.getDeclaredFields());

        //获得属性
        //getFields只能获取public修饰的属性,getDeclaredFields能获取所有的属性
        System.out.println("==============");
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        /**
        获得指定属性值getFields只能获取public修饰的属性,getDeclaredFields能获取所有的属性
        Field name = cl.getField("name");
        **/
        Field name = cl.getDeclaredField("name");
        System.out.println(name);

        //获得所有的方法
        System.out.println("=================");
        Method[] methods = cl.getMethods(); //getMethods是获得本类及其父类的全部的public方法
        for (Method method : methods) {
            System.out.println("正常的"+method);
        }


        Method[] declaredMethods = cl.getDeclaredMethods();//getDeclaredMethods是获得本类的所有方法
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

}
