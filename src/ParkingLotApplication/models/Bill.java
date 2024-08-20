package ParkingLotApplication.models;

import java.util.Date;
import java.util.List;

public class Bill extends ParkingLot{
    private Ticket ticket ;
    private Gate gate ;
    private Operator generatedBy ;
    private List<Payment> payment;
    private Double amount ;
    private Date exitTime ;
    private BillStatus billstatus ;
    private FeeCalculationStrategyType feeCalculationStrategyType ;
}
