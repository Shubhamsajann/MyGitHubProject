package com.NewBank.DAO;

import java.sql.*;
import java.util.Scanner;

import com.NewBank.DTO.Connector;
import com.NewBank.DTO.Customer;
import com.NewBankApp.App;

public class CustomerDAO {
	
	public static Customer getCustomerByAccno(int accno) {
		Customer c =null;
		Connection con =null;
		ResultSet rs  = null;
		PreparedStatement ps = null;
		String query ="Select * from customer where accno =?";
		
		try {
			con =Connector.requesConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, accno);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				c= new Customer();
				
				c.setAccno(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) ps.close();
				
				if(con !=null) con.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		
	}
		return c;
		
	}

	public static boolean signup(String name,long phone,String mail,int pin,int confirm)  {
		
		Scanner sc  = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps =  null;
		String query="INSERT INTO CUSTOMER(NAME,PHONE,MAIL,PIN ) VALUES (?,?,?,?)";
		int i=0;
	
		
		
		try {
			con = Connector.requesConnection();
			ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.setLong(2,phone);
			ps.setString(3, mail);
			if(pin ==confirm && pin>=1000 && pin<=9999) {
				ps.setInt(4, pin);
				i=ps.executeUpdate();
			}
			else {
				  System.out.println("❌ Pin Mismatch or Invalid (must be 4 digits)");
	                return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if(ps!=null) ps.close();
				
				if(con !=null) con.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
		
		if(i>0) {
			String query2 = "SELECT * FROM CUSTOMER WHERE PHONE = ?"; 
			ResultSet rs  =  null;
			Customer c  =  null;
			int accno=0;
			try {
				con = Connector.requesConnection();
				ps = con.prepareStatement(query2);
				ps.setLong(1, phone);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					accno=rs.getInt(1);
					}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			finally {
				try {
					if(ps!=null) ps.close();
					
					if(con !=null) con.close();
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
	
			
		}
		System.out.println("Data Added Successfully.\n Your Account Number is "+accno);
		
		return true;
		
	}
		else {
			System.out.println("Failed To Create Account");
			return false;
		}
	}
	
	public static Customer getCustomer(int accno,int pin) {
		Customer c =null;
		Connection con =null;
		ResultSet rs  = null;
		PreparedStatement ps = null;
		String query ="Select * from customer where accno =? and pin = ?";
		
		try {
			con =Connector.requesConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, accno);
			ps.setInt(2, pin);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				c= new Customer();
				
				c.setAccno(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) ps.close();
				
				if(con !=null) con.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		
	}
		return c;
		
	}
	
	public static  boolean updateCustomer(Customer c) {
		Connection con = null;
		PreparedStatement ps =  null;
		int res=0;
		String query = "UPDATE CUSTOMER SET NAME = ?,PHONE = ?,MAIL =?,BALANCE = ?,PIN =? WHERE ACCNO = ?";
		try {
			con = Connector.requesConnection();
			ps = con.prepareStatement(query);
			ps.setString(1,c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getMail());
			ps.setDouble(4, c.getBal());
			ps.setInt(5, c.getPin());
			ps.setInt(6, c.getAccno());
			res = ps.executeUpdate();
			if(res >0) {
				return true;
			}
			else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static boolean updatePhone(int accno,int pin, long newphone) {
		Connection con  = null;
		PreparedStatement ps = null;
		int res =0;
		String query = "UPDATE customer SET PHONE =? WHERE ACCNO =? AND PIN = ?";
		
		try {
			con =Connector.requesConnection();
			ps = con.prepareStatement(query);
			ps.setLong(1, newphone);
			ps.setInt(2, accno);
			ps.setInt(3,pin);
			
			res = ps.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
	        try {
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		if(res >0) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public static boolean updateEmail(int accno,int pin, String newEMail) {
		Connection con  = null;
		PreparedStatement ps = null;
		int res =0;
		String query = "UPDATE customer SET Mail =? WHERE ACCNO =? AND PIN = ?";
		
		try {
			con =Connector.requesConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, newEMail);
			ps.setInt(2, accno);
			ps.setInt(3,pin);
			
			res = ps.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
	        try {
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		if(res >0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
