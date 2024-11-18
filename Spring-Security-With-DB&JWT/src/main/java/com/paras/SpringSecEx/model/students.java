package com.paras.SpringSecEx.model;


public class students
{

    private int id;
    private String name;
    private int  Marks;

    public students(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        Marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return Marks;
    }

    public void setMarks(int marks) {
        Marks = marks;
    }

    @Override
    public String toString() {
        return "students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Marks=" + Marks +
                '}';
    }
}
