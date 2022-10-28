package ru.job4j.generics;

public class Role extends Base {

    private String name;

    public Role(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getRoleName() {
        return name;
    }
}
