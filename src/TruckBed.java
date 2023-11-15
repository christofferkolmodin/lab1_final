public class TruckBed {


    public int raiseTruckBed(int maxPosition, int amount, int currentPosition) {
        return Math.min(currentPosition + amount, maxPosition);
    }

    public int lowerTruckBed(int minPosition, int amount, int currentPosition) {
        return Math.max(currentPosition - amount, minPosition);
    }

    //    public double setTruckBedPosition(double maxPosition, double minPosition, double position){
//
//
//        if ((position > maxPosition) || (position < minPosition)){
//            return position;
//        }
//        return newAngle;
//    }

    public double startEngine(int truckBedPosition, double currentSpeed) {

        if (currentSpeed != 0) {
            System.out.println("Engine is already on!");
        }
        else if (truckBedPosition == 0) {
            return 0.1;
        }
        else {
            System.out.println("Trailer position has to be 0 to start engine");
        }
        return currentSpeed;
    }

    public double gas(int truckBedPosition, double amount) {
        if (truckBedPosition == 0) {
            return amount;
        }
        else {
            return 0;
        }
    }
}
