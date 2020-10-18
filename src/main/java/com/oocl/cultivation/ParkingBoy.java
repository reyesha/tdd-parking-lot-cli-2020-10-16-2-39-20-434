package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    public List<ParkingLot> parkingLotList;
    private ParkingStrategy parkingStrategy;

    public ParkingBoy(List<ParkingLot> parkingLotList, ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) throws Exception {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) throws UnrecognizedParkingTicketException, ProvideParkingTicketException {
        Car car = new Car();
        if (parkingTicket == null) {
                throw new ProvideParkingTicketException("Please provide your parking ticket.");
        } else if (parkingTicket.isUsed()) {
                throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket.");
        }

        for(ParkingLot lot : parkingLotList){
            car = lot.getTicketCarMap().get(parkingTicket);
            if (!(car == null)){
                break;
            }
        }

        parkingTicket.setUsed(true);
        return car;
    }

}
