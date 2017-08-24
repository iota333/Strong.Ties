package bcccp.carpark.entry;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class EntryController 
		implements ICarSensorResponder,
				   ICarparkObserver,
		           IEntryController {
	
	private IGate entryGate;
	private ICarSensor outsideSensor; 
	private ICarSensor insideSensor;
	private IEntryUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long entryTime;
	private String seasonTicketId = null;
	
	

	public EntryController(Carpark carpark, IGate entryGate, 
			ICarSensor os, 
			ICarSensor is,
			IEntryUI ui) {
	   this.carpark = carpark;
		this.entryGate = entryGate;
		this.outsideSensor = os;
		this.insideSensor = is;
		this.ui = ui;
	}



	@Override
	public void buttonPushed() {

if (state.equals(STATE.WAITING)) {
			if (!carpark.isFull()) {
				adhocTicket = carpark.issueAdhocTicket();

				int ticketNo = adhocTicket.getTicketNo();
				String carParkId = adhocTicket.getCarparkId();
				entryTime = System.currentTimeMillis();
				String barCode = adhocTicket.getBarcode();
				ui.printTicket(carParkId, ticketNo, entryTime, barCode);
				setState(STATE.ISSUED);
			} else {
				setState(STATE.FULL);
			}
		} else {
			ui.beep();
		}
	}
			}



	@Override
	public void ticketInserted(String barcode) {
		if (state.equals(STATE.WAITING)) {
			if (carpark.isSeasonTicketValid(barcode) && !carpark.isSeasonTicketInUse(barcode)) {
				this.seasonTicketId = barcode;
				setState(STATE.VALIDATED);
			}
		} else {
			ui.beep();
		}
	}
	}



	@Override
	public void ticketTaken() {
	if (state.equals(STATE.ISSUED) || state.equals(STATE.VALIDATED)) {
 			setState(STATE.TAKEN);
 		} else {
 			ui.beep();
 		}
  	}			
	}



	@Override
	public void notifyCarparkEvent() {
			if (state.equals(STATE.ISSUED) || state.equals(STATE.VALIDATED)) {
 		setState(STATE.TAKEN);
 		} else {
 			ui.beep();
 		}
  	}	
	}
private void log(String message) {
 		System.out.println("Exit Controller : " + message);
 	}
   	private void setState(STATE newState) {
 		switch (newState) {
 		case BLOCKED:
 			log("set State : BLOCKED");
 			state = STATE.BLOCKED;
 		break;
			ui.display("BLOCKED");
 
 		case IDLE:
 			log("set State : IDLE");
 			state = STATE.IDLE;
			ui.display("IDLE");
			break;
 		default:
 			break;
 			// In-progress to do the other status
 			// Need to do EXITED, REJECTED, WAITING, EXITING, PROCESSED, TAKEN, ISSUED, VALIDATED, FULL
 			// status as like above
 		}
 	}
 	// This method used to do the car park event
  	@Override
  	public void carEventDetected(String detectorId, boolean detected) {
 		// TODO Auto-generated method stub
 		
 		log("Car Event Detected: " + detectorId + "Car Detected" + detected);
 		switch (state) {
 		case BLOCKED:
 			if (detectorId.equals(insideSensor.getId()) && !detected) {
 				setState(initState);
 			}
 			break;
 		case IDLE:
 			if (detectorId.equals(insideSensor.getId()) && detected) {
 				setState(STATE.WAITING);
 			} else if (detectorId.equals(outsideSensor.getId()) && detected) {
 				setState(STATE.BLOCKED);
 			}
 		case EXITED:
 			if (detectorId.equals(insideSensor.getId()) && detected) {
 				setState(STATE.EXITING);
 			} else if (detectorId.equals(outsideSensor.getId()) && detected) {
 				setState(STATE.IDLE);
 			}
 			// In-progress to do the further development
 		default:
 			break;
 		}
  	}
  
 	
 	
  }



	