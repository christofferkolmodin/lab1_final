import java.awt.*;
public class Scania extends Vehicle {

    private double trailerAngle = 0;

    protected Scania(){ super(2, 110, Color.magenta, "Scania");


    }
    protected void raiseTrailer(double angle){
        if((trailerAngle + angle) < 70){
            trailerAngle += angle;

        }

        else{
            trailerAngle = 70;

        }


    }
    protected void lowerTrailer(double angle){
        if((trailerAngle - angle) < 0) {
            trailerAngle = 0;
        }

        else{
            trailerAngle -= angle;
        }
    }

    public double getTrailerAngle(){
        return trailerAngle;
    }

    @Override
    public void gas(double amount){
        if (amount > 1) {
            amount = 1;
        }
        else if (amount < 0){
            amount = 0;
        }
        if (trailerAngle == 0){
            incrementSpeed(amount);
        }
    }

    @Override
    public void startEngine(){
        if (trailerAngle == 0) {
            currentSpeed = 0.1;
        }

        else{
            System.out.println("Trailer angle has to be 0 to start engine");
        }
    }

}
