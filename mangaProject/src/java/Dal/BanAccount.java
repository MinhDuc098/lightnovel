/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.account;
import model.ban;

/**
 *
 * @author AS
 */
public class BanAccount extends DBContext {
    public void Ban(int uID){
       String sql = "insert into ban([uID])\n"
                + "values(?)";
       try{
           PreparedStatement p =connection.prepareStatement(sql);
           p.setInt(1, uID);
          
           p.executeUpdate();
       }
       catch(Exception e){
           System.out.println(e);
       }
   }
    public ban checkBanAccount(int uID){
        String sql = "select * from ban where [uID] = ?";
        try{
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, uID);
            ResultSet r = p.executeQuery();
            if(r.next()){
                ban b = new ban(r.getInt("banid"), uID);
                return b;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public List<ban> getAllBanAccount(){
        String sql = "select * from ban";
        List<ban> list = new ArrayList<>();
        try{
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while(r.next()){
                ban b = new ban(r.getInt("banid"), r.getInt("uID"));
                list.add(b);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
}
