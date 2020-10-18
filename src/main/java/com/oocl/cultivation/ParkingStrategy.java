package com.oocl.cultivation;

public interface ParkingStrategy {
    ParkingTicket park (ParkingBoy parkingBoy, Car car) throws Exception;
}
