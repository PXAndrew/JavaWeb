package javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class IntrospectorDemo  {

    public static void main(String[] args) throws IntrospectionException {
        // 获取 user 字节码的 javabean 描述对象 (不包括 object )
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        // 获取所有属性的描述器
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor propertyDescriptor :
                propertyDescriptors) {

            String name = propertyDescriptor.getName();
            Class type = propertyDescriptor.getPropertyType();
            Method getter = propertyDescriptor.getReadMethod();
            Method setter = propertyDescriptor.getWriteMethod();
            System.out.println(propertyDescriptor);

        }
    }
}
