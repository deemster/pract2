import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ovchip", "postgres", "halloo");



        getConnection();
        closeConnection();

    }

    private static void closeConnection() {
    }

    private static void getConnection() {
    }


    private static void testReizigerDAO(ReizigerDAO rdao) throws SQLException {
        System.out.println("\n---------- Test ReizigerDAO -------------");

        List<Reiziger> reizigers = rdao.findAll();
        System.out.println("[Test] ReizigerDAO.findAll() geeft de volgende reizigers:");
        for (Reiziger r : reizigers) {
            System.out.println(r);
        }
        System.out.println();

        String gbdatum = "1981-03-14";
        Reiziger sietske = new Reiziger(77, "S", "", "Boers", java.sql.Date.valueOf(gbdatum));
        System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.save() ");
        rdao.save(sietske);
        reizigers = rdao.findAll();
        System.out.println(reizigers.size() + " reizigers\n");
    }
}
