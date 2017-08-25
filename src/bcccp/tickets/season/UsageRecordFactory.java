/* Author: Muhammad Jaaved
   Student Id:11636599 */
package bcccp.tickets.season;

public class UsageRecordFactory implements IUsageRecordFactory {

ArrayList<SeasonTicket> ticketArrayList; //to keep the list of all the session tickets been issued
	

     public UsageRecordFactory(){ 
 		this.ticketArrayList = new ArrayList<SeasonTicket>(); // arraylist been initalized
   }


@Override
	public IUsageRecord make(String ticketId, long startDateTime) {
		SeasonTicket seasonTicket = new SeasonTicket(ticketId, "22222", startDateTime, 10); 
 		ticketArrayList.add(seasonTicket); // object been added to the list. 
 		return null; // still returing null 

	}


}
