import java.awt.*;
import java.util.Stack;

public class VolvoVNR extends Vehicle{


    private final TruckBed parent = new TruckBed();
    private final int rampUp = 0;
    private final int rampDown = 1;
    private final int loadedCarCapacity = 4;
    private final int loadingRange = 2;
    private final int carWeightLimit = 2500;
    private Stack<Vehicle> loadedCars = new Stack<Vehicle>();
    private int size = loadedCars.size();
    private int truckBedPosition = 0;

    //Variable for max amount of loaded cars
    //Size of cars cannot be too large (eget antagande)

    public VolvoVNR(){
        super(2, 150, Color.cyan, "VolvoVNR", 6500);
    }

    public int getloadedCarsSize() {
        return loadedCars.size();
    }

    public int getTruckBedPosition() {
        return truckBedPosition;
    }

    public void lowerRamp(int incrementPosition){
        truckBedPosition = parent.raiseTruckBed(rampDown, incrementPosition, truckBedPosition);
    }

    //Ramp can only be lowered if the car is not moving
    public void raiseRamp(int decrementPosition){
        truckBedPosition = parent.lowerTruckBed(rampUp, decrementPosition, truckBedPosition);
    }

    @Override
    public void startEngine(){
        currentSpeed = parent.startEngine(getTruckBedPosition(), currentSpeed);
    }

    @Override
    public void gas(double amount){
        super.gas(parent.gas(getTruckBedPosition(), amount));
    }

    public void loadCar(Vehicle car){
        if (getTruckBedPosition() == rampDown && car.getCarWeightInKG() <= carWeightLimit) {
            if (car.getPositionX() >= xPosition - loadingRange &&
                    car.getPositionX() <= xPosition + loadingRange &&
                    car.getPositionY() >= yPosition - loadingRange &&
                    car.getPositionY() <= yPosition + loadingRange &&
                    loadedCars.size() != loadedCarCapacity &&
                    // Checks if car is already loaded. search(car) returns -1 if it is not loaded.
                    loadedCars.search(car) == -1) {

                loadedCars.push(car);
                car.xPosition = xPosition;
                car.yPosition = yPosition;
            }
        }
    }

    //Unloading can only happen if the ramp is the lowered mode
    //Unloaded cars should be close to the truck directly after unloading
    //Unloaded cars should unload in reverse order of the loading (first in, last out)
    protected void unloadCar(){
        if (getTruckBedPosition() == rampDown && loadedCars.size() != 0)
            loadedCars.peek().xPosition = xPosition - loadingRange;
            loadedCars.pop();

    }

    @Override
    public void move() {
            super.move();
            for (Vehicle car : loadedCars) {
                car.xPosition = xPosition;
                car.yPosition = yPosition;
        }
    }
    //This truck cannot be loaded onto another.



}
