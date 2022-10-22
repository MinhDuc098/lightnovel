/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author AS
 */
public class ban {
    private int banid,uID;

    public ban() {
    }

    public ban(int banid, int uID) {
        this.banid = banid;
        this.uID = uID;
    }

    public int getBanid() {
        return banid;
    }

    public void setBanid(int banid) {
        this.banid = banid;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }
    
}
