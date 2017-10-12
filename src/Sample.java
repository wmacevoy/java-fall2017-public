/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wmacevoy
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sample {

    public static void main(String[] args) {
        new Sample().run();
    }

    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            synchronized (this) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
                    } catch (SQLException ex) {
                        Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return connection;
    }

    void reset() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer primary key, name string)");
        } catch (SQLException ex) {
            Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    long insertPerson(String name) {
        long id = -1;
        try {
            Connection connection = getConnection();
            String sql = "insert into person (name) values (?)";

            PreparedStatement ps
                    = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    String getPerson(long id) {
        try {
            Connection connection = getConnection();
            String sql = "select name from person where id=?";
            PreparedStatement ps
                    = connection.prepareStatement(sql, Statement.NO_GENERATED_KEYS);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    void run() {
        reset();
        long aliceId = insertPerson("alice");
        System.out.println("aliceId=" + aliceId);
        long bobId = insertPerson("bob");
        System.out.println("alice name=" + getPerson(aliceId));
    }

}
