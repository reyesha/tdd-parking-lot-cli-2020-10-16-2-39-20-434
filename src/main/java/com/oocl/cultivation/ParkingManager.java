package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy {
    public List<ParkingBoy> managedParkingBoys = new ArrayList<>();

    public ParkingManager(List<ParkingLot> parkingLotList, ParkingStrategy parkingStrategy) {
        super(parkingLotList, parkingStrategy);
    }

    public void manage(ParkingBoy parkingBoy) {
        this.managedParkingBoys.add(parkingBoy);
    }
}
