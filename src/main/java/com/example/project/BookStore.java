package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books = new Book[0];
    private User[] users = new User[10];

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
        if (users[i] == null) { // finds the first null instane in the user list
            users[i] = user; // sets that instance to the new user
            i = users.length;
            break;
        }
    }
    }

    public void removeUser(User user){
        for (int i = 0; i < users.length ; i++) {
            if (users[i] == user) { // finds that user in the list
                users[i] = null; // sets user to null
                consolidateUsers();
                break;
            }
        }
    }

    public void consolidateUsers(){
        for (int i = 0; i < users.length ; i ++) {
            if (users[i] == null) { // if the instance is null...
                for (int j = i + 1; j < users.length ; j ++) { 
                    if (users[j] != null) { // finds the next non-null instance in the list and sets it to that position
                        users[i] = users[j];
                        users[j] = null;
                        break;
                    }
                }
            }
        }
    }

    public void addBook(Book book){
        Book[] newBookList = new Book[books.length + 1]; //create a new list that is 1 book longer than the original list

        for (int i = 0; i < books.length; i ++) { // add all previous books to the new list
            newBookList[i] = books[i];
        }

        newBookList[newBookList.length-1] = book; // add new book to the end of new list
        books = newBookList;

    }

    public void insertBook(Book book, int index){
        Book[] newBookList = new Book[books.length + 1]; // create a new list that is 1 book longer than the original list

        for (int i = 0; i < index; i ++) { // add all previous books before the index to new list
            newBookList[i] = books[i];
        }

        newBookList[index] = book; // insert new book into index

        for (int i = index; i < books.length; i ++) { // add all previous books after the index to new list
            newBookList[i + 1] = books[i];
        }
        books = newBookList;
    }

    public void removeBook(Book book){
        Book[] newBookList = new Book[books.length - 1]; // create a new list that is 1 shorter than the original list
        book.setQuantity(book.getQuantity() - 1); // lower the current quantity of book
        int idx = 0; // initial search index is set to 0

        if (book.getQuantity() == 0) { // if there are no more copies left..
            for (int i = 0; i < books.length; i ++) { // find the index of the book in book list
                if (books[i] == book) {
                  idx = i;
                  break;
                }  
              }
      
              for (int i = 0; i < idx; i ++) { // add all books before the index to newBookList
                newBookList[i] = books[i];
              }

              for (int i = idx + 1; i < books.length; i ++) { // add all books after the index to newBookList
                newBookList[i-1] = books[i];
              }
          books = newBookList; 
        }    
    }
       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}