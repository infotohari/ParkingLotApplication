package ParkingLotApplication.factories;

import ParkingLotApplication.models.SpotAssignmentStrategyType;
import ParkingLotApplication.strategies.CheapestSpotAssignmentStrategy;
import ParkingLotApplication.strategies.NearestSpotAssignmentStrategy;
import ParkingLotApplication.strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType){
        if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEAPEST)){
            return new CheapestSpotAssignmentStrategy();
        } else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.NEAREST)){
            return new NearestSpotAssignmentStrategy();
        } else {
            return null;
        }
    }
}
