import java.awt.*;
public class Scania extends Vehicle {

    private final TruckBed parent = new TruckBed();
    private final int minAngle = 0;
    private final int maxAngle = 70;
    private int truckBedAngle = 0;


    protected Scania(){
        super(2, 110, Color.magenta, "Scania", 5000);
    }

    public int getTrailerAngle(){
        return truckBedAngle;
    }

    public void raiseTrailer(int angle){
        truckBedAngle = parent.raiseTruckBed(maxAngle, angle, truckBedAngle);
    }

    public void lowerTrailer(int angle){
        truckBedAngle = parent.lowerTruckBed(minAngle, angle, truckBedAngle);
    }

    @Override
    public void startEngine(){
        currentSpeed = parent.startEngine(getTrailerAngle(), currentSpeed);
    }

    @Override
    public void gas(double amount){
        super.gas(parent.gas(getTrailerAngle(), amount));
    }


}
