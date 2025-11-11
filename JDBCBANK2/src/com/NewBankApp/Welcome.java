package com.NewBankApp;

import java.util.Scanner;

public class Welcome   {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        Welcome To Golmal Bank        ║");
        System.out.println("╚══════════════════════════════════════╝");
        
        do {
        	System.out.println("╔══════════════════════════════╗");
        	System.out.println("║ 1. Customer Login            ║");
        	System.out.println("║ 2. Create Account            ║");
        	System.out.println("║ 3. Exit                      ║");
        	System.out.println("╚══════════════════════════════╝");

            System.out.print(" Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1: {
                	 System.out.println("Customer Login selected.");
                     Login.customerLogin();
                   
                    break;
                }
                case 2: {
                	 System.out.println("Create Account selected.");
                     Signup.customerSignup();
                   
                    break;
                }
                case 3: {
                    System.out.println("Thank you for visiting New Bank!");
                    break;
                }
                default: 
                    System.out.println("Invalid Input! Please try again.");
            }
        } while(choice != 3);  
        
        sc.close();
    }
}
