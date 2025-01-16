package com.example.project;

public class test {
    public static void main(String[] args) {
        IdGenerate.reset();
        BookStore store = new BookStore(); //create a new bookstore with 6 empty books
        IdGenerate.generateID();
        User u1 = new User("John",IdGenerate.getCurrentId());
        IdGenerate.generateID();
        User u2 = new User("Jane",IdGenerate.getCurrentId());
        IdGenerate.generateID();
        User u3 = new User("Mary",IdGenerate.getCurrentId());
        IdGenerate.generateID();
        User u4 = new User("Alex",IdGenerate.getCurrentId());
        store.addUser(u1);store.addUser(u2);store.addUser(u3);store.addUser(u4);

        store.removeUser(u2);
        User[] expected = {u1,u3,u4,null,null,null,null,null,null,null};
        for (User u : store.getUsers()) {
            if (u != null) {
                System.out.println(u.getName());
            } else {
                System.out.println(u);
            }
        }
        System.out.println(" ");
        store.removeUser(u1);
        for (User u : store.getUsers()) {
            if (u != null) {
                System.out.println(u.getName());
            } else {
                System.out.println(u);
            }
        }
        System.out.println(" ");
        store.removeUser(u4);
        for (User u : store.getUsers()) {
            if (u != null) {
                System.out.println(u.getName());
            } else {
                System.out.println(u);
            }
        }
        System.out.println(" ");
        store.removeUser(u3);
        for (User u : store.getUsers()) {
            if (u != null) {
                System.out.println(u.getName());
            } else {
                System.out.println(u);
            }
        }
    }
}