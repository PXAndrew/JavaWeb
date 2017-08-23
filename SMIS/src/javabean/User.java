package javabean;

import sun.management.Agent;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Map;

public class User {


    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    // 设置全名，属性 fullName
//    public void setFullName(String fullName) {
//
//
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class Util {

    public static <T> T mapToBean(Map<String, Object> map, Class<T> tClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, IntrospectionException {

        T tInstance = null;
        try {
            tInstance = tClass.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 获取 user 字节码的 javabean 描述对象 (不包括 object )
        BeanInfo beanInfo = Introspector.getBeanInfo(tClass, Object.class);
        // 获取所有属性的描述器
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor :
                propertyDescriptors) {
                Method setter = propertyDescriptor.getWriteMethod();
            try {
                setter.invoke(tInstance, map.get(propertyDescriptor.getName()));
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return tInstance;
    }

    public static Map<String, Object> beanToMap(Object instance) throws IntrospectionException {

        Map map = new HashMap();

        // 获取 user 字节码的 javabean 描述对象 (不包括 object )
        BeanInfo beanInfo = Introspector.getBeanInfo(instance.getClass(), Object.class);
        // 获取所有属性的描述器
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor :
                propertyDescriptors) {
            Method getter = propertyDescriptor.getReadMethod();

            try {
                map.put(propertyDescriptor.getName(), getter.invoke(instance));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

        return map;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IntrospectionException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 200L);
        map.put("firstName", "aaa");
        map.put("lastName", "bbbb");
        map.put("age", 25);


        User user = mapToBean(map, User.class);
        map.clear();
        map = beanToMap(user);
        System.out.println(map);

    }

}
