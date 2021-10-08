package com.learn.bank;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserOperation {

    public int createAccountNo(Map<Integer, User> userMap) {
        if (userMap.isEmpty()) {
            return 101;
        } else {
            TreeMap<Integer, User> sortedMap = new TreeMap<>(userMap);
            return sortedMap.lastKey() + 1;
        }
    }

    public boolean checkMobileNo(Map<Integer, User> userMap, String mobileNo) {
        for (User user : userMap.values()) {
            if (user.getMobileNo().trim().equals(mobileNo)) {
                if (mobileValidation(mobileNo)) {
                    return false;
                }
            }
        }
        return true;
    }

    //mobile validation
    public boolean mobileValidation(String mobileNo) {
        Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = pattern.matcher(mobileNo);
        return match.find() && match.group().equals(mobileNo);
    }

    //for add new user
    public void addUser(Map<Integer, User> userMap) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name:");
        String name = sc.next();//name input
        System.out.println("Mobile No:");
        String mobileNo = sc.next();//mobile input
        if (!checkMobileNo(userMap, mobileNo)) {
            int number = 1;
            while (number > 0) {
                System.out.println("Mobile number is Invalid , Enter again");
                mobileNo = sc.next();
                if (checkMobileNo(userMap, mobileNo)) {
                    number = 0;
                }
            }
        }
        System.out.println("Enter Your initial Amount");
        double amount;
        amount = sc.nextDouble();//initial amount input
        if (amount < 0) {
            amount = 0;
        }
        int accountNo = createAccountNo(userMap);//account number
        userMap.put(accountNo, (new User(name, mobileNo, amount, accountNo)));
        System.out.println("Account created successfully!");
        System.out.println("Your Account Number is " + accountNo);
        System.out.println("--------------------------------------");
    }

    //for check balance
    public void checkBalance(Map<Integer, User> userMap, int accountNo) {
        for (User user : userMap.values()) {
            if (user.getAccountNo() == accountNo) {
                System.out.println("Your Account Balance is :" + user.getBalance());
            }
        }
        System.out.println("----------------------------------------------");
    }

    //for add deposit in account
    public void deposit(Map<Integer, User> userMap, int accountNo, double amount) {
        for (User user : userMap.values()) {
            if (user.getAccountNo() == accountNo) {
                user.setBalance(user.getBalance() + amount);
                System.out.println("Amount Successfully Deposit in your account ");
            }
        }
        System.out.println("----------------------------------------------");
    }

    //for withdraw deposit from account
    public void withdraw(Map<Integer, User> userMap, int accountNo, double amount) {
        for (User user : userMap.values()) {
            if (user.getAccountNo() == accountNo) {
                if (user.getBalance() < amount) {
                    System.out.println("Your balance is Low");
                } else if (user.getBalance() == 0 || amount == 0) {
                    System.out.println("Your balance is 0 or you entered amount is 0");
                } else {
                    user.setBalance(user.getBalance() - amount);
                    System.out.println("Amount successfully withdraw from your account");
                }
            }
        }
        System.out.println("----------------------------------------------");
    }


    //get user by mobile number
    public User getUserByMobileNo(Map<Integer, User> userMap, String mobileNo) {
        for (User user : userMap.values()) {
            if (user.getMobileNo().trim().equals(mobileNo)) {
                return user;
            }
        }
        return null;
    }


    //operations for methods
    public void operation(Map<Integer, User> userMap, int operationNo) {
        try {
            Scanner sc = new Scanner(System.in);
            switch (operationNo) {
                case 1://create new user
                    addUser(userMap);
                    break;

                case 2://check balance
                    System.out.println("Enter Account Number:");
                    int accountNo = sc.nextInt();
                    if (userMap.containsKey(accountNo)) {
                        checkBalance(userMap, accountNo);
                    } else {
                        System.out.println("Account Not Found");
                    }
                    break;

                case 3://deposit
                    System.out.println("Enter Account Number:");
                    int accountNo1 = sc.nextInt();
                    if (userMap.containsKey(accountNo1)) {
                        System.out.println("Enter Deposit Amount");
                        double deposit = sc.nextDouble();
                        deposit(userMap, accountNo1, deposit);
                    } else {
                        System.out.println("Account Not Found");
                    }
                    break;

                case 4://withdraw
                    System.out.println("Enter Account Number:");
                    int accountNo2 = sc.nextInt();
                    if (userMap.containsKey(accountNo2)) {
                        System.out.println("Enter withdraw Amount");
                        double withdraw = sc.nextDouble();
                        withdraw(userMap, accountNo2, withdraw);
                    } else {
                        System.out.println("Account Not Found");
                    }
                    break;

                case 5://getListByAccountNo
                    Map<Integer, User> sortedMap = new TreeMap<>(userMap);
                    if (sortedMap.size() > 0) {
                        for (User user : sortedMap.values()) {
                            System.out.println("Account No : " + user.getAccountNo() + "     Name : " + user.getName());
                            System.out.println("-------------------------------------");
                        }
                    } else {
                        System.out.println("No record");
                    }
                    break;

                case 6://getListByAccountNo
                    System.out.println("Enter Your Mobile Number");
                    String mobileNo = sc.next();
                    User mobileUser = getUserByMobileNo(userMap, mobileNo);
                    if (mobileUser != null) {
                        System.out.println("---------Details of User------");
                        System.out.println("Account Number : " + mobileUser.getAccountNo());
                        System.out.println("Name : " + mobileUser.getName());
                        System.out.println("Mobile : " + mobileUser.getMobileNo());
                        System.out.println("Account Balance : " + mobileUser.getBalance());
                        System.out.println("------------------------------");
                    } else {
                        System.out.println("Didn't find any record with your mobile number");
                    }
                    break;

                default://invalid
                    System.out.println("INVALID INPUT");
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid Account number");
        }
    }
}
