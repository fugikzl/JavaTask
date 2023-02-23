package DB;

import PlaneComponent.Engine.Engine;
import PlaneComponent.Frame.Frame;
import PlaneComponent.Wing.Wing;

import java.sql.SQLException;

public interface IAdding {
    public void addEngine(Engine engine) throws SQLException;
    public void addWing(Wing wing) throws SQLException;
    public void addFrame(Frame frame) throws SQLException;
}
