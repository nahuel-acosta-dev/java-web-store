/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import domain.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nahuel
 */
public class AdminDaoJDBC implements AdminDao {

    private static final String SQL_SELECT = "SELECT id_admin, name, last_name, email, password, super_user "
            + " FROM admin";
    
    private static final String SQL_SELECT_CREDENTIALS = "SELECT * "
            + "FROM admin WHERE email = ? and password = ?";
                

    private static final String SQL_SELECT_BY_ID = "SELECT id_admin, name, last_name, email, password, super_user "
            + "FROM admin WHERE id_admin = ?";

    private static final String SQL_INSERT = "INSERT INTO admin(name, last_name, email, password, super_user) "
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE admin "
            + " SET name=?, last_name=?, email=?, password=?, super_user=? WHERE id_admin=?";

    private static final String SQL_DELETE = "DELETE FROM admin WHERE id_admin = ?";
    
    
    public Admin identify(Admin admin) throws Exception, SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CREDENTIALS);
            stmt.setString(1, admin.getEmail());
            stmt.setString(2, admin.getPassword());
            rs = stmt.executeQuery();
            //rs.absolute(1);//nos posicionamos en el primer registro
            while(rs.next()){
                
                rows += 1;
                
                int idAdmin = rs.getInt("id_admin");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                boolean superUser = rs.getBoolean("super_user");

                admin.setIdAdmin(idAdmin);
                admin.setName(name);
                admin.setLastName(lastName);
                admin.setEmail(email);
                admin.setPassword(password);
                admin.setSuperUser(superUser);
            }
            
            if(rows==1){
                return admin;
            }
            else{
                return null;
            }
            
            
        } catch (SQLException ex) {
            System.out.println("falla en el segundo catch");
            ex.printStackTrace(System.out);
            System.out.println(ex);
            
            return null;
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        //return admin;
    }

    public List<Admin> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Admin admin = null;
        List<Admin> admins = new ArrayList<>();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idAdmin = rs.getInt("id_admin");
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                boolean superUser = rs.getBoolean("super_user");

                admin = new Admin(idAdmin, name, lastName, email, password, superUser);

                admins.add(admin);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return admins;
    }

    public Admin select_by_id(Admin admin) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, admin.getIdAdmin());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro

            String name = rs.getString("name");
            String lastName = rs.getString("lastName");
            String email = rs.getString("email");
            String password = rs.getString("password");

            admin.setName(name);
            admin.setLastName(lastName);
            admin.setEmail(email);
            admin.setPassword(password);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return admin;

    }

    public int insert(Admin admin) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, admin.getName());
            stmt.setString(2, admin.getLastName());
            stmt.setString(3, admin.getEmail());
            stmt.setString(4, admin.getPassword());
            stmt.setBoolean(5, admin.getSuperUser());
            rows = stmt.executeUpdate();
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return rows;
    }
    
    public int update(Admin admin) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, admin.getName());
            stmt.setString(2, admin.getLastName());
            stmt.setString(3, admin.getEmail());
            stmt.setString(4, admin.getPassword());
            stmt.setInt(5, admin.getIdAdmin());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return rows;
        
    }
    
    public int delete(Admin admin) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, admin.getIdAdmin());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return rows;
        
    }
}
