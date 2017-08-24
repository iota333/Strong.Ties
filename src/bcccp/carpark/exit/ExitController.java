package bcccp.carpark.exit;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class ExitController 
		implements ICarSensorResponder,
		           IExitController {
	
	private IGate exitGate;
	private ICarSensor insideSensor;
	private ICarSensor outsideSensor; 
	private IExitUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long exitTime;
	private String seasonTicketId = null;
	
	

	public ExitController(Carpark carpark, IGate exitGate, 
			ICarSensor is,
			ICarSensor os, 
			IExitUI ui) {
		this.carpark = carpark; 
54 		this.exitGate = exitGate; 
55 		this.outsideSensor = os; 
56 		this.insideSensor = is; 
57 		this.ui = ui; 
58 
 
59 		initState = STATE.IDLE; 
60 		setState(STATE.IDLE); 
61 		 
62 	} 
63 
 
64 	/** 
65 	 * This method used to set the state when car entering an exiting 
66 	 *  
67 	 * @param idle 
68 	 */ 
69 	private void setState(STATE newState) { 
70 		switch (newState) { 
71 		case BLOCKED: 
72 			log("set State : BLOCKED"); 
73 			state = STATE.BLOCKED; 
74 			ui.display("BLOCKED"); 
75 			break; 
76 		case IDLE: 
77 			log("set State : IDLE"); 
78 			state = STATE.IDLE; 
79 			ui.display("IDLE"); 
80 			break; 
81 		case EXITED: 
82 			log("set State : EXITED"); 
83 			state = STATE.EXITED; 
84 			ui.display("EXITED"); 
85 			break; 
86 		default: 
87 			break; 
88 			// In-progress to do the other status 
89 			// Need to do EXITED, REJECTED, WAITING, EXITING, PROCESSED, TAKEN, ISSUED, VALIDATED, FULL 
90 			// status as like above 
91 		} 
92 	} 
93 
 
94 	/** 
95 	 * This method used to create the log file 
96 	 *  
97 	 * @param message 
98 	 */ 
99 	private void log(String message) { 
100 		System.out.println("Exit Controller : " + message); 
101 	} 
102 
 

	}



	@Override
	public void ticketInserted(String ticketStr) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		// TODO Auto-generated method stub
		
	}

	
	
}
