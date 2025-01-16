package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private static Book[] books = new Book[0];
    private static User[] users = new User[10];

    //requires 1 empty constructor
    public BookStore() {}
    
    // public getUsers(){}
    public User[] getUsers(){
        return users;
    }
    // public setUsers(){}
    public void setUsers(User[] newUsers) {
        users = newUsers;
    }

    // public  getBooks(){}
    public Book[] getBooks(){
        return books;
    }
    
    
    public void addUser(User user){
    for (int i = 0; i < users.length ; i++) {
        if (users[i] == null) {
            users[i] = user;
            i = users.length;
            break;
        }
    }
    }

    public void removeUser(User user){
        for (int i = 0; i < users.length ; i++) {
            if (users[i] == user) {
                users[i] = null;
                break;
            }
        }
        consolidateUsers();
    }

    public void consolidateUsers(){
        for (int i = 0; i < users.length ; i ++) {
            if (users[i] == null) {
                for (int j = i + 1; j < users.length ; j ++) {
                    if (users[j] != null) {
                        users[i] = users[j];
                        System.out.println("J: " + users[j]);
                        System.out.println("I: " + users[i]);
                        users[j] = null;
                        break;
                    }
                }
            }
        }
    }

    public void addBook(Book book){
        Book[] newBookList = new Book[books.length + 1];

        for (int i = 0; i < books.length; i ++) {
            newBookList[i] = books[i];
        }

        newBookList[newBookList.length-1] = book;
        books = newBookList;

    }

    // public void insertBook(Book book, int index){}

    // public void removeBook(Book book){}
       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}