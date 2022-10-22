/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package addHistory;

import Dal.Lightnovel;
import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import java.util.List;
import model.lightnovel;

/**
 *
 * @author AS
 */
public class addHistory {
    
    
    
    public lightnovel checkHistory(List<lightnovel> lh,int nid){
        for(int i=0;i<lh.size();i++){
            if(lh.get(i).getNid() == nid){
                return lh.get(i);
            }
        }
        return null;
    }
    
    public  List<lightnovel> addNewHistory( List<lightnovel> lh,int nid ){
        Lightnovel L = new Lightnovel();
        if(checkHistory(lh, nid)!=null ){
            lightnovel h = checkHistory(lh, nid);
            lh.remove(h);
            
            lh.add(L.getLightnovelById(nid));
        }
        else{
            lh.add(L.getLightnovelById(nid));
        }
        return lh;
    }
    
}
