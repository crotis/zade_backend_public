package Zade.Server;

import Zade.Server.TimeSeries.Series;
import Zade.Server.TimeSeries.SeriesRepository;
import Zade.Server.Zade.ZadeRequest;
import Zade.Server.AlphaVintage.RequestFX;
import Zade.Server.AlphaVintage.RequestCryp;
import Zade.Server.Assets.Asset;
import Zade.Server.Utility.CalculatePriceDifference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class updateDatabase {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    @Bean
    @Async
    @Scheduled(fixedRate = 60000, initialDelay = 1000)
    public void updateFX(){
        Asset newAsset = new Asset();
        Asset currentAsset = new Asset();
        ZadeRequest zadeRequest = new ZadeRequest();
        CalculatePriceDifference calculatePriceDifference = new CalculatePriceDifference();

            for (int j = 21; j >= 1; j--) {
                Long id = Long.valueOf(j);
                currentAsset = assetRepository.findById(id).get();
                RequestFX requestFX = new RequestFX(currentAsset.getAssetFrom(), currentAsset.getAssetTo());
                Asset updatedAsset = assetRepository.findById(id)
                        .map(asset -> {
                            asset.setAssetFrom(requestFX.getAssetFrom());
                            asset.setAssetTo(requestFX.getAssetTo());
                            asset.setTodaysOpen(requestFX.getTodaysOpen());
                            asset.setTodaysHigh(requestFX.getTodaysHigh());
                            asset.setTodaysLow(requestFX.getTodaysLow());
                            asset.setPrice(requestFX.getCurrentPrice());
                            asset.setDailyChange();
                            System.out.println("UPDATED ASSET: " + asset.getAsset());
                            return assetRepository.save(asset);
                        })
                        .orElseGet(() -> {
                            System.out.println("TASK SCHEDULER:Error updating asset, new asset created");
                            newAsset.setId(id);
                            return assetRepository.save(newAsset);
                        });
                //TODO: This does nothing currently, make it calcualte the difference and push an update when the difference is > x
//                if (calculatePriceDifference.calculate(updatedAsset.getZadePrice(), updatedAsset.getPrice()) > 0.1) {
//                    try {
//                        zadeRequest.postAsset(updatedAsset.getId());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
    }

    @Bean
    @Async
    @Scheduled(fixedRate = 60000, initialDelay = 1000)
    public void updateCrpy(){
        Asset newAsset = new Asset();
        Asset currentAsset = new Asset();
        ZadeRequest zadeRequest = new ZadeRequest();
        CalculatePriceDifference calculatePriceDifference = new CalculatePriceDifference();

        for (int j = 24; j >= 22; j--) {
            Long id = Long.valueOf(j);
            currentAsset = assetRepository.findById(id).get();
            RequestCryp requestCryp = new RequestCryp(currentAsset.getAssetFrom(), currentAsset.getAssetTo());
            Asset updatedAsset = assetRepository.findById(id)
                    .map(asset -> {
                        asset.setAssetFrom(requestCryp.getAssetFrom());
                        asset.setAssetTo(requestCryp.getAssetTo());
                        asset.setPrice(requestCryp.getCurrentPrice());
                        System.out.println("UPDATED ASSET: " + asset.getAsset());
                        return assetRepository.save(asset);
                    })
                    .orElseGet(() -> {
                        System.out.println("TASK SCHEDULER:Error updating asset, new asset created");
                        newAsset.setId(id);
                        return assetRepository.save(newAsset);
                    });
            //TODO: This does nothing currently, make it calcualte the difference and push an update when the difference is > x
//            if (calculatePriceDifference.calculate(updatedAsset.getZadePrice(), updatedAsset.getPrice()) >= 0) {
//                try {
//                    zadeRequest.postAsset(updatedAsset.getId());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

//    @Bean
//    @Async
//    @Scheduled(fixedRate = 60000, initialDelay = 1000)
//    public void updateSeries(){
//        Series newSeries = new Series();
//        Series currentSeries = new Series();
//        ZadeRequest zadeRequest = new ZadeRequest();
//        Long id = Long.valueOf(25);
//
//            currentSeries = seriesRepository.findById(id).get();
//            RequestCryp requestCryp = new RequestCryp(currentSeries.getAssetFrom(), currentSeries.getAssetTo());
//            Series updatesSeries = seriesRepository.findById(id)
//                    .map(series -> {
//                        series.setTest("lol");
//                        return seriesRepository.save(series);
//                    })
//                    .orElseGet(() -> {
//                        System.out.println("TASK SCHEDULER:Error updating asset, new asset created");
//                        newSeries.setId(id);
//                        return seriesRepository.save(newSeries);
//                    });
//    }

//    @Bean
//    @Async
//    @Scheduled(fixedRate = 60000, initialDelay = 1000)
//    public void updateSeries(){
//        Series newSeries = new Series();
//        Series currentSeries = new Series();
//        ZadeRequest zadeRequest = new ZadeRequest();
//        Long id = Long.valueOf(25);
//
//            currentSeries = seriesRepository.findById(id).get();
//            Series updatesSeries = seriesRepository.findById(id)
//                    .map(series -> {
//                        series.setTest("lol");
//                        return seriesRepository.save(series);
//                    })
//                    .orElseGet(() -> {
//                        System.out.println("TASK SCHEDULER:Error updating asset, new asset created");
//                        newSeries.setId(id);
//                        return seriesRepository.save(newSeries);
//                    });
//    }
}
