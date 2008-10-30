//
//  nethelper.java
// Network Analysis and Troubleshooting Application for the shell, to work around lack of built in tools 
//
//  Created by Justin Brinkerhoff on 9/26/08.
//  Copyright 2008, Justin Brinkerhoff & TechDesk LLC. All rights reserved.
//

import java.io.*;
import java.lang.System.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;



public class nethelper {
	public static void main(String args[]) {
		System.out.println("NetHelper 1.0");
		System.out.println("By Justin Brinkerhoff");
		System.out.println("Welcome to NetHelper!");
		System.out.println("Ever frustrated at the lack of integrated network utilities in the shell? \n");
		System.out.println("Well NetHelper has it all. If you have any questions, e-mail me at justin@techdeskllc.com \n");
		System.out.println("To begin, please choose a numeric option corresponding to the menu (e.g. 1, 2, etc...)");
		System.out.println("\n");
		try {
			mainMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public static void mainMenu() throws IOException, IOException {
		System.out.println("Menu Options \n");
		System.out.println("1. ICMP Utilities");
		System.out.println("2. TCP/IP Utilities");
		System.out.println("3. DNS Utilies");
		System.out.println("4. Ethernet Utilities");
		System.out.println("5. WHOIS");
		System.out.println("6. SSH & Telnet");
		System.out.println("7. FTP");
		int menuSelect;
		System.out.print("Please enter a number: ");
		Scanner systemIn = new Scanner(System.in);
		menuSelect = systemIn.nextInt();
		System.out.println("\n");
		switch(menuSelect) {
		case 1: 
			icmpMenu();
			break;
		case 2:
			tcpipMenu();
			break;
		case 3:
			dnsMenu();
			break;
		case 4: 
			ethernetMenu();
			break;
		case 5:
			whoisMenu();
			break;
		case 6:
			remoteMenu();
			break;
		case 7:
			ftpMenu();
			break;
		default:
			System.out.println("Please enter a valid choice from 1 to 7");
			break;
		}
	}
	public static void icmpMenu() {
		System.out.println("ICMP Menu \n");
		System.out.println("Choose an option below.");
		System.out.println("1. Ping");
		System.out.println("2. Trace Route");
		System.out.println("3. Return to Main Menu");
		Scanner icmpSystemIn = new Scanner(System.in);
		int menuIn;
		System.out.print("Enter a selection: ");
		menuIn = icmpSystemIn.nextInt();
		switch(menuIn) {
		case 1:
			ping();
			break;
		case 2:
			tracert();
			break;
		case 3:
			try {
					mainMenu();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		default:
			System.out.println("Please enter a valid selection from 1 to 3");
			break;
		}
		}
	
	
	public static void tcpipMenu() {
		System.out.println("TCP/IP Menu");
	}
	
	public static void dnsMenu() {
		System.out.println("DNS Menu");
	}
	
	public static void ethernetMenu() {
		System.out.println("Ethernet Menu");
	}
	
	public static void whoisMenu() {
	System.out.println("WHOIS Menu");
	}
	
	public static void remoteMenu() {
		System.out.println("Remote Shell Access Menu");
	}
	
	public static void ftpMenu() {
		System.out.println("FTP Menu");
	}
	
	//Module Functions
	
	//Module 1: ICMP PING
	public static void ping() {
		System.out.print("Enter hostname or IP Address: ");
		Scanner hostInput = new Scanner(System.in);
		String host = hostInput.next();
		try {  
			
		      InetAddress address = InetAddress.getByName(host);  
		      System.out.println("\n");
		      System.out.println("Ping Results: \n");
		
		       System.out.println("DNS Hostname (FQDN): " + address.getHostName());  
		  
		      System.out.println("IPv4 Address: " + address.getHostAddress());  
		
		      System.out.println("Reachable via ICMP?: " + address.isReachable(3000));  
		      System.out.println("\n");
		      icmpMenu();
		 
		    }  
		 
		    catch (UnknownHostException e) {  
		  
		       System.err.println("Unable to lookup " + host);  
		  
		    }  
		  
		     catch (IOException e) {  
		  
		       System.err.println("Unable to reach " + host);  
		 
		    }
			
		
	}
	
	public static void tracert() {
		Traceroute trace;
		trace = new Traceroute();
		Scanner hopsInput = new Scanner(System.in);
		String hops = hopsInput.next();
		System.out.println();
		Scanner hostInput = new Scanner(System.in);
		String host = hostInput.next();
		System.out.println();
		String[] args = new String[2];
		args[0] = hops;
		args[1] = host;
		
		try {
			trace.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	
