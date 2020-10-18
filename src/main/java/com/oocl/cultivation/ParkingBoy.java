package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) throws UnrecognizedParkingTicketException, ProvideParkingTicketException {
        if (parkingTicket == null) {
            try {

            } catch (NullPointerException e) {
                throw new ProvideParkingTicketException("Please provide your parking ticket.");
            }
        } else if (parkingTicket.isUsed()) {
            try {

            } catch (NullPointerException e) {
                throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket.");
            }
        } else {
            parkingTicket.setUsed(true);
            return parkingLot.getTicketCarMap().get(parkingTicket);
        }
        return null;
    }

}
