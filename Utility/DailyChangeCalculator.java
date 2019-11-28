package Zade.Server.Utility;

import java.text.DecimalFormat;

public class DailyChangeCalculator {

    public double calculateChange(double todaysOpen, double price){
        double change = ((price - todaysOpen) / (double)todaysOpen)*100;

        DecimalFormat df = new DecimalFormat("00.0000");
        String str = df.format(change);
        change = Double.parseDouble(str);
        return change;
    }


}
