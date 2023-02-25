package DB;
import PlaneComponent.Engine.Engine;
import PlaneComponent.Frame.Frame;
import PlaneComponent.Wing.Wing;

import java.sql.*;

public class Adding implements IAdding{
    static PreparedStatement st = null;
    static Connection con = null;

    public void addEngine(Engine engine) throws SQLException{

        con = DatabaseConnection.getInstance().getConnection();
        st = con.prepareStatement("INSERT INTO planesengine(name,power, weight, volume) VALUES (?,?,?,?)");

        st.setString(1, engine.getName());
        st.setDouble(2, engine.getPower());
        st.setInt(3, engine.getWeight());
        st.setInt(4, engine.getVolume());

        st.execute();
        System.out.println("Engine is added.");
    }

    public void addWing(Wing wing) throws SQLException {

        con = DatabaseConnection.getInstance().getConnection();
        st = con.prepareStatement("INSERT INTO planeswing(name,airresistance, weight, volume) VALUES (?,?,?,?)");

        st.setString(1, wing.getName());
        st.setDouble(2, wing.getAirResistanceCoefficent());
        st.setInt(3, wing.getWeight());
        st.setInt(4, wing.getVolume());

        st.execute();
        System.out.println("Wing is added.");
    }

    public void addFrame(Frame frame) throws SQLException{

        con = DatabaseConnection.getInstance().getConnection();
        st = con.prepareStatement("INSERT INTO planesframe(name,airresistance, weight, capacity) VALUES (?,?,?,?)");

        st.setString(1, frame.getName());
        st.setDouble(2, frame.getAirResistanceCoefficent());
        st.setInt(3, frame.getWeight());
        st.setInt(4, frame.getCapacity());

        st.execute();
        System.out.println("Frame is added.");
    }
}
