package bcccp.tickets.season;
/* Season Class used to create object of season ticket users  
 */
package bcccp.tickets.season;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.IUsageRecordFactory;

public class SeasonTicketDAO implements ISeasonTicketDAO {

	private IUsageRecordFactory usage;
private IUsageRecord currentUsage = null;
	
	private String ticketId;
	private String carparkId;
	private long startValidPeriod;
	private long endValidPeriod;
	
	public SeasonTicket (String ticketId, 
			             String carparkId, 
			             long startValidPeriod,
			             long endValidPeriod) {
		
		this.ticketId = ticketId;
		this.carparkId = carparkId;
		this.startValidPeriod = startValidPeriod;
		this.endValidPeriod = endValidPeriod;
	}
	public SeasonTicket() {
	}
	//Set ticket Id 
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	//Set caroark id
	public void setCarparkId(String carparkId) {
		this.carparkId = carparkId;
	}
	//Set start valid period 
	public void setStartValidPeriod(long startValidPeriod) {
		this.startValidPeriod = startValidPeriod;
	}
	//Set end valid period 
	public void setEndValidPeriod(long endValidPeriod) {
		this.endValidPeriod = endValidPeriod;
	}
	//get ticket id 
	@Override
	public String getId() {	
		return this.ticketId;
	}
	//Get carpark id
	@Override
	public String getCarparkId() {
		
		return this.carparkId;
	}
	//get Start Valid period 
	@Override
	public long getStartValidPeriod() {
		
		return this.startValidPeriod;
	}

	//Get End Valid Period 
	@Override
	public long getEndValidPeriod() {
		
		return this.endValidPeriod;
	}
	//Check inuse 
	@Override
	public boolean inUse() {
		return false;
	}
	
	public SeasonTicketDAO(IUsageRecordFactory factory) {
		//TOD Implement constructor
	}



	@Override
	public void registerTicket(ISeasonTicket ticket) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deregisterTicket(ISeasonTicket ticket) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int getNumberOfTickets() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public ISeasonTicket findTicketById(String ticketId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void recordTicketEntry(String ticketId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void recordTicketExit(String ticketId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
