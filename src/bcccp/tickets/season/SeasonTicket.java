/* Student name : Muhammad Javed
   Student Id :11636599 
*/

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
		File writeUsageFile = new File("../Anonymous/UsageRecordData.txt"); 
 		if(writeUsageFile.exists()) { 
 			try { 
 				PrintWriter writeFile = new PrintWriter(writeUsageFile); 
 				writeFile.print(record.getSeasonTicketId()); 
 				writeFile.print("\t"); 
 				writeFile.print(record.getStartTime()); 
 				writeFile.print("\t"); 
 				writeFile.print(record.getEndTime()); 
 			} catch (FileNotFoundException e) { 
 				e.printStackTrace(); 
 			} 
 		} 

		
	}

	@Override
	public IUsageRecord getCurrentUsageRecord() {
		return null;
	}

	@Override
	public void endUsage(long dateTime) {
		try { 
 			 
 			Scanner readUsageRecord = new Scanner(new File("../Anonymous/UsageRecordData.txt")); 
 			 
 			while(readUsageRecord.hasNext()){ 
 				String usageLine = readUsageRecord.nextLine(); 
 				if(usageLine.contains(ticketId)){ 
 					String[] usageRecArray = usageLine.split("\t"); 
 					UsageRecord usageRec = new UsageRecord(); 
 					usageRec.ticketId = usageRecArray[0]; 
 					usageRec.startDateTime = Date.parse(usageRecArray[1]); 
 					usageRec.endDateTime = dateTime; 
 			} 
 		  } 
 				 
 		} catch (FileNotFoundException e) { 
 			e.printStackTrace(); 
 		} 

		
	}

	@Override
	public List<IUsageRecord> getUsageRecords() {
		List<IUsageRecord> usageRecordList = new ArrayList<>();
		
		try {
			
			Scanner readUsageRecord = new Scanner(new File("../Anonymous/UsageRecordData.txt"));
			
			while(readUsageRecord.hasNext()){
				String usageLine = readUsageRecord.nextLine();
				if(usageLine.contains(ticketId)){
					String[] usageRecArray = usageLine.split("\t");
					UsageRecord usageRec = new UsageRecord();
					usageRec.ticketId = usageRecArray[0];
					usageRec.startDateTime = Date.parse(usageRecArray[1]);
					
					usageRecordList.add(usageRec);
				}
			}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return usageRecordList;
	}


}
