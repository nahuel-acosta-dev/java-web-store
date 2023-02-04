/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nahuel
 */
public class UserDaoJDBC implements UserDao {
    
    private static final String SQL_SELECT_BY_ID = "SELECT id_user, email, phone, first_name, last_name, "
            + "addres_line_1, addres_line_2, city, state_province_region, zipcode, password " 
            + " FROM user WHERE id_user = ?";
    
    public User select_by_id(User user) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, user.getIdUser());
            rs = stmt.executeQuery();
            //rs.absolute(1);//nos posicionamos en el primer registro
            
            
            while(rs.next()){
                String email = rs.getString("email");
                int phone = rs.getInt("phone");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String addressLine1 = rs.getString("addres_line_1");
                String addressLine2 = rs.getString("addres_line_2");
                String city = rs.getString("city");
                String stateProvinceRegion = rs.getString(" state_province_region");
                String zipcode = rs.getString("zipcode");
                String password = rs.getString("password");
                
                user.setEmail(email);
                user.setPhone(phone);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setAddressLine1(addressLine1);
                user.setAddressLine2(addressLine2);
                user.setCity(city);
                user.setStateProvinceRegion(stateProvinceRegion);
                user.setZipcode(zipcode);
                user.setPassword(password);
            }

            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("ERROR EN PRODUCT DAO");
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }
        
        return user;
    }
    
}
