package com.example.comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;

    public static void main(String args[]){
        Comparator<User> compareById = (u1,u2) -> Integer.compare(u1.getId(), u2.getId());
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Bob"));
        users.add(new User(2, "Charlie"));

        users.sort(compareById);

        for (User user : users) {
            System.out.println(user);
        }

        // List<> wale case mein  users.sort(compartor);
        // int[] ke case mein Arrays.sort(compartor)

    }

}
