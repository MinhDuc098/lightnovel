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

/**
 *
 * @author AS
 */

// check xem username voi password co hop le k
public class Account extends DBContext {
   public account checkAccount(String user, String pass){
       String sql = "select * from Account where [user] = ? and pass = ? ";
       try{
           PreparedStatement pt = connection.prepareStatement(sql);
           pt.setString(1, user);
           pt.setString(2, pass);
           ResultSet r = pt.executeQuery();
           if(r.next()){
               account a = new account(r.getInt("uID"), r.getString("user"), r.getString("pass"), r.getInt("isAdmin"), r.getInt("isUser"), r.getString("email"));
             return a;
           }
          
       }
       catch(Exception e){
           System.out.println(e);
       }
       return null;
   }
   
   // tao 1 acc moi cho user
   public void insertAccount(String user, String pass, String email){
       String sql = "insert into Account([user],pass,isAdmin,isUser,email)\n"
                + "values(?,?,0,1,?)";
       try{
           PreparedStatement p =connection.prepareStatement(sql);
           p.setString(1, user);
           p.setString(2, pass);
           p.setString(3, email);
           p.executeUpdate();
       }
       catch(Exception e){
           System.out.println(e);
       }
   }
   
   // tao account cho admin
   public void insertAdminAccount(String user, String pass, String email){
       String sql = "insert into Account([user],pass,isAdmin,isUser,email)\n"
                + "values(?,?,1,0,?)";
       try{
           PreparedStatement p =connection.prepareStatement(sql);
           p.setString(1, user);
           p.setString(2, pass);
           p.setString(3, email);
           p.executeUpdate();
       }
       catch(Exception e){
           System.out.println(e);
       }
   }
   
   // kiem tra xem acc co trung username k
   public account checkAccountSignup(String email){
       String sql = "select * from Account where [email] = ? ";
       try{
           PreparedStatement pt = connection.prepareStatement(sql);
           pt.setString(1, email);
           
           ResultSet r = pt.executeQuery();
           if(r.next()){
               account a = new account(r.getInt("uID"), r.getString("user"), r.getString("pass"), r.getInt("isAdmin"), r.getInt("isUser"), r.getString("email"));
             return a;
           }
          
       }
       catch(Exception e){
           System.out.println(e);
       }
       return null;
   }
   
   
   // lay tat ca account
   
   public List<account> getAllAccount(){
       List<account> list = new ArrayList<>();
       String sql = "select * from Account ";
       try{
           PreparedStatement pt = connection.prepareStatement(sql);
           
           ResultSet r = pt.executeQuery();
           while(r.next()){
               account a = new account(r.getInt("uID"), r.getString("user"), r.getString("pass"), r.getInt("isAdmin"), r.getInt("isUser"), r.getString("email"));
              list.add(a);
           }
          
       }
       catch(Exception e){
           System.out.println(e);
       }
       return list;
   }
   
   public account getAccountById(int uID){
       String sql = "select * from Account where [uID] = ?";
       try{
           PreparedStatement p = connection.prepareStatement(sql);
           p.setInt(1, uID);
           ResultSet r = p.executeQuery();
           if(r.next()){
               account a = new account(r.getInt("uID"), r.getString("user"), r.getString("pass"), r.getInt("isAdmin"), r.getInt("isUser"), r.getString("email"));
               return a;
           }
               
       }
       catch(Exception e){
           System.out.println(e);
       
       }
       return null;
   }
   
   
}

