package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingTicket == null || parkingTicket.isUsed()) {
            return null;
        } else {
            parkingTicket.setUsed(true);
            return parkingLot.getTicketCarMap().get(parkingTicket);
        }
    }
}
