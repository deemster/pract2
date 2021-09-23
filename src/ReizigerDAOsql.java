import java.sql.*;
import java.util.List;

public class ReizigerDAOsql implements  ReizigerDAO{
    public Connection conn;
    Statement myStmt = conn.createStatement();
    ResultSet myRs = myStmt.executeQuery("select * from reiziger");

    public ReizigerDAOsql() throws SQLException {
    }

    @Override
    public boolean save(Reiziger reiziger) throws SQLException {
        boolean uitvoer = false;
        ResultSet save = myStmt.executeQuery("");

        return uitvoer;
    }

    @Override
    public boolean update(Reiziger reiziger) throws SQLException {
        boolean uitvoer = false;
        String delete = "UPDATE reiziger WHERE id=?";

        return uitvoer;
    }

    @Override
    public boolean delete(Reiziger reiziger) throws SQLException {
        boolean uitvoer = false;
        String delete = "DELETE FROM reiziger WHERE reiziger_id='1'";
        PreparedStatement state = conn.prepareStatement(delete);
        int deletedRows = state.executeUpdate();
        if (deletedRows > 0){
            uitvoer = true;

        }
        return uitvoer;
    }

    @Override
    public Reiziger findById(int id) throws SQLException {
        try {
            ResultSet myRs = myStmt.executeQuery("select * from reiziger");
            String ijdee = myRs.getString("reiziger_id");
            System.out.println(ijdee);
        }
        catch (Exception exc){
            exc.printStackTrace();
        };
        return null;
    }

    @Override
    public List<Reiziger> findByGbDatum(String datum) throws SQLException {
        try {
            ResultSet myRs = myStmt.executeQuery("select datum from reiziger");
            System.out.println(myRs);
        }
        catch (Exception exc){
            exc.printStackTrace();
        };
        return null;
    }

    @Override
    public List<Reiziger> findAll() throws SQLException {
        ResultSet myRs = myStmt.executeQuery("select * from reiziger");
        return (List<Reiziger>) myRs;
    }
}
