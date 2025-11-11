package com.NewBankApp;

import java.util.Scanner;

import com.NewBank.DTO.Customer;

public class App {
	public static Customer options(Customer c) {
		Scanner sc  = new Scanner(System.in);
		int choice  =0;
		do {

			System.out.println("╔════════════════════════════════════════════╗");
			System.out.printf("║   Welcome, %-30s  ║%n", c.getName());          
			System.out.println("╠════════════════════════════════════════════╣");
			System.out.println("║ 1. 💵 Check Balance                        ║");
			System.out.println("║ 2. 💰 Deposit Money                        ║");
			System.out.println("║ 3. 💸 Transfer Money                       ║");
			System.out.println("║ 4. 🛠️ Update Account Info                  ║");
			System.out.println("║ 5. 🔑 Reset PIN                            ║");
			System.out.println("║ 6. 🚪 Logout                               ║");
			System.out.println("╚════════════════════════════════════════════╝");

		    System.out.print("Enter your choice: ");
			choice =sc.nextInt();
			switch(choice)
			{
			case 1:{
				 CheckBalance.balance(c);
				break;
			}
			case 2:{
				Deposit.addAmount(c);
				break;
			}
			case 3:{
				Transcations.transfer(c);
				break;
			}
			case 4:{
				UpdateAccount.update(c);
				break;
			}
			case 5:{
				UpdatePin.reset();
				break;
			}
			case 6:{
				System.out.println("Exiting To Main Menu");
				break;
				 
				
			} 
			default:{
				System.out.println("Invalid Input! Please Try Again");
			}
				
			
			}
				
			

		}
		while(choice !=6);
		return null;
	}

	
		
		
	

}
