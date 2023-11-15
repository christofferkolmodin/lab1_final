import java.awt.*;

public class VolvoVNR extends Vehicle{


    private final TruckBed truckBed = new TruckBed();

    private double maxAngle = 70;
    private double minAngle = 0;

    private double truckBedAngle = 0;


    //Variable for max amount of loaded cars
    //Size of cars cannot be too large (eget antagande)


    public VolvoVNR(){
        super(2, 150, Color.cyan, "VolvoVNR");


    }

    //Ramp only has two settings: UP or DOWN
    protected void raiseTruckBed(){
        truckBedAngle = truckBed.raiseTruckBed(maxAngle);

    }

    //Ramp can only be lowered if the car is not moving
    protected void lowerTruckBed(){
        truckBedAngle = truckBed.lowerTruckBed(minAngle);
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
        currentSpeed = truckBed.startEngine(truckBedAngle, currentSpeed);
    }



}
