package com.learn.bank;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserOperation account = new UserOperation();
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(104, new User("Abc", "9967244964", 500, 104));
        userMap.put(102, new User("Acd", "9967244962", 500, 102));
        userMap.put(101, new User("Bif", "9967244961", 500, 101));
        userMap.put(108, new User("Bef", "9967244968", 500, 108));
        userMap.put(105, new User("Bac", "9967244965", 500, 105));
        userMap.put(109, new User("Bef", "9967244969", 500, 109));
        userMap.put(107, new User("Bef", "9967244967", 500, 107));
        userMap.put(106, new User("Acd", "9967244966", 500, 106));
        userMap.put(103, new User("Bef", "9967244963", 500, 103));
        userMap.put(110, new User("Aef", "9967244960", 500, 110));


        int work = 1;
        while (work > 0) {
            System.out.println("---------------------------------------");
            System.out.println("Create New Account = 1 \n" +
                    "Check Balance = 2 \n" +
                    "Deposit = 3 \n" +
                    "Withdraw = 4 \n" +
                    "Display Account No and Users in Sorted Ascending order = 5 \n" +
                    "User Details By Mobile No = 6 \n" +
                    "Sorted By Names = 7\n" +
                    "By Distinct Names = 8 ");
            System.out.println("Choose your options :");
            System.out.println("---------------------------------------------");
            int operationNo = sc.nextInt();
            account.operation(userMap, operationNo);
            System.out.println(" ");
            System.out.println("Would you like to continue? (y/n) :");
            String exit = sc.next().toUpperCase(Locale.ROOT);
            if (exit.equals("N")) {
                System.out.println("Thank You");
                work = 0;
            }
        }
    }
}
