/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.PreparedStatement;

/**
 *
 * @author AS
 */
public class RemoveBan extends DBContext {

    public void remove(int uID) {
        String sql = "delete from ban\n"
                + "where [uID] = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, uID);

            p.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
