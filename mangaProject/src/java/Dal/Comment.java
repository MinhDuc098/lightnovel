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
import model.account;
import model.comment;

/**
 *
 * @author AS
 */
public class Comment extends DBContext {

    public List<comment> getChapterByNovelId(int nid) {
        String sql = "select * from comment where nid = ?";
        List<comment> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, nid);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                account acc = getAccountById(r.getInt("uID"));
                comment c = new comment(acc, r.getString("comment"), r.getInt("nid"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public account getAccountById(int id) {
        String sql = "select * from Account where uID = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                account acc = new account(id, r.getString("user"), r.getString("pass"), r.getInt("isAdmin"), r.getInt("isUser"), r.getString("email"),r.getString("img"));
                return acc;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertComment(int uID, String comment, int nid) {
        String sql = "insert into comment(nid,[uID],comment)\n"
                + "values(?,?,?) ";
        try{
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, nid);
            p.setInt(2, uID);
            p.setString(3,comment);
            p.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Comment c = new Comment();
        System.out.println(c.getAccountById(1).getEmail());
    }

}
