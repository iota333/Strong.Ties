
package bcccp.tickets.adhoc;
/*
Student Name: Hassan Ali
Student ID: 11636525
Assignment 2
*/

import java.util.Date;

public class AdhocTicket implements IAdhocTicket {
	
	private String carparkId;
	private int ticketNo;
	private long entryDateTime;
	private long paidDateTime;
	private long exitDateTime;
	private float charge;
	private String barcode;
        private enum TICKET_STATE {Ticket_Issued, Car_Parked, Ticket_Paid, Car_Exited}
	
        private TICKET_STATE ticket_State;

	public AdhocTicket(String carparkId, int ticketNo, String barcode) {
        this.carparkId = carparkId;
        	this.ticketNo = ticketNo;
        	this.barcode = barcode;
		this.ticket_State = TICKET_STATE.Ticket_Issued;
		
	}


	@Override
	public int getTicketNo() {
		return this.ticketNo;
		
	}


	@Override
	public String getBarcode() {
		return this.barcode;
	}


	@Override
	public String getCarparkId() {
		return this.carparkId;
	}

	@Override
	public void enter(long dateTime) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public long getEntryDateTime() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isCurrent() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void pay(long dateTime, float charge) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public long getPaidDateTime() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isPaid() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public float getCharge() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void exit(long dateTime) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public long getExitDateTime() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean hasExited() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
