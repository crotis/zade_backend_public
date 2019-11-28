package Zade.Server.Assets;

import Zade.Server.Utility.DailyChangeCalculator;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Asset {
    private @Id @GeneratedValue long id;
    private String assetFrom;
    private String assetTo;
    private String type;
    private double price;
    private double zadePrice;
    private double todaysOpen;
    private double todaysHigh;
    private double todaysLow;
    private double dailyChange;

    public Asset() {}

    public Asset(String from, String to, String type){
        this.assetTo = to;
        this.assetFrom = from;
        this.type = type;
    }

    public String getAsset(){
        return this.assetFrom + assetTo;
    }

    public void setAsset(String asset){
        this.assetFrom =  asset.substring(0,3);
        this.assetTo = asset.substring(3,6);
    }

    public void setDailyChange(){
        DailyChangeCalculator calculator = new DailyChangeCalculator();
        dailyChange = calculator.calculateChange(todaysOpen, price);
    }
}
