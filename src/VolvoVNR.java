import java.awt.*;

public class VolvoVNR extends Vehicle{


    private final TruckBed parent = new TruckBed();

    private int maxPosition = 1;
    private int minPosition = 0;
    private int truckBedPosition = 0;
    private int amount;


    //Variable for max amount of loaded cars
    //Size of cars cannot be too large (eget antagande)


    public VolvoVNR(){
        super(2, 150, Color.cyan, "VolvoVNR");

    }

    public double getTruckBedPosition() {
        return truckBedPosition;
    }
    //Ramp only has two settings: UP or DOWN
    protected void raiseTruckBedPosition(int amount){
        truckBedPosition = parent.raiseTruckBed(maxPosition, amount, truckBedPosition);
    }

    //Ramp can only be lowered if the car is not moving
    protected void lowerTruckBed(){
        truckBedPosition = parent.lowerTruckBed(maxPosition, amount, truckBedPosition);
    }

    //Cars can only be loaded if the ramp is down
    //Cars should have the same position as the truck while loaded
    protected void loadCars(){}

    //Unloading can only happen if the ramp is the lowered mode
    //Unloaded cars should be close to the truck directly after unloading
    //Unloaded cars should unload in reverse order of the loading (first in, last out)
    protected void unloadCars(){}

    //This truck cannot be loaded onto another.

    @Override
    public void startEngine(){
        currentSpeed = parent.startEngine(truckBedPosition, currentSpeed);
    }

}
