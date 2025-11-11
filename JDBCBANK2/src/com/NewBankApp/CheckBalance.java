package com.NewBankApp;

import java.util.Scanner;

import com.NewBank.DAO.CustomerDAO;
import com.NewBank.DTO.Customer;

public class CheckBalance {
	public static void balance(Customer c) {
	
		System.out.println("╔════════════════════════════════════╗");
		System.out.println("║          💰 ACCOUNT BALANCE        ║");
		System.out.println("╠════════════════════════════════════╣");
		System.out.printf ("║ Account No : %-20d  ║%n", c.getAccno());
		System.out.printf ("║ Balance    : ₹%-18.2f   ║%n", c.getBal());
		System.out.println("╚════════════════════════════════════╝");

		
	
		
		
		
	}
}
