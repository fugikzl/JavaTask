import PlaneComponent.Engine.Engine;
import PlaneComponent.Frame.Frame;
import PlaneComponent.Wing.Wing;

public class Plane {
    
    private Engine engine;
    private Frame frame;
    private Wing wing;

    public int totalWeight;

    public Plane(Engine engine, Frame frame, Wing wing) throws Exception
    {
        if(frame.getCapacity() < (engine.getVolume() + wing.getVolume()))
        {
            throw new Exception("Plane framework can't fit components");
        }
        else
        {
            this.engine = engine;
            this.wing = wing;
            this.frame = frame;
        }
    }

    public boolean canFly()
    {
        return (Math.sqrt(this.engine.getPower() / this.getWeight()) * this.getAirResistanceCoefficent() >= 28);
    }

    public double getSpeed()
    {
        if(this.canFly())
        {
            return Math.sqrt(this.engine.getPower() / this.getWeight()) * this.getAirResistanceCoefficent();
        }
        else
        {
            return 0;
        }
    }

    public void getPlaneInfo()
    {
        System.out.println("Plane speed is " + this.getSpeed() + "m/s");
    }

    private int getWeight()
    {
        return this.engine.getWeight() + this.frame.getWeight() + this.wing.getWeight();
    }

    private double getAirResistanceCoefficent()
    {
        return (0.7 * this.wing.getAirResistanceCoefficent() + 0.3 * this.frame.getAirResistanceCoefficent());
    }

}
