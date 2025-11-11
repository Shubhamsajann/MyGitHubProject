package com.NewBankApp;
import java.util.Scanner;
import com.NewBank.DAO.CustomerDAO;
import com.NewBank.DTO.Customer;

public class UpdateAccount {
    public static void update(Customer c) {
        Scanner sc = new Scanner(System.in);
        CustomerDAO cdao = new CustomerDAO();

        System.out.print("\nEnter new phone number: ");
        long phone = sc.nextLong();
        System.out.print("Enter new email: ");
        String mail = sc.next();

        c.setPhone(phone);
        c.setMail(mail);
        cdao.updateCustomer(c);

        System.out.println("\n Account details updated successfully!");
        System.out.println("📞 New Phone: " + phone);
        System.out.println("📧 New Email: " + mail);
    }
}
