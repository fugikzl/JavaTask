package PlaneComponent;
public abstract class PlaneComponent {
    private int weight;
    private int volume;
    private String name;


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
