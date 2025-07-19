package com.example.singleton;

import ch.qos.logback.core.net.SyslogOutputStream;

// Static members belong to the class, not to any specific object.
// They are loaded into memory only once, at the time of class loading.
// Useful for utility or helper methods (e.g., Math.max()), constants, and shared resources.
public class Singleton {

   private static Singleton instance; // single instance banega

   private Singleton(){  // ab esko es class ke bhar initiate nahi kar paoge

   }

   public static Singleton getInstance(){  // esse acces milega eska
       if(instance == null){
           //// multi thread
//           try {
//               Thread.sleep(100);
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }
           instance = new Singleton();
       }
       return instance;
   }

   public void showMessage(){
       System.out.println("singleton class called");
   }

//   public static void main(String args[]){
//       Singleton singleton = new Singleton();
//       singleton.showMessage();
//   }

}
