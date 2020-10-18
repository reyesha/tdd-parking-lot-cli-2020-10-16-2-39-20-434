package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) throws Exception {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) throws UnrecognizedParkingTicketException, ProvideParkingTicketException {
        if (parkingTicket == null) {
                throw new ProvideParkingTicketException("Please provide your parking ticket.");
        } else if (parkingTicket.isUsed()) {
                throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket.");
        }
            parkingTicket.setUsed(true);
            return parkingLot.getTicketCarMap().get(parkingTicket);
    }

}
