package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingManagerTest {
    @Test
    void should_return_2_managed_parking_boys_when_adding_parking_boy_to_management_list_given_2_parking_boys() {
        //given
        List<ParkingLot> parkingLotList1 = new ArrayList<>();
        List<ParkingLot> parkingLotList2 = new ArrayList<>();

        //when
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLotList1, new NormalParkingStrategy());
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingLotList2, new SmartParkingStrategy());
        parkingManager.manage(parkingBoy1);
        parkingManager.manage(parkingBoy2);

        //then
        assertEquals(2, parkingManager.managedParkingBoys.size());
    }
}
