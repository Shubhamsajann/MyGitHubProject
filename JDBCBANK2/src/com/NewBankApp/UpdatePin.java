package com.NewBankApp;

import java.util.Scanner;

import com.NewBank.DAO.CustomerDAO;
import com.NewBank.DTO.Customer;

public class UpdatePin {
	public static void reset() {
		Scanner sc = new Scanner(System.in);
		
		CustomerDAO cdao = new CustomerDAO();
		
		System.out.println("Enter Your Account Number");
		int accno=sc.nextInt();
		
		System.out.println("Enter Your Current Pin");
		int pin =sc.nextInt();
		
		Customer c1 =cdao.getCustomer(accno, pin);
		
		System.out.println("Do U Wish To Update Pin");
		String choice =sc.next();
		if(choice.equalsIgnoreCase("y")) {
			System.out.println("Set The New Pin");
			int setPin =sc.nextInt();
			
			System.out.println("Confirm Pin");
			int confirm =sc.nextInt();
			
			if(setPin == confirm) {
				c1.setPin(setPin);
				cdao.updateCustomer(c1);
				System.out.println("Pin is Updated Successfully");
				
			}
			else {
				System.out.println("Unable To Reset Pin");
			}
		}
		
		
	}

}
