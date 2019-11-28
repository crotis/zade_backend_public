package Zade.Server.AlphaVintage;

import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.Double.parseDouble;

@Data
public class RequestCryp {

    private String todaysDate;
    private double todaysOpen;
    private double todaysHigh;
    private double todaysLow;
    private double currentPrice;
    private String assetFrom;
    private String assetTo;
    private String URL_Query = "https://www.alphavantage.co/query";
    private String URL_FunctionDaily = "FX_DAILY";
    private String URL_FunctionCurrent = "CURRENCY_EXCHANGE_RATE";
    private String URL_DailyCurrent = "DIGITAL_CURRENCY_DAILY";
    private String URL_ApiKey = "**************";

    public RequestCryp (String assetFrom, String assetTo){
        this.assetTo = assetTo;
        this.assetFrom = assetFrom;
        this.setTodaysDate();
//        getDaily();
        getCurrent();
    }

    //TODO: Alpha Vantage API does not provide todays Daily data (Open, High, Low) ? What to do about this...
//    private void getDaily() throws NullPointerException{
//        JSONObject json = null;
//        try {
//            json = readJsonFromUrl(URL_Query +"?function=" + URL_DailyCurrent + "&symbol=" + assetFrom + "&market=" + assetTo + "&apikey=" + URL_ApiKey);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JSONObject getSth = json.getJSONObject("Time Series (Digital Currency Daily)").getJSONObject(this.todaysDate);
//        todaysOpen = parseDouble( getSth.get("1a. open (USD)").toString());
//        todaysHigh = parseDouble( getSth.get("2a. high (USD)").toString());
//        todaysLow = parseDouble( getSth.get("3a. low (USD)").toString());
//    }

    private void getCurrent(){
        JSONObject json = null;
        try {
            json = readJsonFromUrl(URL_Query +"?function=" + URL_FunctionCurrent + "&from_currency=" + assetFrom + "&to_currency=" + assetTo + "&apikey=" + URL_ApiKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject getSth = json.getJSONObject("Realtime Currency Exchange Rate");
        currentPrice = parseDouble(getSth.get("5. Exchange Rate").toString());
    }

    private void setTodaysDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        this.todaysDate = dateFormat.format(cal.getTime()).replace("/", "-");
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}

