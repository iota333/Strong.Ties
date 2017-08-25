/** author Muhammad Javed
    Student ID : 11636599
	**/
package bcccp.tickets.adhoc;

import java.util.List;

public class AdhocTicketDAO  implements IAdhocTicketDAO  {

    //Defining class types and variables
	
	private IAdhocTicketFactory factory;
	private int currentTicketNo;

	//Declaration of the list variable 
    
	private List<IAdhocTicket> issued_Adhoc_Tickets; 

	
	public AdhocTicketDAO(IAdhocTicketFactory factory) {
		this.issued_Adhoc_Tickets = new ArrayList<IAdhocTicket>(); 
 		this.factory = factory; 
                this.currentTicketNo = 1; 

	}


    //This overrided method will create a ticket and return it
	@Override
	public IAdhocTicket createTicket(String carparkId) {
		IAdhocTicket ticket = factory.make(carparkId, currentTicketNo++); 
 
     		list.add(ticket); 

		return ticket;
	}



	@Override
	public IAdhocTicket findTicketByBarcode(String barcode) {
		IAdhocTicket ticket = null; 
60 
 
61    		Iterator<IAdhocTicket> itr = list.iterator(); 
62 
 
63     			while (itr.hasNext()) { 
64 
 
65       				if (itr.next().getBarcode().equals(barcode)) { 
66 
 
67         				ticket = itr.next(); 
68 
 
69         			break; 
70       				} 
71     			} 
72 
 
73     	return ticket; 

	}


 //This overrided method will return the generated tickets
	@Override
	public List<IAdhocTicket> getCurrentTickets() {
		return list.stream().filter(c -> c.isCurrent() == true).collect(Collectors.toList());
	}

	
	
}
