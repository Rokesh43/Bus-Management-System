package com;

import java.util.List;
import java.util.Scanner;
import java.util.logging.ErrorManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class BusManagementSystem {
	static Scanner sc=new Scanner (System.in);
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	static EntityManager em=emf.createEntityManager();
	static EntityTransaction et=em.getTransaction();
	
	public void insertBus() {
		System.out.print("Ente the Bus id :");
		int busId=sc.nextInt();
		Bus b=em.find(Bus.class, busId);
		if (b!=null) {
			System.out.println("\t\t\tAlready Bus is There....");
			
		}
		else {
			System.out.print("Enter the id :");
			int id=sc.nextInt();
			System.out.print("Enter the BusNumber :");
			String busNumber=sc.next();
			System.out.print("Enter the From Location :");
			String fromLocation=sc.next();
			System.out.print("Enter the To Location :");
			String toLocation=sc.next();
			System.out.print("Enter the Capacity :");
			int capacity=sc.nextInt();
			System.out.print("Enter the Ticket Price :");
			double ticketPrice=sc.nextDouble();
			
			b=new Bus();
			b.setId(id);
			b.setBusNumber(busNumber);
			b.setFromLocation(fromLocation);
			b.setToLocation(toLocation);
			b.setCapacity(capacity);
			b.setTicketPrice(ticketPrice);
			
			et.begin();
			em.persist(b);
			et.commit();
			System.out.println("\t\t\tBus Data Added Successfully....");
			
		}
	}
	public void fetchById() {
		System.out.println("Enter the Bus Id :");
		int id=sc.nextInt();
		
		Bus b=em.find(Bus.class, id);
		
		if (b!=null) {
			System.out.println("\t\t\tDetails of Bus");
			System.out.println(b);
			
			
		}
		else {
			System.err.println("\t\t\tBus Id Not Found!...");
		}
		
	}
	public void UpdateBusNumber() {
		System.out.print("Enter the Bus Id :");
		int id=sc.nextInt();
		
		Bus b=em.find(Bus.class, id);
		if (b!=null) {
			System.out.println("Enter the new BusNumber :");
			String busNumber=sc.next();
			b.setBusNumber(busNumber);
			System.out.println("\t\t\tBus Number is Updated..");
			
			et.begin();
			em.merge(b);
			et.commit();
			
		}
		else {
			System.err.println("\t\t\tBus Id Not Found!....");
		}
	}
	
	public void updateCapacity() {
		System.out.print("Enter the Bus Id :");
		int id=sc.nextInt();
		
		Bus b=em.find(Bus.class,id);
		if (b!=null) {
			System.out.print("Enter the New Capacity :");
			int capacity=sc.nextInt();
			b.setCapacity(capacity);
			
			et.begin();
			em.merge(b);
			et.commit();
			
			System.out.println("\t\t\tCapacity is Updated!...");
			
		}
		else {
			System.err.println("\t\t\tBus Id not Found!....");
		}
	}
	public void updateRoute() {
		System.out.print("Enter the Bus Id:");
		int id=sc.nextInt();
		
		Bus b=em.find(Bus.class, id);
		if (b!=null) {
			System.out.print("Enter the new From Location");
			String fromLocation=sc.next();
			System.out.print("Enter the new To Location");
			String toLocation=sc.next();
			
			b.setFromLocation(fromLocation);
			b.setToLocation(toLocation);
			
			et.begin();
			em.merge(b);
			et.commit();
			
			System.out.println("\t\t\tFrom and To Location Updated!....");	
			
		}
		else {
			System.err.println("\t\t\tBus ID not Found!....");
		}
	}
	
	public void greaterCapacity() {
		System.out.print("Enter the Capacity :");
		int capacity=sc.nextInt();
		
		Query q=em.createQuery("select b from Bus b where b.capacity>=?1");
		q.setParameter(1, capacity);
		
		List<Bus> list=q.getResultList();
		if(!list.isEmpty()) {
			for(Bus b:list) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("\t\t\tBus is Not Available");
		}
	}
	public void fromLocationBus() {
		System.out.print("Enter the from Location :");
		String fromLocation=sc.next();
		
		Query q=em.createQuery("select b from Bus b where fromLocation=?1");
		q.setParameter(1, fromLocation);
		
		List<Bus> list=q.getResultList();
		if(!list.isEmpty()) {
			for(Bus b:list) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("\t\t\tBus is Not Available");
		}
		
	}
	public void toLocationBus() {
		System.out.print("Enter the To Location :");
		String toLocation=sc.next();
		
		Query q=em.createQuery("select b from Bus b where toLocation=?1");
		q.setParameter(1, toLocation);
		
		List<Bus> list=q.getResultList();
		if(!list.isEmpty()) {
			for(Bus b:list) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("\t\t\tBus is Not Available");
		}
		
	}
	public void searchfromTo() {
		System.out.print("Enter the from Location :");
		String fromLocation=sc.next();
		System.out.print("Enter the To Location :");
		String toLocation=sc.next();
		
		Query q=em.createQuery("select b from Bus b where fromLocation=?1 and toLocation=?2");
		q.setParameter(1, fromLocation);
		q.setParameter(2, toLocation);
		
		List<Bus> list=q.getResultList();
		if(!list.isEmpty()) {
			for(Bus b:list) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("\t\t\tBus is Not Available");
		}
		
		
	}
	public void sortBusNumber() {
		Query q=em.createQuery("select b from Bus b order by busNumber asc");
		
		List<Bus> list=q.getResultList();
		
			for(Bus b:list) {
				System.out.println(b);
			}
		
		
		
	}
	public void sortCapacity() {
		Query q=em.createQuery("select b from Bus b order by capacity asc");
		
		List<Bus> list=q.getResultList();
		
			for(Bus b:list) {
				System.out.println(b);
			}
		
		
		
	}
	public void sortTicketPrice() {
		Query q=em.createQuery("select b from Bus b order by ticketPrice desc");
		
		List<Bus> list=q.getResultList();
		
			for(Bus b:list) {
				System.out.println(b);
			}
	}
	public void keyFromTo() {
		System.out.print("Enter the from Location :");
		String fromLocation=sc.next();
		System.out.print("Enter the To Location :");
		String toLocation=sc.next();
		
		Query q=em.createQuery("select b from Bus b where b.fromLocation like ?1 and b.toLocation like ?2");
		q.setParameter(1, "%"+fromLocation+"%");
		q.setParameter(2, "%"+toLocation+"%");
		
		List<Bus> list=q.getResultList();
		if(!list.isEmpty()) {
			for(Bus b:list) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("\t\t\tBus is Not Available");
		}
		
	}
	public void detailsOfBus() {
		Query q=em.createQuery("select b from Bus b ");
		List<Bus> list=q.getResultList();
		
		for(Bus b:list) {
			System.out.println(b);
		}
		
	}
	public void delete() {
		System.out.print("Enter the Bus Id:");
		int id=sc.nextInt();
		
		Bus b=em.find(Bus.class, id);
		if(b!=null) {
			et.begin();
			em.remove(b);
			et.commit();
			System.out.println("\t\t\tBus data is deleted!...");
		}
		else {
			System.err.println("\t\t\tBus Id not found!...");
		}
	}
	public void updateTicketPrice() {
		System.out.print("Enter the Bus Id :");
		int id=sc.nextInt();
		
		Bus b=em.find(Bus.class,id);
		if (b!=null) {
			System.out.print("Enter the New TicketPrice :");
			double ticketPrice=sc.nextDouble();
			b.setTicketPrice(ticketPrice);
			
			et.begin();
			em.merge(b);
			et.commit();
			
			System.out.println("\t\t\tTicket Price is Updated!...");
			
		}
		else {
			System.err.println("\t\t\tBus Id not Found!....");
		}
	}
	public void lessCapacity() {
		System.out.print("Enter the Capacity :");
		int capacity=sc.nextInt();
		
		Query q=em.createQuery("select b from Bus b where b.capacity<=?1");
		q.setParameter(1, capacity);
		
		List<Bus> list=q.getResultList();
		if(!list.isEmpty()) {
			for(Bus b:list) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("\t\t\tBus is Not Available");
		}
	}
	public void greaterTicketPrice() {
		System.out.print("Enter the Ticket Price :");
		double ticketPrice=sc.nextDouble();
		
		Query q=em.createQuery("select b from Bus b where b.ticketPrice>=?1");
		q.setParameter(1, ticketPrice);
		
		List<Bus> list=q.getResultList();
		if(!list.isEmpty()) {
			for(Bus b:list) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("\t\t\tBus is Not Available");
		}
		
	}
	public void lessTicketPrice() {
		System.out.print("Enter the Ticket Price :");
		double ticketPrice=sc.nextDouble();
		
		Query q=em.createQuery("select b from Bus b where b.ticketPrice<=?1");
		q.setParameter(1, ticketPrice);
		
		List<Bus> list=q.getResultList();
		if(!list.isEmpty()) {
			for(Bus b:list) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("\t\t\tBus is Not Available");
		}
		
	}
	public void keyBusNumber() {
		System.out.print("Enter the Bus Number :");
		String busNumber=sc.next();
		
		Query q=em.createQuery("select b from Bus b where b.busNumber like ?1 ");
		q.setParameter(1, "%"+busNumber+"%");
		
		
		List<Bus> list=q.getResultList();
		if(!list.isEmpty()) {
			for(Bus b:list) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("\t\t\tBus is Not Available");
		}
		
	}
	public void greaterCapacityLesserTicket() {
		System.out.print("Enter the Capacity :");
		int capacity=sc.nextInt();
		
		System.out.print("Enter the Ticket Price:");
		double ticketPrice=sc.nextDouble();
		
		Query q=em.createQuery("select b from Bus b where b.capacity>=?1 and b.ticketPrice<=?2");
		q.setParameter(1, capacity);
		q.setParameter(2, ticketPrice);
		
		List<Bus> list=q.getResultList();
		if(!list.isEmpty()) {
			for(Bus b:list) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("\t\t\tBus is Not Available");
		}
	}


}
