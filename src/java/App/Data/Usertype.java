package App.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Usertype extends Base
{
    private int     UID;
    private String  strName;
    private Boolean flgDeleted;
    private Boolean flgCanManage;
    
    public Usertype(Map<String, String> mapData) {
        super();
        
        this.UID            = Integer.parseInt(mapData.get("UID"));
        this.strName        = mapData.get("STRNAME");
        this.flgDeleted     = Boolean.parseBoolean(mapData.get("FLGDELETED"));
        this.flgCanManage   = Boolean.parseBoolean(mapData.get("FLGCANMANAGE"));
    }

    public int getUID() {
        return UID;
    }

    public Usertype setUID(int UID) {
        this.UID = UID;
        
        return this;
    }

    public Boolean isFlgCanManage() {
        return flgCanManage;
    }

    public void setFlgCanManage(Boolean flgCanManage) {
        this.flgCanManage = flgCanManage;
    }

    public String getStrName() {
        return strName;
    }

    public Usertype setStrName(String strName) {
        this.strName = strName;
        
        return this;
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public Usertype setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
        
        return this;
    }

    @Override
    public Base doInsert() {
        Map<String, String> mapData = new HashMap<>();
        
        mapData.put("STRNAME", this.strName);
        mapData.put("FLGCANMANAGE", String.valueOf(this.flgCanManage));
        
        return this.doInsert("TBLUSERTYPE", mapData);
    }

    @Override
    public Base doUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
