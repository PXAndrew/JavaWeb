package el;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private String username = "Andrew";
    private Integer age = 25;
    private String[] hobbys = {"java", "object-c", "girl"};
    private List<String> list = Arrays.asList("list1", "list2", "list3");
    private Map<String, Object> map = new HashMap<String, Object>() {
        {
            this.put("company", "小马哥");
            this.put("englishName", "see you tomorrow");
            this.put("www.baidu.com", "假域名");
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return username + age;
    }
}
