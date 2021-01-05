package com.www;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态创建对象，通过反射
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class clazz = Class.forName("com.www.User");



        //通过构造器来实现构造有参对象

        Constructor declaredConstructor = clazz.getDeclaredConstructor(int.class, String.class, String.class);
        User www = (User) declaredConstructor.newInstance(1, "wangweiwei", "123455");
        System.out.println(www);




        //通过反射调用普通方法
        User user = (User) clazz.newInstance(); //本质上是调用了无参构造器来创建对象
        //通过反射获取一个方法
        Method setName = clazz.getDeclaredMethod("setName", String.class);

        //invoke:激活的意思
        //（对象,"方法的值"）

        setName.invoke(user, "王炜维");
        System.out.println(user.getName());
        System.out.println("11111111111111111111111");

        //通过反射去操作属性

        User user1 = (User) clazz.newInstance();

        Field name = clazz.getDeclaredField("name");

        name.setAccessible(true);//不能直接操作私有属性，通过setAccessible关闭程序的安全检测

        name.set(user1, "王炜维");

        System.out.println(user1.getName());
    }
}
