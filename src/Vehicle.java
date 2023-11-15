import java.awt.*;

enum Direction {
    RIGHT,
    LEFT,
    UP,
    DOWN
}

public class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    protected String modelName; // The car model name
    protected double xPosition, yPosition = 0;
    protected Direction direction = Direction.RIGHT;

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double speedFactor(){
        return enginePower * 0.01;
    }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void move(){
        // Switch?
        switch (direction) {
            case RIGHT:
                xPosition += getCurrentSpeed();
                break;
            case LEFT:
                xPosition -= getCurrentSpeed();
                break;
            case UP:
                yPosition += getCurrentSpeed();
                break;
            case DOWN:
                yPosition -= getCurrentSpeed();
        }
    }

    public void turnLeft(){
        switch (direction) {
            case RIGHT:
                direction = Direction.UP;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
        }
    }

    public void turnRight(){
        switch (direction) {
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
        }
    }

    public void gas(double amount){
        if (amount > 1) {
            amount = 1;
        }
        else if (amount < 0){
            amount = 0;
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount > 1) {
            amount = 1;
        }
        else if (amount < 0){
            amount = 0;
        }
        decrementSpeed(amount);
    }
}
