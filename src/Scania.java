import java.awt.*;
public class Scania extends Vehicle {

    private final TruckBed parent = new TruckBed();
    private int truckBedAngle = 0;
    private int maxAngle = 70;
    private int minAngle = 0;

    protected Scania(){
        super(2, 110, Color.magenta, "Scania");
    }
    protected void raiseTrailer(int angle){
        truckBedAngle = parent.raiseTruckBed(maxAngle, angle, truckBedAngle);
    }
    protected void lowerTrailer(int angle){
        truckBedAngle = parent.lowerTruckBed(minAngle, angle, truckBedAngle);
    }

    public int getTrailerAngle(){
        return truckBedAngle;
    }

    @Override
    public void gas(double amount){
        super.gas(parent.gas(truckBedAngle, getCurrentSpeed(), amount));
    }
    @Override
    public void startEngine(){
        currentSpeed = parent.startEngine(getTrailerAngle(), currentSpeed);
    }

}
