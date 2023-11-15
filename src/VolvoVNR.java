import java.awt.*;

public class VolvoVNR extends Vehicle{


    private final TruckBed parent = new TruckBed();
    private final int minPosition = 0;
    private final int maxPosition = 1;
    private int truckBedPosition = 0;

    //Variable for max amount of loaded cars
    //Size of cars cannot be too large (eget antagande)

    public VolvoVNR(){
        super(2, 150, Color.cyan, "VolvoVNR");

    }

    public int getTruckBedPosition() {
        return truckBedPosition;
    }
    //Ramp only has two settings: UP or DOWN
    public void raiseTruckBedPosition(int incrementPosition){
        truckBedPosition = parent.raiseTruckBed(maxPosition, incrementPosition, truckBedPosition);
    }

    //Ramp can only be lowered if the car is not moving
    public void lowerTruckBedPosition(int decrementPosition){
        truckBedPosition = parent.lowerTruckBed(maxPosition, decrementPosition, truckBedPosition);
    }

    @Override
    public void startEngine(){
        currentSpeed = parent.startEngine(getTruckBedPosition(), currentSpeed);
    }

    @Override
    public void gas(double amount){
        super.gas(parent.gas(getTruckBedPosition(), amount));
    }

    //Cars can only be loaded if the ramp is down
    //Cars should have the same position as the truck while loaded
    protected void loadCars(){}

    //Unloading can only happen if the ramp is the lowered mode
    //Unloaded cars should be close to the truck directly after unloading
    //Unloaded cars should unload in reverse order of the loading (first in, last out)
    protected void unloadCars(){}

    //This truck cannot be loaded onto another.



}
