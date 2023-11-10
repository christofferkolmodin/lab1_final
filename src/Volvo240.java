import java.awt.*;

public class Volvo240 extends Bil {

    private final static double trimFactor = 1.25;

    protected Volvo240() {
        super(4, 100, Color.black, "Volvo240");
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}

