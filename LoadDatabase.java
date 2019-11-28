package Zade.Server;

import Zade.Server.Assets.Asset;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Autowired
    private AssetRepository assetRepository;

    @Bean
    CommandLineRunner initDatabase(AssetRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Asset("EUR", "USD", "FX-MAJOR")));
            log.info("Preloading " + repository.save(new Asset("USD", "JPY", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Asset("GBP", "USD", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Asset("USD", "CHF", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Asset("AUD", "USD", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Asset("USD", "CAD", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Asset("NZD", "USD", "FX_MAJOR")));
            log.info("Preloading " + repository.save(new Asset("EUR", "GBP", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("CAD", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("GBP", "AUD", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("GBP", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("EUR", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("EUR", "NZD", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("EUR", "AUD", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("EUR", "CHF", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("EUR", "CAD", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("CHF", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("AUD", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("NZD", "JPY", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("GBP", "CHF", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("GBP", "CAD", "FX_MINOR")));
            log.info("Preloading " + repository.save(new Asset("BTC", "USD", "CRYPTO")));
            log.info("Preloading " + repository.save(new Asset("ETH", "USD", "CRYPTO")));
            log.info("Preloading " + repository.save(new Asset("XRP", "USD", "CRYPTO")));
        };
    }
}