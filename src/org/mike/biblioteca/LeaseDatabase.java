package org.mike.biblioteca;

import java.util.ArrayList;

public class LeaseDatabase {
	private ArrayList<Lease> leases = new ArrayList<Lease>();
	
	public LeaseDatabase() {
		
	}
	
	public ArrayList<Lease> getLeases(){
		return this.leases;
	}
}
