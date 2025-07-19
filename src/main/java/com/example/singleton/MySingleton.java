package com.example.singleton;

public enum MySingleton {

    INSTANCE;

    public void doSomething(){

    }

}

// Enum is singleton by nature :
//   1. JVM ensure that one instance of any enum constant is created.As it calls constructor only once and also prevent call through reflection;

// Enum are thread safe internally.

// Enum Serialisation safe :
//     Serialisation : when we write this object in file and read it back in case of our normal singleton class it will  create new object while reading it back

// cannot create enum using reflection it will through error : java.lang.IllegalArgumentException: Cannot reflectively create enum objects.

