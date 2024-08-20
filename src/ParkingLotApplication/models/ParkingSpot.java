package ParkingLotApplication.models;

import java.util.List;

public class ParkingSpot extends BaseModel {
    private ParkingSpotStatus parkingSpotStatus;
    private Integer parkingSpotNo;
    private List<VehicleType> vehicleTypeList;
    private ParkingFloor parkingFloor;

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public Integer getParkingSpotNo() {
        return parkingSpotNo;
    }

    public void setParkingSpotNo(Integer parkingSpotNo) {
        this.parkingSpotNo = parkingSpotNo;
    }

    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
