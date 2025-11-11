package com.NewBankApp;

import java.util.Scanner;

import com.NewBank.DAO.CustomerDAO;
import com.NewBank.DTO.Customer;

public class Transcations {
	public static void transfer(Customer c1) {
		Scanner sc  = new Scanner(System.in);
		CustomerDAO cdao  =new CustomerDAO();
		
		System.out.println("Enter The Benificiary Account Number");
		int benificiary_accno=sc.nextInt();
		
		System.out.println("Enter The Amount TO Transfer");
		double amount =sc.nextDouble();
		
		Customer c2  =cdao.getCustomerByAccno(benificiary_accno);
		
		 if (c2 != null && c1.getAccno() != benificiary_accno && amount > 0 && amount <= c1.getBal()) {
	            double newSenderBal = c1.getBal() - amount;
	            double newReceiverBal = c2.getBal() + amount;

	            c1.setBal(newSenderBal);
	            c2.setBal(newReceiverBal);

	            // Update both in database
	            boolean senderUpdated = cdao.updateCustomer(c1);
	            boolean receiverUpdated = cdao.updateCustomer(c2);

	            System.out.println("\n ₹" + amount + " transferred successfully!");
	            System.out.println(" To: " + c2.getName() + " (Acc No: " + benificiary_accno + ")");
	            System.out.printf(" Your Updated Balance: ₹%.2f\n", c1.getBal());

	        } else {
	            System.out.println("Transfer Failed! Check balance or details.");
	        }
		
	}

}
