package com.www;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * java映射的测试
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
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

        System.out.println("----------------");
        //获得指定的方法
        System.out.println(cl.getDeclaredMethod("getName", null));
        System.out.println(cl.getDeclaredMethod("setName", String.class));
        System.out.println(cl.getDeclaredMethod("getId"));
        System.out.println(cl.getDeclaredMethod("setId", int.class));


        System.out.println("======================");
        //获得所有的构造器
        Constructor[] constructors = cl.getConstructors();//getConstructors是获得本类及其父类的全部的public方法
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor[] declaredConstructors = cl.getDeclaredConstructors();//getDeclaredConstructors是获得本类的所有方法
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("---=-=-=-=-=-=-=-=-=----");
        //获得指定的构造器
        System.out.println(cl.getConstructor());

        System.out.println(cl.getConstructor(int.class, String.class, String.class));

    }

}
