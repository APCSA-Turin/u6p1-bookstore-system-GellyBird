package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    // //requires 1 private attribute String currentId. You must initialize it to 99
    private static String currentId = "99";

    // //requires one empty constructor
    private IdGenerate(){}

    // public  getCurrentId(){}
    public static String getCurrentId(){
        return currentId;
    }

    // public  reset(){} //must reset the currentId back to 99
    public static void reset(){
        currentId = "99";
    }


    // public generateID(){} //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId
    public static void generateID(){
        int tempId = Integer.parseInt(currentId); // I love parsing :) --- Turns the current ID into an int so it can be increased
        tempId ++; // increases the id value by 1
        currentId = "" + tempId; // and then sets the current id to this value

    }
}