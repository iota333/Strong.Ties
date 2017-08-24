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

		return null;
	}



	@Override
	public IAdhocTicket findTicketByBarcode(String barcode) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<IAdhocTicket> getCurrentTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
