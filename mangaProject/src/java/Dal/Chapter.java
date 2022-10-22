/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.chapter;

/**
 *
 * @author AS
 */
public class Chapter extends DBContext {

    public List<chapter> getChapterByNovelId(int nid) {
        String sql = "select * from chapter where nid = ?";
        List<chapter> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, nid);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                chapter c = new chapter(r.getInt("chapId"), r.getString("chapname"), r.getString("file"), r.getString("dayUpdate"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertChapter(String name, String file, int nid) {
        String sql = "insert into Chapter(chapname, [file],nid,dayUpdate)\n"
                + "values(?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, file);
            p.setInt(3, nid);
             long millis=System.currentTimeMillis(); 
            java.sql.Date date=new java.sql.Date(millis);
            p.setDate(4, date);
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

     public void deleteChapter(int chapID){
         String sql = "delete from chapter where chapId = ?";
         try{
             PreparedStatement p = connection.prepareStatement(sql);
             p.setInt(1, chapID);
             p.executeUpdate();
         }
         catch(Exception e){
             System.out.println(e);
         }
     }
    public static void main(String[] args) {
        Chapter c = new Chapter();
        List<chapter> list = c.getChapterByNovelId(2);
        System.out.println(list.get(0).getChapname());
    }
}
