package ParkingLotApplication.models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private List<Gate> gates;
    private List<VehicleType> supportVehicleTypes;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getSupportVehicleTypes() {
        return supportVehicleTypes;
    }

    public void setSupportVehicleTypes(List<VehicleType> supportVehicleTypes) {
        this.supportVehicleTypes = supportVehicleTypes;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategy() {
        return spotAssignmentStrategyType;
    }

    public void setSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }
}

