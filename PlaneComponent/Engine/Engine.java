package PlaneComponent.Engine;
import PlaneComponent.PlaneComponent;
import java.lang.Math;

public abstract class Engine extends PlaneComponent implements IEngine{
    
    // power in horse power 75kg * (1m/s)^2
    public double power; 

    public int weight;

    public int volume;

    public String name;

    public double fuelConsumtion;

    public boolean canFly(int weight)
    {
        return (Math.sqrt(this.power / weight) < 28);
    }

    public double getSpeed(int weight)
    {
        if(this.canFly(weight))
        {
            return Math.sqrt(this.power / weight);
        }
        else
        {
            return 0;
        }
    }

}
