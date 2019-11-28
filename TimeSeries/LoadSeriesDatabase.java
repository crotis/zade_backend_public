package Zade.Server.TimeSeries;

import Zade.Server.Assets.Asset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadSeriesDatabase {

    @Autowired
    private SeriesRepository seriesRepository;

    @Bean
    CommandLineRunner initDatabase2(SeriesRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Series("EUR", "USD", "FX-MAJOR")));
            log.info("Preloading " + repository.save(new Series("USD", "JPY", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Series("GBP", "USD", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Series("USD", "CHF", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Series("AUD", "USD", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Series("USD", "CAD", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Series("NZD", "USD", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Series("EUR", "GBP", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("CAD", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("GBP", "AUD", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("GBP", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("EUR", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("EUR", "NZD", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("EUR", "AUD", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("EUR", "CHF", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("EUR", "CAD", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("CHF", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("AUD", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("NZD", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("GBP", "CHF", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("GBP", "CAD", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Series("BTC", "USD", "CRYPTO")));
            log.info("Preloading " + repository.save(new Series("ETH", "USD", "CRYPTO")));
            log.info("Preloading " + repository.save(new Series("XRP", "USD", "CRYPTO")));
        };
    }

//    @Bean
//    CommandLineRunner initDatabase2(SeriesRepository repository) {
//        return args -> {
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//            log.info("Preloading " + repository.save(new Series()));
//        };
//    }
}
