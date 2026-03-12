package com;

import java.util.Scanner;

public class UserBus {
	static Scanner sc=new Scanner (System.in);
	public static void main(String[] args) {
		
		BusManagementSystem bm=new BusManagementSystem();
		
		boolean flag=true;
		
		do {
			System.out.println("\t\t\tBus Management System");
			System.out.println("1.Add the Bus Data");
			System.out.println("2.Details of Bus Data by Id ");
			System.out.println("3.Update the Bus Number");
			System.out.println("4.Update the Capacity");
			System.out.println("5.Update the Bus From and to Route");
			System.out.println("6.Capacity Greater Than based Bus data");
			System.out.println("7.From route Based Bus Data");
			System.out.println("8.To route Based Bus Data");
			System.out.println("9.From And To rote based Bus Data");
			System.out.println("10.Sorted by Bus Number");
			System.out.println("11.Sorted by Capacity");
			System.out.println("12.Sorted by Ticket Price");
			System.out.println("13.Key word Based from to location");
			System.out.println("14.Details of All Bus");
			System.out.println("15.Detele the Bus Data");
			System.out.println("16.Update the Ticket Price");
			System.out.println("17.Capacity lesser than based Bus Data");
			System.out.println("18.Ticket Price greater than based Bus data");
			System.out.println("19.Ticket Price lesser than based Bus data");
			System.out.println("20.BusNumber key values Based Bus data");
			System.out.println("21.Greater than Capacity Lesser than TicketPrice");
			System.out.println("22.Exit");
			
			System.out.print("Choose Here:");
			int input=sc.nextInt();
			
			switch(input) {
			case 1 :{
				bm.insertBus();
				break;
			}
			case 2:{
				bm.fetchById();
				break;
			}
			case 3:{
				bm.UpdateBusNumber();
				break;
			}
			case 4:{
				bm.updateCapacity();
				break;
				
			}
			case 5:{
				bm.updateRoute();
				break;
			}
			case 6:{
				bm.greaterCapacity();
				break;
			}
			case 7:{
				bm.fromLocationBus();
				break;
			}
			case 8:{
				bm.toLocationBus();
				break;
			}
			case 9:{
				bm.searchfromTo();
				break;
			}
			case 10:{
				bm.sortBusNumber();
				break;
			}
			case 11:{
				bm.sortCapacity();
				break;
			}
			case 12:{
				bm.sortTicketPrice();
				break;
			}
			case 13:{
				bm.keyFromTo();
				break;
			}
			case 14:{
				bm.detailsOfBus();
				break;
			}
			case 15:{
				bm.delete();
				break;
			}
			case 16:{
				bm.updateTicketPrice();
				break;
			}
			case 17:{
				bm.lessCapacity();
				break;
			}
			case 18:{
				bm.greaterTicketPrice();
				break;
			}
			case 19:{
				bm.lessTicketPrice();
				break;
			}
			case 20:{
				bm.keyBusNumber();
				break;
			}
			case 21:{
				bm.greaterCapacityLesserTicket();
				break;
			}
			case 22:{
				flag=false;
				break;
			}
			default:{
				System.err.println("\t\t\tInvalid Option!...");
			}
			
			}
			
		} while (flag);
	}

}
