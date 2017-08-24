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

        // Defining an enum
        private enum TICKET_STATE {Ticket_Issued, Car_Parked, Ticket_Paid, Car_Exited}
	
        //Defining an enum variable
        private TICKET_STATE ticket_State;

	//Overrided constructor 

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
		this.entryDateTime = dateTime;
		
	}


	@Override
	public long getEntryDateTime() {
		Date d = new Date();
		return d.getTime();
	}

        //This overrided method will return the status
	@Override
	public boolean isCurrent() {
		return entryDateTime > 0 && paidDateTime == 0;
	}


	@Override
	public void pay(long dateTime, float charge) {
		paidDateTime = dateTime;

    		this.charge = charge;
		
	}

	//This overrided method will return the time and paid date

	@Override
	public long getPaidDateTime() {
        return this.paidDateTime;
		
	}

	//This overrided method will return the paid status

	@Override
	public boolean isPaid() {
		return paidDateTime > 0;
	}


	@Override
	public float getCharge() {
		return this.charge;
	}


	@Override
	public void exit(long dateTime) {
		
		DateTime = dateTime;
	}


	@Override
	public long getExitDateTime() {
                return this.exitDateTime;
	}


	@Override
	public boolean hasExited() {
		return exitDateTime > 0;
	}

	
	
}
