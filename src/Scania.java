import java.awt.*;
public class Scania extends Vehicle {

    private final TruckBed truckBed = new TruckBed();

    private double truckBedAngle = 0;

    public Scania(){ super(2, 110, Color.magenta, "Scania");


    }
    protected void setTruckBed(double angle){
        truckBedAngle = truckBed.setTruckBed(truckBedAngle, angle);
    }

    protected void raiseTruckBed(double angle){

    }
    protected void lowerTruckBed(double angle){

    }

    public double getTruckBedAngle(){
        return truckBedAngle;
    }

    @Override
    public void gas(double amount){
        if (amount > 1) {
            amount = 1;
        }
        else if (amount < 0){
            amount = 0;
        }
        if (truckBedAngle == 0){
            incrementSpeed(amount);
        }
    }

    @Override
    public void startEngine(){
        currentSpeed = truckBed.startEngine(truckBedAngle, currentSpeed);

    }


}
