/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.lightnovel;
import model.save;

/**
 *
 * @author AS
 */
public class Save extends DBContext {

    public List<save> getSavedNovelByUid(int uID) {
        List<save> list = new ArrayList<>();
        String sql = "select * from [save] where uID = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, uID);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                save l = new save(uID, r.getInt("nid"));
                list.add(l);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertSave(int uID, int nid) {
        String sql = "insert into [save]([uID],nid)\n"
                + "values(?,?)";
        try{
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, uID);
            p.setInt(2, nid);
            p.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void  deleteSave(int nid,int uID){
        String sql = "delete from [save]\n"
                + "where [uID] = ? and nid = ?";
        try{
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, uID);
            p.setInt(2, nid);
            p.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
