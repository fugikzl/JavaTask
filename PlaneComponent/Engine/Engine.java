package PlaneComponent.Engine;
import PlaneComponent.PlaneComponent;

public class Engine extends PlaneComponent implements IEngine{

    public Engine(String name, double power, int weight, int volume)
    {
        super(weight, volume, name);
        this.power = power;
    }
    // power in horse power 75kg * (1m/s)^2
    private double power;

    public double getPower()
    {
        return this.power;
    }

}
