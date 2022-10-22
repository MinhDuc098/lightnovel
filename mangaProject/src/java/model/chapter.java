/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author AS
 */
public class chapter {
    private int chapId;
    private String chapname;
    private String file;
    private String dayUpdate;

    public chapter() {
    }

    public chapter(int chapId, String chapname, String file, String dayUpdate) {
        this.chapId = chapId;
        this.chapname = chapname;
        this.file = file;
        this.dayUpdate = dayUpdate;
    }

   

    

    public int getChapId() {
        return chapId;
    }

    public void setChapId(int chapId) {
        this.chapId = chapId;
    }

    public String getChapname() {
        return chapname;
    }

    public void setChapname(String chapname) {
        this.chapname = chapname;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDayUpdate() {
        return dayUpdate;
    }

    public void setDayUpdate(String dayUpdate) {
        this.dayUpdate = dayUpdate;
    }
    
}
