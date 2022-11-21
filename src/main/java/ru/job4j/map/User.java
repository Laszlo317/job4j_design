package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {

    private String name;

    private int children;

    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && name.equals(user.name) && birthday.equals(user.birthday);
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        User u1 = new User("Sergey", 4, calendar);
        User u2 = new User("Sergey", 4, calendar);
        Map<User, Object> map = new HashMap<>();
        map.put(u1, new Object());
        int hashCode1 = u1.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int bucket1 = hash1 & 15;
        map.put(u2, new Object());
        int hashCode2 = u2.hashCode();
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int bucket2 = hash2 & 15;
        System.out.println(u1 + " : " + bucket1);
        System.out.println(u2 + " : " + bucket2);
        System.out.println(map.get(u1));
    }
}
