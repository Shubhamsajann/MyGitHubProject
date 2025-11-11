package com.NewBankApp;

import java.util.Scanner;

import com.NewBank.DAO.CustomerDAO;
import com.NewBank.DTO.Customer;

public class Login {
	public static void customerLogin() {
		Scanner sc  = new Scanner(System.in);
		CustomerDAO cdao= new CustomerDAO();
		System.out.println("Enter the Account Number");
		int accno=sc.nextInt();
		
		System.out.println("Enter the PIN");
		int pin = sc.nextInt();
	   Customer c=	cdao.getCustomer(accno,pin);
	
		
		if(c!=null) {
			 System.out.println("Welcome " + c.getName() +"!");
	            App.options(c); 
		}
		
		else {
		 	 System.out.println(" Login Failed! Invalid account or PIN.");
		}
	
		
	}

}
