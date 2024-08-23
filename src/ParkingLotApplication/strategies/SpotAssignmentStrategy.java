package ParkingLotApplication.strategies;

import ParkingLotApplication.models.Gate;
import ParkingLotApplication.models.ParkingSpot;
import ParkingLotApplication.models.VehicleType;

public interface SpotAssignmentStrategy {

    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);

}
