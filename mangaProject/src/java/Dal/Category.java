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
import model.category;
import model.catenovel;
import model.lightnovel;

/**
 *
 * @author AS
 */
// lay toan bo category trong database
public class Category extends DBContext {

    public List<category> getAllCategory() {
        List<category> list = new ArrayList<>();
        String sql = "select * from Category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = new category(rs.getInt("cid"), rs.getString("cname"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public category getCategoryById(int cid) {

        String sql = "select * from  Category where cid = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, cid);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                category c = new category(rs.getInt("cid"), rs.getString("cname"));
                return c;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

// lay du lieu tu bang catenovel bang cid    
    public List<catenovel> getTop9ProductIdByCategoryId(int cid,int index ) {
        String sql = "select * from catenovel where cid = ? order by cid\n"
                + "offset ? rows fetch next 9 rows only";
        List<catenovel> list = new ArrayList<>();

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, cid);
            pt.setInt(2, (index-1)*9 );
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                catenovel p = new catenovel(rs.getInt("nid"), cid);
                list.add(p);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<catenovel> getLightnovelIdByCategoryId(int cid ) {
        String sql = "select * from catenovel where cid = ?";
        List<catenovel> list = new ArrayList<>();

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, cid);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                catenovel p = new catenovel(rs.getInt("nid"), cid);
                list.add(p);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    // lay du lieu tu catenovel bang lightnovel id
    public List<catenovel> getCategoryIdByLightnovelId(int nid) {
        String sql = "select * from catenovel where nid = ?";
        List<catenovel> list = new ArrayList<>();

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, nid);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                catenovel p = new catenovel(nid, rs.getInt("cid"));
                list.add(p);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    // lay cac light novel thuoc 1 category
    public List<lightnovel> getLightnovelByCategoryId(List<catenovel> lc) {
        List<lightnovel> list = new ArrayList<>();
        String sql = "select * from lightnovel where nid = ?";
        try {

            for (int i = 0; i < lc.size(); i++) {
                PreparedStatement p = connection.prepareStatement(sql);
                p.setInt(1, lc.get(i).getNid());
                ResultSet r = p.executeQuery();
                if (r.next()) {
                    lightnovel l = new lightnovel(r.getInt("nid"), r.getString("name"), r.getString("otherName"), r.getString("img"), r.getString("des"), r.getString("status"));
                    list.add(l);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // lay cac category cua 1 light novel
    public List<category> getCategoryByLightnovelId(List<catenovel> lc) {
        List<category> list = new ArrayList<>();
        String sql = "select * from category where cid = ?";
        try {

            for (int i = 0; i < lc.size(); i++) {
                PreparedStatement p = connection.prepareStatement(sql);
                p.setInt(1, lc.get(i).getCid());
                ResultSet r = p.executeQuery();
                if (r.next()) {
                    category l = new category(r.getInt("cid"), r.getString("cname"));
                    list.add(l);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertCategory(int nid, int[] cid) {
        String sql = "insert into catenovel(nid,cid)\n"
                + "values(?,?)";
        try {
            for (int i = 0; i < cid.length; i++) {

                PreparedStatement p = connection.prepareStatement(sql);
                p.setInt(1, nid);
                p.setInt(2, cid[i]);
                p.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deteleCategory(int nid) {
        String sql = "delete from  catenovel\n"
                + "where nid = ?";
        try {

            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, nid);
            p.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //test
    public static void main(String[] args) {
        Category c = new Category();
     //   List<catenovel> list = c.getProductIdByLightnovelId(2);
  //      List<catenovel> lc = c.getProductIdByCategoryId(1,0);
           List<catenovel> list = c.getLightnovelIdByCategoryId(1);
           System.out.println(list.size());
        category cae = c.getCategoryById(5);
  //      System.out.println(lc.size());

    }
}
