package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    public List<ParkingBoy> managedParkingBoys = new ArrayList<>();

    public void manage(ParkingBoy parkingBoy) {
        this.managedParkingBoys.add(parkingBoy);
    }
}
