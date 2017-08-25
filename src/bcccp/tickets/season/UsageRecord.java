package bcccp.tickets.season;

public class UsageRecord implements IUsageRecord {
	
	String ticketId;
	long startDateTime;
	long endDateTime;
	
	
	
	public UsageRecord(String ticketId, long startDateTime) {
		this.ticketId = ticketId;
		this.startDateTime = startDateTime;
	}



	@Override
	public void finalise(long endDateTime) {
		UsageRecord newTicketUsage = new UsageRecord();
		newTicketUsage.ticketId = ticketId;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		newTicketUsage.startDateTime = 1413972425000L;
		newTicketUsage.endDateTime = 1413972425000L;
		
	}



	@Override
	public long getStartTime() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public long getEndTime() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String getSeasonTicketId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
