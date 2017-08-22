package JDBC.student.unittest;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class test {

    public static void main (String[] args) throws IOException {

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("DBCP.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        System.out.println(properties);

    }
}
