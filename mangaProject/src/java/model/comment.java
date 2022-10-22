/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author AS
 */
public class comment {
    private account user;
    private String comment;
    private int nid;

    public comment() {
    }

    public comment(account user, String comment, int nid) {
        this.user = user;
        this.comment = comment;
        this.nid = nid;
    }

    public account getUser() {
        return user;
    }

    public void setUser(account user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }
    
}
