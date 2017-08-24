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
		if (state.equals(STATE.WAITING)) { 
110 			if (ticketStr.substring(0, 1).equals('A')) { 
111 				adhocTicket = carpark.getAdhocTicket(ticketStr); 
112 				if (adhocTicket != null && adhocTicket.isPaid()) { 
113 					setState(STATE.PROCESSED); 
114 				} else { 
115 					setState(STATE.REJECTED); 
116 				} 
117 			} else if (carpark.isSeasonTicketValid(ticketStr) && carpark.isSeasonTicketInUse(ticketStr)) { 
118 				setState(STATE.PROCESSED); 
119 				seasonTicketId = ticketStr; 
120 			} else { 
121 				ui.beep(); 
122 				setState(STATE.REJECTED); 
123 			} 
124 		} else { 
125 			ui.beep(); 
126 			ui.discardTicket(); 
127 			setState(STATE.REJECTED); 
128 		} 

		
	}



	@Override
	public void ticketTaken() {
		if (state.equals(STATE.PROCESSED)) { 
138 			exitGate.raise(); 
139 			setState(STATE.TAKEN); 
140 		} else if (state.equals(STATE.REJECTED)) { 
141 			setState(STATE.WAITING); 
142 		} else { 
143 			ui.beep(); 
144 		} 
	}



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		 
155 		log("Car Event Detected: " + detectorId + "Car Detected" + detected); 
156 		switch (state) { 
157 		case BLOCKED: 
158 			if (detectorId.equals(insideSensor.getId()) && !detected) { 
159 				setState(initState); 
160 			} 
161 			break; 
162 		case IDLE: 
163 			if (detectorId.equals(insideSensor.getId()) && detected) { 
164 				setState(STATE.WAITING); 
165 			} else if (detectorId.equals(outsideSensor.getId()) && detected) { 
166 				setState(STATE.BLOCKED); 
167 			} 
168 			// In-progress to do the further development 
169 		default: 
170 			 
171 				
	}

	
	
}
