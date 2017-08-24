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
		// TODO Auto-generated method stub
		
	}



	@Override
	public void notifyCarparkEvent() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		// TODO Auto-generated method stub
		
	}

	
	
}
