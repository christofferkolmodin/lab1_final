public class TruckBed{
    public TruckBed(){}
    public double raiseTruckBed(double maxAngle){
        return maxAngle;
    }

    public double lowerTruckBed(double minAngle){
        return minAngle;
    }

    public double setTruckBed(double currentAngle, double newAngle){
        if ((currentAngle + newAngle < 70) && (currentAngle + newAngle) > 0){
            newAngle = currentAngle + newAngle;


        }

        return newAngle;
    }

    public void getTruckBedAngle(){


    }



    public double startEngine(double trailerAngle, double currentSpeed){

        if (trailerAngle == 0) {
            currentSpeed = 0.1;
        }

        else{
            System.out.println("Trailer angle has to be 0 to start engine");
        }

        return currentSpeed;


    }
}
