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

/**
 *
 * @author AS
 */
public class Lightnovel extends DBContext {
// lay toan bo lightnovel

    public List<lightnovel> getAllLightnovel() {
        List<lightnovel> list = new ArrayList<>();
        String sql = "select * from lightnovel ";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                lightnovel l = new lightnovel(r.getInt("nid"), r.getString("name"), r.getString("otherName"), r.getString("img"), r.getString("des"), r.getString("status"));
                list.add(l);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<lightnovel> getLightnovelOrderByDate(int a) {
        String sql = "select * from lightnovel order by  dayOfUpdate desc\n"
                + "offset ? rows fetch next 9 rows only";
                List<lightnovel> list = new ArrayList<>();

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, (a-1)*9 );
            ResultSet r = p.executeQuery();
            while(r.next()){
           lightnovel l = new lightnovel(r.getInt("nid"), r.getString("name"), r.getString("otherName"), r.getString("img"), r.getString("des"), r.getString("status"));
           list.add(l);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // lay light novel dua theo id
    public lightnovel getLightnovelById(int nid) {
        String sql = "select * from lightnovel where nid = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, nid);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                lightnovel l = new lightnovel(r.getInt("nid"), r.getString("name"), r.getString("otherName"), r.getString("img"), r.getString("des"), r.getString("status"));
                return l;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // lay light novel by name
    public List<lightnovel> getLightnovelByName(String name) {
        String sql = "select * from lightnovel where name like ? or otherName like ?";
        List<lightnovel> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, "%" + name + "%");
            p.setString(2, "%" + name + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                lightnovel l = new lightnovel(r.getInt("nid"), r.getString("name"), r.getString("otherName"), r.getString("img"), r.getString("des"), r.getString("status"));
                list.add(l);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // xoa lightnovel
    public void deleteLightnovel(int nid) {
        String sql = "delete from lightnovel\n"
                + "where nid = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, nid);

            p.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // insert new lightnovel
    public void insertLightnovel(String name, String othername, String img, String des, String status) {
        String sql = "insert into lightnovel([name],otherName,img,[des],[status],dayOfUpdate)\n"
                + "values(?,?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, othername);
            p.setString(3, img);
            p.setString(4, des);
            p.setString(5, status);

            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            p.setDate(6, date);

            p.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getLightnovel() {
        String sql = "select max(nid)as nid from lightnovel ";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                int i = r.getInt("nid");
                return i;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public void updateLightnovel(int nid, String name, String othername, String img, String des, String status) {
        String sql = "update lightnovel\n"
                + "set [name] = ? ,otherName =?,img = ?, [des] = ?, [status] =?,dayOfUpdate=?\n"
                + "where nid = ? ;";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, othername);
            p.setString(3, img);
            p.setString(4, des);
            p.setString(5, status);

            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            p.setDate(6, date);

            p.setInt(7, nid);

            p.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateDate(int nid) {
        String sql = "update lightnovel set dayOfUpdate=? where nid =?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            p.setDate(1, date);
            p.setInt(2, nid);
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Lightnovel l = new Lightnovel();
        lightnovel li = l.getLightnovelById(2);
        l.deleteLightnovel(1010);
        System.out.println(l.getLightnovelById(1010));
    }
}
