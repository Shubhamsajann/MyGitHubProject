package com.NewBankApp;

import java.util.Scanner;

import com.NewBank.DAO.CustomerDAO;
import com.NewBank.DTO.Customer;

public class Deposit {
	public static void addAmount(Customer c) {
		Scanner sc  = new Scanner(System.in);
		
		CustomerDAO cdao =  new CustomerDAO();

		System.out.println("Enter The Amount To Deposit");
		double amount = sc.nextDouble();
		
		if(amount>0) {
		double	newamount = amount + c.getBal();
			c.setBal(newamount);
			cdao.updateCustomer(c);
			System.out.println("\n₹" + amount + " deposited successfully!");
            System.out.printf(" Updated Balance: ₹%.2f\n", newamount);
		}
		else {
			System.out.println("Failed To Deposit! ");
		}
		
		
	}

}
