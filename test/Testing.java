import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class Testing {

    private Saab95 saab = new Saab95();
    private Vehicle volvo = new Volvo240();

    private Scania scania = new Scania();

    @Test
    public void testBilGetEnginePowerAndSaabConstructor(){
        assertTrue(saab.getEnginePower() == 125);
    }

    @Test
    public void testBilGetNrDoorsAndSaabConstructor(){
        assertTrue(saab.getNrDoors() == 2);
    }
    @Test
    public void testBilGetColorAndSaabConstructor(){
        assertTrue(saab.getColor() == Color.red);
    }
    @Test
    public void testSaabConstructorModelNameAttribute(){
        assertTrue(saab.modelName.equals("Saab95"));
    }

    @Test
    public void testBilGetEnginePowerAndVolvoConstructor(){
        assertTrue(volvo.getEnginePower() == 100);
    }

    @Test
    public void testBilGetNrDoorsAndVolvoConstructor(){
        assertTrue(volvo.getNrDoors() == 4);
    }
    @Test
    public void testBilGetColorAndVolvoConstructor(){
        assertTrue(volvo.getColor() == Color.black);
    }
    @Test
    public void testVolvoConstructorModelNAmeAttribute(){
        assertTrue(volvo.modelName.equals("Volvo240"));
    }

    @Test
    public void testBilSetColor() {
        saab.setColor(Color.blue);
        assertTrue(saab.getColor() == Color.blue);
    }

    @Test
    public void testStartEngine() {
        saab.startEngine();
        assertTrue(saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testStopEngine(){
        saab.startEngine();
        saab.stopEngine();
        assertTrue(saab.getCurrentSpeed() == 0);
    }

    @Test
    public void testVolvoSpeedFactor() {
        assertTrue(volvo.speedFactor() == 1.25);
    }

    @Test
    public void testSaabSpeedFactorTurboOn() {
        saab.setTurboOn();
        assertTrue(saab.speedFactor() == 1.625);
    }

    @Test
    public void testSaabSpeedFactorTurboOff() {
        saab.setTurboOn();
        saab.setTurboOff();
        assertTrue(saab.speedFactor() == 1.25);
    }

    // This test was used to test incrementSpeed() when it was public
//    @Test
//    public void testIncrementSpeed() {
//        volvo.startEngine();
//        volvo.incrementSpeed(50);
//        assertTrue(volvo.getCurrentSpeed() == 62.6);
//    }

    // This test was used to test decrementSpeed() when it was public
//    @Test
//    public void testDecrementSpeed() {
//        volvo.startEngine();
//        volvo.incrementSpeed(50);
//        volvo.decrementSpeed(25);
//        assertTrue(volvo.getCurrentSpeed() == 31.35);
//    }

        // This test was used to test testMove when it was public
//    @Test
//    public void testMove() {
//        volvo.startEngine();
//        volvo.incrementSpeed(50);
//        volvo.move();
//        volvo.move();
//        assertTrue(volvo.xPosition == 125.2);
//    }

        // This test was used to test turnLeft() when it was public
//    @Test
//    public void testTurnLeft() {
//        volvo.startEngine();
//        volvo.turnLeft();
//        volvo.incrementSpeed(50);
//        volvo.move();
//        assertTrue(volvo.yPosition == 62.6);
//    }

    @Test
    public void testTurnRight() {
        volvo.turnRight();
        assertTrue(volvo.direction == Direction.DOWN);
    }

    @Test
    public void testGas() {
        volvo.startEngine();
        volvo.gas(0.5);
        assertTrue(volvo.getCurrentSpeed() == 0.725);
    }

    @Test
    public void testGasUpperLimit() {
        volvo.startEngine();
        volvo.gas(12);
        assertTrue(volvo.getCurrentSpeed() == 1.35);
    }

    @Test
    public void testGasLowerLimit() {
        volvo.startEngine();
        volvo.gas(-5);
        assertTrue(volvo.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testBreak() {
        volvo.startEngine();
        volvo.gas(0.5);

        volvo.brake(0.3);
        // 0.725 - (1.25 * 0.3)
        assertTrue(volvo.getCurrentSpeed() == 0.35);
    }

    @Test
    public void testBreakUpperLimit() {
        for (int i = 0; i < 1000; i++)
        {
            volvo.gas(1);
        }
        // currentSpeed = 100
        volvo.brake(12);
        assertTrue(volvo.getCurrentSpeed() == 98.75);
    }

    @Test
    public void testBreakLowerLimit() {
        for (int i = 0; i < 1000; i++)
        {
            volvo.gas(1);
        }
        // currentSpeed = 100
        volvo.brake(-5);
        assertTrue(volvo.getCurrentSpeed() == 100);
    }

    @Test
    public void testSpeedLimitedByEnginePower() {
        volvo.startEngine();
        for (int i = 0; i < 1000; i++)
        {
            volvo.gas(1);
        }
        assertTrue(volvo.getCurrentSpeed() == 100);
    }

    @Test
    public void testScaniaRaiseTrailer(){
        scania.raiseTrailer(20);
        scania.raiseTrailer(7);

        assertTrue(scania.getTrailerAngle() == 27);
    }

    @Test
    public void testScaniaLowerTrailer(){
        scania.raiseTrailer(25);
        scania.lowerTrailer(14);

        assertTrue(scania.getTrailerAngle() == 11);
    }

    @Test
    public void testScaniaRaiseTrailerUpperLimit(){
        scania.raiseTrailer(500);

        assertTrue(scania.getTrailerAngle() == 70);
    }

    @Test
    public void testScaniaLowerTrailerLowerLimit(){
        scania.lowerTrailer(100);

        assertTrue(scania.getTrailerAngle() == 0);
    }

    @Test
    public void testScaniaStartEngine(){
        scania.raiseTrailer(20);
        scania.startEngine();

        assertTrue(scania.getCurrentSpeed() == 0);

    }


//    @Test
//    public void testScaniaGas(){
//        scania.raiseTrailer(20);
//        scania.gas(1);
//
//        assertTrue(scania.getCurrentSpeed() == 0);
//    }

}
