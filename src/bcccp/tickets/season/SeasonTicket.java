package bcccp.tickets.season;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeasonTicket implements ISeasonTicket {
	
	private List<IUsageRecord> usages;
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

        //No Argument constructor  
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

	@Override
	public String getId() {
		this.ticketId = ticketId;
	}

	@Override
	public String getCarparkId() {
		this.carparkId = carparkId;
	}

	@Override
	public long getStartValidPeriod() {
		this.startValidPeriod = startValidPeriod
	}

	@Override
	public long getEndValidPeriod() {
		this.endValidPeriod = endValidPeriod;
	}

	@Override
	public boolean inUse() {
		
		return false;
	}

	@Override
	public void recordUsage(IUsageRecord record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IUsageRecord getCurrentUsageRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endUsage(long dateTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IUsageRecord> getUsageRecords() {
		// TODO Auto-generated method stub
		return null;
	}


}
