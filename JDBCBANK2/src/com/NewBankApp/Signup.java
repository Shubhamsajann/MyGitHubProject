package com.NewBankApp;

import java.util.Scanner;

import com.NewBank.DAO.CustomerDAO;

public class Signup {

	public static void customerSignup() {
		Scanner sc  =  new Scanner(System.in);
		CustomerDAO cdao= new CustomerDAO();
		System.out.println("\n <---Create New Account---->");
		
		System.out.println("Enter Name");
		String name  = sc.next();
		
		System.out.println("enter Phone Number");
		Long  phone =sc.nextLong();
		sc.nextLine();
		
		 System.out.print("Enter Email: ");
	        String email = sc.next();
		
		System.out.println("Enter 4-Digit Pin");
		int pin = sc.nextInt();
		
		System.out.println("Enter 4-Digit Pin To Confirm");
		int confirm = sc.nextInt();
		
		boolean success = cdao.signup(name, phone, email, pin, confirm);

        if (success) {
            System.out.println("Account created successfully for " + name + "!");
        } else {
            System.out.println("Account creation failed. Please try again.");
        }
		
		
		
	}

}
