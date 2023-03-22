/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import domain.SalesExtends;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nahuel
 */
public interface SalesDao {
    public List<SalesExtends> select_max_limit(int limit) throws SQLException;
    public List<SalesExtends> select_limit(int offset, int count) throws SQLException;
    public double select_entries_of_the_day() throws SQLException;
    public double select_all_entries() throws SQLException;
    public int select_count() throws SQLException;
    public int select_count_of_day() throws SQLException;
}
