package PlaneComponent;
public abstract class PlaneComponent {

    protected int weight;
    protected int volume;
    protected String name;

    public int getWeight()
    {
        return this.weight;
    }
    public int getVolume()
    {
        return this.volume;
    }
    public String getName()
    {
        return this.name;
    }
}
