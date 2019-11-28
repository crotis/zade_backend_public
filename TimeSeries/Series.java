package Zade.Server.TimeSeries;

//import Zade.Server.TimeSeries.Embedded.Data;
//import Zade.Server.TimeSeries.Embedded.Date;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
public class Series {

    private @Id
    @GeneratedValue long id;
//
//    @Embedded
//    private Date date;
//    @Embedded
//    private Data data;

    private String assetFrom;
    private String assetTo;
    private String type;
    private String test;

    public Series() {}

    public Series(String from, String to, String type){
        this.assetTo = to;
        this.assetFrom = from;
        this.type = type;
    }

    public String getSeries(){
        return this.assetFrom + assetTo;
    }

    public void setAsset(String asset){
        this.assetFrom =  asset.substring(0,3);
        this.assetTo = asset.substring(3,6);
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Data getData() {
//        return data;
//    }
//
//    public void setData(Data data) {
//        this.data = data;
//    }

    public String getAssetFrom() {
        return assetFrom;
    }

    public void setAssetFrom(String assetFrom) {
        this.assetFrom = assetFrom;
    }

    public String getAssetTo() {
        return assetTo;
    }

    public void setAssetTo(String assetTo) {
        this.assetTo = assetTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
